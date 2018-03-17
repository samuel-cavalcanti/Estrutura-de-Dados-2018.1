/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   State.cpp
 * Author: samuel
 * 
 * Created on 16 de Março de 2018, 10:37
 */

#include "State.h"



State::State(std::vector<int>& p) {
   // pos = new int[ (int)p.size()];
    int tam = p.size();
    for (int i = 0; i < tam; i++)
        pos.push_back(p[i]);
    
    

    prev = NULL;
}

State::State(State* s, int _c, int _d) {
    prev = s;
    pos = s->pos;
    
    c = _c;
    d = _d;
    
    pos[_c] += _d;
    
    // A SER COMPLETADO
}

bool State::equals(State* s) {
    if (s->pos.size() != pos.size()) {
        std::cout << "Estados de comprimento diferentes" << std::endl;
        exit(1);
    }
    int tamanho = pos.size();

    for (int i = 0; i < tamanho; i++)
        if (pos[i] != s->pos[i]) return false;
    return true;
}

bool State::success() {
    
    // A SER COMPLETADO
    if (pos[0] == 4)
        return true; 
    else 
        return false;
}




