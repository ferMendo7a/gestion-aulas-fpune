package com.devmp.gestionaulas.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devmp.gestionaulas.model.Usuario;
import com.devmp.gestionaulas.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path = "/login")
public class LoginController {

	@Autowired
	private UsuarioService service;

	@PostMapping
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
		try {
			Usuario usuarioAuth = service.findByLoginAndPassword(usuario);
			if (usuarioAuth == null) {
				return ResponseEntity.badRequest().body(usuario);
			}
			usuarioAuth.setToken(getJWTToken(usuarioAuth.getUsername()));
			return ResponseEntity.ok(usuarioAuth);
		} catch (Exception e) {
			return null;
		}

	}

	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

}
