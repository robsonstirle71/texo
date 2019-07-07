package robson.stirle.dao;

import robson.stirle.dto.FilmeDto;
import robson.stirle.model.Filme;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaoFilme {

	public List<Filme> leArquivoCsv() {

		List<Filme> listFilmes = new ArrayList<>();

		try {

			File arquivoCSV = new File("src\\main\\resources\\movielist.csv");
			Filme filme;

			// cria um scanner para ler o arquivo
			Scanner leitor = new Scanner(arquivoCSV);

			// variavel que armazenara as linhas do arquivo
			String linhasDoArquivo = new String();

			// ignora a primeira linha do arquivo
			leitor.nextLine();

			while (leitor.hasNext()) {

				// recebe cada linha do arquivo
				linhasDoArquivo = leitor.nextLine();

				// separa os campos entre as virgulas de cada linha
				String[] dados = linhasDoArquivo.split(";");

				String producers = dados[3].replaceAll(" and ", ",");

				String producersFormat[] = producers.split(",");

				int i = 0;
				while (i < producersFormat.length) {

					filme = new Filme();

					filme.setYear(Integer.parseInt(dados[0]));
					filme.setTitle(dados[1]);
					filme.setStudios(dados[2]);
					filme.setProducers(dados[3]);
					filme.setProducers(producersFormat[i].trim());

					if (dados.length == 5) { // se for vencedor do premio
						filme.setWinner(true);
					} else {
						filme.setWinner(false);
					}

					listFilmes.add(filme);

					i++;
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		return listFilmes;

	}

	public List<FilmeDto> defineIntervalos(List<Filme> listFilmes) {

		List<FilmeDto> listDto = new ArrayList<>();
		FilmeDto filmeDto;

		try {			
			
			if(listFilmes.size() > 0) {
				
				int z = 0;
				int y = 0;
				
				for (z = 0; z <= listFilmes.size(); z++) {
					for (y = z + 1; y < listFilmes.size(); y++) {
						if (listFilmes.get(y).getProducers().equals(listFilmes.get(z).getProducers())) {

							filmeDto = new FilmeDto();

							int intervalo = listFilmes.get(y).getYear() - listFilmes.get(z).getYear();

							if (intervalo < 0) {
								intervalo = intervalo * (-1);
								filmeDto.setFollowingWin(listFilmes.get(z).getYear());
								filmeDto.setPreviousWin(listFilmes.get(y).getYear());
							} else {
								filmeDto.setFollowingWin(listFilmes.get(y).getYear());
								filmeDto.setPreviousWin(listFilmes.get(z).getYear());
							}

							filmeDto.setInterval((intervalo));
							filmeDto.setProducer(listFilmes.get(y).getProducers());

							listDto.add(filmeDto);

						}
					}
				}
				
			}
			
		}catch(IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

		return listaMenorMaiorInterlo(listDto);

	}

	public List<FilmeDto> listaMenorMaiorInterlo(List<FilmeDto> listParam) {

		List<FilmeDto> listReturn = new ArrayList<>();
		FilmeDto filmeDto;

		int r = 0;
		int maior = 0;
		int menor = 0;
		int posMenor = 0;
		int posMaior = 0;

		while (r < listParam.size()) { // lista ja separada um produtor por linha

			if (r == 0) {
				maior = listParam.get(r).getInterval();
				menor = listParam.get(r).getInterval();
				posMenor = r;
				posMaior = r;
			} else {

				if (listParam.get(r).getInterval() > maior) {

					maior = listParam.get(r).getInterval();
					posMaior = r;
				}

				if (listParam.get(r).getInterval() < menor) {
					menor = listParam.get(r).getInterval();
					posMenor = r;
				}

			}

			r++;

		}

		filmeDto = new FilmeDto();

		filmeDto.setInterval(listParam.get(posMaior).getInterval());
		filmeDto.setFollowingWin(listParam.get(posMaior).getFollowingWin());
		filmeDto.setPreviousWin(listParam.get(posMaior).getPreviousWin());
		filmeDto.setProducer(listParam.get(posMaior).getProducer());

		listReturn.add(filmeDto);

		filmeDto = new FilmeDto();
		filmeDto.setInterval(listParam.get(posMenor).getInterval());
		filmeDto.setFollowingWin(listParam.get(posMenor).getFollowingWin());
		filmeDto.setPreviousWin(listParam.get(posMenor).getPreviousWin());
		filmeDto.setProducer(listParam.get(posMenor).getProducer());

		listReturn.add(filmeDto);

		return listReturn;
	}

}
