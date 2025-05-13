package in.abc.factory;

import in.abc.dao.IStudentDao;
import in.abc.dao.StudentDaoImpl;

public class StudentDaoFactory {

	private static IStudentDao studentDao = null;

	private StudentDaoFactory() {

	}

	public static IStudentDao getStudentDao() {
		if (studentDao == null)
			studentDao = new StudentDaoImpl();
		return studentDao;
	}
}
