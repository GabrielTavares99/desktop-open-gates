package SistemaDesktop.controller.dao;

import SistemaDesktop.model.Email;

import java.util.ArrayList;
import java.util.List;

public class EmailDAO implements IDao {

    private List<Email> emails = new ArrayList<>();

    @Override
    public void salvar(Object o) {
        emails.add((Email) o);
    }

    @Override
    public void atualizar(Object o) {
        // TODO: 10/11/18 UPDATE COM O BANCO DE DADOS 
    }

    public Email getEmailNaoEnviado() {
        for (Email email : emails) {
            if (email.isEnviado())
                return email;
        }
        return null;
    }

    @Override
    public List<Object> pegarTodos() {
        return null;
    }
}
