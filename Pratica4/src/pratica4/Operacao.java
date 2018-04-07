/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica4;

/**
 * @author samuel
 */
public class Operacao {

    char code;
    Double a;
    Double b;
    
    /**
     * cria uma operação de empilhamento (código ’e’)
     * de valor a
     * @param _a  valor
     */

    public Operacao(Double _a) {
        code = 'e';
        a = _a;
    }
    
    /**
     * cria uma operação aritmética de código code com os operandos a e b.
     * 
     * @param _code código da operação
     * @param _a    valor do primeiro operando
     * @param _b    valor do segundo operando
     */

    public Operacao(char _code, Double _a, Double _b) {
        code = _code;
        a = _a;
        b = _b;
    }
    
    /**
     * retorna uma cadeia de caracteres representando o valor empilhado
     * @return o valor empilhado
     */
    
    public String toString (){
        if (code == 'e'){
            return a.toString();
        }
        
        return  String.valueOf(code);
    }

}
