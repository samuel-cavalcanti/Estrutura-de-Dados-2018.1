
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
public class Database {

    public static final ArrayList<Letra> caracteres;

    static {
        caracteres = new ArrayList<Letra>();
        getAllNumbers();
        getAllCapitalLetters();
        getAllSmallLetter();
        getSpace();

    }

    public static Letra getLetra(String md5) {

        for (Letra l : caracteres) {
            if (l.getMd5Code().compareTo(md5) == 0) {
                return l;
            }
        }

        return null;
    }

    public static Conta getConta(String[] keys) {
        String crypt = getCryptString(keys);

        ArrayList<String> info = getInfo(crypt.split(" "));

        return new Conta(info.get(0), info.get(1));
    }

    private static String getCryptString(String[] keys) {
        String crypt = getLetra(keys[0]).getCaractere();

        for (int i = 1; i < keys.length; i++) {
            crypt += getLetra(keys[i]).getCaractere();
        }

        return crypt;
    }

    private static void getAllNumbers() {
        for (int i = 48; i < 58; i++) {
            char number = (char) i;
            caracteres.add(new Letra(Character.toString(number)));

        }
    }

    private static void getAllCapitalLetters() {
        for (int i = 65; i < 91; i++) {
            char number = (char) i;
            caracteres.add(new Letra(Character.toString(number)));

        }

    }

    private static void getAllSmallLetter() {

        for (int i = 97; i < 123; i++) {
            char number = (char) i;
            caracteres.add(new Letra(Character.toString(number)));

        }

    }

    private static void getSpace() {
        char space = (char) 32;
        caracteres.add(new Letra(Character.toString(space)));
    }

    private static ArrayList<String> getInfo(String[] parts) {
        String saldo = null;
        String nomeCliente = "";
        ArrayList<String> info = new ArrayList<>();

        for (String part : parts) {
            try {
                Double.parseDouble(part);
                saldo = part;
            } catch (NumberFormatException e) {
                if (nomeCliente.isEmpty()) {
                    nomeCliente += part;
                } else {
                    nomeCliente += " " + part;
                }

            }

        }

        info.add(nomeCliente);
        info.add(saldo);

        return info;
    }

}
