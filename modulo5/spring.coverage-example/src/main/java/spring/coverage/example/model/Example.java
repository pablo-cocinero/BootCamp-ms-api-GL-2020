package spring.coverage.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Example {

	private int id;
	private String name;
	private int value;
}
