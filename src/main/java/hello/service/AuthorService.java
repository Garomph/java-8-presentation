package hello.service;

import hello.model.Author;
import hello.model.Book;

import java.util.List;
import java.util.Map;

public interface AuthorService {

		/**
		 * Return list of authors of all books stored.
		 *
		 * @return list
		 */
		List<Author> getAuthors();

		/**
		 * Return list of tostring.
		 *
		 * @return list
		 */
		List<String> getAuthorsToString();

		/**
		 * get all book for author.
		 *
		 * @return Map
		 */
		Map<Author, List<Book>> getAuthorsAndBook();

		/**
		 * Return a list of author who sold more than soldUnit.
		 *
		 * @param soldUnit
		 * @return list
		 */
		List<Author> getAuthorSoldMore(int soldUnit);
}
