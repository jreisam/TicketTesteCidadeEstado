package dbc.jreis.ticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringReactApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReactApplication.class, args);
    }

/*
    @Component
    public class DatabaseLoader implements CommandLineRunner {
        // teste
        private final EstadoRepository estadoRepository;

        public DatabaseLoader(EstadoRepository repository) {
            this.estadoRepository = repository;
        }

        @Override
        public void run(String... strings) throws Exception {
            this.estadoRepository.save(new Estado("Rio Grande do Sul", "riograndedosul", "bandeiraRS", null));
            this.estadoRepository.save(new Estado("Santa Catarina", "santacatarina", "bandeiraSC", null));
            this.estadoRepository.save(new Estado("Paraná", "parana", "bandeiraPN", null));
        }
    }*/
}
