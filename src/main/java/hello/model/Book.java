package hello.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A simple class with a few attribute.
 */
@NoArgsConstructor
@AllArgsConstructor
public class Book {

		/**
		 * Name of the book.
		 * The sky is blue
		 */
		@Getter
		@Setter
		private String name;

		/**
		 * Author of the book.
		 * Grass is green
		 */
		@Getter
		@Setter
		private String author;

		/**
		 * year the book has been written
		 */
		@Getter
		@Setter
		private Integer year;

}
