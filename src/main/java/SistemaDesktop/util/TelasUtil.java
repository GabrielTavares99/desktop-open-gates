package SistemaDesktop.util;

import SistemaDesktop.model.Usuario;
import SistemaDesktop.view.telas.TelaDashboard;

import javax.swing.*;
import java.util.List;

public class TelasUtil {


    public static TelaDashboard TELA_DASHBOARD;
    public static Usuario USUARIO_LOGADO;

    public static void addItensToTela(JComponent jPanel, List<JComponent> list){
        for (JComponent component: list){
            jPanel.add(component);
        }
    }

    public static JFrame TELA_ANTERIOR;
}
