package model;

//@author Paulo Cassola

public class User {

    private int id_user;
    private String nome_user;
    private String login_user;
    private String senha_user;
    
    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public String getNome_user() {
        return nome_user;
    }
    public void setNome_user(String nome_user) {
        this.nome_user = nome_user;
    }
    public String getLogin_user() {
        return login_user;
    }
    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }
    public String getSenha_user() {
        return senha_user;
    }
    public void setSenha_user(String senha_user) {
        this.senha_user = senha_user;
    }    
}
