package in.abc.factory;

import in.abc.controller.IStudentController;
import in.abc.controller.StudentControllerImpl;

public class StudentControllerFactory {
	
	private static IStudentController studentController = null;

	private StudentControllerFactory() {
		
	}
	
	public static IStudentController getStudentController() {
		
		if (studentController == null) 
		    studentController = new StudentControllerImpl();
		
		return studentController;
	}
}
