/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica4;

import java.io.*;

/**
 *
 * @author samuel
 */
public class CalcRPN {

    /**
     * variáveis da instancia : uma pilha para os cálculos, uma pilha para
     * histórico
     */
    Pilha<Double> aPilha;
    Pilha<Operacao> hist;

    /**
     * construtor
     */
    CalcRPN() {
        aPilha = new Pilha<>();
        hist = new Pilha<>();

    }

    /**
     * Adição de dois elementos do topo da pilha
     */
    public void mais() {

        Double a = aPilha.desempilha();

        Double b = aPilha.desempilha();

        aPilha.empilha(a + b);

        hist.empilha(new Operacao('+', a, b));

    }

    /**
     * Subtração de dois elementos do topo da pilha
     */
    public void menos() {
        Double a = aPilha.desempilha();

        Double b = aPilha.desempilha();

        aPilha.empilha(b - a);
        hist.empilha(new Operacao('-', a, b));

    }

    /**
     * Multiplicação de dois elementos do topo da pilha
     */
    public void vezes() {
        Double a = aPilha.desempilha();

        Double b = aPilha.desempilha();

        aPilha.empilha(a * b);
        hist.empilha(new Operacao('*', a, b));

    }

    /**
     * Divisão de dois elementos no topo da pilha
     */
    public void dividido() {
        Double a = aPilha.desempilha();

        Double b = aPilha.desempilha();

        aPilha.empilha(b / a);
        hist.empilha(new Operacao('/', a, b));
    }

    /**
     *
     * @return retorna o conteudo do topo da pilha
     */
    public Double resultado() {
        //   Double resultado = aPilha.topo();

        // hist.empilha(new Operacao(resultado));
        return aPilha.topo();

    }

    /**
     * o cancelamento do último comando
     */
    public void cancela() {
        Operacao ultimaOperacao = hist.desempilha();
        aPilha.desempilha();

        if (ultimaOperacao.code != 'e') {
            aPilha.empilha(ultimaOperacao.b);
            aPilha.empilha(ultimaOperacao.a);
        }

    }

    private void empilha(String cmd) {
        Double value = Double.parseDouble(cmd);

        aPilha.empilha(value);
        hist.empilha(new Operacao(value));
    }

    private void renicialize() {
        aPilha.reinicialize();
        hist.reinicialize();

    }

    /**
     * interpretador de comandos
     *
     * @param cmd comando a ser interpretado
     */
    public void exec(String cmd) {

        switch (cmd) {

            case "+":
                mais();
                break;
            case "-":
                menos();
                break;
            case "*":
                vezes();
                break;
            case "/":
                dividido();
                break;
            case "clear":
                renicialize();
                break;

            case "hist":
                System.out.println("Historico = " + hist.toStringInverse());
                break;
            case "undo":
                cancela();
                System.out.println("Historico = " + hist.toStringInverse());
                break;

            case "exit":
                System.exit(0);
                break;

            default:
                empilha(cmd);
                break;
        }

    }

    public void interfaceUsuario() throws IOException {
        CalcRPN calc = new CalcRPN();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                continue;
            }
            for (String s : line.split(" ")) {
                calc.exec(s);
            }
            System.out.println("Pilha = " + calc.aPilha);

        }
        System.out.println("Até logo");
    }

}
