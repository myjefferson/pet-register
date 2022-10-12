import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @authores Eduarda dos Reis, Jefferson Carvalho dos Santos, Luis Henrique Martins Bonfim
 */
public class Main{
    public static void main(String[] args){
        Scanner leitura = new Scanner(System.in);
        ArrayList<Impressao> listaObjetos = new ArrayList<>();
        char opcao = 0;
        while(opcao != 'X'){
            System.out.println("==| Boas vindas ao iPetz Register |==");
            System.out.println("Digite C para nova cadastro");
            System.out.println("Digite M para listar cadastros");
            System.out.println("Digite X para encerrar");
            opcao = leitura.nextLine().toUpperCase().charAt(0);
            System.out.println("Opção selecionada: " + opcao);

            if(opcao == 'C'){
                System.out.println("Novo cadastro");
                Impressao cm = new Impressao();
                Mascara mascara = new Mascara();

                System.out.println("Nome do animal: ");
                cm.nomeAnimal = leitura.nextLine();

                System.out.println("Tutor do animal: ");
                cm.tutorAnimal = leitura.nextLine();

                System.out.println("Especie: ");
                cm.especie = leitura.nextLine();

                System.out.println("Peso em kg: ");
                cm.pesoAnimal = leitura.nextDouble();

                System.out.println("Data de Nascimento: ");
                leitura.nextLine();
                String entradaDataNascimento = leitura.nextLine();
                String dataNascimento = mascara.formatString(entradaDataNascimento,"##/##/####");
                cm.dataNascimento = dataNascimento;

                System.out.println("Telefone: ");
                String entradaTelefone = leitura.nextLine();
                String Telefone = mascara.formatString(entradaTelefone,"(##) #####-####");
                cm.numTelefone = Telefone;

                System.out.println("Endereço: ");
                cm.endereco = leitura.nextLine();

                System.out.println("Cidade: ");
                cm.cidade = leitura.nextLine();

                System.out.println("UF: ");
                cm.uf = leitura.nextLine();

                System.out.println("Selecione a foto Animal: ");
                JFileChooser chooser = new JFileChooser();

                FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
                    chooser.setFileFilter(filter);
                    Component parent = null;
                int returnVal = chooser.showOpenDialog(parent);
                    if(returnVal == JFileChooser.APPROVE_OPTION) {
                        cm.fotoAnimal = chooser.getSelectedFile().getPath();
                }
                listaObjetos.add(cm);
                System.out.println("=====| CADASTRADO COM SUCESSO!!! |=====");
            }
            else if(opcao == 'M'){
                System.out.println("Imprimindo conteúdo da lista");
                for(int i = 0; i< listaObjetos.size(); i++){
                    listaObjetos.get(i).listagem();
                }
            }else{
                System.out.println("Opção inválida");
            }
        }
        System.out.println("Você escolheu encerrar o programa. Pressione qualquer tecla para fechar");
        leitura.nextLine();
        System.exit(0);
    }
}