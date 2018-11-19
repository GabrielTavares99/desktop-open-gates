package SistemaDesktop.util;

import SistemaDesktop.model.Funcionario;
import SistemaDesktop.model.Usuario;
import SistemaDesktop.view.telas.TelaDashboard;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static SistemaDesktop.config.ViewSettings.MEIO_TELA_X;

public class TelasUtil {

    public static Funcionario FUNCIONARIO_SELECIONADO;
    public static String URL_FOTO_FUNCIONARIO;
    public static TelaDashboard TELA_DASHBOARD;
    public static Usuario USUARIO_LOGADO;
    public static String EMAIL_RECUPERACAO;
    public static JFrame TELA_ANTERIOR;
    public static String URL_CSV;
    public static String URL_ARQUIVO_FOTOS;

    public static void addItensToTela(JComponent jPanel, List<JComponent> list) {
        for (JComponent component : list) {
            jPanel.add(component);
        }
    }

    public static void centralizar(JComponent component) {
        component.setLocation(MEIO_TELA_X - (component.getWidth() / 2), component.getY());
    }

    public static void limpaCampos(JPanel panel){
        for(int i = 0; i < panel.getComponentCount(); i++){
            Component component = panel.getComponent(i);
            if(component instanceof JTextField) {
                JTextField campo = (JTextField) component;
                campo.setText("");
            }

            if(component instanceof JPasswordField){
                JPasswordField campo = (JPasswordField) component;
                campo.setText("");
            }
        }
    }
}
