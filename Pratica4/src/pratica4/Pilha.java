/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica4;

import java.util.LinkedList;

/**
 *
 * @author samuel
 */
public class Pilha<T> {

    private LinkedList<T> conteudo;

    /*
     @param instancia uma lista vazia
     */
    public Pilha() {
        conteudo = new LinkedList<>();
    }

    /**
     * adiciona o elemento x ao topo da pilha
     *
     * @param x item a ser a adicionado a lista
     */
    public void empilha(T x) {
        conteudo.addFirst(x);
    }

    /**
     *
     * @return o primeiro elemento da pilha
     */
    public T topo() {
        return conteudo.getFirst();
    }

    /**
     * remove e retorna o primeiro elemento
     *
     * @return o primeiro elemento
     */
    public T desempilha() {
        return conteudo.removeFirst();
    }

    /**
     *
     * @return o tamanho da pilha
     */
    public int size() {
        return conteudo.size();
    }

    /**
     * retira todos os elemento da lista conteudo
     */
    public void reinicialize() {
        conteudo.clear();
       

    }

    /**
     *
     * @return retorna true se a pilha está vazia e false caso contrário
     */
    public boolean estaVazia() {
        return conteudo.isEmpty();
    }

    /**
     * poder imprimir o estado da pilha enquanto a calculadora funcionar
     *
     * @return
     */
    public String toString() {
        return conteudo.toString();
    }
    
    /**
     * 
     * @return retorna uma cadeia de caracteres correspondente ao conteúdo da lista conteudo na ordem inversa 
     */

    public String toStringInverse() {
        Pilha temp = new Pilha<>();
        for (T value : conteudo) {
            temp.empilha(value);
        }
        return temp.toString();
    }

}
