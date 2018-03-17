/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Test.cpp
 * Author: samuel
 * 
 * Created on 16 de Março de 2018, 12:15
 */

#include "Test.h"

#include "State.h"
#include "RushHour.h"

Test::Test() {
}

Test::Test(const Test& orig) {
}

Test::~Test() {
}

void Test::test1() {
    int positioning[] = {1, 0, 1, 4, 2, 4, 0, 1};
    std::vector<int> start(positioning, positioning + 8);
    State* s0 = new State(start);
    std::cout << (!s0->success()) << std::endl;
    State* s = new State(s0, 1, 1);

    std::cout << (s->prev == s0) << std::endl;
    std::cout << s0->pos[1] << " " << s->pos[1] << std::endl;

    s = new State(s, 6, 1);
    s = new State(s, 1, -1);
    s = new State(s, 6, -1);

    std::cout << s->equals(s0) << std::endl;

    s = new State(s0, 1, 1);
    s = new State(s, 2, -1);
    s = new State(s, 3, -1);
    s = new State(s, 4, -1);
    s = new State(s, 4, -1);
    s = new State(s, 5, -1);
    s = new State(s, 5, -1);
    s = new State(s, 5, -1);
    s = new State(s, 6, 1);
    s = new State(s, 6, 1);
    s = new State(s, 6, 1);
    s = new State(s, 7, 1);
    s = new State(s, 7, 1);
    s = new State(s, 0, 1);
    s = new State(s, 0, 1);
    s = new State(s, 0, 1);

    std::cout << (s->success()) << std::endl;


}

void Test::test2() {

    int nbcars = 8;
    std::vector<std::string> color = {"nenhum"};
    std::vector<bool> horiz1 = {true, true, false, false, true, true, false, false};
    std::vector<int> len = {2, 2, 3, 2, 3, 2, 3, 3};
    std::vector<int> moveon = {2, 0, 0, 0, 5, 4, 5, 3};
    std::vector<int> start = {1, 0, 1, 4, 2, 4, 0, 1};


    State* s = new State(start);

    RushHour rushHour(nbcars, color, horiz1, len, moveon);
    rushHour.initFree(s);


    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++)
            if (rushHour.free[i][j])
                std::cout << "true" << "\t";
            else
                std::cout << "false" << "\t";

        std::cout << std::endl;
    }

}

void Test::test3() {

    int nbcars = 12;
    std::vector<bool> horiz1 = {true, false, true, false, false, true, false, true, false, true, false, true};

    std::vector<int> len1 = {2, 2, 3, 2, 3, 2, 2, 2, 2, 2, 2, 3};

    std::vector<int> moveon1 = {2, 2, 0, 0, 3, 1, 1, 3, 0, 4, 5, 5};

    std::vector<std::string> color = {"nenhum"};

    RushHour rushHour(nbcars, color, horiz1, len1, moveon1);

    std::vector<int> start = {1, 0, 3, 1, 1, 4, 3, 4, 4, 2, 4, 1};

    State* s = new State(start);

    std::vector<int> start2 = {1, 0, 3, 1, 1, 4, 3, 4, 4, 2, 4, 2};

    State* s2 = new State(start2);


    int n = 0;

    for (std::list<State*> l = rushHour.moves(s); !l.empty(); n++)
        l.pop_front();
    std::cout << n << std::endl;

    n = 0;
    for (std::list<State*> l = rushHour.moves(s2); !l.empty(); n++)
        l.pop_front();

    std::cout << n << std::endl;

}

void Test::test4() {

    int nbcars = 12;

    std::vector<std::string> color1 = {"vermelho", "verde claro", "amarelo", "laranja",
        "violeta claro", "azul ceu", "rosa", "violeta", "verde", "preto", "bege", "azul"};

    std::vector<bool> horiz1 = {true, false, true, false, false, true, false,
        true, false, true, false, true};

    std::vector<int> len1 = {2, 2, 3, 2, 3, 2, 2, 2, 2, 2, 2, 3};

    std::vector<int> moveon1 = {2, 2, 0, 0, 3, 1, 1, 3, 0, 4, 5, 5};

    std::vector<int> start = {1, 0, 3, 1, 1, 4, 3, 4, 4, 2, 4, 1};

    State* s = new State(start);

    RushHour rushHour(nbcars, color1, horiz1, len1, moveon1);

    int n = 0;
    for (s = rushHour.solve(s); s->prev != NULL; s = s->prev)
        n++;
    std::cout << n << std::endl;


}

void Test::solve22() {

    int nbcars = 12;
    std::vector<std::string> color = {"vermelho", "verde claro", "amarelo", "laranja",
        "violeta claro", "azul ceu", "rosa", "violeta", "verde", "preto", "bege", "azul"};

    std::vector<bool> horiz = {true, false, true, false, false, true, false,
        true, false, true, false, true};

    std::vector<int> len = {2, 2, 3, 2, 3, 2, 2, 2, 2, 2, 2, 3};

    std::vector<int> moveon = {2, 2, 0, 0, 3, 1, 1, 3, 0, 4, 5, 5};

    std::vector<int> start = {1, 0, 3, 1, 1, 4, 3, 4, 4, 2, 4, 1};

    RushHour rushHour(nbcars, color, horiz, len, moveon);

    State* s = new State(start);

    s = rushHour.solve(s);

    rushHour.printSolution(s);


}

void Test::solve1() {

    int nbcars = 8;
    std::vector<std::string> color = {"vermelho", "verde claro", "violeta",
        "laranja", "verde", "azul ceu", "amarelo", "azul"};

    std::vector<bool> horiz = {true, true, false, false, true,
        true, false, false};

    std::vector<int> len = {2, 2, 3, 2, 3, 2, 3, 3};

    std::vector<int> moveon = {2, 0, 0, 0, 5, 4, 5, 3};

    std::vector<int> start = {1, 0, 1, 4, 2, 4, 0, 1};

    RushHour rushHour(nbcars, color, horiz, len, moveon);

    State* s = new State(start);

    s = rushHour.solve(s);

    rushHour.printSolution(s);


}

void Test::solve40() {


    int nbcars = 13;
    std::vector<std::string> color = {"vermelho", "amarelo", "verde claro", "laranja", "azul claro",
        "rosa", "violeta claro", "azul", "violeta", "verde", "preto", "bege", "amarelo claro"};

    std::vector<bool> horiz = {true, false, true, false, false, false, false,
        true, false, false, true, true, true};

    std::vector<int> len = {2, 3, 2, 2, 2, 2, 3, 3, 2, 2, 2, 2, 2};

    std::vector< int > moveon = {2, 0, 0, 4, 1, 2, 5, 3, 3, 2, 4, 5, 5};

    std::vector<int> start = {3, 0, 1, 0, 1, 1, 1, 0, 3, 4, 4, 0, 3};

    RushHour rushHour(nbcars, color, horiz, len, moveon);

    State* s = new State(start);

    s = rushHour.solve(s);

    rushHour.printSolution(s);


}



