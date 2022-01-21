package io.github.erichcl;

import io.github.erichcl.domain.entity.Cliente;
import io.github.erichcl.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            clientes.save(new Cliente("teste1"));
            clientes.save(new Cliente("teste2"));
            clientes.save(new Cliente("teste3"));
            clientes.save(new Cliente("teste4"));

            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado");
                clientes.save(c);
            });

            clientes.findByNomeLike("2").forEach(System.out::println);


            clientes.findByNomeLike("est").forEach(c -> {
                clientes.delete(c);
            });

            clientes.findAll().forEach(System.out::println);



        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
