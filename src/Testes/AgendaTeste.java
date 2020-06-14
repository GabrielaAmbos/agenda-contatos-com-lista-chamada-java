package Testes;

import Classes.Agenda;
import Classes.Contato;

import java.util.List;

public class AgendaTeste {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        Contato contato = new Contato("Pessoa1", "12345");
        agenda.adicionar(contato);
        List<Contato> listaContatos = agenda.listaDeContatos();
        for(int i = 0; i < listaContatos.size(); i++) {
            System.out.println(listaContatos.get(i).getNome());
        }
        System.out.println(agenda.pesquisarNome("12345"));
        agenda.remover(0);

    }
}
