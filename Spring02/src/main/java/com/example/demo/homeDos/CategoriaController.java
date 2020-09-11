package com.example.demo.homeDos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoriaController {

	//@GetMapping("/index")
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {

		return"Categorias/ListaCategorias";

	}

	//@GetMapping("/crate")
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create() {

		return"Categorias/formCategoria";

	}
	
	//@GetMapping("/save")
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save() {

		return"Categorias/lisCategoria";

	}
	


}
