/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   State.h
 * Author: samuel
 *
 * Created on 16 de Março de 2018, 10:37
 */

#ifndef STATE_H
#define STATE_H

#include <iostream>
#include <set>
#include <queue>
#include <vector>


class State {
public:
    /*
     * constrói um estado inicial (c e d recebem qualquer valor = lixo)
     */

   
    State(std::vector<int>& p);


    /*
     * o estado fornece a posição de cada veículo, utilizando a seguinte convenção :
     * para um veículo horizontal é a coluna da casa mais à esquerda
     * para um veículo vertical é a coluna da casa mais acima
     * (lembrete: a coluna mais à esquerda é 0, e a linha mais alta é 0)
     */
    std::vector<int> pos;

    /*
     * nós guardamos qual o deslocamento levou a este estado
     */
    int c;
    int d;
    State* prev;


    /*
     * constrói um estado obtido a partir de s deslocando-se o veículo c de d (-1 ou +1)
     */
    State(State* s, int c, int d);

    // nós ganhamos?
    bool success();

    bool equals(State* s);
private:

};

#endif /* STATE_H */

