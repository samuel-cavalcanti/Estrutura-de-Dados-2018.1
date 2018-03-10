/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaCandidatos.cpp
 * Author: samuel
 * 
 * Created on 23 de Fevereiro de 2018, 10:04
 */

#include "ListaCandidatos.h"
#include <iostream>
#include <fstream>

ListaCandidatos::ListaCandidatos() {
    head = NULL;
    end = NULL;
    listSize = 0;
    listName = "default";

}

ListaCandidatos::ListaCandidatos(std::string fileName) {
    head = NULL;
    listSize = 0;

    std::fstream file(fileName);

    if (file.is_open() and file.good())
        readFile(file);
    else
        std::cout << "error file is not opened" << endl;
    
    std::cout << "criacao da lista de candidatos de: " << listName << std::endl;


}

ListaCandidatos::~ListaCandidatos() {
}

bool ListaCandidatos::estaVazia() {

    if (head)
        return false;

    return true;

}

void ListaCandidatos::adicioneComoHead(Candidato* c) {
    if (isFirstNode()) {
        end = head;
    } 
        head = new NoCandidato(c, head);
    

    listSize++;


}

int ListaCandidatos::tamanho() {
    return listSize;
}

std::string ListaCandidatos::toString() {
    if (head == NULL)
       return "0";
    else
        return head->toString();
}

void ListaCandidatos::readFile(std::fstream& file) {

    std::string lineInfo;

    std::getline(file, lineInfo);
    listName = lineInfo;

    while (std::getline(file, lineInfo)) {

        adicioneComoHead(new Candidato(lineInfo));

    }

}

bool ListaCandidatos::remove(std::string name, std::string lastName) {
    NoCandidato* node;

    if (findTheNodeWichName(name, lastName, node)) {
        removeTheNode(node);
        return true;
    }

    return false;


}

bool ListaCandidatos::findTheNodeWichName(std::string name, std::string lastName, NoCandidato*& backNode) {
    backNode = NULL;
    NoCandidato* node = head;
    while (node != NULL) {

        if (node->conteudo->igual(name, lastName))
            return true;

        backNode = node;
        node = node->next;
    }


    return false;

}

void ListaCandidatos::removeTheNode(NoCandidato*& n) {
    if (n == NULL)
        deleteTheHead();
    else
        deleteThemiddle(n);
}

void ListaCandidatos::deleteThemiddle(NoCandidato*& n) {
    NoCandidato* newNext = n->next->next;

    delete n->next;
    n->next = newNext;

    listSize--;
}

void ListaCandidatos::deleteTheHead() {
    NoCandidato* next = head->next;

    delete head;

    head = next;

    listSize--;
}

void ListaCandidatos::filtrarCandidatos(int _nota) {
    NoCandidato* tempHead = head;
    NoCandidato* backNode = NULL;

    while (tempHead != NULL) {



        if (tempHead->conteudo->nota < _nota) {
            NoCandidato* proxTemp = tempHead->next;
            removeTheNode(backNode);
            tempHead = proxTemp;
        } else {
            backNode = tempHead;
            tempHead = tempHead->next;

        }
    }

}

void ListaCandidatos::restartFilter(NoCandidato*& backNode, NoCandidato*& tempHead) {
    backNode = NULL;
    tempHead = head;

}

void ListaCandidatos::verifyTheHead(int _nota) {
    NoCandidato* node = head;

    if (head->conteudo->nota < _nota) {
        delete head;
        head = node->next;
    }



}

NoCandidato* ListaCandidatos::getEnd() {
    return end;
}

bool ListaCandidatos::isFirstNode() {
    if (listSize == 0) {
        return true;
    }
    return false;

}

void ListaCandidatos::concatena(ListaCandidatos*& secondList) {

    end->next = secondList->head;

    listSize += secondList->listSize;



}



