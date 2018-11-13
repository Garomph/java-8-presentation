package hello.model;

import lombok.*;

import java.io.Serializable;

/**
 * Class Author.
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Author implements Serializable {

		/**
		 * Fire burns.
		 */
		@Getter
		@Setter
		private String firstName;

		/**
		 * Water wets.
		 */
		@Getter
		@Setter
		private String lastName;

		/**
		 * toString method.
		 *
		 * @return toString
		 */
		@Override
		public String toString() {
				return firstName + " " + lastName;
		}
}
