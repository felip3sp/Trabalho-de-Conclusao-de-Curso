/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author paulo
 */
public class Agenda {
    
    private int id_agenda;
    private int fk_paci;
    private int fk_doutor;
    private Date data;
    private String hora;
    private String motivo;
    private String status;
    
    private String nome_paci;
    private String cpf_paci;
    private String nome_doutor;
    private String cro_doutor;

    public int getId_agenda() {
        return id_agenda;
    }

    public void setId_agenda(int id_agenda) {
        this.id_agenda = id_agenda;
    }

    public int getFk_paci() {
        return fk_paci;
    }

    public void setFk_paci(int fk_paci) {
        this.fk_paci = fk_paci;
    }

    public int getFk_doutor() {
        return fk_doutor;
    }

    public void setFk_doutor(int fk_doutor) {
        this.fk_doutor = fk_doutor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome_paci() {
        return nome_paci;
    }

    public void setNome_paci(String nome_paci) {
        this.nome_paci = nome_paci;
    }

    public String getCpf_paci() {
        return cpf_paci;
    }

    public void setCpf_paci(String cpf_paci) {
        this.cpf_paci = cpf_paci;
    }

    public String getNome_doutor() {
        return nome_doutor;
    }

    public void setNome_doutor(String nome_doutor) {
        this.nome_doutor = nome_doutor;
    }

    public String getCro_doutor() {
        return cro_doutor;
    }

    public void setCro_doutor(String cro_doutor) {
        this.cro_doutor = cro_doutor;
    }
    
    
    
}

