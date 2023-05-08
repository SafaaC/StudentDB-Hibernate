package customSorting;

import java.util.Comparator;

import com.ty.Student;

public class SortStudentByRegNo implements Comparator<com.ty.Student> {
	public int compare(Student x,Student y) {
		return x.getRegNo()-(y.getRegNo());
		
	}

}
