import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ComandoComprador extends Comando{
    private JFrame janela= new JFrame("");  
    private JLabel lblNome,lblCpf;
    private JTextField txtNome,txtCpf;
    private JButton botao;
    //metodo que importa as variaveis globais para decidir qual operação fazer
    public void criarComando(String digitoOperacao, String digitoEntidade){
        //caso seja operação insert
        if (digitoOperacao.equals("1") && digitoEntidade.equals("2")) {
            //criação da janela
            lblNome=new JLabel("Nome: ");  
            lblNome.setBounds(10,50, 100,30);  
            txtNome= new JTextField();
            txtNome.setBounds(110, 50, 100, 30);

            lblCpf=new JLabel("Cpf: ");  
            lblCpf.setBounds(10,100, 100,30);  
            txtCpf= new JTextField();
            txtCpf.setBounds(110, 100, 100, 30);

            botao = new JButton("Confirmar");
            botao.setBounds(110, 150, 100, 30);

            janela.add(lblNome); 
            janela.add(txtNome);
            janela.add(lblCpf); 
            janela.add(txtCpf);
            janela.add(botao);

            janela.setSize(400,250);  
            janela.setLayout(null);  
            janela.setVisible(true);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nome = txtNome.getText();
                    String cpf = txtCpf.getText();
                    String msg = "insert into comprador(nome,cpf) values ('"+nome+"','"+cpf+"')";
                    Conexao cn = new Conexao();
                    cn.inserir(msg);
                    janela.dispose();
                    voltarIndex();
                }
            });
        //se for operação delete
        }else if(digitoOperacao.equals("2") && digitoEntidade.equals("2")){
            //criação da janela
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
                    //recuperar id
                    String nome = txtNome.getText();
                    String msg = "delete from comprador where idcom="+nome;
                    Conexao cn = new Conexao();
                    cn.excluir(msg);
                    janela.dispose();
                    voltarIndex();
                }
            });
        //se operação for listar
        }else if(digitoOperacao.equals("3") && digitoEntidade.equals("2")){
            Conexao cn = new Conexao();
            cn.listar("select * from comprador",2);
            janela.dispose();
            voltarIndex();
        }
    }
}
