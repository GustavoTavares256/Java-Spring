package br.com.gustavodev.spring_boot_essentials.service;

import br.com.gustavodev.spring_boot_essentials.databse.model.ExerciciosEntity;
import br.com.gustavodev.spring_boot_essentials.databse.repository.IExerciciosRepository;
import br.com.gustavodev.spring_boot_essentials.dto.ExercicioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {

    private final IExerciciosRepository exerciciosRepository;

    public List<ExerciciosEntity> findAll() {
        return exerciciosRepository.findAll();
    }

    public void save(ExercicioDto exercicioDTO) {
        ExerciciosEntity exercicio = ExerciciosEntity.builder()
                .nome(exercicioDTO.getNome())
                .grupoMuscular(exercicioDTO.getGrupoMuscular())
                .build();

        exerciciosRepository.save(exercicio);
    }

    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(String grupoMuscular) {
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }
}
