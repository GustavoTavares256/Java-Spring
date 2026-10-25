package br.com.gustavodev.spring_boot_essentials.service;

import br.com.gustavodev.spring_boot_essentials.databse.model.AlunosEntity;
import br.com.gustavodev.spring_boot_essentials.databse.model.ExerciciosEntity;
import br.com.gustavodev.spring_boot_essentials.databse.model.TreinosEntity;
import br.com.gustavodev.spring_boot_essentials.databse.repository.IAlunosRepository;
import br.com.gustavodev.spring_boot_essentials.databse.repository.IExerciciosRepository;
import br.com.gustavodev.spring_boot_essentials.databse.repository.ITreinosRepository;
import br.com.gustavodev.spring_boot_essentials.dto.TreinoDto;
import br.com.gustavodev.spring_boot_essentials.exception.BadRequestException;
import br.com.gustavodev.spring_boot_essentials.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final IAlunosRepository alunosRepository;
    private final IExerciciosRepository exerciciosRepository;
    private final ITreinosRepository treinosRepository;

    public void criarTreino(TreinoDto treinoDto) throws NotFoundException, BadRequestException {
        Set<ExerciciosEntity> exercicios = new HashSet<>();

        AlunosEntity aluno = alunosRepository.findById(treinoDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        TreinosEntity treino = treinosRepository.findByNomeAndAlunoId(treinoDto.getNome(), treinoDto.getAlunoId())
                .orElse(null);

        if( treino != null) {
            throw new BadRequestException("Já existe um treino com esse nome para esse aluno");
        }

        for (Integer exercicioId : treinoDto.getExercicioIds()) {
            ExerciciosEntity exercicio = exerciciosRepository.findById(exercicioId)
                    .orElseThrow(() -> new NotFoundException(String.format("Exercicio %s não encontrado", exercicioId)));

            exercicios.add(exercicio);
        }

        treino = TreinosEntity.builder()
                .nome(treinoDto.getNome())
                .aluno(aluno)
                .exercios(exercicios)
                .build();

        treinosRepository.save(treino);

    }

}
