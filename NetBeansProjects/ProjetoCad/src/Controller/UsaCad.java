package Controller;

import javax.swing.JOptionPane;

/**
 * public class UsaCad {
 *
 * Cad primeiroNo; Cad ultimoNo; int cont;
 *
 * UsaCad() { primeiroNo = null; ultimoNo = null; cont = 0; }
 *
 * void addCad(Object dado) { Cad newCad = new Cad(); newCad.dado = dado;
 * newCad.liga = null; cont++; if (primeiroNo == null) {
 *
 * primeiroNo = newCad; ultimoNo = newCad;
 *
 * } else {
 *
 * ultimoNo.liga = newCad;
 *
 * }
 * ultimoNo = newCad;
 *
 * }
 *
 * void pilotar() { Cad temp = primeiroNo; while (temp != null) {
 * System.out.println("");
 *
 * }
 * }
 *
 * void destrutor() { Cad temp = primeiroNo; Cad aux;
 *
 * while (temp != null) { aux = temp; aux = null; temp = temp.liga; }
 *
 * System.out.println("Estrutura Destruida..."); } }
 *
 * @author vinicius.damaceno
 */
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class UsaCad {

    Cad primeiroNo;
    Cad ultimoNo;
    int cont;

    UsaCad() {
        primeiroNo = null;
        ultimoNo = null;
        cont = 0;
    }

    void addCad(Object dado) {
        Cad newCad = new Cad();
        newCad.dado = dado;
        newCad.liga = null;
        cont++;
        if (primeiroNo == null) {
            primeiroNo = newCad;
            ultimoNo = newCad;
        } else {
            ultimoNo.liga = newCad;
        }
        ultimoNo = newCad;
    }

    void pilotar() {
        Cad temp = primeiroNo;
        StringBuilder output = new StringBuilder();
        while (temp != null) {
            output.append(temp.dado).append("\n");
            temp = temp.liga;
        }
        JOptionPane.showMessageDialog(null, output.toString(), "Elementos na lista", JOptionPane.INFORMATION_MESSAGE);
    }

    void destrutor() {
        primeiroNo = null;
        ultimoNo = null;
        JOptionPane.showMessageDialog(null, "Estrutura Destruida...", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        UsaCad lista = new UsaCad();
        int opcao;

        do {
            String input = JOptionPane.showInputDialog("Menu de Controle\n"
                    + "1. Adicionar elemento\n"
                    + "2. Mostrar elementos\n"
                    + "3. Destruir estrutura\n"
                    + "0. Sair\n"
                    + "Escolha uma opção:");
            opcao = Integer.parseInt(input);

            switch (opcao) {
                case 1:
                    Object dado = JOptionPane.showInputDialog("Digite o elemento a ser adicionado:");
                    lista.addCad(dado);
                    break;
                case 2:
                    lista.pilotar();
                    break;
                case 3:
                    lista.destrutor();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Encerrando programa...", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (opcao != 0);
    }
}

class Cad {

    Object dado;
    Cad liga;
}
