package com.example.demo.homeDos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.vacante.Vacante;

@Controller

public class Home {
	// *****************************************************************************
	// *****************************************************************************

	@GetMapping("/listado")
	public String MostarlLista(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero");
		lista.add("Medico");
		lista.add("Fisico");
		lista.add("Matematico");
		lista.add("Manager");
		model.addAttribute("trabajos", lista);

		return "listado";
	}

	// *****************************************************************************
	// *****************************************************************************
	@GetMapping("/")
	public String mostrarHome(Model model) {
		/*
		 * model.addAttribute("mensaje", "Saludos desde la clase Home ");
		 * model.addAttribute("fecha", new Date());
		 */

		String nombre = "Junior Java";
		double salario = 2000.00;
		Date fechaPub = new Date();
		boolean vigente = true;

		model.addAttribute("oferta", nombre);
		model.addAttribute("salario", salario);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("vigente", vigente);

		return "home";
	}

	// *****************************************************************************
	// *****************************************************************************
	@GetMapping("/indexVacante")
	public String vacante(Model model) {

		Vacante vacante01 = new Vacante();

		vacante01.setDescripcion("Manejo de sistemas");
		vacante01.setDate(new Date());
		vacante01.setNombre("Dveloper");
		vacante01.setSalario(2000.00);
		model.addAttribute("vacante", vacante01);

		return "indexVacante";
	}

	/*
	 * Metodo vacante******************************************************
	 * 
	 */

	public List<Vacante> getVacante() {
		// Creo un object de tipo date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		// Creo una lista para añadir los vacantes
		List<Vacante> listVacante = new LinkedList<Vacante>();

		try {
			// Vacante 01
			Vacante vacante01 = new Vacante();
			vacante01.setId(1);
			vacante01.setNombre("Programador");
			vacante01.setDescripcion("Developer");
			vacante01.setDate(sdf.parse("02-02-1992"));
			vacante01.setSalario(44.44);
			vacante01.setImagen("empresa1.png");

			// Vacante 02
			Vacante vacante02 = new Vacante();
			vacante02.setId(2);
			vacante02.setNombre("Programador");
			vacante02.setDescripcion("Developer");
			vacante02.setDate(sdf.parse("02-02-1992"));
			vacante02.setSalario(44.44);
			vacante02.setImagen("empresa2.png");

			// Vacante 03
			Vacante vacante03 = new Vacante();
			vacante03.setId(3);
			vacante03.setNombre("Programador");
			vacante03.setDescripcion("Developer");
			vacante03.setDate(sdf.parse("02-02-1992"));
			vacante03.setSalario(44.44);
			vacante03.setImagen("empresaDefault.png");

			// Vacante 04
			Vacante vacante04 = new Vacante();
			vacante04.setId(3);
			vacante04.setNombre("Programador");
			vacante04.setDescripcion("Developer");
			vacante04.setDate(sdf.parse("02-02-1992"));
			vacante04.setSalario(44.44);
			vacante04.setImagen("empresa4.png");


			// Añadimos las vacantes a la lista
			listVacante.add(vacante01);
			listVacante.add(vacante02);
			listVacante.add(vacante03);
			listVacante.add(vacante04);

		} catch (Exception ex) {
			ex.fillInStackTrace();

		}
		// Devuelvo la lista de vacante
		return listVacante;
	}

	// Creamos una un modelo para eviear el metodo getVacante
	@GetMapping("/indexListaVacante")
	public String getListaVacante(Model model) {

		// Creamos una lista con la cual trabajaremos de tipo vacante.
		List<Vacante> lista = getVacante();

		model.addAttribute("listaVacante", lista);
		return "indexListaVacante";
	}

}
