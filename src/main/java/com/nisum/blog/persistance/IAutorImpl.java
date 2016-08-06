package com.nisum.blog.persistance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import com.nisum.blog.model.Author;

public class IAutorImpl implements IAutor {

	@Override
	public void create(Author author) {

		try {
			String content = author.toString();
			File file = new File("src/main/resources/authors.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.newLine();
			bw.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void read() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean update(Author autor) {
		boolean actualizado = false;
		File directorio = new File("\\src\\main\\resources\\");
		File archivo = new File(directorio, "authors.txt");
		if (directorio.exists()) {
			try {
			if (archivo.exists()) {
				BufferedReader lector;
					lector = new BufferedReader(new FileReader(archivo));
					String identificador;
					while ((identificador = lector.readLine()) != null) {
						StringTokenizer token = new StringTokenizer(identificador, ",");
						if (token.hasMoreTokens()) {
							if (token.nextToken().equals(String.valueOf(autor.getId()))) {
								identificador = identificador.replace(identificador, autor.toString());
								actualizado = true;
							} else {
								identificador = lector.readLine();
							}
						}
					}
					lector.close();
				} 
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return actualizado;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
