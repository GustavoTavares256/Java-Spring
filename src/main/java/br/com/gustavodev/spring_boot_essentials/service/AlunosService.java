package br.com.gustavodev.spring_boot_essentials.service;

import br.com.gustavodev.spring_boot_essentials.databse.model.AlunosEntity;
import br.com.gustavodev.spring_boot_essentials.databse.model.AvaliacoesFisicasEntity;
import br.com.gustavodev.spring_boot_essentials.databse.repository.IAlunosRepository;
import br.com.gustavodev.spring_boot_essentials.dto.AlunoDto;
import br.com.gustavodev.spring_boot_essentials.exception.BadRequestException;
import br.com.gustavodev.spring_boot_essentials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunosService {

    private final IAlunosRepository alunosRepository;

    public void criarAluno(AlunoDto alunoDto) throws BadRequestException {
        AlunosEntity aluno = alunosRepository.findByEmail(alunoDto.getEmail())
                .orElse(null);

        if (aluno != null) {
            throw new BadRequestException("Aluno ja cadastrado com este email");
        }

        alunosRepository.save(AlunosEntity.builder()
                .nome(alunoDto.getNome())
                .email(alunoDto.getEmail())
                .build());
    }

    public AvaliacoesFisicasEntity getAlunoAvaliacao(Integer alunoId) throws NotFoundException{
        AlunosEntity aluno = alunosRepository.findByIdFetch(alunoId)
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado "));

        AvaliacoesFisicasEntity avaliacao = aluno.getAvaliacaoFisica();
        if (avaliacao == null) {
            throw new NotFoundException("Avalição fisica não encontrada para este aluno");
        }
        return avaliacao;
    }
}