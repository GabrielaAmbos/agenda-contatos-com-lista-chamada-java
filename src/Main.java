import Classes.Agenda;
import Classes.Chamadas;
import Classes.Contato;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static Agenda agenda = new Agenda();
    private static Chamadas chamadas = new Chamadas();

    public static void main(String[] args) {
        int escolha;
        do {
            mostrarMenuPrincipal();
            escolha = in.nextInt();
            in.nextLine(); //Limpa cache do teclado
            switch (escolha) {
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    cadastrarChamadaNaoAtendida();
                    break;
                case 4:
                    mostrarListaChamadasNaoAtendidas();
                    break;
                case 5:
                    excluirTodasChamadasNaoAtendidas();
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

    private static void excluirTodasChamadasNaoAtendidas() {
        System.out.println(" ---- Excluir todas as chamadas nao atendidas ----- ");
        chamadas.removerTudo();
    }

    private static void mostrarListaChamadasNaoAtendidas() {
        System.out.println(" ---- Mostrar lista de chamadas nao atendidas ------- ");
        List<Contato> listaDeChamadas = chamadas.exibirChamadas();
        if(listaDeChamadas.isEmpty()) {
            System.out.println("Nao há chamadas!");
        } else {
            for (int i = 0; i < listaDeChamadas.size(); i++) {
                System.out.println(listaDeChamadas.get(i).getNome());
            }
        }
    }

    private static void cadastrarChamadaNaoAtendida() {
        System.out.println(" ----- Cadastrar chamada nao atendida ------- ");
        System.out.println("Informe um numero: ");
        String numeroAdd = in.nextLine();
        String nomeAdd = agenda.pesquisarNome(numeroAdd);
        chamadas.adicionar(nomeAdd, numeroAdd);
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Escolha uma opcao: ");
        System.out.println("" +
                "[1] Cadastrar contato \n" +
                "[2] Remover contato \n" +
                "[3] Cadastrar chamada nao atendida \n" +
                "[4] Mostrar lista de chamadas nao atendidas \n" +
                "[5] Excluir todas as chamadas nao atendidas \n" +
                "[6] Sair ");
    }

    private static void adicionarContato() {
        System.out.println(" ------ Adicionando contato -------- ");
        System.out.println("Informe um nome: ");
        String nome = in.nextLine();
        System.out.println("Informe um numero: ");
        String numero = in.nextLine();
        Contato contato = new Contato(nome, numero);
        chamadas.atualizaContato(contato);
        agenda.adicionar(contato);
    }

    private static void removerContato() {
        System.out.println(" ------ Removendo um contato -------- ");
        List<Contato> contatos = agenda.listaDeContatos();
        if(contatos.isEmpty()) {
            System.out.println("Nao há contatos para serem removidos!");
        } else {
            for (int i = 0; i < contatos.size(); i++) {
                System.out.println("[" + i + "] " + contatos.get(i).getNome());
            }
            System.out.println("Qual numero voce deseja excluir? ");
            int posicao = in.nextInt();
            in.nextLine(); //Limpa cache do teclado
            if(posicao < contatos.size()) {
                Contato contatoRemover = contatos.get(posicao);
                chamadas.removeContato(contatoRemover);
                agenda.remover(posicao);
            } else {
                System.out.println("Posicao inválida!!!");
            }
        }
    }
}
