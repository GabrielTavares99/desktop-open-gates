package SistemaDesktop.view;

import SistemaDesktop.model.Cargo;

import javax.swing.*;

public class ComboBoxModel extends DefaultComboBoxModel<Cargo> {


    public ComboBoxModel(Cargo[] items) {
        super(items);
    }

    @Override
    public Cargo getSelectedItem() {
        Cargo cargo = (Cargo) super.getSelectedItem();
        return cargo;
    }


}
