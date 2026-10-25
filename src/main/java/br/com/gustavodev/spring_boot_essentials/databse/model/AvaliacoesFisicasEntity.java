package br.com.gustavodev.spring_boot_essentials.databse.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Avaliacoes fisicas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AvaliacoesFisicasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private BigDecimal peso;

    @Column(nullable = false)
    private BigDecimal altura;

    @Column(name = "porcentagem_gordura_corporal")
    private BigDecimal porcentagemGorduraCorporal;
}
