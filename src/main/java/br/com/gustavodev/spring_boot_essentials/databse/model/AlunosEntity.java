package br.com.gustavodev.spring_boot_essentials.databse.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alunos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AlunosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Avaliacao_fisica_id")
    private AvaliacoesFisicasEntity avaliacaoFisica;

    @OneToMany(mappedBy = "aluno")
    private Set<TreinosEntity> treinos = new HashSet<>();
}
