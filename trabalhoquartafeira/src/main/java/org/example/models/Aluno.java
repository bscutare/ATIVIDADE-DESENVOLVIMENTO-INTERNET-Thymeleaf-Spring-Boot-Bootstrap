package org.example.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class Aluno {


    public static final String API = "api/v1/aluno";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 100, message = "Nome deve ter até 100 caracteres")
    private String nome;


    @NotBlank(message = "Telefone é obrigatório")
    @Size(max = 20, message = "Telefone até 20 caracteres")
    private String telefone;


    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;


    // getters e setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }


    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }


    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

