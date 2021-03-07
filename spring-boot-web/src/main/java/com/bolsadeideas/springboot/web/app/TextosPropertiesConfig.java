package com.bolsadeideas.springboot.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//Necesario etiquetas de configuracion y propertysources, se linkea textos.properties senalando el lugar donde se encuentra.
@Configuration
@PropertySources({
	@PropertySource("classpath:textos.properties")
})
public class TextosPropertiesConfig {

}
