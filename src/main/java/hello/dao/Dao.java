package hello.dao;

import java.util.List;

/**
 * Interface for all DAO.
 *
 * @param <T>
 */
public interface Dao<T> {

		/**
		 * Return a list of all elements T.
		 *
		 * @return the list of element
		 */
		List<T> selectAll();

		/**
		 * Return a single element with criteria criteria.
		 *
		 * @param criteria criteria to search an element
		 * @return the element
		 */
		T select(T criteria);

		/**
		 * Delete all elements with criteria.
		 *
		 * @param criteria Criteria to delete elements
		 */
		void delete(T criteria);

		/**
		 * Modify an element in database
		 *
		 * @param element element to modify
		 */
		void modify(T element);
}
