package hello.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A simple class with a few attribute.
 */
@NoArgsConstructor @AllArgsConstructor public class Book {

		@Getter @Setter private String name;

		@Getter @Setter private String author;

		@Getter @Setter private Integer year;

}
