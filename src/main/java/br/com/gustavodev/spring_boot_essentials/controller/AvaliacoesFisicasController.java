package br.com.gustavodev.spring_boot_essentials.controller;


import br.com.gustavodev.spring_boot_essentials.dto.AvaliacaoFisicaDto;
import br.com.gustavodev.spring_boot_essentials.exception.BadRequestException;
import br.com.gustavodev.spring_boot_essentials.exception.NotFoundException;
import br.com.gustavodev.spring_boot_essentials.service.AvaliacaoFisicaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
public class AvaliacoesFisicasController {

    private final AvaliacaoFisicaService avaliacaoFisicaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        avaliacaoFisicaService.criarAvaliacaoFisica(avaliacaoFisicaDto);
    }
}
