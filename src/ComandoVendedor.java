import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ComandoVendedor extends Comando{
    private JFrame janela= new JFrame("");  
    private JLabel lblNome,lblCpf,lblTurno;
    private JTextField txtNome,txtCpf,txtTurno;
    private JButton botao;

    public void criarComando(String digitoOperacao, String digitoEntidade){
        if (digitoOperacao.equals("1") && digitoEntidade.equals("1")) {
            lblNome=new JLabel("Nome: ");  
            lblNome.setBounds(10,50, 100,30);  
            txtNome= new JTextField();
            txtNome.setBounds(110, 50, 100, 30);

            lblCpf=new JLabel("Cpf: ");  
            lblCpf.setBounds(10,100, 100,30);  
            txtCpf= new JTextField();
            txtCpf.setBounds(110, 100, 100, 30);

            lblTurno=new JLabel("Turno: ");  
            lblTurno.setBounds(10,150, 100,30);  
            txtTurno= new JTextField();
            txtTurno.setBounds(110, 150, 100, 30);

            botao = new JButton("Confirmar");
            botao.setBounds(110, 200, 100, 30);

            janela.add(lblNome); 
            janela.add(txtNome);
            janela.add(lblCpf); 
            janela.add(txtCpf);
            janela.add(lblTurno); 
            janela.add(txtTurno);
            janela.add(botao);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            janela.setSize(400,300);  
            janela.setLayout(null);  
            janela.setVisible(true);

            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nome = txtNome.getText();
                    String cpf = txtCpf.getText();
                    String turno = txtTurno.getText();
                    String msg = "insert into vendedor(nome,cpf,turno) values ('"+nome+"','"+cpf+"','"+turno+"')";
                    Conexao cn = new Conexao();
                    cn.inserir(msg);
                    janela.dispose();
                    voltarIndex();
                }
            });
            
        }else if(digitoOperacao.equals("2") && digitoEntidade.equals("1")){
            lblNome=new JLabel("ID: ");  
            lblNome.setBounds(10,50, 100,30);  
            txtNome= new JTextField();
            txtNome.setBounds(110, 50, 100, 30);

            botao = new JButton("Confirmar");
            botao.setBounds(110, 200, 100, 30);
            
            janela.add(lblNome); 
            janela.add(txtNome);
            janela.add(botao);

            janela.setSize(400,270);  
            janela.setLayout(null);  
            janela.setVisible(true);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nome = txtNome.getText();
                    String msg = "delete from vendedor where idvend="+nome;
                    Conexao cn = new Conexao();
                    cn.excluir(msg);
                    janela.dispose();
                    voltarIndex();
                }
            });
        }else if(digitoOperacao.equals("3") && digitoEntidade.equals("1")){
            Conexao cn = new Conexao();
            cn.listar("select * from vendedor",1);
            janela.dispose();
            voltarIndex();
        }
    }
}