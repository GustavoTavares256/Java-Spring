package br.com.gustavodev.spring_boot_essentials.databse.repository;

import br.com.gustavodev.spring_boot_essentials.databse.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IExerciciosRepository extends JpaRepository<ExerciciosEntity, Integer> {

    List<ExerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);

    @Query(value = """
    SELECT e 
    FROM ExerciciosEntity e 
    WHERE UPPER(e.grupoMuscular) = UPPER(: grupoMuscular)
        """)
    List<ExerciciosEntity> findAllByGrupoMuscularJpql(@Param("grupoMuscular") String grupoMuscular);

    @NativeQuery(value = """
    SELECT e 
    FROM Exercicios e 
    WHERE UPPER(e.grupo_muscular) = UPPER(: grupoMuscular)""")

    List<ExerciciosEntity> findAllBygrupoMuscularNative(@Param("grupoMuscular") String grupoMuscular);


}
