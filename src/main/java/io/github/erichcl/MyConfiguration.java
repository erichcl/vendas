package io.github.erichcl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Development
public class MyConfiguration {

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("Rodando dev");
        };
    }

        @Bean(name = "applicationName")
        public String applicationName(){
            return "Sistema de vendas";
        }

}
