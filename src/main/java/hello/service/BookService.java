package hello.service;

import hello.model.Book;

import java.util.List;

/**
 * Interface used to access all method for Book
 */
public interface BookService {
		/**
		 * Get all the book filter and order by Name
		 *
		 * @param name the name of the book
		 * @return
		 */
		List<Book> getBookByName(String name);

		/**
		 * get a list of distinct element
		 */
		List<Book> getDistinctBooks();

		/**
		 * Get books for a table.
		 *
		 * @param elementPerPage number of element to display
		 * @param pageNumber     The page number
		 * @return
		 */
		List<Book> getPageBooks(int elementPerPage, int pageNumber);

}
