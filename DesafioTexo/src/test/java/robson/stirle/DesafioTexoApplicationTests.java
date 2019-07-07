package robson.stirle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import robson.stirle.dao.DaoFilme;
import robson.stirle.dto.FilmeDto;
import robson.stirle.model.Filme;
import robson.stirle.repository.FilmeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DesafioTexoApplicationTests {
	
	@Autowired
	FilmeRepository filmeRepository;
	

	@Test
	public void tamanhoLista() {
		
		DaoFilme daofilme = new DaoFilme();
		List<Filme> listFilmes = new ArrayList<>();
		listFilmes = daofilme.leArquivoCsv();
		
		assertEquals("deveria vir valor 439", listFilmes.size(), 439);
	}
	@Test
	public void gravaDadosBanco() {
		
		DaoFilme daofilme = new DaoFilme();
		List<Filme> listFilmes = new ArrayList<>();
		listFilmes = daofilme.leArquivoCsv();
		
		filmeRepository.saveAll(listFilmes);
		
		assertNotNull("nao deveria ser nula a lista", listFilmes);
		assertEquals("deveria vir valor 439", listFilmes.size(), 439);
		assertEquals("deveria vir valor Allan Carr", listFilmes.get(0).getProducers(), "Allan Carr");
	}
	
	@Test
	public void resultadoFinal() {
		
		DaoFilme daofilme = new DaoFilme();
		List<Filme> listFilmes = new ArrayList<>();
		List<FilmeDto> listFinal = new ArrayList<>();
		listFilmes = daofilme.leArquivoCsv();
		
		filmeRepository.saveAll(listFilmes);
		
		listFinal = daofilme.defineIntervalos(filmeRepository.listaVencedores());
		
		assertNotNull("nao deveria ser nulo o resultado", listFinal);
		assertEquals("deveria vir valor 2", listFinal.size(), 2);
		
		
	}

}
