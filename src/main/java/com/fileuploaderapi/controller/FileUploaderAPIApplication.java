package com.fileuploaderapi.controller;


import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * @author Tekle Ayele
 *
 */

@SpringBootApplication
@ComponentScan({ "com.fileuploaderapi.config", "com.fileuploaderapi.beans", "com.fileuploaderapi.controller", "com.fileuploaderapi.dao", "com.fileuploaderapi.service" })
@EnableJSONDoc
public class FileUploaderAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileUploaderAPIApplication.class, args);
	}
}
