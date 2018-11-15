package SistemaDesktop.view.combobox;

import SistemaDesktop.model.Cargo;

import javax.swing.*;

public class ComboBoxCargoModel extends DefaultComboBoxModel<Cargo> {


    public ComboBoxCargoModel(Cargo[] items) {
        super(items);
    }

    @Override
    public Cargo getSelectedItem() {
        Cargo cargo = (Cargo) super.getSelectedItem();
        return cargo;
    }


}
