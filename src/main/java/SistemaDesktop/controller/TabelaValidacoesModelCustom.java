package SistemaDesktop.controller;

import SistemaTerminal.model.Validacao;

import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public abstract class TabelaValidacoesModelCustom implements TableModel {
    private List<Validacao> validacaos = new ArrayList<>();

    public List<Validacao> getValidacaos() {
        return validacaos;
    }

    public void setValidacaos(List<Validacao> validacaos) {
        this.validacaos = validacaos;
    }
}
