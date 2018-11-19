package SistemaDesktop.view.telas;

import SistemaDesktop.controller.dao.CargoDAO;
import SistemaDesktop.controller.modelosTabela.ModeloTabelaCadastroFuncionario;
import SistemaDesktop.model.Cargo;
import SistemaDesktop.model.Funcionario;
import SistemaDesktop.util.CriptografiaUtil;
import SistemaDesktop.util.ImageUtil;
import SistemaDesktop.util.TelasUtil;
import SistemaDesktop.view.botoes.BotaoSimples;
import SistemaDesktop.view.camposTexto.CampoTextoCadastro;
import SistemaDesktop.view.combobox.ComboBoxCargoModel;
import SistemaDesktop.view.labels.LabelTitulo;
import SistemaDesktop.view.listeners.CadastrarFuncionarioListener;
import SistemaDesktop.view.listeners.SelecionarFotoFuncionario;
import SistemaDesktop.view.menu.MenuSuperior;
import SistemaDesktop.view.paineis.GroupForm;
import SistemaDesktop.view.paineis.PainelFotoFuncionario;
import SistemaDesktop.view.paineis.PainelSimples;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static commoms.config.Constantes.TITULO_TELA_CADASTRO_FUNCIONARIO;

public class TelaCadastroFuncionario extends TelaCustom {

    public static JTextField txtNome = new JFormattedTextField();
    public static JTextField txtCPF = new CampoTextoCadastro();
    public static JTextField txtEmail = new CampoTextoCadastro();
    public static JRadioButton rdAtivo = new JRadioButton();
    public static JComboBox<Cargo> comboBoxCargo;
    public static JLabel lblImagemFuncionario = new JLabel();
    public static Integer ID_FUNCIONARIO = null;
    public static Integer ID_USUARIO;
    JLabel lblTitulo = new LabelTitulo(TITULO_TELA_CADASTRO_FUNCIONARIO);
    ModeloTabelaCadastroFuncionario modeloTabelaCadastroFuncionario;
    JTable tabela = new JTable();
    JLabel lblNome = new JLabel("NOME");
    JLabel lblCPF = new JLabel("CPF");
    JLabel lblCargo = new JLabel("CARGO");
    JLabel lblEmail = new JLabel("EMAIL");
    JLabel lblAtivo = new JLabel("Ativo");
    List<JComponent> components = new ArrayList<>();
    JButton btnFoto = new BotaoSimples("SELECIONAR FOTO");

    public TelaCadastroFuncionario() {
        super();
        add(lblTitulo);

        JTextField txtPesquisa = new JTextField();
        txtPesquisa.setBounds(50, 100, 700, 30);

        modeloTabelaCadastroFuncionario = new ModeloTabelaCadastroFuncionario(tabela);
        tabela.setModel(modeloTabelaCadastroFuncionario);
        JScrollPane scroolPane = new JScrollPane(tabela);
        scroolPane.setBounds(50, 80, 700, 150);
        add(scroolPane);

        JPanel pnCadastro = new PainelSimples();
        pnCadastro.setBounds(50, 240, 700, 300);

        List<Object> cargos = new CargoDAO().pegarTodos();
        Cargo[] c = new Cargo[cargos.size()];
        for (int i = 0; i < cargos.size(); i++) {
            c[i] = (Cargo) cargos.get(i);
        }
        comboBoxCargo = new JComboBox<>(new ComboBoxCargoModel(c));

        try {
            txtCPF = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        GroupForm groupNome = new GroupForm(lblNome, txtNome);
        groupNome.setBounds(230, 10, 300, 60);
        components.add(groupNome);

        GroupForm grupoCargo = new GroupForm(lblCargo, comboBoxCargo);
        grupoCargo.setBounds(550, 10, 140, 60);
        components.add(grupoCargo);

        GroupForm grupoEmail = new GroupForm(lblEmail, txtEmail);
        grupoEmail.setBounds(230, 90, 270, 60);
        components.add(grupoEmail);

        GroupForm grupoCpf = new GroupForm(lblCPF, txtCPF);
        grupoCpf.setBounds(520, 90, 170, 60);
        components.add(grupoCpf);

        PainelFotoFuncionario pnFotoFuncionario = new PainelFotoFuncionario(lblImagemFuncionario, btnFoto);
        pnFotoFuncionario.setBounds(10, 15, pnFotoFuncionario.getWidth(), pnFotoFuncionario.getHeight());
        btnFoto.addActionListener(new SelecionarFotoFuncionario(tela));
        components.add(pnFotoFuncionario);

        rdAtivo.setLabel("ATIVO");
        GroupForm e5 = new GroupForm(lblAtivo, rdAtivo);
        e5.setBounds(230, 170, 200, 60);
        components.add(e5);
        TelasUtil.addItensToTela(pnCadastro, components);

        JPanel pnBotoes = new PainelSimples();
        pnBotoes.setLayout(new GridLayout(1, 2, 5, 2));
        pnBotoes.setOpaque(false);
        pnBotoes.setBorder(null);
        pnBotoes.setBounds(pnCadastro.getWidth() - 260, 480, 300, 40);

        JButton btnCancelar = new BotaoSimples("Cancelar");
        JButton btnSalvar = new BotaoSimples("SALVAR");
        btnSalvar.addActionListener(new CadastrarFuncionarioListener(modeloTabelaCadastroFuncionario));

        pnBotoes.add(btnSalvar);
        pnBotoes.add(btnCancelar);


        tabela.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tabela.getSelectedRow();
                Funcionario funcionario = (Funcionario) modeloTabelaCadastroFuncionario.getFuncionarios().get(selectedRow);

                txtNome.setText(funcionario.getNome());
                txtCPF.setText(funcionario.getUsuario().getCpf());
                txtEmail.setText(funcionario.getUsuario().getEmail());
                txtEmail.setEnabled(false);
                comboBoxCargo.setSelectedItem(funcionario.getCargo());
                rdAtivo.setSelected(funcionario.getUsuario().isAtivo());

                String pathImage = String.format("/tmp/funcionario/%s.jpg", CriptografiaUtil.generateUUID());
                ImageUtil.fromBaseToImage(funcionario.getFotoBase64(), pathImage);
                ImageIcon imageIcon = new ImageIcon(pathImage);
                imageIcon.setImage(imageIcon.getImage().getScaledInstance(198, 170, 100));
                lblImagemFuncionario.setIcon(imageIcon);

                ID_FUNCIONARIO = funcionario.getId();
                ID_USUARIO = funcionario.getUsuario().getId();
                TelasUtil.URL_FOTO_FUNCIONARIO = pathImage;
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

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        add(pnBotoes);
        add(pnCadastro);
        add(txtPesquisa);
        setJMenuBar(new MenuSuperior(tela));

        setVisible(true);
    }

    public static void limparCampos() {
        txtNome.setText("");
        txtCPF.setText("");
        txtEmail.setText("");
        rdAtivo.setSelected(false);
        comboBoxCargo.setSelectedItem(0);
        lblImagemFuncionario.setIcon(new ImageIcon(ImageUtil.getImagemProporcional("image/avatar.png", lblImagemFuncionario.getWidth(), lblImagemFuncionario.getHeight())));

        ID_FUNCIONARIO = null;
        ID_USUARIO = null;
        TelasUtil.URL_FOTO_FUNCIONARIO = null;
        txtEmail.enable(true);
    }
}
