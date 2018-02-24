/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NoCandidato.h
 * Author: samuel
 *
 * Created on 23 de Fevereiro de 2018, 09:50
 */

#ifndef NOCANDIDATO_H
#define NOCANDIDATO_H

#include "Candidato.h"

class NoCandidato {
public:
    NoCandidato();
    NoCandidato(const NoCandidato& orig);
    NoCandidato(Candidato*_conteudo, NoCandidato* _next );
    virtual ~NoCandidato();
    std::string toString();
    
    Candidato* conteudo;
    NoCandidato* next;
    
    
    
    
    
private:

};

#endif /* NOCANDIDATO_H */

