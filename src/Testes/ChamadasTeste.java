package Testes;
import Classes.Chamadas;
import Classes.Contato;

import java.util.List;

public class ChamadasTeste {
    public static void main(String[] args) {
        Chamadas chamadas = new Chamadas();
        Contato contato = new Contato("Pessoa1", "123445");
        chamadas.adicionar("Pessoa1", "123445");
        chamadas.removeContato(contato);
        chamadas.atualizaContato(contato);
        List<Contato> listaContatos = chamadas.exibirChamadas();
        for(int i = 0; i < listaContatos.size(); i++) {
            System.out.println(listaContatos.get(i).getNome());
        }
        chamadas.removerTudo();
    }
}
