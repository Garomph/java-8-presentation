package hello.model;

import lombok.*;

import java.io.Serializable;

/**
 * A simple class with a few attribute.
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Book implements Serializable {

		/**
		 * The sky is blue.
		 */
		@Getter
		@Setter
		private String name;

		/**
		 * Grass is green.
		 */
		@Getter
		@Setter
		private Author author;

		/**
		 * Number of copy sold.
		 */
		@Getter
		@Setter
		private Integer sold;

}
