package com.iappsan.fixi.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:application.properties"),
	@PropertySource("classpath:values.properties"),
	@PropertySource("classpath:homePage.properties"),
	@PropertySource("classpath:tax.properties")
})
public class ValuesCofiguration {

}
