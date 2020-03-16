package dbc.jreis.ticket.repository;

import dbc.jreis.ticket.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    Optional<Cidade> findByNome(String nome);

    List<Cidade> findAllByEstadoId(long estadoId);
}

