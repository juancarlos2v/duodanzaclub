package com.mindhub.duodanzaclub;

import com.mindhub.duodanzaclub.models.*;
import com.mindhub.duodanzaclub.repositories.AcademiaRepository;
import com.mindhub.duodanzaclub.repositories.ProductoRepository;
import com.mindhub.duodanzaclub.repositories.SalaFestivalRepository;
import com.mindhub.duodanzaclub.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class DuodanzaclubApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(DuodanzaclubApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UsuarioRepository usuarioRepository, AcademiaRepository academiaRepository, ProductoRepository productoRepository, SalaFestivalRepository salaFestivalRepository){

		return (args) -> {
			Usuario nacho = usuarioRepository.save(new Usuario("Nacho", "Molina", "1144332211", "nacho@gmail.com", "123456", LocalDate.now()));
			Academia academia1 = academiaRepository.save(new Academia("La academia del chona", "Buenos cyphers"));
			Academia academia2 = academiaRepository.save(new Academia("Racing club", "Mar del plata"));
			Usuario admin = new Usuario("admin@admin.com", passwordEncoder.encode("123456"));
			usuarioRepository.save(admin);

			Productos producto1 = new Productos("Zapatos de Salsa", "Zapatos de cuero", 12000.0, "Insert path", Estilos.BACHATA, TipoProducto.CALZADOS);
			productoRepository.save(producto1);


		};
	}
}
