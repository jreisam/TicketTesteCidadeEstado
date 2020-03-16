package dbc.jreis.ticket.service;

import dbc.jreis.ticket.model.Cidade;
import dbc.jreis.ticket.model.Estado;
import dbc.jreis.ticket.repository.CidadeRepository;
import dbc.jreis.ticket.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public Estado findById(final Long id) {
        return estadoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }

    public Estado findBySigla(final String sigla) {
        return estadoRepository.findBySigla(sigla)
                .orElseThrow(() -> new ResourceNotFoundException(this.getClass().getName() + " not found!"));
    }


    public void save(final Estado estado) {
        estadoRepository.save(estado);
    }

    public void update(Long id, Estado estado) {
        Estado estadoOld = findById(id);
        estado.setId(estadoOld.getId());

        estadoRepository.save(estado);
    }

    public long retornaPopulacaoPorEstado(Estado estado) {
        List<Cidade> cidades = cidadeRepository.findAllByEstadoId(estado.getId());
        long populacaoTotEstado = 0;
        for (Cidade cidade : cidades
        ) {
            populacaoTotEstado += cidade.getPopulacao();
        }
        return populacaoTotEstado;
    }

    public long retornaNumCidadesPorEstado(Estado estado) {
        List<Cidade> cidades = cidadeRepository.findAllByEstadoId(estado.getId());
        return cidades.size();
    }
}