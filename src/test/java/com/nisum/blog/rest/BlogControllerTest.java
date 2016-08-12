package com.nisum.blog.rest;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.nisum.blog.model.News;
import com.nisum.blog.service.INewsService;

@RunWith(MockitoJUnitRunner.class)
public class BlogControllerTest {
	
	
	@Mock
	private INewsService  newsService;
	
	@InjectMocks
	private BlogController  blogController;
	
    @Before
    public void setUp() {


        RestAssuredMockMvc.standaloneSetup(blogController);
    }
	
    @Test
    public void checkCreateIReceiveAStatus201(){
		News noticia= new  News();
		String titulo="titulo";
		noticia.setTitle(titulo);



        given().
            contentType(ContentType.JSON).
            body(noticia).
        when().
            post("/api/create").
        then().equals(noticia);
    }

}
