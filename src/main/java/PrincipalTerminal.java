import SistemaTerminal.view.telas.TelaLeituraCarteirinha;

import java.awt.*;

public class PrincipalTerminal {
    public static void main(String[] args) {

        new Thread(() -> new TelaLeituraCarteirinha()).start();
        GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = environment.getScreenDevices();
        for (GraphicsDevice device : devices) {
//            device.setFullScreenWindow(telaLeituraCarteirinha);
//            Rectangle bounds = device.getDefaultConfiguration().getBounds();
        }


    }
}
