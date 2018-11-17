package SistemaDesktop.view.telas;

import SistemaDesktop.controller.dao.CargoDAO;
import SistemaDesktop.controller.modelosTabela.ModeloTabelaCadastroFuncionario;
import SistemaDesktop.model.Cargo;
import SistemaDesktop.model.Funcionario;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.camposTexto.CampoTextoCadastro;
import SistemaDesktop.view.combobox.ComboBoxCargoModel;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.listeners.CadastrarFuncionarioListener;
import SistemaDesktop.view.listeners.SelecionarFotoFuncionario;
import SistemaDesktop.view.menu.MenuSuperior;
import SistemaDesktop.view.paineis.GroupForm;
import SistemaDesktop.view.paineis.PainelFotoFuncionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import static SistemaDesktop.config.Constantes.TITULO_TELA_CADASTRO_FUNCIONARIO;

public class TelaCadastroFuncionario extends TelaCustom {

    public static JTextField txtNome = new CampoTextoCadastro();
    public static JTextField txtCPF = new CampoTextoCadastro();
    public static JTextField txtEmail = new CampoTextoCadastro();
    public static JRadioButton rdAtivo = new JRadioButton();
    public static JComboBox<Cargo> comboBoxCargo;
    public static JLabel lblImagemFuncionario = new JLabel(new ImageIcon("/home/gabriel/Documents/casamento/IMG-20180804-WA0013.jpg"));
    public static Integer ID_FUNCIONARIO = null;
    public static Integer ID_USUARIO;
    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_CADASTRO_FUNCIONARIO);
    String[] nomeColunas;
    ModeloTabelaCadastroFuncionario modeloTabelaCadastroFuncionario;
    JTable tabela = new JTable();
    JLabel lblFuncionario = new JLabel();
    JLabel lblNome = new JLabel("NOME");
    JLabel lblCPF = new JLabel("CPF");
    JLabel lblCargo = new JLabel("CARGO");
    JLabel lblEmail = new JLabel("EMAIL");
    JLabel lblAtivo = new JLabel("Ativo");
    List<JComponent> components = new ArrayList<>();
    JButton btnFoto = new JButton("SELECIONAR FOTO");

    public TelaCadastroFuncionario() {
        super();
        add(lblTitulo);

        JTextField txtPesquisa = new JTextField();
        txtPesquisa.setBounds(50, 100, 700, 30);

        modeloTabelaCadastroFuncionario = new ModeloTabelaCadastroFuncionario(tabela);
        tabela.setModel(modeloTabelaCadastroFuncionario);
        JScrollPane scroolPane = new JScrollPane(tabela);
        scroolPane.setBounds(50, 100, 700, 150);
        add(scroolPane);

        JPanel pnCadastro = new JPanel();
        pnCadastro.setOpaque(true);
        pnCadastro.setBackground(Color.orange);
        pnCadastro.setLayout(null);
        pnCadastro.setBounds(50, 260, 700, 300);

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

        GroupForm e4 = new GroupForm(lblCPF, txtCPF);
        e4.setBounds(230, 80, 200, 60);
        components.add(e4);

        GroupForm e3 = new GroupForm(lblCargo, comboBoxCargo);
        e3.setBounds(450, 10, 200, 60);
        components.add(e3);

        PainelFotoFuncionario pnFotoFuncionario = new PainelFotoFuncionario(lblImagemFuncionario, btnFoto);
        pnFotoFuncionario.setBounds(10, 80, pnFotoFuncionario.getWidth(), pnFotoFuncionario.getHeight());
        btnFoto.addActionListener(new SelecionarFotoFuncionario(tela));
        components.add(pnFotoFuncionario);

        rdAtivo.setLabel("ATIVO");
        GroupForm e5 = new GroupForm(lblAtivo, rdAtivo);
        e5.setBounds(450, 80, 200, 60);
        components.add(e5);
        TelasUtil.addItensToTela(pnCadastro, components);

        JPanel pnBotoes = new JPanel();
        pnBotoes.setBackground(Color.RED);
        pnBotoes.setLayout(new GridLayout());
        pnBotoes.setOpaque(true);
        pnBotoes.setBounds(370, 450, 300, 70);

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnSalvar = new JButton("SALVAR");
        btnSalvar.addActionListener(new CadastrarFuncionarioListener(modeloTabelaCadastroFuncionario));

        pnBotoes.add(btnSalvar);
        pnBotoes.add(btnCancelar);

        btnCancelar.addActionListener(e1 -> {
            ID_FUNCIONARIO = null;
            ID_USUARIO = null;
        });

        tabela.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tabela.getSelectedRow();
                Funcionario funcionario = (Funcionario) modeloTabelaCadastroFuncionario.getFuncionarios().get(selectedRow);
                txtNome.setText(funcionario.getNome());
                ID_FUNCIONARIO = funcionario.getId();
                ID_USUARIO = funcionario.getUsuario().getId();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        add(pnBotoes);
        add(pnCadastro);
        add(txtPesquisa);
        setJMenuBar(new MenuSuperior(tela));

        setVisible(true);
    }
}
