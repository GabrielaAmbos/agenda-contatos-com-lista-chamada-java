package Classes;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionar(Contato contato) {
        contatos.add(contato);
    }
    public void remover(int posicao) {
        contatos.remove(posicao);
    }
    public String pesquisarNome(String numero) {
        for(int i = 0; i < contatos.size(); i++) {
            if(contatos.get(i).getNumero().equals(numero)) {
                return contatos.get(i).getNome();
            }
        }
        return numero;
    }

    public List<Contato> listaDeContatos() {
        return contatos;
    }
}
