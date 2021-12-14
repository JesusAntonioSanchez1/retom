package co.sergioarboleda.retos;

import co.sergioarboleda.retos.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import co.sergioarboleda.retos.repository.ClotheCrudRepository;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Retosc4Application implements CommandLineRunner{

    @Autowired
    private ClotheCrudRepository cloneRepository;
    
    @Autowired
    private UserCrudRepository userRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(Retosc4Application.class, args);
                
	}
        
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
                }
            };
        }

    @Override
    public void run(String... args) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //   cloneRepository.deleteAll();
    //   userRepository.deleteAll();
       
    }

}
