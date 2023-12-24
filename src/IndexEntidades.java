import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IndexEntidades extends JFrame{
    private JFrame janela= new JFrame("Entidades");
    private JButton botaoVendedor, botaoComprador, botaoLivro, botaoVenda;
    //inicia criando a janela
    public void initialize() {
        int x = 60;
        int y = 50;
        int width = 150;
        int height = 30;

        botaoVendedor = new JButton("Vendedor");
        botaoVendedor.setBounds(x, y, width, height);

        botaoComprador = new JButton("Comprador");
        botaoComprador.setBounds(x, y + 40, width, height);

        botaoLivro = new JButton("Livro");
        botaoLivro.setBounds(x, y + 80, width, height);

        botaoVenda = new JButton("Venda");
        botaoVenda.setBounds(x, y + 120, width, height);

        janela.add(botaoVendedor);
        janela.add(botaoComprador);
        janela.add(botaoLivro);
        janela.add(botaoVenda);

        janela.setSize(300,300); 
        janela.setLayout(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        janela.setSize(300, 300);
        janela.setLayout(null);
    
        //deixa centralizado
          janela.setLocationRelativeTo(null);
          janela.setVisible(true);
          janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    //escuta os botoes e abre suas respectivas janelas, atribuindo a variavel global
    public void atribuirDigito() {        
            botaoVendedor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    App.digitoEntidade = "1";
                    abrirNovaJanela(new ComandoVendedor());
                }
            });
            
            botaoComprador.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    App.digitoEntidade = "2";
                    abrirNovaJanela(new ComandoComprador());
                }
            });
    
            botaoLivro.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    App.digitoEntidade = "3";
                    abrirNovaJanela(new ComandoLivro());
                }
            });

            botaoVenda.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    App.digitoEntidade = "4";
                    abrirNovaJanela(new ComandoVenda());
                }
            });

            
    }

    //usado em todos os botoes para abrir as opções de entidades
    private void abrirNovaJanela(ComandoVendedor janela) {
        janela.criarComando(App.digitoOperacao, App.digitoEntidade);
        this.janela.dispose();
    }

    private void abrirNovaJanela(ComandoComprador janela) {
        janela.criarComando(App.digitoOperacao, App.digitoEntidade);
        this.janela.dispose();
    }

    private void abrirNovaJanela(ComandoLivro janela) {
        janela.criarComando(App.digitoOperacao, App.digitoEntidade);
        this.janela.dispose();
    }

    private void abrirNovaJanela(ComandoVenda janela) {
        janela.criarComando(App.digitoOperacao, App.digitoEntidade);
        this.janela.dispose();
    }
}
