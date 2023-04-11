package br.com.javatos.usuario.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "Usuario_Table")
public class Usuario {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private @NotBlank String nome;

  @Column(unique = true, nullable = false)
  private @Email String email;

  @Column(nullable = false)
  private @NotBlank String senha;

  @ManyToMany(cascade = CascadeType.PERSIST)
  Set<Permissao> permissoes = new HashSet<>();

}
