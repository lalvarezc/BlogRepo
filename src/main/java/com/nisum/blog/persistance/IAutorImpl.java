package com.nisum.blog.persistance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.nisum.blog.model.Author;

public class IAutorImpl implements IAutor {
	
	@Override
	public  void create(Author author) {

			try {
				String content = author.toString();
				File file = new File("src/main/resources/authors.txt");
				if (!file.exists()) {
					file.createNewFile();
				}
				
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw =new BufferedWriter(fw);
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
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	
}
