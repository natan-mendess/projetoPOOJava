import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class IndexCruds extends JFrame{
    private JFrame janela= new JFrame("Operações");
    private JButton botaoCadastrar, botaoDeletar, botaoListar;
    //inicio do programa, criando a janela
    public void initialize() {
        
        int x = 60;
        int y = 50;
        int width = 150;
        int height = 30;

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(x, y, width, height);

        botaoDeletar = new JButton("Deletar");
        botaoDeletar.setBounds(x, y + 40, width, height);

        botaoListar = new JButton("Listar");
        botaoListar.setBounds(x, y + 80, width, height);

        janela.add(botaoCadastrar);
        janela.add(botaoDeletar);
        janela.add(botaoListar);

        janela.setSize(300,250); 
        janela.setLayout(null);
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int janelaX = 800;  // posição horizontal
        int janelaY = 350;  // posição vertical
        janela.setLocation(janelaX, janelaY);

    }
    //escuta os botoes e abre suas respectivas janelas, atribuindo a variavel global
    public void atribuirDigito() {        
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.digitoOperacao = "1";
                abrirNovaJanela(new IndexEntidades());
            }
        });
       

        botaoDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.digitoOperacao = "2";
                abrirNovaJanela(new IndexEntidades());
            }
        });

        botaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                App.digitoOperacao = "3";
                abrirNovaJanela(new IndexEntidades());
            }
        });

    }
    //usado em todos os botoes para abrir as opções de entidades
    private void abrirNovaJanela(IndexEntidades janela) {
        janela.initialize();
        janela.atribuirDigito();
        this.janela.dispose();
    }

}

