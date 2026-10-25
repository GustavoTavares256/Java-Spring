package br.com.gustavodev.spring_boot_essentials.service;

import br.com.gustavodev.spring_boot_essentials.databse.model.AlunosEntity;
import br.com.gustavodev.spring_boot_essentials.databse.model.AvaliacoesFisicasEntity;
import br.com.gustavodev.spring_boot_essentials.databse.repository.IAlunosRepository;
import br.com.gustavodev.spring_boot_essentials.databse.repository.IAvaliacoesFisicasRepository;
import br.com.gustavodev.spring_boot_essentials.dto.AvaliacaoFisicaDto;
import br.com.gustavodev.spring_boot_essentials.exception.BadRequestException;
import br.com.gustavodev.spring_boot_essentials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisicaService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacoesFisicasRepository avaliacsoesFisicasRepository;

    public void criarAvaliacaoFisica(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacoesFisicasEntity avaliacaoFisica = aluno.getAvaliacaoFisica();
        if (avaliacaoFisica != null) {
            throw new BadRequestException("Avaliação fisica já cadastrada para esse aluno! ");
        }

        avaliacaoFisica = AvaliacoesFisicasEntity.builder()
                .peso(avaliacaoFisicaDto.getPeso())
                .altura(avaliacaoFisicaDto.getAltura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDto.getPorcentagemGorduraCorporal())
                .build();

        aluno.setAvaliacaoFisica(avaliacaoFisica);
        alunosRepository.save(aluno);
    }
}
