package br.com.cauabernardo.gestao_de_vagas.exceptions;

public class UserFoundExeption extends RuntimeException{
    public UserFoundExeption() {
        super("Usuário já existe");
    }
}
