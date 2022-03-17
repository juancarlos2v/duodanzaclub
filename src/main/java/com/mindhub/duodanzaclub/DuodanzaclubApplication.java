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
import java.util.List;

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
			Usuario admin = usuarioService.saveUsuario(new Usuario("admin@admin.com", passwordEncoder.encode("123456")));
			Academia academia1 = academiaRepository.save(new Academia("Percanta", "Rosario"));
			Academia academia2 = academiaRepository.save(new Academia("La casa del tango", "Rosario"));
			Academia academia3 = academiaRepository.save(new Academia("Casona Yiró", "Rosaio"));
			Academia academia4 = academiaRepository.save(new Academia("La Viruta", "Buenos Aires"));
			Academia academia5 = academiaRepository.save(new Academia("Club Manso", "Buenos Aires"));
			Academia academia6 = academiaRepository.save(new Academia("Danzarte", "Buenos Aires"));
			Academia academia7 = academiaRepository.save(new Academia("Colmena", "Buenos Aires"));
			Academia academia8 = academiaRepository.save(new Academia("Parana", "Rosario"));
			Academia academia9 = academiaRepository.save(new Academia("Chamuyera", "Rosario"));
			Academia academia10 = academiaRepository.save(new Academia("Moef Ga-ga", "Rosario"));
			Academia academia11 = academiaRepository.save(new Academia("Fábrica de artes", "Rosario"));
			Festival festival1 = new Festival("Milonga Roja", Estilos.TANGO, 400.0, List.of(19.00, 20.30));
			Festival festival2 = new Festival("Percanta", Estilos.TANGO, 500.0, List.of(19.00, 20.30));
			Festival festival3 = new Festival("El Faro", Estilos.TANGO, 350.0, List.of(19.00, 20.30));
			Festival festival4 = new Festival("Mestiza", Estilos.TANGO, 400.0, List.of(19.00, 20.30));
			Festival festival5 = new Festival("La Chamuyera", Estilos.TANGO, 350.0, List.of(19.00, 20.30));
			Festival festival6 = new Festival("Viva la Pepa", Estilos.TANGO, 400.0, List.of(19.00, 20.30));
			Festival festival7 = new Festival("El beso", Estilos.TANGO, 550.0, List.of(19.00, 20.30));
			Festival festival8 = new Festival("Pipí Cucú", Estilos.TANGO, 500.0, List.of(19.00, 20.30));
			Festival festival9 = new Festival("Cachirulo", Estilos.TANGO, 350.0, List.of(19.00, 20.30));
			Festival festival10 = new Festival("CITA", Estilos.TANGO, 400.0, List.of(19.00, 20.30));
			Festival festivalSalsa1 = new Festival("Chayanne", Estilos.SALSA, 400.0, List.of(19.00, 20.30));
			Festival festivalSalsa2 = new Festival("La Rosita", Estilos.SALSA, 500.0, List.of(19.00, 20.30));
			Festival festivalSalsa3 = new Festival("Sabroso", Estilos.SALSA, 350.0, List.of(19.00, 20.30));
			Festival festivalSalsa4 = new Festival("Don Juan", Estilos.SALSA, 400.0, List.of(19.00, 20.30));
			Festival festivalSalsa5 = new Festival("Tropicana", Estilos.SALSA, 350.0, List.of(19.00, 20.30));
			Festival festivalSalsa6 = new Festival("Privé", Estilos.SALSA, 400.0, List.of(19.00, 20.30));
			Festival festivalSalsa7 = new Festival("Rosalía", Estilos.SALSA, 550.0, List.of(19.00, 20.30));
			Festival festivalSalsa8 = new Festival("Danzarte", Estilos.SALSA, 500.0, List.of(19.00, 20.30));
			Festival festivalSalsa9 = new Festival("Selvática", Estilos.SALSA, 350.0, List.of(19.00, 20.30));
			Festival festivalSalsa10 = new Festival("MariMar", Estilos.SALSA, 400.0, List.of(19.00, 20.30));
			Festival festivalBachata1 = new Festival("Santa Margarita", Estilos.BACHATA, 400.0, List.of(19.00, 20.30));
			Festival festivalBachata2 = new Festival("Romeo", Estilos.BACHATA, 500.0, List.of(19.00, 20.30));
			Festival festivalBachata3 = new Festival("La Sabrosa", Estilos.BACHATA, 350.0, List.of(19.00, 20.30));
			Festival festivalBachata4 = new Festival("El Yate", Estilos.BACHATA, 400.0, List.of(19.00, 20.30));
			Festival festivalBachata5 = new Festival("Rosario Bachata", Estilos.BACHATA, 350.0, List.of(19.00, 20.30));
			Festival festivalBachata6 = new Festival("Irupé", Estilos.BACHATA, 400.0, List.of(19.00, 20.30));
			Festival festivalBachata7 = new Festival("Shakti", Estilos.BACHATA, 550.0, List.of(19.00, 20.30));
			Festival festivalBachata8 = new Festival("Yira Yira", Estilos.BACHATA, 500.0, List.of(19.00, 20.30));
			Festival festivalBachata9 = new Festival("Camello de Rio", Estilos.BACHATA, 350.0, List.of(19.00, 20.30));
			Festival festivalBachata10 = new Festival("A todo Ritmo", Estilos.BACHATA, 400.0, List.of(19.00, 20.30));
			Productos producto1 = productoRepository.save(new Productos("Zapatos de Salsa", "Zapatos de cuero", 12000.0, "/web/recursos/imagenes/zapatos/MONOCHECKEREDREDPATENT.jpg", Estilos.BACHATA, Arrays.asList("38", "39", "40"), TipoProducto.CALZADOS, 5));
			Productos producto2 = productoRepository.save(new Productos("Camisa", "Camisa de seda", 3000.0, "Insert path", Estilos.SALSA, Arrays.asList("S", "M", "L"), TipoProducto.PRENDAS, 3));
			Productos producto3 = productoRepository.save(new Productos("Mono Checkered Red Patent", "Zapato clásico con motivo estampado tipo collage de colores.", 7000.0, "/web/recursos/imagenes/zapatos/MONOCHECKEREDREDPATENT.jpg", Estilos.BACHATA, Arrays.asList("40", "41", "42"), TipoProducto.CALZADOS, 5));
			Productos producto4 = productoRepository.save(new Productos("Mono Orient Express", "modelo clásico acordonado con motivos orientales y punta de charol", 12300.0, "/web/recursos/imagenes/zapatos/MONOORIENTEXPRESS.jpg", Estilos.SALSA, Arrays.asList("37", "38", "39", "40", "41", "42"), TipoProducto.CALZADOS, 23));
			Productos producto5 = productoRepository.save(new Productos("MONO TROILO", "modelo clásico acordonado en cuero", 15000.0, "/web/recursos/imagenes/zapatos/MONO_TROILO.jpg", Estilos.TANGO, Arrays.asList("37", "38", "39", "40", "41", "42", "43"), TipoProducto.CALZADOS, 32));
			Productos producto6 = productoRepository.save(new Productos("Falda FELICIA reversible", "falda media pierna con tajo lateral reversible, disponible en 4 tonos", 1800.0, "/web/recursos/imagenes/indumentaria/FALDAFELICIAREVERSIBLE.png", Estilos.SALSA, Arrays.asList("XS", "S", "M", "L", "XL", "XXL"), TipoProducto.PRENDAS, 18));
			Productos producto7 = productoRepository.save(new Productos("Top CAMILA", "top manga larga con detalle de volados en los bordes", 3000.0, "/web/recursos/imagenes/indumentaria/TopCAMILA.jpg", Estilos.TANGO, Arrays.asList("XS", "S", "M", "L", "XL", "XXL"), TipoProducto.PRENDAS, 15));





			Clase clase = claseRepository.save(new Clase("Clase de ballet", new ArrayList<Double>(), academia1));
			Clase clase2 = claseRepository.save(new Clase("Clase de tango", new ArrayList<Double>(), academia1));

			Suscripcion suscripcion1 = new Suscripcion("Básico", Arrays.asList(100.0,120.0,150.0), 5);
			suscripcionRepository.save(suscripcion1);
		};
	}
}
