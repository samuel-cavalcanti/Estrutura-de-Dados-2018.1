/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samuel
 */
public class Conta {

    private String nomeCliente;
    private String saldo;
    private String agencia;
    private String numero;
    private String senha;
    private String md5;

    public Conta(String _agencia, String _numero, String _senha) {
        agencia = _agencia;
        numero = _numero;
        senha = _senha;
        saldo = null;
        md5 = null;
        nomeCliente = null;

        md5 = SecurityProvider.md5ToServer(this);
    }

    public Conta(String _agencia, String _numero, String _senha, String _saldo, String _nomeCliente) {
        agencia = _agencia;
        numero = _numero;
        senha = _senha;
        saldo = _saldo;
        nomeCliente = _nomeCliente;
        md5 = SecurityProvider.md5ToServer(this);

    }

    public Conta(String _nomeCliente, String _saldo) {
        nomeCliente = _nomeCliente;
        saldo = _saldo;

    }

    public String toString() {

        return "AGENCIA: " + agencia + "\n"
                + "CONTA: " + numero + "\n"
                + "SENHA:" + senha + "\n"
                + "NOME CLIENTE: " + nomeCliente + "\n"
                + "SALDO: " + saldo + "\n"
                + "MD5: " + md5 + "\n\n";

    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumero() {
        return numero;
    }

    public String getSenha() {
        return senha;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getSaldo() {
        return saldo;
    }

    public String getMD5() {
        return md5;
    }

    public void setAgencia(String _agencia) {
        agencia = _agencia;
    }

    public void setNumero(String _numero) {
        numero = _numero;
    }

    public void setSenha(String _senha) {
        senha = _senha;
    }

    public void setNomeCliente(String _nomeCliente) {
        nomeCliente = _nomeCliente;
    }

    public void setSaldo(String _saldo) {
        saldo = _saldo;
    }

    public void setMD5(String _md5) {
        md5 = _md5;
    }

}
