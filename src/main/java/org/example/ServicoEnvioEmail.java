package org.example;

public class ServicoEnvioEmail {

    private PlataformaEnvio plataformaEnvio;

    void enviaEmail(String enderecoEmail, String mensagem, boolean formatoHTML){
        Email email = null;
        if (formatoHTML){
            email = new Email(enderecoEmail, mensagem, Formato.HTML);
        } else {
            email = new Email(enderecoEmail, mensagem, Formato.TEXTO);
        }
        plataformaEnvio.enviaEmail(email);
    }
}
