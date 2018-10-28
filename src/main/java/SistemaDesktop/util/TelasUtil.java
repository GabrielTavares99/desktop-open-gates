package SistemaDesktop.util;

import javax.swing.*;
import java.util.List;

public class TelasUtil {
    public static void addItensToTela(JPanel jPanel, List<JComponent> list){
        for (JComponent component: list){
            jPanel.add(component);
        }
    }
}
