/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NoCandidato.cpp
 * Author: samuel
 * 
 * Created on 23 de Fevereiro de 2018, 09:50
 */

#include "NoCandidato.h"
#include <iostream>

NoCandidato::NoCandidato() {
}

NoCandidato::NoCandidato(const NoCandidato& orig) {
}

NoCandidato::~NoCandidato() {
}

NoCandidato::NoCandidato(Candidato* _conteudo, NoCandidato* _next) {
    conteudo = _conteudo;
    next = _next;

}

std::string NoCandidato::toString() {
    stringstream stream;

    if (next != NULL){
        stream << conteudo->toString() << "-> " << next->toString();
    }
    else
        stream <<  conteudo->toString() << "-> 0" ;
    
    return stream.str();

}


