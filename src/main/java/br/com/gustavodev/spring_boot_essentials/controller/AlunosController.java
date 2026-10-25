package br.com.gustavodev.spring_boot_essentials.controller;

import br.com.gustavodev.spring_boot_essentials.databse.model.AvaliacoesFisicasEntity;
import br.com.gustavodev.spring_boot_essentials.exception.BadRequestException;
import br.com.gustavodev.spring_boot_essentials.exception.NotFoundException;
import br.com.gustavodev.spring_boot_essentials.dto.AlunoDto;
import br.com.gustavodev.spring_boot_essentials.service.AlunosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
@Validated
public class AlunosController {

    private final AlunosService alunosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDto alunoDto) throws BadRequestException {
        alunosService.criarAluno(alunoDto);
    }

    @GetMapping("/{alunoId}/avaliacao")
    public AvaliacoesFisicasEntity getAvaliacaoFisica(@PathVariable Integer alunoId) throws NotFoundException {
        return alunosService.getAlunoAvaliacao(alunoId);
    }
}