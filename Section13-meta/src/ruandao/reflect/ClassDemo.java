package ruandao.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

public class ClassDemo {

	public static void main(String[] args) 
			throws Exception{
		Student s = new Student();
		
		// s.name = "Jack";
		
		// Field: �ֶΣ����ݳ�Ա��������
		// Attribut�� ����
		// Property: ���ԣ���ȡ����д��������ȡ��  setName getName
		Class studentClass = Student.class;
		// Class.forName("Student");
		// Student studentObject = new Student();
		// Class typeInfo = studentObject.getClass();
		
		// s.name = "Jack";
		Field nameField = studentClass.getDeclaredField("name");
		nameField.setAccessible(true);
		nameField.set(s, "Jack");
		
		Field ageField = studentClass.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.set(s, 20);
		
		System.out.println(s.toString());
		
		
		// int score = s.score("yuwen");
		Method scoreMethod = studentClass.getMethod("score",String.class);
		int score = (Integer) scoreMethod.invoke(s,"yuwen");
		
		System.out.println("score is " + score);
		
		Student[] students = new Student[10];
	}

}
