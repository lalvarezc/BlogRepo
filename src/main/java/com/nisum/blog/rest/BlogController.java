package com.nisum.blog.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.blog.model.News;
import com.nisum.blog.service.INewsService;

@RestController
@RequestMapping("/api")
public class BlogController {

	
	@Autowired
	private INewsService newsService;
	
	@RequestMapping(value="/create",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public News  create(@RequestBody News  news){
		
		System.out.println("create....................");
		News  noticia=	 newsService.create(news);		
		return noticia;
		
	}
	
}
