package SistemaTerminal.view.telas;

import SistemaDesktop.view.telas.TelaCustom;
import SistemaTerminal.view.listeners.DeteccaoWebCam;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TelaLeituraCarteirinha extends TelaCustom implements Runnable, ThreadFactory {

    private static final long serialVersionUID = 6441489157408381878L;

    private Executor executor = Executors.newSingleThreadExecutor(this);

    private Webcam webcam;
    private WebcamPanel panel;

    public TelaLeituraCarteirinha() {
        super();

        setLayout(new FlowLayout());

        Dimension size = WebcamResolution.VGA.getSize();

        List<Webcam> webcams = Webcam.getWebcams();
        if (webcams.size() > 1) {
            StringJoiner joiner = new StringJoiner("\n");
            joiner.add("Qual webcam usar?\nDigite apenas números");
            for (int i = 0; i < webcams.size(); i++) {
                joiner.add(String.format("%d - %s", i + 1, webcams.get(i).getName()));
            }
            String escolhaCamera = JOptionPane.showInputDialog(joiner.toString());
            try {
                webcam = webcams.get(Integer.valueOf(escolhaCamera) - 1);
            } catch (Exception e) {
                webcam = Webcam.getWebcams().get(0);
            }
        } else if (webcams.size() == 0) {
            JOptionPane.showMessageDialog(null, "Câmeras não disponíveis!");
        } else {
            webcam = Webcam.getWebcams().get(0);
        }
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        add(panel);

        pack();
        setVisible(true);

        executor.execute(this);
    }

    @Override
    public void run() {

        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image;

            if (webcam.isOpen()) {

                if ((image = webcam.getImage()) == null)
                    continue;

                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    result = new MultiFormatReader().decode(bitmap);
                } catch (NotFoundException e) {
                    // fall thru, it means there is no QR code in image
                }
            }

            if (result != null) {
                Result finalResult = result;
                System.out.println("VALIDANDO " + finalResult);
                new DeteccaoWebCam(finalResult.getText()).run();
            }

        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "example-runner");
        t.setDaemon(true);
        return t;
    }


}
