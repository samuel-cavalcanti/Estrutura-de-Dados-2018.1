/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   TestPratica_1.cpp
 * Author: samuel
 * 
 * Created on 23 de Fevereiro de 2018, 09:36
 */

#include "TestPratica_1.h"

#include <cstring>
#include <fstream>
#include <iostream>
#include "Candidato.h"
#include "NoCandidato.h"

TestPratica_1::TestPratica_1() {



}

TestPratica_1::TestPratica_1(const TestPratica_1& orig) {


}

TestPratica_1::~TestPratica_1() {


}

void TestPratica_1::testeCandidato() {

    std::ifstream fcin("data/candidatsPicardie.txt");

    std::string dados;
    std::getline(fcin, dados);
    std::cout << "nome da regiao: " << dados << std::endl;

    while (std::getline(fcin, dados)) {

        Candidato c(dados);
        std::cout << "criacao do candidato: " << c.toString() << std::endl;

    }


}

void TestPratica_1::testeEx1() {

    NoCandidato* m = NULL;
    cout << "No comeco m vale: ";
    cout << m << endl << endl;

    Candidato c("FONFEC Sophie 13");
    m = new NoCandidato(&c, NULL);

    cout << "Depois m aponta para o no ";
    cout << m->conteudo->toString() << endl;
    cout << "e o seu no seguinte e ";
    cout << m->next << endl << endl;


    Candidato c1("HADY Jacques 7");
    m = new NoCandidato(&c1, m);

    cout << "finalmente m referencia o no ";
    cout << m->conteudo->toString() << endl;
    cout << "e tambem via m->next, o no ";
    cout << m->next->conteudo->toString() << endl;
    cout << "que e o ultimo no, pois m->next->next vale ";
    cout << m->next->next << endl << endl;



}

 void TestPratica_1::testeEx2() {

    ListaCandidatos* lista = new ListaCandidatos();
    if (lista->estaVazia())
        cout << "Lista A vazia: " << lista->estaVazia() << endl;
    lista->adicioneComoHead(new Candidato("FONFEC Sophie 13"));
    if (!lista->estaVazia())
        cout << "Lista B vazia: " << lista->estaVazia() << " " << lista->head->toString() << endl;
    lista->adicioneComoHead(new Candidato("HADY Jacques 7"));
    if (!lista->estaVazia())
        cout << "Lista C vazia: " << lista->estaVazia() << " " << lista->head->toString() << endl;

}

void TestPratica_1::testeEx3a() {


    ListaCandidatos* lista = new ListaCandidatos();
    lista->adicioneComoHead(new Candidato("FONFEC Sophie 13"));
    cout << "Numero de nos da lista: " << lista->tamanho() << endl;
    lista->adicioneComoHead(new Candidato("HADY Jacques 7"));
    lista->adicioneComoHead(new Candidato("ZAPPA Frank 2"));
    cout << "Numero de nos da lista: " << lista->tamanho() << endl;


}

void TestPratica_1::testeEx3b() {

    ListaCandidatos* lista = new ListaCandidatos();
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl;
    lista->adicioneComoHead(new Candidato("FONFEC Sophie 13"));
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl;
    lista->adicioneComoHead(new Candidato("HADY Jacques 7"));
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl;


}

void TestPratica_1::testeEx4() {
    ListaCandidatos* lista = new ListaCandidatos("data/candidatsBourgogne.txt");
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl;



}

void TestPratica_1::tryRemove(ListaCandidatos* l, std::string nome, std::string sobrenome) {
    if (l->remove(nome, sobrenome)) {
        cout << "remocao feita; nova lista: " << endl;
    } else {
        cout << "remocao nao realizada, " << nome << " " << sobrenome << " nao se encontra na lista" << endl;
    }

}

void TestPratica_1::testeEx5() {

    ListaCandidatos* lista = new ListaCandidatos("data/candidatsBourgogne.txt");
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl << endl;

    tryRemove(lista, "KENZA", "BEGIZ");
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl << endl;

    tryRemove(lista, "UGO", "CHESNEVARIN");
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl << endl;

    tryRemove(lista, "SARAH", "THOULIER");
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl << endl;

    tryRemove(lista, "LUC", "LEROI");
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl << endl;

    tryRemove(lista, "CLEMENT", "RABODOU");
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl << endl;

    tryRemove(lista, "GERALDINE", "ALLUIRE");
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl << endl;

    tryRemove(lista, "CLEMENT", "RABODOU");
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl << endl;


}

void TestPratica_1::testeEx6() {
    ListaCandidatos* lista1 = new ListaCandidatos("data/candidatsCentre.txt");
    cout << "lista de " << lista1->tamanho() << " candidatos: " << lista1->toString() << endl;
    cout << "filtragem com nota = 13" << endl;
    lista1->filtrarCandidatos(13);
    cout << "lista de " << lista1->tamanho() << " candidatos: " << lista1->toString() << endl << endl;

    ListaCandidatos* lista2 = new ListaCandidatos("data/candidatsBourgogne.txt");
    cout << "lista de " << lista2->tamanho() << " candidatos: " << lista2->toString() << endl;
    cout << "filtragem com nota = 20" << endl;
    lista2->filtrarCandidatos(20);
    cout << "lista de " << lista2->tamanho() << " candidatos: " << lista2->toString() << endl << endl;

    ListaCandidatos* lista3 = new ListaCandidatos("data/candidatsLimousin.txt");
    cout << "lista de " << lista3->tamanho() << " candidatos: " << lista3->toString() << endl;
    cout << "filtragem com nota = 0" << endl;
    lista3->filtrarCandidatos(0);
    cout << "lista de " << lista3->tamanho() << " candidatos: " << lista3->toString() << endl << endl;




}

void TestPratica_1::testeEx7() {


    ListaCandidatos* lista = new ListaCandidatos("data/candidatsBourgogne.txt");
    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl << endl;

    ListaCandidatos* lista1 = new ListaCandidatos("data/candidatsPicardie.txt");
    cout << "lista de " << lista1->tamanho() << " candidatos: " << lista1->toString() << endl << endl;

    cout << "concatenacao" << endl;

    lista->concatena(lista1);

    cout << "lista de " << lista->tamanho() << " candidatos: " << lista->toString() << endl << endl;




}



