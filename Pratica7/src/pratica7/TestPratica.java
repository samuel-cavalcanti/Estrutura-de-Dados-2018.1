/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica7;

import java.util.Random;
import static pratica7.Aa.N;
import static pratica7.Aa.R;
import static pratica7.Aa.infixe;

/**
 *
 * @author samuel
 */
public class TestPratica {

    public void test1() {
        Aa a = new Aa(3, N,
                new Aa(1, N, null, null),
                new Aa(8, R,
                        new Aa(5, N,
                                null,
                                new Aa(6, R, null, null)),
                        new Aa(9, N,
                                null,
                                new Aa(11, R, null, null))));
        System.out.println(infixe(a));
    }

    public void testRodeDir() {
        Aa a = new Aa(4, R,
                new Aa(2, R,
                        new Aa(1, N, null, null),
                        new Aa(3, N, null, null)),
                new Aa(5, N, null, null));

        new Fenetre(a, "antes da rotação a direita ");

        a = a.rodeDir(a);

        new Fenetre(a, " depois da rotação a direita");

    }

    public void testRodeEsq() {

        Aa a = new Aa(2, N,
                new Aa(1, N, null, null),
                new Aa(4, R,
                        new Aa(3, N, null, null),
                        new Aa(6, R,
                                new Aa(5, N, null, null),
                                new Aa(7, N, null, null))));

        new Fenetre(a, "antes da rotação a esquerda");

        a = a.rodeEsq(a);

        new Fenetre(a, " depois da rotação  a esquerda");

    }

    public void finalTest() {

        Aa treeTest = new Aa(2, 1, null, null);

        Random ger = new Random();

        for (int i = 0; i < 64; i++) {
            int value = ger.nextInt(15);
            treeTest = treeTest.insereECorrigeRaiz(treeTest, value);

        }

       new Fenetre(treeTest, "");
       
        System.out.println("teste testeArvoreAa: "+ treeTest.testeArvoreAa(treeTest));
        System.out.println(infixe(treeTest));

    }

}
