package hello.service;

import hello.model.Author;
import hello.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service author.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

		/**
		 * If I was bald, I will not wash my hair.
		 */
		@Autowired private BookService bookService;

		/**
		 * Get the loist of author from the list of books stored.
		 *
		 * @return
		 */
		@Override
		public List<Author> getAuthors() {
				return bookService.getPageBooks(10, 1)
				                  .stream()
				                  .map(Book::getAuthor)
				                  .distinct()
				                  .collect(Collectors.toList());
		}

		/**
		 * Return list of tostring.
		 *
		 * @return
		 */
		@Override
		public List<String> getAuthorsToString() {
				return getAuthors().stream()
				                   .map(Author::toString)
				                   .collect(Collectors.toList());
		}

		@Override
		public final Map<Author, List<Book>> getAuthorsAndBook() {
				return bookService.getPageBooks(10, 1)
				                  .stream()
				                  .collect(Collectors.groupingBy(Book::getAuthor));
		}

		/**
		 * Return a list of author who sold more than soldUnit.
		 *
		 * @param soldUnit
		 * @return list
		 */
		@Override
		public List<Author> getAuthorSoldMore(int soldUnit) {
				Map<Author, Integer> authorsAndSoldUnit = bookService.getPageBooks(10, 1)
				                                                     .stream()
				                                                     .collect(Collectors.toMap(Book::getAuthor, Book::getSold, (oldValue, newValue) -> oldValue + newValue));

				return authorsAndSoldUnit.entrySet()
				                         .stream()
				                         .filter(entry -> entry.getValue() >= soldUnit)
				                         .map(Map.Entry::getKey)
				                         .collect(Collectors.toList());
		}
}
