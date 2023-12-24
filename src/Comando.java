
public abstract class Comando {
    //metodo para abrir a próxima janela
    protected void abrirNovaJanela(IndexCruds janela) {
        janela.initialize();
        janela.atribuirDigito();
    }
    //voltar para a página inicial após a conclusão das ações
    protected void voltarIndex(){
        abrirNovaJanela(new IndexCruds());
    }
    //obrigar a implementar o método criar comando
    protected abstract void criarComando(String digitoOperacao, String digitoEntidade);
}
