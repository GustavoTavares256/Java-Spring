package br.com.gustavodev.spring_boot_essentials.databse.repository;

import br.com.gustavodev.spring_boot_essentials.databse.model.AlunosEntity;
import br.com.gustavodev.spring_boot_essentials.databse.model.AvaliacoesFisicasEntity;
import br.com.gustavodev.spring_boot_essentials.databse.model.TreinosEntity;
import br.com.gustavodev.spring_boot_essentials.dto.AvaliacoesFisicasProjection;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Value;
import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface IAvaliacoesFisicasRepository extends JpaRepository<AvaliacoesFisicasEntity, Integer> {




    @NativeQuery(value = """
        SELECT
            a.id AS idAluno,
            a.nome AS nomeAluno,
            af.id AS idAvaliacao,
            af.peso AS peso,
            af.altura AS altura,
            af.porcentagem_gordura_corporal AS percentualGorduraCorporal
        FROM alunos a
        INNER JOIN `Avaliacoes fisicas` af
            ON a.Avaliacao_fisica_id = af.id
        WHERE a.id = :alunoId
        """)
    List<AvaliacoesFisicasProjection> getAllAvaliacoes();


}
