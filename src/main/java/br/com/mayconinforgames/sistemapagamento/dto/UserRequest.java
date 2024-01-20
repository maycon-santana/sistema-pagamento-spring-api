package br.com.mayconinforgames.sistemapagamento.dto;

import br.com.mayconinforgames.sistemapagamento.entity.User;

public record UserRequest(
        String name,

        String email,

        String password
) {

    public User toModel() {
        return new User(name, email, password);
    }

}
