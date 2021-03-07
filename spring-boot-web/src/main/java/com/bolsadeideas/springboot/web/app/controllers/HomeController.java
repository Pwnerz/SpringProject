package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	//En el momento en el que entra una ruta simple. 1 / , redirecciona a /app/index.
	@GetMapping("/")
	public String home() {
//		Podemos tambien redireccionar a otras paginas simplemente metiendo la url a donde redireccionar. 
//		redirect:https://www.google.com
//		Tambien funciona con forward. Con forward no se reinicia la peticion. forward no se puede usar para redireccionar a paginas externas.
//		Forward ejecuta un RequestDispatcher.forward() de api.servlet
		return "forward:/app/index";
	}
}
