/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samuel
 */
public class Letra {

    private String caractere;
    private String md5Code;
   
    Letra(String _caractere) {
        caractere = _caractere;
        md5Code = SecurityProvider.md5(caractere);

    }

    public String getCaractere() {
        return caractere;
    }

    public String getMd5Code() {
        return md5Code;
    }

    public void setCaractere(String _caractere) {
        caractere = _caractere;
    }

    public void setMd5(String _md5) {
        md5Code = _md5;
    }

}
