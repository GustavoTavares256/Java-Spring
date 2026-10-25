
package br.com.gustavodev.spring_boot_essentials.databse.repository;

import br.com.gustavodev.spring_boot_essentials.databse.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IAlunosRepository extends JpaRepository<AlunosEntity, Integer> {

    Optional<AlunosEntity> findByEmail(String email);

    @Query("""
        SELECT a FROM AlunosEntity a
        LEFT JOIN FETCH a.avaliacaoFisica
        WHERE a.id = :alunoId
        """)
    Optional<AlunosEntity> findByIdFetch(@Param("alunoId") Integer alunoId);
}
