package hello.dao;

import hello.model.Author;
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
		private List<Book> booksStored = new ArrayList<>();

		/**
		 * Name of the file containing the data
		 */
		private static final String FILE_NAME = "book.o";

		/**
		 * get all the books stored.
		 *
		 * @return the list of books
		 */
		private List<Book> getBooks() {
				if (booksStored.isEmpty()) {
						booksStored = readFile();
				}
				return booksStored;
		}

		@Override
		public final List<Book> selectAll() {
				return getBooks();
		}

		@Override
		public final Book select(final Book criteria) {
				for (Book book : getBooks()) {
						if (book.getName().equals(criteria.getName())) {
								return book;
						}
				}
				return null;
		}

		@Override
		public final void delete(final Book criteria) {
				List<Book> books = getBooks();
				books.remove(criteria);
				saveElements(books);
		}

		@Override
		public final void modify(final Book element) {
				List<Book> books = getBooks();

				saveElements(books);
		}

		@Override
		public final void insert(final Book element) {
				List<Book> books = getBooks();
				books.add(element);
				saveElements(books);
		}

		/**
		 * Return a set of Data
		 *
		 * @return
		 */
		@Override
		protected final List<Book> createData() {
				Author author1 = new Author("Charles", "Dickens");
				Author author2 = new Author("J. R. R.", "Tolkien");
				Author author3 = new Author("Antoine", "de Saint-Exupéry");
				Author author4 = new Author("J. K.", "Rowling");
				Author author5 = new Author("Lewis", "Carroll");
				Author author6 = new Author("Cao", "Xueqin");
				Author author7 = new Author("Agatha", "Christie");
				Author author8 = new Author("C. S.", "Lewis");
				Author author9 = new Author("H.", "Rider Haggard");

				List<Book> books = new ArrayList<>();

				books.add(new Book("A Tale of Two Cities", author1, 200000000));
				books.add(new Book("The Lord of the Rings", author2, 150000000));
				books.add(new Book("The Little Prince", author3, 140000000));
				books.add(new Book("Harry Potter and the Philosopher's Stone", author4, 120000000));
				books.add(new Book("The Hobbit", author2, 100000000));
				books.add(new Book("Alice's Adventures in Wonderland", author5, 100000000));
				books.add(new Book("Dream of the Red Chamber", author6, 100000000));
				books.add(new Book("And Then There Were None", author7, 100000000));
				books.add(new Book("The Lion, the Witch and the Wardrobe", author8, 85000000));
				books.add(new Book("She: A History of Adventure", author9, 83000000));

				return books;
		}

		@Override
		protected final String getFileName() {
				return FILE_NAME;
		}




}
