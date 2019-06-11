package test.sql2o.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {

	private int studentId;
	private String firstName;
	private String lastName;
}
