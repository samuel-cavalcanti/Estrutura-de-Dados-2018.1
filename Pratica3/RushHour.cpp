/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   RushHour.cpp
 * Author: samuel
 * 
 * Created on 16 de Março de 2018, 12:09
 */

#include "RushHour.h"

#include <hash_set>
#include <iostream>
#include <queue>

RushHour::RushHour() {
}

RushHour::RushHour(const RushHour& orig) {
}

RushHour::~RushHour() {
}

RushHour::RushHour(int _nbCars, std::vector<std::string>& _color,
        std::vector<bool>& _horiz, std::vector<int>& _len, std::vector<int>& _moveon) {

    nbcars = _nbCars;
    color = _color;
    horiz = _horiz;
    len = _len;
    moveon = _moveon;


}

void RushHour::initFree(State* s) {
    clearFree();



    for (unsigned int i = 0; i < nbcars; i++) {


        if (horiz[i]) {
            for (int spaceOccupied = 0; spaceOccupied < len[i]; spaceOccupied++)
                free[moveon[i]][s->pos[i] + spaceOccupied] = false;
        } else {
            for (int spaceOccupied = 0; spaceOccupied < len[i]; spaceOccupied++)
                free[s->pos[i] + spaceOccupied ][moveon[i] ] = false;

        }



    }

}

std::list<State*> RushHour::moves(State* s) {
    initFree(s);
    std::list<State*> l;


    for (int i = 0; i < nbcars; i++) {


        if (horiz[i]) {

            if (s->pos[i] + len[i] < 6)
                if (free[moveon[i]][s->pos[i] + len[i]])
                    l.push_back(new State(s, i, 1));

            if (s->pos[i] - 1 >= 0)
                if (free[moveon[i]][s->pos[i] - 1])
                    l.push_back(new State(s, i, -1));

        } else {

            if (s->pos[i] + len[i] < 6)
                if (free[s->pos[i] + len[i] ][moveon[i] ])
                    l.push_back(new State(s, i, 1));

            if (s->pos[i] - 1 >= 0)
                if (free[s->pos[i] - 1 ][moveon[i] ])
                    l.push_back(new State(s, i, -1));

        }


    }
    // A SER COMPLETADA
    return l;

}

State* RushHour::solve(State* s) {
    if (s->success())
        return s;

    __gnu_cxx::hash_set<State*, hash_state, eq_state> visited;
    visited.insert(s);
    std::queue<State*> q;
    q.push(s);


    while (!q.empty()) {

        State* currentState = q.front();

        for (auto s : moves(currentState)) {

            if (visited.find(s) == visited.end()) {

                if ((s)->success())
                    return s;

                q.push(s);
                visited.insert(s);
            }
        }

        q.pop();

    }
    std::cerr << "sem solução" << std::endl;
    exit(1);
}

/*
 * imprime uma solução
 */

void RushHour::printSolution(State* s) {
    int n = 0;
    std::list<State*> allSteps;

    for (State* i = s; i->prev != NULL; i = i->prev) {
        allSteps.push_front(i);
        n++;
    }



    std::cout << n << " deslocamentos" << std::endl;

    for (auto step : allSteps) {

        std::cout << "veiculo " << color[step->c] << " ";

        if (horiz[step->c]) {

            if (step->d > 0)
                std::cout << "para a direita" << std::endl;
            else
                std::cout << "para esquerda" << std::endl;

        } else {

            if (step->d < 0)
                std::cout << "para cima" << std::endl;
            else
                std::cout << "para baixo" << std::endl;

        }

    }




}

void RushHour::clearFree() {
    int tam = 6;
    for (int i = 0; i < tam; i++)
        for (int j = 0; j < tam; j++)
            free[i][j] = 1;
}


