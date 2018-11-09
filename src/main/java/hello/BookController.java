package hello;

import hello.model.Book;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller pour la ressource Book.
 */
@RestController @RequestMapping("book") public class BookController {

		@RequestMapping("/") public Book greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
				return new Book("Test", "Test", 2019);
		}
}
