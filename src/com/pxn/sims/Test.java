package com.pxn.sims;

import java.io.*;
import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

import com.pxn.sims.entity.Student;
import com.pxn.sims.resource.DatabaseUtils;

enum ssex {
	��,Ů
}
public class Test {
	Scanner in=new Scanner(System.in);
	public static void main(String[] args) 
	{
		Test a=new Test();
	    a.menu(DatabaseUtils.getStudents());        
	}
	public void menu(List<Student> students)  
    {
		//����˵�ʱ�����������¸�ֵ
		DatabaseUtils.Rank(students);
        System.out.println("***************************************");
        System.out.println("        ___                  _ _ \r\n" + 
        		"       | . \\__  __  __  __  | \\ |\r\n" + 
        		"       |  _/\\ \\/\\ \\/\\ \\/\\ \\/|   |\r\n" + 
        		"       |_|  /\\_\\/\\_\\/\\_\\/\\_\\|_\\_|\r\n");
        System.out.println("***********   ѧ����Ϣ����ϵͳ      ***********\n");
        System.out.println("***************************************");                
        System.out.println("               0.����ѧ����Ϣ    	           ");
        System.out.println("               1.�޸�ѧ����Ϣ          	       ");
        System.out.println("               2.��ʾѧ����Ϣ           	   	   ");
        System.out.println("               3.��ѯѧ����Ϣ            	   	   ");
        System.out.println("               4.ɾ��ѧ����Ϣ            	  	   ");    
        System.out.println("               5.��ѧ����Ϣ��������             	   ");
        System.out.println("               6.����ѧ����Ϣ����¼�ļ�              ");
        System.out.println("               7.�Ӽ�¼�ļ���ȡѧ����Ϣ              ");
        System.out.println("               8.�½�ѧ����Ϣ�ļ�                        ");
        System.out.println("               9.�˳�ϵͳ                                     ");
        System.out.println("***************************************");    
        //����ѡ��
        System.out.print("��Ҫִ�еĲ����ǣ�0-9����");
        int order; 
        order=in.nextInt();
        while(order < 0 || order > 9) {
            System.out.print("������Ч������������:");
            order = in.nextInt();
        }    
        switch(order) {
        	case 0:add(students);break;      
        	case 1:modify(students);break;
        	case 2:show(students);break;              
        	case 3:search(students);break;
        	case 4:delete(students);break;
        	case 5:sort(students);break;
        	case 6:save(students);break;
        	case 7:read(students);break;
        	case 8:newfile(students);break;
        	case 9:exit();break; 
        	default:break;   
        }
    }
	//����ѧ����Ϣ
	public void add(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("�밴��˳���������룺ѧ�� ���� �Ա� �����ɼ� �ߴ��ɼ� Java�ɼ� ���ݿ�ɼ� ����ɼ�");
		String sno = in.next();
		String sname = in.next();
		String ssex = in.next();
		double math = in.nextDouble();
		double linear = in.nextDouble();
		double java = in.nextDouble();
		double database = in.nextDouble();
		double construction = in.nextDouble();
		double sum = math+linear+java+database+construction;
		double ave = sum/5.0;
		//����Ҫ�ȵ���Ϣ��ӵ������в�������������
		//������ѧ����Ϣ�У�����rank��һ��������
		Student s = new Student(sno,sname,ssex,math,linear,java,database,construction,ave,sum,9999);
		students.add(s);
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	//�޸�ѧ����Ϣ
	public void modify(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		//������Ϊ��ѧ�������Ա����ڻ�����Ϣ��һ����Ӧ����Ӧ����ϸ��飬��������������޸�
		//������޸���Ϣʱ���趨ֻ�޸ĳɼ������������Ҫ���������Ӧ����
		System.out.println("��������Ҫ�޸ĳɼ���ѧ��ѧ��");
		in.nextLine();
		String recent_sno = in.nextLine();
		for(int i=0;i<students.size();++i) {
			if(students.get(i).getSno().equals(recent_sno)) {
				System.out.println("1.�ߵ���ѧ�ɼ� 2.���Դ����ɼ� 3.Java�ɼ� 4.���ݿ�ɼ� 5.��������ԭ��ɼ�");
				System.out.print("��������Ҫ�޸ĵ���Ϣ��ţ�");
				int order = in.nextInt();
				while(order < 1 || order > 5) {
		            System.out.print("������Ч������������:");
		            order = in.nextInt();
		        }
				System.out.print("�������³ɼ���");
				switch(order) {
				case 1:{
					double newmathscore = in.nextDouble();
					Student newstu = new Student(students.get(i).getSno(),students.get(i).getSname(),students.get(i).getSsex(),newmathscore,students.get(i).getLinear(),students.get(i).getJava(),students.get(i).getDatabase(),students.get(i).getConstruction(),students.get(i).getAve(),students.get(i).getSum(),students.get(i).getRank());
					students.set(i, newstu);
					break;
				}
				case 2:{
					double newlinearscore = in.nextDouble();
					Student newstu = new Student(students.get(i).getSno(),students.get(i).getSname(),students.get(i).getSsex(),students.get(i).getMath(),newlinearscore,students.get(i).getJava(),students.get(i).getDatabase(),students.get(i).getConstruction(),students.get(i).getAve(),students.get(i).getSum(),students.get(i).getRank());
					students.set(i, newstu);
					break;
				}
				case 3:{
					double newjavascore = in.nextDouble();
					Student newstu = new Student(students.get(i).getSno(),students.get(i).getSname(),students.get(i).getSsex(),students.get(i).getMath(),students.get(i).getLinear(),newjavascore,students.get(i).getDatabase(),students.get(i).getConstruction(),students.get(i).getAve(),students.get(i).getSum(),students.get(i).getRank());
					students.set(i, newstu);
					break;
				}
				case 4:{
					double newdbscore = in.nextDouble();
					Student newstu = new Student(students.get(i).getSno(),students.get(i).getSname(),students.get(i).getSsex(),students.get(i).getMath(),students.get(i).getLinear(),students.get(i).getJava(),newdbscore,students.get(i).getConstruction(),students.get(i).getAve(),students.get(i).getSum(),students.get(i).getRank());
					students.set(i, newstu);
					break;
				}
				case 5:{
					double newconscore = in.nextDouble();
					Student newstu = new Student(students.get(i).getSno(),students.get(i).getSname(),students.get(i).getSsex(),students.get(i).getMath(),students.get(i).getLinear(),students.get(i).getJava(),students.get(i).getDatabase(),newconscore,students.get(i).getAve(),students.get(i).getSum(),students.get(i).getRank());
					students.set(i, newstu);
					break;
				}
				default:break;
				}
			}
		}
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	//��ʾ����ѧ����Ϣ
	public void show(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		students.stream()
			.forEach(s -> {
				System.out.println(s.toString());
			});
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	//����ĳһ������ѧ����Ϣ
	public void search(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("1.ѧ�� 2.���� 3.����");
		System.out.print("��������ұ�׼��");
		int order = in.nextInt();
		while(order < 1 || order > 3) {
            System.out.print("������Ч������������:");
            order = in.nextInt();
        }
		switch(order) {
			case 1:searchSno(students);break;
			case 2:searchSname(students);break;
			case 3:searchRank(students);break;
			default:break;
		}
		in.nextLine();
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	//�����β���
	private void searchRank(List<Student> students) {
		System.out.println("������ѡ������η�ΧΪ��0-"+(students.size()-1));
		int searchrank = in.nextInt();
		if(searchrank>=0 && searchrank<students.size()) {
			for(int i=0;i<students.size();++i) {
				if(students.get(i).getRank( )== searchrank) {
					String lname = null;
					if(students.get(i).getSsex().equals("��"))
						lname = "��";
					else if(students.get(i).getSsex().equals("Ů"))
						lname = "��";
					System.out.println(lname+"����Ϣ���£�");
					System.out.println(students.get(i).toString());
				}
			}
		}
		else {
			System.out.println("��������������Χ������������...");
			searchRank(students);
		}
		
	}
	//����������
	private void searchSname(List<Student> students) {
		int flag = 0;
		in.nextLine();
		System.out.print("��������Ҫ���ҵ�ѧ��������");
		String searchsname = in.nextLine();
		for(int i=0;i<students.size();++i) {
			if(students.get(i).getSname().equals(searchsname)) {
				String lname = null;
				if(students.get(i).getSsex().equals("��"))
					lname = "��";
				else if(students.get(i).getSsex().equals("Ů"))
					lname = "��";
				System.out.println(lname+"����Ϣ���£�");
				System.out.println(students.get(i).toString());
			}
			else
				flag++;
		}
		if(flag == students.size()) {
			System.out.println("δ�ڵ�ǰѧ����Ϣ�����ҵ�ƥ��ѧ��");
			System.out.println("1.������������ 2.�������˵� 3.�˳�ϵͳ");
			System.out.print("��Ҫ���е���һ�������ǣ�");
			int order = in.nextInt();
			while(order < 0 || order > 3) {
	            System.out.print("������Ч������������:");
	            order = in.nextInt();
	        }
			switch(order) {
				case 1:searchSname(students);break;
				case 2:this.menu(students);
				case 3:exit();
			}
		}
	}
	//��ѧ�Ų���
	private void searchSno(List<Student> students) {
		int flag = 0;
		in.nextLine();
		System.out.print("��������Ҫ���ҵ�ѧ��ѧ�ţ�");
		String searchsno = in.nextLine();
		for(int i=0;i<students.size();++i) {
			if(students.get(i).getSno().equals(searchsno)) {
				String lname = null;
				if(students.get(i).getSsex().equals("��"))
					lname = "��";
				else if(students.get(i).getSsex().equals("Ů"))
					lname = "��";
				System.out.println(lname+"����Ϣ���£�");
				System.out.println(students.get(i).toString());
			}
			else
				flag++;
		}
		if(flag == students.size()) {
			System.out.println("δ�ڵ�ǰѧ����Ϣ�����ҵ�ƥ��ѧ��");
			System.out.println("1.��������ѧ�� 2.�������˵� 3.�˳�ϵͳ");
			System.out.print("��Ҫ���е���һ�������ǣ�");
			int order = in.nextInt();
			while(order < 1 || order > 3) {
	            System.out.print("������Ч������������:");
	            order = in.nextInt();
	        }
			switch(order) {
				case 1:searchSno(students);break;
				case 2:this.menu(students);
				case 3:exit();
				default:break;
			}
		}
	}
	//ɾ��ĳһ��ѧ����Ϣ
	public void delete(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		System.out.print("��������Ҫɾ����ѧ��ѧ�ţ�");
		in.nextLine();
		String delsno = in.nextLine();
		for(int i=0;i<students.size();++i) {
			if(students.get(i).getSno().equals(delsno)) {
				System.out.print("ȷ��Ҫɾ��������Ϣ��");
				String check = in.nextLine();
				if(check == "y" || check == "Y")
					students.remove(i);
				else if(check == "n" || check == "N") {
					System.out.println("1.����ɾ������Ϣ 2.ɾ��������Ϣ 3.�������˵� 4.�˳�ϵͳ");
					System.out.print("��Ҫ���е���һ�������ǣ�");
					int order = in.nextInt();
					while(order < 1 || order > 4) {
			            System.out.print("������Ч������������:");
			            order = in.nextInt();
			        }
					switch(order) {
						case 1:students.remove(i);;break;
						case 2:delete(students);break;
						case 3:this.menu(students);
						case 4:exit();
					}
				}
			}
		}
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	//����
	public void sort(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("1.�ߵ���ѧ�ɼ� 2.���Դ����ɼ� 3.Java�ɼ� 4.���ݿ�ɼ� 5.��������ԭ��ɼ� 6.���� 7.ѧ�� 8.����");
		System.out.print("��ѡ�������׼��");
		int order = in.nextInt();
		if(order < 1 || order > 8) {
			System.out.print("������Ч������������:");
            order = in.nextInt();
		}
		switch(order) {
			case 1:sortbyMath(students);break;
			case 2:sortbyLinear(students);break;
			case 3:sortbyJava(students);break;
			case 4:sortbyDB(students);break;
			case 5:sortbyCon(students);break;
			case 6:sortbySum(students);break;
			case 7:sortbySno(students);break;
			case 8:sortbySname(students);break;
			default:break;
		}
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	//�������ɼ�����/��������
	private void sortbyMath(List<Student> students) {
		System.out.println("1.���򣨴�С���� 2.�����ɴ�С��");
		System.out.print("��ѡ������ʽ��");
		int way = in.nextInt();
		if(way == 1) {
		students.stream()
			.sorted(Comparator.comparing(Student::getMath))
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else if(way == 2) {
			students.stream()
			.sorted(Comparator.comparing(Student::getMath).reversed())
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else {
			System.out.println("��������ȷ����...");
			sortbyMath(students);
		}
	}
	//���ߴ��ɼ�����/��������
	private void sortbyLinear(List<Student> students) {
		System.out.println("1.���򣨴�С���� 2.�����ɴ�С��");
		System.out.print("��ѡ������ʽ��");
		int way = in.nextInt();
		if(way == 1) {
			students.stream()
			.sorted(Comparator.comparing(Student::getLinear))
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else if(way == 2) {
			students.stream()
			.sorted(Comparator.comparing(Student::getLinear).reversed())
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else {
			System.out.println("��������ȷ����...");
			sortbyLinear(students);
		}
	}
	//��Java�ɼ�����/��������
	private void sortbyJava(List<Student> students) {
		System.out.println("1.���򣨴�С���� 2.�����ɴ�С��");
		System.out.print("��ѡ������ʽ��");
		int way = in.nextInt();
		if(way == 1) {
			students.stream()
			.sorted(Comparator.comparing(Student::getJava))
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else if(way == 2) {
			students.stream()
			.sorted(Comparator.comparing(Student::getJava).reversed())
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else {
			System.out.println("��������ȷ����...");
			sortbyJava(students);
		}
	}
	//�����ݿ�ɼ�����/��������
	private void sortbyDB(List<Student> students) {
		System.out.println("1.���򣨴�С���� 2.�����ɴ�С��");
		System.out.print("��ѡ������ʽ��");
		int way = in.nextInt();
		if(way == 1) {
			students.stream()
			.sorted(Comparator.comparing(Student::getDatabase))
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else if(way == 2) {
			students.stream()
			.sorted(Comparator.comparing(Student::getDatabase).reversed())
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else {
			System.out.println("��������ȷ����...");
			sortbyDB(students);
		}
	}
	//������ɼ�����/��������
	private void sortbyCon(List<Student> students) {
		System.out.println("1.���򣨴�С���� 2.�����ɴ�С��");
		System.out.print("��ѡ������ʽ��");
		int way = in.nextInt();
		if(way == 1) {
			students.stream()
			.sorted(Comparator.comparing(Student::getConstruction))
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else if(way == 2) {
			students.stream()
			.sorted(Comparator.comparing(Student::getConstruction).reversed())
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else {
			System.out.println("��������ȷ����...");
			sortbyCon(students);
		}
	}
	//��ѧ������/��������
	private void sortbySno(List<Student> students) {
		System.out.println("1.���򣨴�С���� 2.�����ɴ�С��");
		System.out.print("��ѡ������ʽ��");
		int way = in.nextInt();
		if(way == 1) {
			students.stream()
			.sorted(Comparator.comparing(Student::getSno))
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else if(way == 2) {
			students.stream()
			.sorted(Comparator.comparing(Student::getSno).reversed())
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else {
			System.out.println("��������ȷ����...");
			sortbySno(students);
		}
	}
	//����������/��������
	private void sortbySum(List<Student> students) {
		System.out.println("1.���򣨴�С���� 2.�����ɴ�С��");
		System.out.print("��ѡ������ʽ��");
		int way = in.nextInt();
		if(way == 1) {
			students.stream()
			.sorted(Comparator.comparing(Student::getSum))
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else if(way == 2) {
			students.stream()
			.sorted(Comparator.comparing(Student::getSum).reversed())
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
		}
		else {
			System.out.println("��������ȷ����...");
			sortbySum(students);
		}
	}
	//������A-Z/Z-A����
	private void sortbySname(List<Student> students) {
		System.out.println("1.����A-Z�� 2.����Z-A��");
		System.out.print("��ѡ������ʽ��");
		int way = in.nextInt();
		if(way == 1) {
			Comparator<Object> comparator = Collator.getInstance(Locale.CHINA);
	        // ����ʵ��
	        Collections.sort(students, (s1, s2) -> {
	            return comparator.compare(s1.getSname(), s2.getSname());
	        });
	        students.stream().forEach(System.out::println);
	        /*
			students.stream()
			.sorted(Comparator.comparing(Student::getSname))
			.collect(Collectors.toList())
			.forEach(s -> {
				System.out.println(s.toString());
			});
			*/
		}
		else if(way == 2) {
			Comparator<Object> comparator = Collator.getInstance(Locale.CHINA);
			//students.stream()
			Collections.sort(students, (s1, s2) -> {
	            return comparator.compare(s1.getSname(), s2.getSname());
	        });
			Collections.reverse(students);;
			students.stream().forEach(System.out::println);
		}
		else {
			System.out.println("��������ȷ����...");
			sortbySname(students);
		}
	}

	//��ǰָ��·���������ļ�
	private void newfile(List<Student> students) {
		//D:/SIMS/
		System.out.println("-----------------------------------------------------------------");
		System.out.println("���������ļ����ƣ��ļ���.txt����");
		String filename = "D:/SIMS/"+in.next();
		File file = new File(filename);
		if(!file.exists()){
			//�ȵõ��ļ����ϼ�Ŀ¼���������ϼ�Ŀ¼���ڴ����ļ�
			file.getParentFile().mkdir();
			try {
				//�����ļ�
				file.createNewFile();
				System.out.println("�����ɹ���");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	//��д���ļ�ʱ�����û�и�·����ֱ�Ӵ���һ��
	private void newfile() {
		//D:/SIMS/
		System.out.println("���������ļ����ƣ��ļ���.txt����");
		String filename = "D:/SIMS/"+in.next();
		File file = new File(filename);
		if(!file.exists()){
			//�ȵõ��ļ����ϼ�Ŀ¼���������ϼ�Ŀ¼���ڴ����ļ�
			file.getParentFile().mkdir();
			try {
				//�����ļ�
				file.createNewFile();
				System.out.println("�����ɹ���");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//������Ϣ�����ӵ�ָ��·���µ��ļ���
	private void save(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		//D:/SIMS/
		System.out.println("��ѧ����Ϣ���������ļ���.txt����");
		String filename = "D:/SIMS/"+in.next();
		File file = new File(filename);
		if(!file.exists()){
			newfile();
		}
		students.stream()
			.forEach(s -> {			
				try {
					writeToFile(s.toString(),filename);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	private void writeToFile(String content,String fileName) throws IOException {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(fileName, true);//��true
			bw = new BufferedWriter(fw);
			bw.write(content);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}  
	}
	//��ȡ�ļ�����
	private void read(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		try {			
			System.out.print("�������ȡ�ļ����ƣ��ļ���.txt����");
			String filename = "D:/SIMS/"+in.next();
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));
			byte[] b = new byte[bis.available()];
			bis.read(b);
			System.out.println(new String(b));
			bis.close();
		} catch (FileNotFoundException e) {			
			// TODO Auto-generated catch block			
			//ϵͳǿ�ƽ�������⣺�ļ�û���ҵ�			
			e.printStackTrace();		
		} catch (IOException e) {			
			//�ļ���д�쳣			
			// TODO Auto-generated catch block			
			e.printStackTrace();		
		}
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	//�˳�ϵͳ
	public void exit()  
    {    
		System.out.println("********************************************");
        System.out.println("______                        _   _");
        System.out.println("| ___ \\                      | \\ | |");
        System.out.println("| |_/ /_  ____  ____  ____  _|  \\| |");
        System.out.println("|  __/\\ \\/ /\\ \\/ /\\ \\/ /\\ \\/ / . ` |");
        System.out.println("| |    >  <  >  <  >  <  >  <| |\\  |");
        System.out.println("\\_|   /_/\\_\\/_/\\_\\/_/\\_\\/_/\\_\\_| \\_/");
        System.out.println("\n");
        System.out.println("*********************************************");
        System.exit(0);
    }
 
}
