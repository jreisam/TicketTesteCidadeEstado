package dbc.jreis.ticket.service;

import dbc.jreis.ticket.model.Cidade;
import dbc.jreis.ticket.repository.CidadeRepository;
import dbc.jreis.ticket.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Cidade> findAll() {
        return cidadeRepository.findAll();
    }

    public Cidade findById(final Long id) {
        return cidadeRepository.findById(id)
                .orElseThrow(this::cidadeNotFount);
    }

    public Optional<Cidade> findByNome(final String nomeCidade) {
        return cidadeRepository.findByNome(nomeCidade);
    }

/*    public List<Cidade> findAllByEstado(final Estado estado) {
        return cidadeRepository.findAllByEstado(estado);
    }*/

    public void save(final Cidade cidade) {
        cidadeRepository.save(cidade);
    }

    public void update(Long id, Cidade cidade) {
        Cidade cidadeOld = findById(id);
        cidade.setId(cidadeOld.getId());

        cidadeRepository.save(cidade);
    }

    public void delete(Long id, String siglaEstado) {
        if (!estadoRepository.findBySigla(siglaEstado).isPresent())
            cidadeRepository.deleteById(id);

    }
/*    public Cidade findByName(Cidade cidade) {
        return cidadeRepository.findFirstByNome(cidade.getNome())
                .orElseThrow(this::cidadeNotFount);
    }*/

    private ResourceNotFoundException cidadeNotFount() {
        return new ResourceNotFoundException(this.getClass().getName() + " not found!");
    }
}