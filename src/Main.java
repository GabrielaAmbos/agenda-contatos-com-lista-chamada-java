import Classes.Agenda;
import Classes.Chamadas;
import Classes.Contato;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Agenda agenda = new Agenda();
        Chamadas chamadas = new Chamadas();
        int escolha;
        do {
            System.out.println("Escolha uma opcao: ");
            System.out.println("" +
                    "[1] Cadastrar contato \n" +
                    "[2] Remover contato \n" +
                    "[3] Cadastrar chamada nao atendida \n" +
                    "[4] Mostrar lista de chamadas nao atendidas \n" +
                    "[5] Excluir todas as chamadas nao atendidas \n" +
                    "[6] Sair ");
            escolha = in.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Adicionando contato: ");
                    System.out.println("Informe um nome: ");
                    String nome = in.nextLine();
                    System.out.println("Informe um numero: ");
                    String numero = in.nextLine();
                    Contato contato = new Contato(nome, numero);
                    agenda.adicionar(contato);
                    break;
                case 2:
                    System.out.println("Removendo um contato: ");
                    List<Contato> contatos = agenda.listaDeContatos();
                    for (int i = 0; i < contatos.size(); i++) {
                        System.out.println("[" + i + "] " + contatos.get(i).getNome());
                    }
                    System.out.println("Qual numero voce deseja excluir? ");
                    int posicao = in.nextInt();
                    agenda.remover(posicao);
                    break;
                case 3:
                    System.out.println("Cadastrar chamada nao atendida: ");
                    System.out.println("Informe um numero: ");
                    String numeroAdd = in.nextLine();
                    String nomeAdd = agenda.pesquisarNome(numeroAdd);
                    chamadas.adicionar(nomeAdd, numeroAdd);
                    break;
                case 4:
                    System.out.println("Mostrar lista de chamadas nao atendidas: ");
                    List<Contato> listaDeChamadas = chamadas.exibirChamadas();
                    for (int i = 0; i < listaDeChamadas.size(); i++) {
                        System.out.println(listaDeChamadas.get(i).getNome());
                    }
                    break;
                case 5:
                    System.out.println("Excluir todas as chamadas nao atendidas: ");
                    chamadas.removerTudo();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida!!!");
                    break;
            }
        }while (escolha != 6);
    }
}
