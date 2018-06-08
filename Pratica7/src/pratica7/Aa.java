/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica7;

/**
 *
 * @author samuel
 */
public class Aa {

    Integer value;
    Integer cor;
    Aa esq;
    Aa dir;

    static int R = 0;
    static int N = 1;

    public Aa(int v, int c, Aa Esq, Aa Dir) {
        value = v;
        cor = c;
        esq = Esq;
        dir = Dir;

    }

    public static String infixe(Aa a) {
        String values = "";

        if (a.esq != null) {
            values += infixe(a.esq);
        }

        values += " " + a.value.toString();

        if (a.dir != null) {
            values += infixe(a.dir);
        }

        return values;

    }

    public Aa rodeDir(Aa a) {
        if (a == null) {
            return null;
        } else if (a.esq == null) {
            return a;
        }

        if (a.esq.cor  == N) {
            return a;
        }

        Aa aux = a;

        // M sobe
        a = a.esq;
        // N rescebe o filho direito de N
        aux.esq = a.dir;

        // N vira o filho direito de M
        a.dir = aux;

        return a;

    }

    public Aa rodeEsq(Aa a) {
        if (a == null) {
            return null;
        } else if (a.dir == null || a.dir.dir == null) {
            return a;
        }

        if (a.dir.cor != a.dir.dir.cor) {
            return a;
        }

        Aa m = a;

        // N sobe
        a = a.dir;
        // M recebe o filho esquerdo de N
        m.dir = a.esq;
        // N adota M 
        a.esq = m;

  
        a.dir.cor = N;
        

        return a;

    }

    static Aa insere(Aa a, int i) {

        if (a == null) {
            a = new Aa(i, R, null, null);

        } else if (a.value > i) {
            a.esq = insere(a.esq, i);
        } else {
            a.dir = insere(a.dir, i);
        }

        a = a.rodeDir(a);

        a = a.rodeEsq(a);

       


        return a;
    }

  
    Aa insereECorrigeRaiz(Aa a, int i) {
   

        a = insere(a, i);

        a.cor = N;
        
        return a;

    }

    static boolean testeArvoreAa(Aa a) {
        return testSubArvoreAa(a, nivel(a), false);
    }

    static int nivel(Aa a) {

        if (a == null) {
            return 0;
        }

        return (a.cor == N) ? 1 : 0 + nivel(a.esq);

    }

    static boolean testSubArvoreAa(Aa a, int n, boolean raizPodeSerVermelha) {
        if (a == null && n == 0) {
            return true;
        }

        if (a.cor == R) {
            if (raizPodeSerVermelha == true) {
                return false;
            }
            raizPodeSerVermelha = true;
        }

        boolean pass = false;

        if (a.esq != null) {
            pass = testSubArvoreAa(a.esq, n - 1, raizPodeSerVermelha);
        }

        if (a.dir != null) {
            pass = testSubArvoreAa(a.dir, n - 1, raizPodeSerVermelha);
        }

        return pass;

    }

}
