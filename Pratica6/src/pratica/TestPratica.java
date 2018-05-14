package pratica;

public class TestPratica {

    public TestPratica() {
    }

// 2. Campos e construtores
    public void test1() {
        System.out.println("Construcao de FenwickTree(3) : " + new FenwickTree(3));

        System.out.println("Construcao da arvore da figura : " +
                new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
                        new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
                        new FenwickTree(1, new FenwickTree(3),
                                new FenwickTree(1, new FenwickTree(6), new FenwickTree(1)))));
    }

// 3. Representação de uma tabela cheia de zeros
    public void test2() {
        System.out.println("Construcao de all allZeros(3) : " + FenwickTree.allZeros(3));
        System.out.println("Construcao de all allZeros(4) : " + FenwickTree.allZeros(4));
        System.out.println("Construcao de all allZeros(5) : " + FenwickTree.allZeros(5));
        System.out.println("Construcao de all allZeros(6) : " + FenwickTree.allZeros(6));
    }


    // 4. Tamanho de uma árvore
    public void test3() {
        // teste de correcao
        System.out.println("Verificacao de correcao da funcao...");

        System.out.println("Tamanho de FenwickTree(6) : " + (new FenwickTree(6)).size());

        System.out.println("Tamanho de allZeros(6) : " + (FenwickTree.allZeros(6)).size());

        System.out.println("Tamanho de allZeros(12) : " + (FenwickTree.allZeros(12)).size());

        FenwickTree T1 = new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
                new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
                new FenwickTree(1, new FenwickTree(3),
                        new FenwickTree(1, new FenwickTree(6), new FenwickTree(1))));

        System.out.println("Árvore this : " + T1);

        System.out.println("Tamanho de this : " + T1.size());
    }

// 5. Alterando o valor de uma folha
    public void test4() {
        // teste de correcao
        // teste de correcao
        System.out.println("Verificacao de correcao da funcao...");
        FenwickTree T = new FenwickTree(3,
                new FenwickTree(1, new FenwickTree(0),
                        new FenwickTree(1, new FenwickTree(0), new FenwickTree(0))),
                new FenwickTree(1, new FenwickTree(0),
                        new FenwickTree(1, new FenwickTree(0), new FenwickTree(0))));
        System.out.println("Arvore this : " + T);
        T.increment(0, 4);
        System.out.println("Resultado de increment(0, 4) : " + T);
        T.increment(1, 2);
        System.out.println("Resultado de increment(1, 2) : " + T);
        T.increment(2, 5);
        System.out.println("Resultado de increment(2, 5) : " + T);
        T.increment(3, 3);
        System.out.println("Resultado de increment(3, 3) : " + T);
        T.increment(4, 6);
        System.out.println("Resultado de increment(4, 6) : " + T);
        T.increment(5, 1);
        System.out.println("Resultado de increment(5, 1) : " + T);
    }

// 6. Soma das primeiras folhas
    public void test5() {
        // teste de correcao
        System.out.println("Verificacao de correcao da funcao...");
        FenwickTree T = new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
                new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
                new FenwickTree(1, new FenwickTree(3),
                        new FenwickTree(1, new FenwickTree(6), new FenwickTree(1))));
        System.out.println("Arvore this : " + T);
        System.out.println("Soma das primeiras folhas : ");
        for (int upto = 0; upto <= 6; upto++)
            System.out.println("prefixSum(" + upto + ") : " + T.prefixSum(upto));

    }
  //  7. Soma de uma gama de folhas
    public void test6() {
        FenwickTree T = new FenwickTree(3, new FenwickTree(1, new FenwickTree(4),
                new FenwickTree(1, new FenwickTree(2), new FenwickTree(5))),
                new FenwickTree(1, new FenwickTree(3),
                        new FenwickTree(1, new FenwickTree(6), new FenwickTree(1))));
        System.out.println("Arvore this : " + T);
        System.out.println("Soma das folhas entre lo e hi : ");
        System.out.print(" ");
        for (int lo = 0; lo <= 6; lo++)
            System.out.print("lo = " + lo + " ");
        System.out.println();
        for (int hi = 0; hi <= 6; hi++) {
            System.out.print("hi = " + hi + " ");
            for (int lo = 0; lo <= hi; lo++) {
                System.out.print(T.between(lo, hi) + " ");
                if (T.between(lo, hi) < 10) System.out.print(" ");
            }
            System.out.println();
        }


    }


}
