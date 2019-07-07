package robson.stirle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import robson.stirle.model.Filme;

@Repository
public interface FilmeRepository extends CrudRepository<Filme, Long> {

	@Query(value = "select f2 from Filme f2 where f2.winner = true and f2.producers in (SELECT f.producers FROM Filme f where f.winner = true GROUP BY f.producers HAVING count(*) > 1) GROUP BY f2.idFilme, f2.producers, f2.studios, f2.title, f2.winner, f2.year order by  f2.producers, f2.year desc")
	public List<Filme> listaVencedores();	
	

}
