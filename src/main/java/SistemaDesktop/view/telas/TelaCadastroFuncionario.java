package SistemaDesktop.view.telas;

import SistemaDesktop.controller.dao.CargoDAO;
import SistemaDesktop.controller.modelosTabela.ModeloTabelaCadastroFuncionario;
import SistemaDesktop.model.Cargo;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.camposTexto.CampoTextoCadastro;
import SistemaDesktop.view.combobox.ComboBoxCargoModel;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.menu.MenuSuperior;
import SistemaDesktop.view.paineis.GroupForm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.config.Constantes.TITULO_TELA_CADASTRO_FUNCIONARIO;

public class TelaCadastroFuncionario extends TelaCustom {

    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_CADASTRO_FUNCIONARIO);
    String[] nomeColunas;
    ModeloTabelaCadastroFuncionario modeloTabelaCadastroFuncionario;
    JTable tabela = new JTable();

    JLabel lblFuncionario = new JLabel();
    JLabel lblNome = new JLabel("NOME");
    JTextField txtNome = new CampoTextoCadastro();
    JLabel lblMatricula = new JLabel("MATRICULA");
    JTextField txtMatricula = new CampoTextoCadastro();
    JLabel lblCPF = new JLabel("CPF");
    JTextField txtCPF = new CampoTextoCadastro();
    JLabel lblCargo = new JLabel("CARGO");
    JLabel lblEmail = new JLabel("EMAIL");
    JTextField txtEmail = new CampoTextoCadastro();
    JLabel lblAtivo = new JLabel("Ativo");
    JRadioButton checkbox = new JRadioButton();
    JComboBox<Cargo> comboBoxCargo;
    List<JComponent> components = new ArrayList<>();

    public TelaCadastroFuncionario() {
        super();
        add(lblTitulo);

        JTextField txtPesquisa = new JTextField();
        txtPesquisa.setBounds(50, 100, 700, 30);

        nomeColunas = new String[]{"CredenciamentoAluno", "Nome", "CPF", "Email", "Cargo", "Ativo"};
        List<Object> objects = new ArrayList<>();
        modeloTabelaCadastroFuncionario = new ModeloTabelaCadastroFuncionario(nomeColunas, objects);
        tabela.setModel(modeloTabelaCadastroFuncionario);
        JScrollPane scroolPane = new JScrollPane(tabela);
        scroolPane.setBounds(50, 100, 700, 150);
        add(scroolPane);

        JPanel pnCadastro = new JPanel();
        pnCadastro.setOpaque(true);
        pnCadastro.setBackground(Color.orange);
        pnCadastro.setLayout(null);
        pnCadastro.setBounds(50, 260, 700, 150);

        List<Object> cargos = new CargoDAO().pegarTodos();
        Cargo[] c = new Cargo[1];
        for (int i = 0; i < cargos.size(); i++) {
            c[i] = (Cargo) cargos.get(i);
        }
        comboBoxCargo = new JComboBox<>(new ComboBoxCargoModel(c));

        GroupForm e = new GroupForm(lblNome, txtNome);
        e.setBounds(10, 10, 200, 60);
        components.add(e);

        GroupForm e2 = new GroupForm(lblEmail, txtEmail);
        e2.setBounds(230, 10, 200, 60);
        components.add(e2);

        GroupForm e1 = new GroupForm(lblMatricula, txtMatricula);
        e1.setBounds(10, 80, 200, 60);
        components.add(e1);

        GroupForm e4 = new GroupForm(lblCPF, txtCPF);
        e4.setBounds(230, 80, 200, 60);
        components.add(e4);

        GroupForm e3 = new GroupForm(lblCargo, comboBoxCargo);
        e3.setBounds(450, 10, 200, 60);
        components.add(e3);

        checkbox.setLabel("ATIVO");
        GroupForm e5 = new GroupForm(lblAtivo, checkbox);
        e5.setBounds(450, 80, 200, 60);
        components.add(e5);
        TelasUtil.addItensToTela(pnCadastro, components);

        JPanel pnBotoes = new JPanel();
        pnBotoes.setBackground(Color.RED);
        pnBotoes.setOpaque(true);
        pnBotoes.setBounds(370, 450, 300, 70);

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnSalvar = new JButton("SALVAR");
        pnBotoes.add(btnCancelar);
        pnBotoes.add(btnSalvar);

        add(pnBotoes);
        add(pnCadastro);
        add(txtPesquisa);
        setJMenuBar(new MenuSuperior(tela));

        setVisible(true);
    }
}
