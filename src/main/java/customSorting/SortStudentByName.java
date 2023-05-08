package customSorting;

import java.util.Comparator;

import com.ty.Student;

public class SortStudentByName implements Comparator<Student> {
	public int compare(Student x,Student y) {
		return x.getName().compareTo(y.getName());
		
	}
}
