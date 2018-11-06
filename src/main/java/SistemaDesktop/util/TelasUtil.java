package SistemaDesktop.util;

import SistemaDesktop.model.Pessoa;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.view.telas.TelaDashboard;

import javax.swing.*;
import java.util.List;

public class TelasUtil {


    public static TelaDashboard TELA_DASHBOARD;
    public static Usuario USUARIO_LOGADO;
    public static String EMAIL_RECUPERACAO;

    public static void addItensToTela(JComponent jPanel, List<JComponent> list){
        for (JComponent component: list){
            jPanel.add(component);
        }
    }

    public static JFrame TELA_ANTERIOR;
    public static String URL_CSV;
    public static String URL_ARQUIVO_FOTOS;


}
