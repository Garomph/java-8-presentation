package hello.controller;

import hello.model.Book;
import hello.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller pour la ressource Book.
 */
@RestController
@RequestMapping("books")
public class BookController {

		/**
		 * Fish swims.
		 */
		@Autowired private BookService bookService;

		/**
		 * Main method.
		 *
		 * @param distinct filter duplicate entry
		 * @param element  number of element to display
		 * @param page     page number
		 * @return
		 */
		@RequestMapping("/")
		public List<Book> book(
				@RequestParam(value = "distinct", defaultValue = "false")
				final boolean distinct,
				@RequestParam(value = "number", defaultValue = "10")
				final Integer element,
				@RequestParam(value = "page", defaultValue = "1")
				final Integer page) {
				if (distinct) {
						return bookService.getDistinctBooks();
				}

				return bookService.getPageBooks(element, page);

		}
}
