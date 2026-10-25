package br.com.gustavodev.spring_boot_essentials.databse.repository;

import br.com.gustavodev.spring_boot_essentials.databse.model.ExerciciosEntity;
import br.com.gustavodev.spring_boot_essentials.databse.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer> {

    Optional<TreinosEntity> findByNomeAndAlunoId(String nome, Integer alunoId);

}
