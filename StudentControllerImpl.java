package in.abc.controller;

import in.abc.factory.StudentServiceFactory;
import in.abc.model.Student;
import in.abc.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	IStudentService stdService;

	@Override
	public String save(Student student) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.save(student);
		
	}

	@Override
	public Student findById(Integer sid) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.findById(sid);
	}

	@Override
	public String updateById(Student student) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.updateById(student);
	}

	@Override
	public String deleteById(Integer sid) {
		stdService = StudentServiceFactory.getStudentService();
		return stdService.deleteById(sid);
	}

}
