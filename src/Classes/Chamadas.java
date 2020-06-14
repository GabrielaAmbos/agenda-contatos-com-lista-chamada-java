package Classes;

import java.util.ArrayList;
import java.util.List;

public class Chamadas {
    private List<Contato> contatos;

    public Chamadas() {
        contatos = new ArrayList<>();
    }

    public void adicionar(String nome, String numero) {
        contatos.add(new Contato(nome, numero));
    }

    public void removerTudo() {
        contatos.clear();
    }

    public List<Contato> exibirChamadas () {
        return contatos;
    }
}
