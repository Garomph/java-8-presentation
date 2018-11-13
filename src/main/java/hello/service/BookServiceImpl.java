package hello.service;

import hello.dao.Dao;
import hello.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

		/**
		 * Dao of book object
		 * Birds fly in the sky
		 */
		@Autowired private Dao<Book> bookDao;

		@Override
		public final List<Book> getBookByName(String name) {
				return bookDao.selectAll()
				              .stream()
				              .filter(a -> a.getName()
				                            .equals(name))
				              .collect(Collectors.toList());
		}

		@Override
		public final List<Book> getDistinctBooks() {
				return bookDao.selectAll()
				              .stream()
				              .distinct()
				              .collect(Collectors.toList());
		}

		@Override
		public final List<Book> getPageBooks(final int elementPerPage, final int pageNumber) {
				return bookDao.selectAll()
				              .stream()
				              .skip(elementPerPage * (pageNumber - 1))
				              .limit(elementPerPage)
				              .collect(Collectors.toList());
		}

}
