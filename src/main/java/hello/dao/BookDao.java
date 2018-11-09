package hello.dao;

import hello.model.Book;

import java.util.List;

/**
 * Dao for Book.
 */
public class BookDao implements Dao<Book> {

		@Override public final List<Book> selectAll() {
				return null;
		}

		@Override public final Book select(Book criteria) {
				return null;
		}

		@Override public final void delete(Book criteria) {

		}

		@Override public final Book modify(Book element) {
				return null;
		}
}
