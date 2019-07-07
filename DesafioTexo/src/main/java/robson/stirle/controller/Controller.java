package robson.stirle.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import robson.stirle.dao.DaoFilme;
import robson.stirle.model.Filme;
import robson.stirle.repository.FilmeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/producers")
@Api(value="API REST")
public class Controller {

	@Autowired
	FilmeRepository filmeRepository;
	
	@ApiOperation(value="Retorna o maior e menor intervalo entre dois prêmios")
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity listaGeral() {
		
		DaoFilme daoFilme = new DaoFilme();
		List<Filme> listFilmes = new ArrayList<>();
		
		listFilmes = daoFilme.leArquivoCsv(); 
		
		filmeRepository.saveAll(listFilmes);
						
		return new ResponseEntity(daoFilme.defineIntervalos(filmeRepository.listaVencedores()), HttpStatus.OK);
	}

}
