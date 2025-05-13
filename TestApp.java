package in.abc.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import in.abc.controller.IStudentController;
import in.abc.factory.StudentControllerFactory;
import in.abc.model.Student;
import in.abc.util.HibernateUtil;

public class TestApp {
	
	static {
		HibernateUtil.startUp();
	}

	public static void main(String[] args) {
		IStudentController studentController = null;
		String status = null, name = null, city = null, email = null, country = null;
		Integer id = null;
		Student studentRecord = null;
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.print("Your Option ::[1,2,3,4,5]:: ");
				Integer option = Integer.parseInt(br.readLine());

				studentController = StudentControllerFactory.getStudentController();

				switch (option) {
				case 1:
					System.out.print("Enter the name::");
					name = br.readLine();

					System.out.print("Enter the city::");
					city = br.readLine();

					System.out.print("Enter the email::");
					email = br.readLine();

					System.out.print("Enter the country::");
					country = br.readLine();

					Student student = new Student();
					student.setName(name);
					student.setCity(city);
					student.setEmail(email);
					student.setCountry(country);

					status = studentController.save(student);
					if (status.equalsIgnoreCase("success")) {
						System.out.println("Record inserted successfully...");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record insertion failed...");
					} else {
						System.out.println("Some problem occured...");
					}
					break;
				case 2:
					System.out.print("Enter the id::");
					id = Integer.parseInt(br.readLine());

					studentRecord = studentController.findById(id);
					if (studentRecord != null)
						System.out.println(studentRecord);
					else
						System.out.println("Record not available for given id ::" + id);
					break;
				case 3:
					System.out.print("Enter the id of the record to be updated::");
					id = Integer.parseInt(br.readLine());

					studentRecord = studentController.findById(id);
					if (studentRecord != null) {

						studentRecord.setSid(id);

						System.out.print("StudentName :: [Old Name is :: " + studentRecord.getName() + "]: ");
						String newName = br.readLine();

						if (newName == null || newName.equals("")) {
							studentRecord.setName(studentRecord.getName());
						} else {
							studentRecord.setName(newName);
						}

						System.out.print("StudentEmail :: [Old Email is :: " + studentRecord.getEmail() + "]: ");
						String newEmail = br.readLine();

						if (newEmail == null || newEmail.equals("")) {
							studentRecord.setEmail(studentRecord.getEmail());
						} else {
							studentRecord.setEmail(newEmail);
						}

						System.out.print("StudentCity :: [Old City is :: " + studentRecord.getCity() + "]: ");
						String newCity = br.readLine();

						if (newCity == null || newCity.equals("")) {
							studentRecord.setCity(studentRecord.getCity());
						} else {
							studentRecord.setCity(newCity);
						}

						System.out.print("StudentCountry :: [Old Country is :: " + studentRecord.getCountry() + "]: ");
						String newCountry = br.readLine();

						if (newCountry == null || newCountry.equals("")) {
							studentRecord.setCountry(studentRecord.getCountry());
						} else {
							studentRecord.setCountry(newCountry);
						}
						System.out.println(studentRecord);
						status = studentController.updateById(studentRecord);
						if (status.equalsIgnoreCase("success")) {
							System.out.println("Record updated successfully...");
						} else if (status.equalsIgnoreCase("failure")) {
							System.out.println("Record updation failed...");
						} else {
							System.out.println("Some problem occured...");
						}
					} else {
						System.out.println("Record not available for the given id" + id);
					}
					break;
				case 4:
					System.out.print("Enter the id::");
					id = Integer.parseInt(br.readLine());
					status = studentController.deleteById(id);

					if (status.equalsIgnoreCase("success")) {
						System.out.println("Record deleted successfully...");
					} else if (status.equalsIgnoreCase("failure")) {
						System.out.println("Record deletion failed...");
					} else {
						System.out.println("Record not available for the given id to delete...");
					}
					break;
				case 5:
					System.out.println("Thanks for using the application");
					System.exit(0);
					break;

				default:
					System.out.println("Plz enter the option like 1,2,3,4,5 for operation");
					break;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
