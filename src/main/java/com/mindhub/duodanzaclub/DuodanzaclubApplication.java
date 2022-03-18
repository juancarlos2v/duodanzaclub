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
									  SuscripcionRepository suscripcionRepository, FestivalRepository festivalRepository, UsuarioClaseRepository usuarioClaseRepository,
									  ProfesorClaseRepository profesorClaseRepository, ProfesorRepository profesorRepository){

		return (args) -> {
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







			Festival festival1 = new Festival("Milonga Roja", "/web/recursos/imagenes/eventos/milongaRoja.png", "Lorem ipsu quibusdam sequi numquam dolor sit amet cone nesciunt mquam.  inventore, porro impedit non.\n" +
					"\n" +
					"España 320, Rosario, Santa Fe, Argentina - Horas: Cerrado ⋅ Abre a las 18:30 - Teléfono: +54 9 11 5674-2345", Estilos.TANGO, 400.0, List.of(Dias.VIERNES));
			Festival festival2 = new Festival("Percanta", "/web/recursos/imagenes/eventos/percanta.png", "Salón de baile tradicional de milonga y tango con en pleno centro de la ciudad de Rosario.\n" +
					"\n" +
					"Salta 1568 PA, S2000 Rosario, Santa Fe, Argentina - Horas: Cerrado ⋅ Abre a las 20:00 - Teléfono: +54 9 11 4102-7810", Estilos.TANGO, 500.0, List.of(Dias.SÁBADO));

			Festival festival3 = new Festival("El Beso", "/web/recursos/imagenes/eventos/elBeso.png", "Lorem ipsum dolor sit amet cone nesciunt mquam. Aliquid!\n" +
					"\n" +
					" 1233, San Telmo, Buenos Aires, Argentina - Horas: Cerrado ⋅ Abre a las 20:30 - Teléfono: +54 9 11 4900-4854", Estilos.TANGO, 550.0, List.of(Dias.LUNES));

			Festival festival4 = new Festival("Mestiza", "/web/recursos/imagenes/eventos/mestiza.png", " Lorem ipsum dolo omnis voluptates mollitia accusantium !\n\n" +
					"\n" +
					"Leguizamón 383, Rosario, Santa Fe, Argentina - Horas: Cerrado ⋅ Abre a las 22:00 - Teléfono: +54 9 11 4293-1021", Estilos.TANGO, 400.0, List.of(Dias.SÁBADO));

			Festival festival5 = new Festival("Pipí Cucú", "/web/recursos/imagenes/eventos/pipiCucu.png", "Lorem, d eos alias.\n" +
					"\n" +
					"Belgrano 970, Avellaneda, Buenos Aires, Argentina - Horas: Cerrado ⋅ Abre a las 20:00 - Teléfono: +54 9 11 4711-1932", Estilos.TANGO, 500.0, List.of(Dias.MARTES));

			Festival festival6 = new Festival("Viva la Pepa", "/web/recursos/imagenes/eventos/vivaLaPepa", "Lorem ipsum dolor site obcaecati rerum. Hic eos placeat provident.\n" +
					"\n" +
					"Corriente 772, Rosario, Santa Fe, Argentina - Horas: Cerrado ⋅ Abre a las 22:00 - Teléfono: +54 9 11 4332-0041", Estilos.TANGO, 400.0, List.of(Dias.MIÉRCOLES));

			Festival festival7 = new Festival("La Chamuyera", "/web/recursos/imagenes/eventos/laChamuyera", "Lorem ipsum dolor, sit amet conse culpa illo repellat ex veritatis eaque saficia dolore nemo illum!\n" +
					"\n" +
					"Balcarce 2375, Rosario, Santa Fe, Argentina - Horas: Cerrado ⋅ Abre a las 20:00 - Teléfono: +54 9 11 4990-3683", Estilos.TANGO, 550.0, List.of(Dias.JUEVES));


			Festival festivalSalsa1 = new Festival("Chayanne", "/web/recursos/imagenes/eventos/chayanne.png", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Enim fuga iste error repellat volupem explicabo?\n" +
					"\n" +
					"Urquíza 320, Quílmes, Buenos Aires, Argentina - Horas: Cerrado ⋅ Abre a las 21:00 - Teléfono: +54 9 11 4992-2376", Estilos.SALSA, 400.0, List.of(Dias.VIERNES));

			Festival festivalSalsa2 = new Festival("La Rosita", "/web/recursos/imagenes/eventos/laRosita.png", "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Maiores veniam esse itaque psconsectetur!\n" +
					"\n" +
					"Magallanes 543, Escobar, Buenos Aires, Argentina - Horas: Cerrado ⋅ Abre a las 21:30 - Teléfono: +54 9 11 4087-7110", Estilos.SALSA, 500.0, List.of(Dias.JUEVES));

			Festival festivalSalsa3 = new Festival("Sabroso", "/web/recursos/imagenes/eventos/sabroso.png", "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Temporibus odio deleniti aliquid dicta. Illo atque inventore sequi.\n" +
					"\n" +
					"Centenario 267, Lanús, Buenos Aires, Argentina - Horas: Cerrado ⋅ Abre a las 20:45 - Teléfono: +54 9 11 4198-5546", Estilos.SALSA, 350.0, List.of(Dias.SÁBADO));



			Festival festivalSalsa4 = new Festival("Danzarte", "/web/recursos/imagenes/eventos/danzarte.png", " Lorem ipsum dolor sit, amet consectetur adipisicing elit. Ratione maiores! Veniam optio dignissimos sunt itaque similique.\n" +
					"\n" +
					"San Martín 582, Rosario, Santa Fe, Argentina - Horas: Cerrado ⋅ Abre a las 21:30 - Teléfono: +54 9 11 4441-9775", Estilos.SALSA, 400.0, List.of(Dias.MARTES));

			Festival festivalSalsa5 = new Festival("Tropicana", "/web/recursos/imagenes/eventos/tropicana.png", "Lorem ipsum dolor sit amet consectetur adipisicing elit. accusamus cupiditate optio quidem quia fuga alias fugit!\n" +
					"\n" +
					"Entre Ríos 332, Rosario, Santa Fe, Argentina - Horas: Cerrado ⋅ Abre a las 22:30 - Teléfono: +54 9 11 4683-2310", Estilos.SALSA, 350.0, List.of(Dias.LUNES));

			Festival festivalSalsa6 = new Festival("Privé", "/web/recursos/imagenes/eventos/prive.png", "Lorem ipsum dolor sit, amet consectetur adipisicing elit. Debitis corrupti tempora nisi deserunt illo cupiditate iste magni.\n" +
					"\n" +
					"Buenos Aires 1500, Rosario, Santa Fe, Argentina - Horas: Cerrado ⋅ Abre a las 21:00 - Teléfono: +54 9 11 4223-7999", Estilos.SALSA, 400.0, List.of(Dias.MIÉRCOLES));

			Festival festivalSalsa7 = new Festival("Rosalía", "/web/recursos/imagenes/eventos/rosalia.png", "Lorem ipsum dolor sit amet, consectetur adipisicing elit. earum quos error voluptatibus sit odit repudiandae repellat culpa eveniet.\n" +
					"\n" +
					"Sarmiento 828, Rosario, Santa Fe, Argentina - Horas: Cerrado ⋅ Abre a las 22:15 - Teléfono: +54 9 11 4265-9436", Estilos.SALSA, 550.0, List.of(Dias.DOMINGO));



			Festival festivalBachata1 = new Festival("Santa Margarita", "/web/recursos/imagenes/eventos/santaMargarita.png", "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Ipsum, ipsam dolore optio harum sed  alias.\n" +
					"\n" +
					"Bransen 120, La Boca, Buenos Aires, Argentina - Horas: Cerrado ⋅ Abre a las 20:30 - Teléfono: +54 9 11 4666-0098", Estilos.BACHATA, 400.0, List.of(Dias.VIERNES));

			Festival festivalBachata2 = new Festival("Romeo", "/web/recursos/imagenes/eventos/romeo.png", "Lorem ipsum dolor, sit amet consectetur adipisicing elit. Recusandae optio animi itaque quisquam inventore illum velit nemo atque eveniet ad.\n" +
					"\n" +
					"San Luís 600, Tandíl, Buenos Aires, Argentina - Horas: Cerrado ⋅ Abre a las 22:00 - Teléfono: +54 9 11 5762-6653", Estilos.BACHATA, 500.0, List.of(Dias.LUNES));

			Festival festivalBachata3 = new Festival("La Sabrosa", "/web/recursos/imagenes/eventos/sabroso.png", "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Laborum, id? Voluptatem quo iusto ab illum alias in quis odit dolorum!\n" +
					"\n" +
					"Carriego 120, Banfield, Buenos Aires, Argentina - Horas: Cerrado ⋅ Abre a las 20:45 - Teléfono: +54 9 11 4009-8810", Estilos.BACHATA, 350.0, List.of(Dias.MARTES));

			Festival festivalBachata4 = new Festival("El Yate", "/web/recursos/imagenes/eventos/elYate.png", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Cum officiis, consequatur, cumque unde et dicta accusantium consequuntur.\n" +
					"\n" +
					"J. J. Paso 342, Flores, Buenos Aires, Argentina - Horas: Cerrado ⋅ Abre a las 23:00 - Teléfono: +54 9 11 5432-8869", Estilos.BACHATA, 400.0, List.of(Dias.DOMINGO));

			Festival festivalBachata5 = new Festival("Rosario Bachata", "/web/recursos/imagenes/eventos/rosarioBachata.png", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat aperiam corrupti asperiores dolor, esse in molestias.\n" +
					"\n" +
					"San Lorenzo 2300, Rosario, Santa Fe, Argentina - Horas: Cerrado ⋅ Abre a las 20:15 - Teléfono: +54 9 11 3452-6446", Estilos.BACHATA, 350.0, List.of(Dias.MIÉRCOLES));

			Festival festivalBachata6 = new Festival("Irupé", "/web/recursos/imagenes/eventos/irupe.png", "Lorem ipsum dolor, sit amet consectetur adipisicing elit. A, asperiores excepturi quam molestiae eius incidunt a quae eveniet.\n" +
					"\n" +
					"Bolivia 900, S2000 Rosario, Santa Fe, Argentina - Horas: Cerrado ⋅ Abre a las 19:00 - Teléfono: +54 9 10 4326-6554", Estilos.BACHATA, 400.0, List.of(Dias.JUEVES));

			Festival festivalBachata7 = new Festival("Shakti", "/web/recursos/imagenes/eventos/shakti.png", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam et ad, odio,epellendus tempora ullam? Hic.\n" +
					"\n" +
					"La Pampa 443, Rosario, Santa Fe, Argentina - Horas: Cerrado ⋅ Abre a las 18:00 - Teléfono: +54 9 11 4244-4678", Estilos.BACHATA, 550.0, List.of(Dias.SÁBADO));


			festivalRepository.save(festival1);
			festivalRepository.save(festival2);
			festivalRepository.save(festival3);
			festivalRepository.save(festival4);
			festivalRepository.save(festival5);
			festivalRepository.save(festival6);
			festivalRepository.save(festival7);

			festivalRepository.save(festivalSalsa1);
			festivalRepository.save(festivalSalsa2);
			festivalRepository.save(festivalSalsa3);
			festivalRepository.save(festivalSalsa4);
			festivalRepository.save(festivalSalsa5);
			festivalRepository.save(festivalSalsa6);
			festivalRepository.save(festivalSalsa7);

			festivalRepository.save(festivalBachata1);
			festivalRepository.save(festivalBachata2);
			festivalRepository.save(festivalBachata3);
			festivalRepository.save(festivalBachata4);
			festivalRepository.save(festivalBachata5);
			festivalRepository.save(festivalBachata6);
			festivalRepository.save(festivalBachata7);




			Usuario nacho = usuarioService.saveUsuario(new Usuario("Nacho", "Molina", "1144332211", "nacho@gmail.com", passwordEncoder.encode("123456"), LocalDate.now(), academia1));
			Usuario mati = usuarioService.saveUsuario(new Usuario("Mati", "Voro", "1122993493", "mati@gmail.com", passwordEncoder.encode("123456"), LocalDate.now(), academia1));
			Usuario tomi = usuarioService.saveUsuario(new Usuario("Tomi", "Voro", "11442910249", "tomi@gmail.com", passwordEncoder.encode("123456"), LocalDate.now(), academia1));
			Usuario lauti = usuarioService.saveUsuario(new Usuario("Lauti", "Molina", "1157284919", "lauti@gmail.com", passwordEncoder.encode("123456"), LocalDate.now(), academia1));

      

			Profesor profesor1 = new Profesor("Fernando", "Obanos");
			Profesor profesor2 = new Profesor("Romina", "Gasper");
			Profesor profesor3 = new Profesor("María", "Muñoz");
			Profesor profesor4 = new Profesor("Guillermo", "Ruiz");
			Profesor profesor5 = new Profesor("Gio", "De Bellonia");
			Profesor profesor6 = new Profesor("Lucia", "Be");
			Profesor profesor7 = new Profesor("El Peque", "");
			Profesor profesor8 = new Profesor("Rocío", "Lequio");
			Profesor profesor9 = new Profesor("Bruno", "Tombari");
			Profesor profesor10 = new Profesor("El Duende", "");
			Profesor profesor11 = new Profesor("Marisa", "Talamoni");
			Profesor profesor12 = new Profesor("Ricardo", "Calvo");
			Profesor profesor13 = new Profesor("Soledad", "Cantarini");
			Profesor profesor14 = new Profesor("Diego", "López");
			Profesor profesor15 = new Profesor("Rosana", "Romero");
			Profesor profesor16 = new Profesor("El colo", "Benítez");
			Profesor profesor17 = new Profesor("Fernando", "Obanos");
			Profesor profesor18 = new Profesor("Romi", "Gasperi");
			Profesor profesor19 = new Profesor("Ani", "Badalyan");
			Profesor profesor20 = new Profesor("Roberlito", "");
			Profesor profesor21 = new Profesor("Tamara", "Bornia");
			Profesor profesor22 = new Profesor("El Tano", "");
			Profesor profesor23 = new Profesor("Los Tolis", "");
			Profesor profesor24 = new Profesor("Yamila", "López");
			Profesor profesor25 = new Profesor("Romeo", "");
			Profesor profesor26 = new Profesor("Chayanne", "");


			profesorRepository.save(profesor1);
			profesorRepository.save(profesor2);
			profesorRepository.save(profesor3);
			profesorRepository.save(profesor4);
			profesorRepository.save(profesor5);
			profesorRepository.save(profesor6);
			profesorRepository.save(profesor7);
			profesorRepository.save(profesor8);
			profesorRepository.save(profesor9);
			profesorRepository.save(profesor10);
			profesorRepository.save(profesor11);
			profesorRepository.save(profesor12);
			profesorRepository.save(profesor13);
			profesorRepository.save(profesor14);
			profesorRepository.save(profesor15);



			Productos producto1 = productoRepository.save(new Productos("Zapatos AZRAEL", "Zapatos de cuero", 12000.0, "/web/recursos/imagenes/zapatos/MONOAZRAEL.jpg", Estilos.BACHATA, Arrays.asList("38", "39", "40"), TipoProducto.CALZADOS, 5));
			Productos producto2 = productoRepository.save(new Productos("Zapatos ROMANIA", "Camisa de seda", 3000.0, "/web/recursos/imagenes/zapatos/100ROMANIA.png", Estilos.SALSA, Arrays.asList("S", "M", "L"), TipoProducto.PRENDAS, 3));
			Productos producto11 = productoRepository.save(new Productos("Vestido SILVINA Negro", "vestido elegante espalda descubierta, disponible en 4 tonos", 5800.0, "/web/recursos/imagenes/indumentaria/SILVINANEGRO.png", Estilos.SALSA, Arrays.asList("XS", "S", "M", "L", "XL", "XXL"), TipoProducto.PRENDAS, 18));
			Productos producto3 = productoRepository.save(new Productos("Mono Checkered Patent", "Zapato clásico con motivo estampado tipo collage de colores.", 7000.0, "/web/recursos/imagenes/zapatos/MONOCHECKEREDREDPATENT.jpg", Estilos.BACHATA, Arrays.asList("40", "41", "42"), TipoProducto.CALZADOS, 5));
			Productos producto4 = productoRepository.save(new Productos("Mono Orient Express", "modelo clásico acordonado con motivos orientales y punta de charol", 12300.0, "/web/recursos/imagenes/zapatos/MONOORIENTEXPRESS.jpg", Estilos.SALSA, Arrays.asList("37", "38", "39", "40", "41", "42"), TipoProducto.CALZADOS, 23));
			Productos producto6 = productoRepository.save(new Productos("Falda FELICIA reversible", "falda media pierna con tajo lateral reversible, disponible en 4 tonos", 1800.0, "/web/recursos/imagenes/indumentaria/NINAREVERSIBLE.png", Estilos.SALSA, Arrays.asList("XS", "S", "M", "L", "XL", "XXL"), TipoProducto.PRENDAS, 18));
			Productos producto5 = productoRepository.save(new Productos("MONO TROILO", "modelo clásico acordonado en cuero", 15000.0, "/web/recursos/imagenes/zapatos/MONO_TROILO.jpg", Estilos.TANGO, Arrays.asList("37", "38", "39", "40", "41", "42", "43"), TipoProducto.CALZADOS, 32));
			Productos producto7 = productoRepository.save(new Productos("Top CAMILA", "top manga larga con detalle de volados en los bordes", 3000.0, "/web/recursos/imagenes/indumentaria/TopCAMILA.jpg", Estilos.TANGO, Arrays.asList("XS", "S", "M", "L", "XL", "XXL"), TipoProducto.PRENDAS, 15));
			Productos producto8 = productoRepository.save(new Productos("Mono Cachirulo ", "Zapato clásico con motivo estampado tipo collage de colores.", 7000.0, "/web/recursos/imagenes/zapatos/MONOCACHIRULO.jpg", Estilos.BACHATA, Arrays.asList("40", "41", "42"), TipoProducto.CALZADOS, 5));
			Productos producto10 = productoRepository.save(new Productos("MONO TROILO", "modelo clásico acordonado en cuero", 15000.0, "/web/recursos/imagenes/zapatos/MONO_TROILO.jpg", Estilos.TANGO, Arrays.asList("37", "38", "39", "40", "41", "42", "43"), TipoProducto.CALZADOS, 32));
			Productos producto12 = productoRepository.save(new Productos("Vestido ROCOCÓ", "vestido con detalle de volados en los bordes", 3000.0, "/web/recursos/imagenes/indumentaria/ROCOCO.png", Estilos.TANGO, Arrays.asList("XS", "S", "M", "L", "XL", "XXL"), TipoProducto.PRENDAS, 15));
			Productos producto9 = productoRepository.save(new Productos("Mono Orient Express", "modelo clásico acordonado con motivos orientales y punta de charol", 12300.0, "/web/recursos/imagenes/zapatos/MONOORIENTEXPRESS.jpg", Estilos.SALSA, Arrays.asList("37", "38", "39", "40", "41", "42"), TipoProducto.CALZADOS, 23));




			Clase clase = claseRepository.save(new Clase("Clase de ballet", Estilos.SALSA ,"21:30 a 23:00", "Ayacucho 2345, San Cristobal", academia1));
			Clase clase2 = claseRepository.save(new Clase("Clase de tango", Estilos.BACHATA , "20:00 a 21:30", "Primera Junta 823, La Lucila", academia1));

			UsuarioClase usuarioClase1 = usuarioClaseRepository.save(new UsuarioClase(nacho, clase));
			//UsuarioClase usuarioClase2 = usuarioClaseRepository.save(new UsuarioClase(nacho, clase2));
			UsuarioClase usuarioClase3 = usuarioClaseRepository.save(new UsuarioClase(lauti, clase));
			UsuarioClase usuarioClase4 = usuarioClaseRepository.save(new UsuarioClase(tomi, clase));

			ProfesorClase profesorClase = profesorClaseRepository.save(new ProfesorClase(profesor1, clase));
			ProfesorClase profesorClase2 = profesorClaseRepository.save(new ProfesorClase(profesor2, clase2));
			ProfesorClase profesorClase3 = profesorClaseRepository.save(new ProfesorClase(profesor3, clase2));


			Suscripcion suscripcion1 = new Suscripcion("Clase suelta", List.of(1000.0), 1);
			suscripcionRepository.save(suscripcion1);

			Suscripcion suscripcion2 = new Suscripcion("Mensual", List.of(2500.0), 3);
			suscripcionRepository.save(suscripcion2);

			Suscripcion suscripcion3 = new Suscripcion("Trimestral", List.of(6000.0), 5);
			suscripcionRepository.save(suscripcion3);


		};
	}
}
