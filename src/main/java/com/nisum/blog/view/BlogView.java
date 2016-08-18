/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.nisum.blog.view;

import com.nisum.blog.model.Author;
import com.nisum.blog.model.News;
import com.nisum.blog.persistance.INewsRepository;
import com.nisum.blog.persistance.NewsRepositoryImpl;
import com.nisum.blog.rest.BlogController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogView {

	private int flagLoad = 0;
	@Autowired
	private INewsRepository newsPersistence;

	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public ModelAndView blog() {

		System.out.println("In the blog..............");

		loadData();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("blog");
		return mav;

	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test() {

		System.out.println("In the test..............");
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Hello word!");
		mav.setViewName("test");
		return mav;

	}

	public void loadData() {

		if (flagLoad == 0) {
			flagLoad=1;

			News new1 = new News();
			new1.setTitle("Pokemon Go es el juego movil mas popular");
			new1.setContent(
					"\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, \" +\n"
							+ "                \"totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. \" +\n"
							+ "                \"Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui \" +\n"
							+ "                \"ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci \" +\n"
							+ "                \"velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. \" +\n"
							+ "                \"Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea \" +\n"
							+ "                \"commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil \" +\n"
							+ "                \"molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\"");
			new1.setAuthor(new Author("Juanito Perez", "juanito@gmail.com", 1));

			News new2 = new News();
			new2.setTitle("conoce mas sobre swift, el lenguaje de apple");
			new2.setContent(
					"\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, \" +\n"
							+ "                \"totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. \" +\n"
							+ "                \"Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui \" +\n"
							+ "                \"ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci \" +\n"
							+ "                \"velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. \" +\n"
							+ "                \"Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea \" +\n"
							+ "                \"commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil \" +\n"
							+ "                \"molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\"");
			new2.setAuthor(new Author("Diego Montaña", "diegomontana@gmail.com", 2));

			News new3 = new News();
			new3.setTitle("los programadores java son mas felices");
			new3.setContent(
					"\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, \" +\n"
							+ "                \"totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. \" +\n"
							+ "                \"Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui \" +\n"
							+ "                \"ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci \" +\n"
							+ "                \"velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. \" +\n"
							+ "                \"Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea \" +\n"
							+ "                \"commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil \" +\n"
							+ "                \"molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\"");
			new3.setAuthor(new Author("Perico Los Palotes", "perico@gmail.com", 3));

			newsPersistence.create(new1);
			newsPersistence.create(new2);
			newsPersistence.create(new3);
		}
	}

}
