import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ComandoVenda extends Comando{
    private JFrame janela= new JFrame("");  
    private JLabel lblData,lblIdCom,lblIdLivro,lblIdVend;
    private JTextField txtData,txtIdCom,txtIdLivro,txtIdVend;
    private JButton botao;

    public void criarComando(String digitoOperacao, String digitoEntidade){
        if (digitoOperacao.equals("1") && digitoEntidade.equals("4")) {
            lblIdCom=new JLabel("IdCom: ");  
            lblIdCom.setBounds(10,50, 100,30);  
            txtIdCom= new JTextField();
            txtIdCom.setBounds(110, 50, 100, 30);

            lblIdLivro=new JLabel("IdLivro: ");  
            lblIdLivro.setBounds(10,100, 100,30);  
            txtIdLivro= new JTextField();
            txtIdLivro.setBounds(110, 100, 100, 30);

            lblIdVend=new JLabel("IdVend: ");  
            lblIdVend.setBounds(10,150, 100,30);  
            txtIdVend= new JTextField();
            txtIdVend.setBounds(110, 150, 100, 30);

            botao = new JButton("Confirmar");
            botao.setBounds(110, 200, 100, 30);

            janela.add(lblIdCom); 
            janela.add(txtIdCom);
            janela.add(lblIdLivro); 
            janela.add(txtIdLivro);
            janela.add(lblIdVend); 
            janela.add(txtIdVend);
            janela.add(botao);

            janela.setSize(350,320);  
            janela.setLayout(null);  
            janela.setVisible(true);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int IdCom = Integer.parseInt(txtIdCom.getText());
                    int IdLivro = Integer.parseInt(txtIdLivro.getText());
                    int IdVend = Integer.parseInt(txtIdVend.getText());
                    String msg = "insert into venda(Data,IdCom,IdLivro,IdVend) values (now(),'"+IdCom+"','"+IdLivro+"','"+IdVend+"')";
                    Conexao cn = new Conexao();
                    cn.inserir(msg);
                    janela.dispose();
                    voltarIndex();
                }
            });
            
        }else if(digitoOperacao.equals("2") && digitoEntidade.equals("4")){
            lblData=new JLabel("ID: ");  
            lblData.setBounds(10,50, 100,30);  
            txtData= new JTextField();
            txtData.setBounds(110, 50, 100, 30);

            botao = new JButton("Confirmar");
            botao.setBounds(110, 100, 100, 30);
            
            janela.add(lblData); 
            janela.add(txtData);
            janela.add(botao);

            janela.setSize(350,240);  
            janela.setLayout(null);  
            janela.setVisible(true);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String Data = txtData.getText();
                    String msg = "delete from venda where idvend="+Data;
                    Conexao cn = new Conexao();
                    cn.excluir(msg);
                    janela.dispose();
                    voltarIndex();
                }
            });
        }else if(digitoOperacao.equals("3") && digitoEntidade.equals("4")){
            Conexao cn = new Conexao();
            cn.listar("select * from venda",4);
            janela.dispose();
            voltarIndex();
        }
        
        
    }
}
