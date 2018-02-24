/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaCandidatos.h
 * Author: samuel
 *
 * Created on 23 de Fevereiro de 2018, 10:04
 */

#ifndef LISTACANDIDATOS_H
#define LISTACANDIDATOS_H
#include "NoCandidato.h"

class ListaCandidatos {
public:
    ListaCandidatos();
    ListaCandidatos(const ListaCandidatos& orig);
    ListaCandidatos(std::string fileName);
    virtual ~ListaCandidatos();
    void adicioneComoHead(Candidato* c);
    bool estaVazia();
    bool remove(std::string name, std::string lastName);
    int tamanho();
    void filtrarCandidatos(int _nota);
    void concatena(ListaCandidatos*& secondList);
    NoCandidato* getEnd();
    std::string toString();
    NoCandidato* head;


private:
    int listSize;
    std::string listName;
    NoCandidato* end;


    void readFile(std::fstream& file);
    bool findTheNodeWichName(std::string name, std::string lastName, NoCandidato*& backNode);
    void verifyTheHead(int _nota);
    bool isFirstNode();

    void restartFilter(NoCandidato*& backNode, NoCandidato*& tempHead);

    void removeTheNode(NoCandidato*& n);
    void deleteThemiddle(NoCandidato*& n);
    void deleteTheHead();





};

#endif /* LISTACANDIDATOS_H */

