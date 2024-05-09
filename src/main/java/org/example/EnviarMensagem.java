package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnviarMensagem {

    private List<Mensagem> mensagens = new ArrayList<>();

    void adicionarMensagem(Mensagem mensagem) {
        this.mensagens.add(mensagem);
    }

    public List<Mensagem> getMensagens() {
        return Collections.unmodifiableList(this.mensagens);
    }
}
