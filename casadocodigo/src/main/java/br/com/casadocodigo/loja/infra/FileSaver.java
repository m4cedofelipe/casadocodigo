package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {

	@Autowired // anotação para o Spring cuidar da injeção de dependencia
	private HttpServletRequest request;

	public String write(String baseFolder, MultipartFile file) {

		try {

			/*
			 * A partir do objeto (request), conseguimos extrair o contexto atual em que o
			 * usuário se encontra e então conseguir o caminho absoluto desse diretório em
			 * nosso servidor.
			 */
			String realPath = request.getServletContext().getRealPath("/" + baseFolder);
			
			String path = realPath + "/" + file.getOriginalFilename();
			file.transferTo(new File(path));

			return baseFolder + "/" + file.getOriginalFilename();

		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}

	}
}
