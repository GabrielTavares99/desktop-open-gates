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
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TelaLeituraCarteirinha extends TelaCustom implements Runnable, ThreadFactory {

    private static final long serialVersionUID = 6441489157408381878L;

    private Executor executor = Executors.newSingleThreadExecutor(this);

    private Webcam webcam = null;
    private WebcamPanel panel = null;
    private JTextArea textarea = null;

    public TelaLeituraCarteirinha() {
        super();

        setLayout(new FlowLayout());

        Dimension size = WebcamResolution.VGA.getSize();

        webcam = Webcam.getWebcams().get(1);
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
            BufferedImage image = null;

            if (webcam.isOpen()) {

                if ((image = webcam.getImage()) == null)
                    continue;

                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

                try {
                    result = new MultiFormatReader().decode(bitmap);
                } catch (NotFoundException e) {
                    // fall thru, it means there is no QR code in image
                    System.out.println("sei lá");
                }
            }

            if (result != null) {
                Result finalResult = result;
                new Thread(() -> DeteccaoWebCam.consulta(finalResult.getText())).start();
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
