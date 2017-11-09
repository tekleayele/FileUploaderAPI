package com.fileuploaderapi.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Tekle Ayele
 *
 */

@Controller
public class ViewController implements ErrorController{

	 private final static String ERROR_PATH = "/";
    
	@Value("${app-mode}")
	private String appMode;
	
	@Autowired
	public ViewController(Environment environment) {
		appMode = environment.getProperty("app-mode");
	}
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("mode", appMode);
		return "index";
	}
	
	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
}
