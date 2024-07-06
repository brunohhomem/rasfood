package br.com.rasmoo.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pratos")
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String description;

    private Boolean disponivel;

    private BigDecimal valor;

    @Column(name = "data_de_registro")
    private LocalDateTime dataDeRegistro = LocalDateTime.now(); //Já deixando a data ser iniciada na criação da entidade

    public Prato() {
    }

    public Prato(Integer id, String nome, String description, Boolean disponivel, BigDecimal valor, LocalDateTime dataDeRegistro) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.disponivel = disponivel;
        this.valor = valor;
        this.dataDeRegistro = dataDeRegistro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(LocalDateTime dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    @Override
    public String toString() {
        return "Prato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", description='" + description + '\'' +
                ", disponivel=" + disponivel +
                ", valor=" + valor +
                ", dataDeRegistro=" + dataDeRegistro +
                '}';
    }
}
