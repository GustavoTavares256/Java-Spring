package br.com.gustavodev.spring_boot_essentials.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Builder


public class AlunoDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String  email;
}
