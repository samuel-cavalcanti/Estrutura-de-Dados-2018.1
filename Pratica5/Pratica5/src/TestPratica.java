/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samuel
 */
public class TestPratica {

    public TestPratica() {
    }

    public void teste1() {
        Conta c1 = new Conta("124", "333", "1234", "10", "john doe");
        System.out.println(c1);
        Conta c2 = new Conta("John Doe", "10");
        System.out.println(c2);
        Conta c3 = new Conta("123", "321", "666");
        System.out.println(c3);
    }

    public void teste2() {
        System.out.println(SecurityProvider.md5("teste"));
    }

    public void teste3() {
        Conta c = new Conta("1234", "2222", "1245");
        System.out.println(SecurityProvider.md5ToServer(c));
    }

    public void teste4() {

        Conta c1 = new Conta("124", "333", "1234", "10", "john doe");
        System.out.println(c1);
        Conta c2 = new Conta("John Doe", "10");
        System.out.println(c2);
        Conta c3 = new Conta("123", "321", "666");
        System.out.println(c3);

    }

    public void teste5() {

        Conta c = new Conta("1234", "2222", "1245");
        ServerDatabase.insereConta(c);
        String chave = SecurityProvider.md5ToServer(c);
        System.out.println(chave);
        Conta conta = ServerDatabase.getConta(chave);
        System.out.println(conta);

    }

    public void teste6() {
        Conta c = new Conta("124", "333", "1234", "10", "john doe");
        ServerDatabase.insereConta(c);
        String chave = SecurityProvider.md5ToServer(c);
        Conta conta = ServerDatabase.getConta(chave);
        String chars[];
        chars = SecurityProvider.md5ToClient(conta);
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
    }

    public void teste7() {

        Letra l = new Letra("a");
        String md5 = l.getMd5Code();
        System.out.println(md5);
        Letra ll = Database.getLetra(md5);
        System.out.println(ll.getCaractere());

    }

    public void teste8() {
        Conta c = new Conta("124", "333", "1234", "10", "john doe");
        ServerDatabase.insereConta(c);
        String chave = SecurityProvider.md5ToServer(c);
        Conta conta = ServerDatabase.getConta(chave);
        String chars[];
        chars = SecurityProvider.md5ToClient(conta);
        System.out.println(Database.getConta(chars));
    }

}
