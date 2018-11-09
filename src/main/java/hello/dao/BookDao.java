package hello.dao;

import hello.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * FileDao for Book.
 */
@Repository
public class BookDao extends AbstractFileDao<Book> {

		/**
		 * contains all books.
		 */
		private List<Book> books = new ArrayList<>();

		@Override public final List<Book> selectAll() {
				if (books.isEmpty()) {
						books = readFile();
				}
				return books;
		}

		@Override
		public final Book select(final Book criteria) {
				for (Book book : books) {
						if (book.getName().equals(criteria.getName())) {
								return book;
						}
				}
				return null;
		}

		@Override
		public final void delete(final Book criteria) {

				books.remove(criteria);
				saveElements(books);
		}

		@Override
		public final void modify(final Book element) {

				saveElements(books);
		}
}
