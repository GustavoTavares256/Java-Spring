package br.com.gustavodev.spring_boot_essentials.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder


public class ExercicioDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String  grupoMuscular;
}
