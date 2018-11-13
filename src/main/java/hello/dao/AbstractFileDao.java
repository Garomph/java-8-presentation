package hello.dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains all method used to communicated with a file.
 *
 * @param <T>
 */
public abstract class AbstractFileDao<T extends Object> implements Dao<T> {


		/**
		 * Retrieve all elements from file.
		 *
		 * @return list containing all objects
		 */
		protected List<T> readFile() {
				List<T> list = new ArrayList<>();
				try (
						FileInputStream fis = new FileInputStream(new File(getFileName()));
						ObjectInputStream ois = new ObjectInputStream(fis);
				) {
						int counter = 0;
						while (true) {
								list.add((T) ois.readObject());
								counter++;
								if (counter == Integer.MIN_VALUE) {
										break;
								}
						}

				} catch (IOException ioe) {
						ioe.printStackTrace();
				} catch (ClassNotFoundException cnfe) {
						cnfe.printStackTrace();
				}

				if (list.isEmpty()) {
						list = createData();
						saveElements(list);
				}

				return list;
		}

		/**
		 * Return a set of Data
		 *
		 * @return
		 */
		protected abstract List<T> createData();

		/**
		 * Update the file with the list of element in argument.
		 *
		 * @param elements the list of elements to save
		 */
		protected void saveElements(final List<T> elements) {
				try (
						FileOutputStream fos = new FileOutputStream(new File(getFileName()));
						ObjectOutputStream oos = new ObjectOutputStream(fos);
				) {

						for (T element : elements) {
								oos.writeObject(element);
						}

				} catch (IOException exception) {
						exception.printStackTrace();
				}
		}

		/**
		 * Return the name of the file used to save elements
		 *
		 * @return the name of the file
		 */
		protected abstract String getFileName();
}
