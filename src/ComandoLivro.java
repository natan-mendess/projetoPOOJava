import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ComandoLivro extends Comando{
    private JFrame janela= new JFrame("");  
    private JLabel lblTitulo,lblAutor,lblPreco;
    private JTextField txtTitulo,txtAutor,txtPreco;
    private JButton botao;

    public void criarComando(String digitoOperacao, String digitoEntidade){
        if (digitoOperacao.equals("1") && digitoEntidade.equals("3")) {
            lblTitulo=new JLabel("Titulo: ");  
            lblTitulo.setBounds(10,50, 100,30);  
            txtTitulo= new JTextField();
            txtTitulo.setBounds(110, 50, 100, 30);

            lblAutor=new JLabel("Autor: ");  
            lblAutor.setBounds(10,100, 100,30);  
            txtAutor= new JTextField();
            txtAutor.setBounds(110, 100, 100, 30);

            lblPreco=new JLabel("Preco: ");  
            lblPreco.setBounds(10,150, 100,30);  
            txtPreco= new JTextField();
            txtPreco.setBounds(110, 150, 100, 30);

            botao = new JButton("Confirmar");
            botao.setBounds(110, 200, 100, 30);

            janela.add(lblTitulo); 
            janela.add(txtTitulo);
            janela.add(lblAutor); 
            janela.add(txtAutor);
            janela.add(lblPreco); 
            janela.add(txtPreco);
            janela.add(botao);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            janela.setSize(400,300);  
            janela.setLayout(null);  
            janela.setVisible(true);

            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String Titulo = txtTitulo.getText();
                    String Autor = txtAutor.getText();
                    double Preco = Double.parseDouble(txtPreco.getText());
                    String msg = "insert into livro(titulo,autor,preco) values ('"+Titulo+"','"+Autor+"','"+Preco+"')";
                    Conexao cn = new Conexao();
                    cn.inserir(msg);
                    janela.dispose();
                    voltarIndex();
                }
            });
            
        }else if(digitoOperacao.equals("2") && digitoEntidade.equals("3")){
            lblTitulo=new JLabel("ID: ");  
            lblTitulo.setBounds(10,50, 100,30);  
            txtTitulo= new JTextField();
            txtTitulo.setBounds(110, 50, 100, 30);

            botao = new JButton("Confirmar");
            botao.setBounds(110, 200, 100, 30);
            
            janela.add(lblTitulo); 
            janela.add(txtTitulo);
            janela.add(botao);

            janela.setSize(400,270);  
            janela.setLayout(null);  
            janela.setVisible(true);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String Titulo = txtTitulo.getText();
                    String msg = "delete from livro where idlivro="+Titulo;
                    Conexao cn = new Conexao();
                    cn.excluir(msg);
                    janela.dispose();
                    voltarIndex();
                }
            });
        }else if(digitoOperacao.equals("3") && digitoEntidade.equals("3")){
            Conexao cn = new Conexao();
            cn.listar("select * from livro",3);
            janela.dispose();
            voltarIndex();
        }
    }
}
