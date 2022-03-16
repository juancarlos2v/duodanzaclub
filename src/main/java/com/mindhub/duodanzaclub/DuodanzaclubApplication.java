package com.mindhub.duodanzaclub;

import com.mindhub.duodanzaclub.models.*;
import com.mindhub.duodanzaclub.repositories.*;
import com.mindhub.duodanzaclub.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class DuodanzaclubApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {SpringApplication.run(DuodanzaclubApplication.class, args);}

	@Bean
	public CommandLineRunner initData(UsuarioService usuarioService, AcademiaRepository academiaRepository,
									  ProductoRepository productoRepository, SalaFestivalRepository salaFestivalRepository, ClaseRepository claseRepository,
									  SuscripcionRepository suscripcionRepository){

		return (args) -> {
			Usuario nacho = usuarioService.saveUsuario(new Usuario("Nacho", "Molina", "1144332211", "nacho@gmail.com", passwordEncoder.encode("123456"), LocalDate.now()));
			Usuario mati = usuarioService.saveUsuario(new Usuario("Mati", "Voro", "1122993493", "mati@gmail.com", passwordEncoder.encode("123456"), LocalDate.now()));
			Usuario tomi = usuarioService.saveUsuario(new Usuario("Tomi", "Voro", "11442910249", "tomi@gmail.com", passwordEncoder.encode("123456"), LocalDate.now()));
			Usuario lauti = usuarioService.saveUsuario(new Usuario("Lauti", "Molina", "1157284919", "lauti@gmail.com", passwordEncoder.encode("123456"), LocalDate.now()));
			Academia academia1 = academiaRepository.save(new Academia("La academia del chona", "Buenos cyphers"));
			Academia academia2 = academiaRepository.save(new Academia("Racing club", "Mar del plata"));
			Usuario admin = usuarioService.saveUsuario(new Usuario("admin@admin.com", passwordEncoder.encode("123456")));


			Productos producto1 = productoRepository.save(new Productos("Zapatos de Salsa", "Zapatos de cuero", 12000.0, "Insert path", Estilos.BACHATA, "39", TipoProducto.CALZADOS, 5));
			Productos producto2 = productoRepository.save(new Productos("Camisa", "Camisa de seda", 3000.0, "Insert path", Estilos.SALSA, "39", TipoProducto.PRENDAS, 3));




			Clase clase = claseRepository.save(new Clase("Clase de ballet", new ArrayList<Double>(), academia1));
			Clase clase2 = claseRepository.save(new Clase("Clase de tango", new ArrayList<Double>(), academia1));

			Suscripcion suscripcion1 = new Suscripcion("Básico", Arrays.asList(100.0,120.0,150.0), Arrays.asList(1, 2));
			suscripcionRepository.save(suscripcion1);
		};
	}
}
