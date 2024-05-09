package org.example;

public class Conta {

    private int saldo;

    public Conta(int saldo) {
        this.saldo = saldo;
    }

    public void pagaBoleto(int valorPagar){
        validaSaldo(valorPagar);
        debita(valorPagar);
        enviaCreditoEmissor(valorPagar);
    }

    public void validaSaldo(int ValorPagar){
        if(ValorPagar > saldo){
            throw new IllegalThreadStateException("Saldo insuficiente.");
        }
    }

    public void debita(int ValorPagar){
        this.saldo = (this.saldo - ValorPagar);
    }

    public void enviaCreditoEmissor(int valorPagar){}

    public int getSaldo() {
        return saldo;
    }
}
