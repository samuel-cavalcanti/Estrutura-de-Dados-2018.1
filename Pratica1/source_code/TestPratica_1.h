/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   TestPratica_1.h
 * Author: samuel
 *
 * Created on 23 de Fevereiro de 2018, 09:36
 */

#ifndef TESTPRATICA_1_H
#define TESTPRATICA_1_H
#include "ListaCandidatos.h"


class TestPratica_1 {
public:
    TestPratica_1();
    TestPratica_1(const TestPratica_1& orig);
    void testeCandidato(); // TesteCandidato.cpp
    void testeEx1();  // TesteEx1.cpp
    void testeEx2();  // TesteEx2.cpp
    void testeEx3a(); // TesteEx3a.cpp
    void testeEx3b(); // TesteEx3b.cpp
    void testeEx4();  // TesteEx4.cpp
    void testeEx5();  // TesteEx5.cpp
    void testeEx6();  //TesteEx6.cpp
    void testeEx7();  //TesteEx7.cpp
    

    virtual ~TestPratica_1();
private:
    
    void tryRemove(ListaCandidatos* l, std::string nome, std::string sobrenome);

};

#endif /* TESTPRATICA_1_H */

