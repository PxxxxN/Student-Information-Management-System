package com.pxn.sims.resource;

import java.util.ArrayList;
import java.util.List;

import com.pxn.sims.entity.Student;

public class DatabaseUtils {
	private static final List<Student> STUDENTS = create();

    public static List<Student> create() {
    	//只有将信息添加到集合中，名次才有依据，所以在初始赋值时，统一赋为9999
    	//在add后再对名次重新赋值
        Student s1 = new Student("2018214111","赵阳阳","男",89.0,84.0,92.0,85.0,86.0,87.2,436.0,9999);
        Student s2 = new Student("2018214222","邵鹏","男",76.0,87.0,69.0,83.0,79.0,78.8,394.0,9999);
        Student s3 = new Student("2018214333","高学斌","男",61.0,87.0,62.0,75.0,81.0,73.2,366.0,9999);
        Student s4 = new Student("2018224555","张扬","女",91.0,89.0,95.0,94.0,90.0,91.8,459.0,9999);
        Student s5 = new Student("2018224666","乔一","女",87.0,82.0,86.0,81.0,89.0,85.0,425.0,9999);
        Student s6 = new Student("2018224777","孔二","女",79.0,77.0,87.0,92.0,80.0,83.0,415.0,9999);

        List<Student> students = new ArrayList<>();
        students.add(s1); students.add(s2);
        students.add(s3); students.add(s4);
        students.add(s5); students.add(s6);
        Rank(students);
        return students;
    }
    
    public static List<Student> getStudents() {
        return STUDENTS;
    }
    //冒泡排序
    public static void Rank(List<Student> students) {
    	for (int i = 0; i <  students.size(); ++i) {
            for (int j = 0; j < students.size() - i -1; j++) {
                if (students.get(j).getSum() < students.get(j+1).getSum()) {
                    Student temp = students.get(j);
                    students.set(j,students.get(j+1));
                    students.set(j+1,temp);
                }
            }
            int rank = i+1;
            Student stu = students.get(i);
            stu.setRank(rank);
        }
    }
    
}
