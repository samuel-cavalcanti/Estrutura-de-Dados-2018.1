/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   RushHour.h
 * Author: samuel
 *
 * Created on 16 de Março de 2018, 12:09
 */

#ifndef RUSHHOUR_H
#define RUSHHOUR_H

#include "State.h"

#include <string>
#include <list>

class RushHour {
    /*
     * a representação do problema é :
     * a grade tem 6 colunas, numeradas 0 a 5 de esquerda para direita
     * e 6 linhas, numeradas de 0 a  5 de cima para baixo
     *
     * existem nbcars carros, numerados de 0 a  nbcars-1
     * para cada veículo i :
     * - color[i] fornece sua cor
     * - horiz[i] indica se temos um carro na horizontal
     * - len[i] fornece o seu comprimento (2 ou 3)
     * - moveon[i] indica em qual linha o carro se desloca para um carro horizontal
     *   e em qual coluna para um carro vertical
     *
     * o veiculo de indice 0 é o que tem que sair, temos então
     * horiz[0]==true, len[0]==2, moveon[0]==2
     */

public:
    
    RushHour(int _nbCars, std::vector<std::string>& _color , std::vector<bool>& _horiz,
             std::vector<int>& _len ,std::vector<int>& _moveon );

    int nbcars;
    std::vector<std::string> color;
    std::vector<bool> horiz;
    std::vector<int> len;
    std::vector<int> moveon;

    int nbMoves;
    /*
     * a matriz free é utilizada em moves para determinar rapidamente se a casa (i,j) está livre
     */
    bool free[6][6];

    void initFree(State* s);
    std::list<State*> moves(State* s);
    State* solve(State* s);
    void printSolution(State* s);


    RushHour();
    RushHour(const RushHour& orig);
    virtual ~RushHour();
private:
    
    void clearFree();
    bool verifyInAdjacencyList();

};


struct hash_state {

    size_t operator()(const State* t) const {
        int h = 0;

        for (int i = 0; i < t->pos.size(); i++)
            h = 37 * h + t->pos[i];

        return h;
    }
};

//função igualdade para hash_set

struct eq_state {

    bool operator()(const State* t1, const State* t2) const {

        if (t1->pos.size() != t2->pos.size()) return false;
        for (int i = 0; i < t1->pos.size(); i++) {
            if (t1->pos[i] != t2->pos[i]) return false;

        }
        return true;
    }
};


#endif /* RUSHHOUR_H */

