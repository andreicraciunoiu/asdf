package com.dbtechschool;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@SpringBootApplication
public class TmfaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmfaApplication.class, args);
	}
}
