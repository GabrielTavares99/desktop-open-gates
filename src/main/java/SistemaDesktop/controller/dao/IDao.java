package SistemaDesktop.controller.dao;

import java.util.List;

public interface IDao {

    void salvar(Object o);
    void atualizar(Object o);

    List<Object> pegarTodos();

}
