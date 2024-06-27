package com.taimBack.controllers;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BasicAuthController {

	@PostMapping(path = "/login")
	public ResponseEntity<String> basicauth(Principal principal) {
		// El objeto principal tiene información sobre el usuario y la contraseña, aunque de todas formas no la vamos a utilizar
		// No devolveremos el usuario ni la contraseña al front, sino información sobre si el login ha sido exitoso. Si lo ha sido, a partir de ese momento, desde el front, mandaremos en la cabecera de cada petición el username y password que han provocado que el login sea exitoso

		return ResponseEntity.ok().body("{\"resp\":\"Login exitoso\"}");

	}
}