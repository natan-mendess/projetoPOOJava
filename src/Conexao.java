import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Conexao implements Interface{
    //dados da conexão
    private String DB_URL = "jdbc:mysql://localhost:3306/pukapuka";
    private String USER = "root";
    private String PASS = "";
    private Connection conn;

    //abrir conexão
    public Conexao() {
      try {
        this.conn = DriverManager.getConnection(this.DB_URL, this.USER, this.PASS);
         
      } catch (SQLException e) {
         e.printStackTrace();
      } 
    }
    //metodo de inserção
    public void inserir(String comando){
        try (Statement stmt = this.conn.createStatement()) {
          try {
            stmt.executeUpdate(comando);
          } catch (SQLException e) {
            e.printStackTrace();
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }  
    }

    //metodo de exclusão
    public void excluir(String comando){
        try (Statement stmt = this.conn.createStatement()) {
          try {
            stmt.executeUpdate(comando);
          } catch (SQLException e) {
            e.printStackTrace();
          }
        } catch (SQLException e) {
          e.printStackTrace();
        }  
    }
    //cria um result set e recebe a entidade
    public void listar(String comando, int Entidade) {
        try (Statement stmt = this.conn.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(comando)) {
                exibirResultados(rs,Entidade);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //cria a lista efetivamente recebendo oq foi coletado no método listar
    public void exibirResultados(ResultSet rs, int Entidade) throws SQLException {
        //cria o espaço para exibição dos dados
        JFrame frame = new JFrame("Resultados da Consulta");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        //cria a area de texto para exibir os registro
        JTextArea textArea = new JTextArea();
        //bloqueia a edição
        textArea.setEditable(false);

        //decide qual entidade irá ser exibida baseando-se na varíavel global
        //vendedor
        if(Entidade==1){
          while (rs.next()) {
            textArea.append("ID: " + rs.getInt("idvend") + "\nNome: " + rs.getString("nome") + "\nCPF: " + rs.getString("cpf") + "\nTurno: " + rs.getString("turno") + "\n\n");
          }
        //comprador
        }else if(Entidade==2){
            while (rs.next()) {
              textArea.append("ID: " + rs.getInt("idcom") + "\nNome: " + rs.getString("nome") + "\nCPF: " + rs.getString("cpf") + "\n\n");
          }
        //livro
        }else if(Entidade==3){
            while (rs.next()) {
            textArea.append("ID: " + rs.getInt("idlivro") + "\nTítulo: " + rs.getString("titulo") + "\nAutor: " + rs.getString("autor") + "\nPreço: " + rs.getFloat("preco") + "\n\n");
          }
        //venda
        }else if(Entidade==4){
            while (rs.next()) {
              textArea.append("ID: " + rs.getInt("idvenda") + "\nData: " + rs.getDate("data") + "\nIDcom: " + rs.getInt("idcom") + "\nIDlivro: " + rs.getInt("idlivro") + "\nIDvend: " + rs.getInt("idvend") + "\n\n");
          }
        }
        //adiciona o scroll
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);
        //botao para fechar
        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        //adiciona o botao ao frame
        frame.add(closeButton, BorderLayout.SOUTH);
        //define o tamanho do espaço de registros
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
}
