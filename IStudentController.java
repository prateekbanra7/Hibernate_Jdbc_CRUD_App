package in.abc.controller;

import in.abc.model.Student;

public interface IStudentController {

	String save(Student student);// Creating a record

	Student findById(Integer sid);// Reading a record

	String updateById(Student student);// updating a record

	String deleteById(Integer sid);// deleting a record
}
