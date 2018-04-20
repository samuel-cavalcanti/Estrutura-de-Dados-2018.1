
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author samuel
 */
public class SecurityProvider {

    public static String salt = "5a1t";

    public static String md5(String stringToConvert) {
        String hashtext = "";
        stringToConvert += salt;
        MessageDigest m;
        try {
            m = MessageDigest.getInstance("MD5");
            m.reset();
            m.update(stringToConvert.getBytes());
            byte[] digest = m.digest();
            BigInteger bigInt = new BigInteger(1, digest);
            hashtext = bigInt.toString(16);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecurityProvider.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return hashtext;
    }

    /*
      return "AGENCIA: " + agencia + "\n"
                + "CONTA: " + numero + "\n"
                + "SENHA:" + senha + "\n"
                + "NOME CLIENTE: " + nomeCliente + "\n"
                + "SALDO: " + saldo + "\n"
                + "MD5: " + md5 + "\n\n";

     */
    public static String md5ToServer(Conta conta) {

        String info = conta.getAgencia();

        info += conta.getNumero();

        info += conta.getSenha();

        info += salt;

        return md5(info);

    }

    public static String[] md5ToClient(Conta conta) {

        String toCrypt = conta.getNomeCliente() + " " + conta.getSaldo();
        int size = toCrypt.length();
        String[] infoClient = new String[size];
        char[] toCryptCharArray = toCrypt.toCharArray();

        for (int i = 0; i < size; i++) {
            infoClient[i] = md5(Character.toString(toCryptCharArray[i]));
        }

        return infoClient;

    }

}
