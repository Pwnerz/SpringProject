package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

//Controller
@Controller
//Adds an app to the route. To get to index you have to go through it. /app/index || home . http://localhost:8080/app/index
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	//Mappeador que carga una ruta/vista mediante url. Puede ser GetMapping, PostMapping...
	@RequestMapping({"/index", "/","","/home"})
	//Adding stuff to the model.
	// Sustituible por Map<String,Object> map || Abajo seria map.put();
	//Otra manera mas es ModelAndView mv || mv.addObject(); || mv.setViewName("index");||Se cambia a return mv;
	public String index(Model model) {
		//titulo del html se muestra a traves del atributo titulo.
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Pepe"); 
		usuario.setApellido("Perez");
		usuario.setEmail("pepe@gmail.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
	model.addAttribute("titulo", textoListar);
	return "/listar";
	}
	//Usamos el ModelAttribute cuando queremos pasar a la vista algo comun a todos los metodos del controlador/ o que queremos tener en todas las vistas: /index /listar etc....
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Paco","Gonzalez","paco@mail.com"), new Usuario("Poco","Campos","poco@mail.com"), new Usuario("Xing","Martinez","xing@mail.com"));
		return usuarios;
	}
	
	
	
}
