
import java.math.BigInteger;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author samuel
 */
public class ServerDatabase {

    public static final ArrayList<ArrayList<Conta>> contas;
    public static final int N = 100;

    static {
        contas = new ArrayList<ArrayList<Conta>>();
        for (int i = 0; i < N; i++) {
            contas.add(new ArrayList<Conta>());
        }
    }

    public static int hashCode(String md5) {
        BigInteger bi = new BigInteger(md5, 16);
        BigInteger m = new BigInteger(Integer.toString(N), 10);
        int pos;
        pos = bi.mod(m).intValue();
        return pos;

    }

    public static void insereConta(Conta conta) {
        int pos = hashCode(conta.getMD5());

        ArrayList<Conta> c = contas.get(pos);

        if (c != null) {
            c.add(conta);

        } else {
            c = new ArrayList<>();
            c.add(conta);

        }
    }

    public static Conta getConta(String md5) {
        int pos = hashCode(md5);

        for (Conta c : contas.get(pos)) {
            if (c.getMD5().compareTo(md5) == 0) {
                return c;
            }

        }

        return null;

    }

}
