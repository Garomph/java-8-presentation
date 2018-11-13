package hello.controller;

import hello.model.Author;
import hello.model.Book;
import hello.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Controller pour la ressource Author.
 */
@RestController
@RequestMapping("authors")
public class AuthorController {

		/**
		 *
		 */
		@Autowired private AuthorService authorService;

		@RequestMapping("/")
		public List<Author> author(
				@RequestParam(value = "unit")
				final Integer unitSold) {
				if (unitSold != null) {
						return authorService.getAuthorSoldMore(unitSold);
				}
				return authorService.getAuthors();
		}

		@RequestMapping("/string")
		public List<String> authorString() {
				return authorService.getAuthorsToString();
		}

		@RequestMapping("/books")
		public Map<Author, List<Book>> authorAndBook() {
				return authorService.getAuthorsAndBook();
		}
}
