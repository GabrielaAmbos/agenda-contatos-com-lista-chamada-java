package Testes;

import Classes.Contato;

public class ContatoTeste {
    public static void main(String[] args) {

        Contato contato = new Contato("Pessoa1", "1234");
        System.out.println(contato.getNome() + "\n" + contato.getNumero());

        contato.setNome("Pessoa2");
        contato.setNumero("4567");
        System.out.println(contato.getNome() + "\n" + contato.getNumero());
    }
}
