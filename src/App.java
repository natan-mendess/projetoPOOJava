public class App {
    //variaveis globais para identicar a operação e entidade a ser manipulada
    public static String digitoOperacao;
    public static String digitoEntidade;
    public static void main(String[] args) throws Exception { 
        IndexCruds janela = new IndexCruds();
        janela.initialize();
        janela.atribuirDigito();
    }
}
