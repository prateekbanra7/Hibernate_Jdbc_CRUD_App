package in.abc.factory;

import in.abc.service.IStudentService;
import in.abc.service.StudentServiceImpl;

public class StudentServiceFactory {
	
	private static IStudentService studentServiceImpl;

	private StudentServiceFactory() {
		
	}
	
	public static IStudentService getStudentService() {
		
		if (studentServiceImpl == null) 
		  studentServiceImpl = new StudentServiceImpl();
		  
		  return studentServiceImpl;
	}
}
