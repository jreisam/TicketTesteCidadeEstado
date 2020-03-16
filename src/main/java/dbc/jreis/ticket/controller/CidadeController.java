package dbc.jreis.ticket.controller;

import dbc.jreis.ticket.model.Cidade;
import dbc.jreis.ticket.model.Estado;
import dbc.jreis.ticket.service.CidadeService;
import dbc.jreis.ticket.service.EstadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/cidade"})
@Slf4j
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;
    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity<List<Cidade>> findAll() {
        log.info("findAll Cidades");
        List<Cidade> response = cidadeService.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }

/*    @GetMapping
    public ResponseEntity<List<Cidade>> findAllByEstado(@RequestBody Estado estado) {
        log.info("findAll Cidades by Estado");
        List<Cidade> response = cidadeService.findAllByEstado(estado);
        return ResponseEntity.status(HttpStatus.OK)
                .body(response);
    }*/

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody Cidade cidade) {
        if (!cidadeJaExiste(cidade.getNome())) {
            cidadeService.save(cidade);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).build();
        }

    }

    @CrossOrigin
    @PostMapping("/porUF/{uf}")
    public ResponseEntity<Void> savePorSiglaUF(@PathVariable String uf, @Valid @RequestBody Cidade cidade) {
        Estado estado = estadoService.findBySigla(uf);
        long estadoId = estado.getId();
        cidade.setEstadoId(estadoId);
        if (!cidadeJaExiste(cidade.getNome())) {
            cidadeService.save(cidade);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> save(@PathVariable Long id, @Valid @RequestBody Cidade cidade) {
        cidadeService.update(id, cidade);

        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    private boolean cidadeJaExiste(String nomeCidade) {
        return cidadeService.findByNome(nomeCidade).isPresent();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cidadeService.delete(id, "rs");
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}