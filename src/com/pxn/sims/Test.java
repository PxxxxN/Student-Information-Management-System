package com.pxn.sims;

import java.io.*;
import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

import com.pxn.sims.entity.Student;
import com.pxn.sims.resource.DatabaseUtils;

enum ssex {
	男,女
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
		//进入菜单时，给名次重新赋值
		DatabaseUtils.Rank(students);
        System.out.println("***************************************");
        System.out.println("        ___                  _ _ \r\n" + 
        		"       | . \\__  __  __  __  | \\ |\r\n" + 
        		"       |  _/\\ \\/\\ \\/\\ \\/\\ \\/|   |\r\n" + 
        		"       |_|  /\\_\\/\\_\\/\\_\\/\\_\\|_\\_|\r\n");
        System.out.println("***********   学生信息管理系统      ***********\n");
        System.out.println("***************************************");                
        System.out.println("               0.增加学生信息    	           ");
        System.out.println("               1.修改学生信息          	       ");
        System.out.println("               2.显示学生信息           	   	   ");
        System.out.println("               3.查询学生信息            	   	   ");
        System.out.println("               4.删除学生信息            	  	   ");    
        System.out.println("               5.对学生信息进行排序             	   ");
        System.out.println("               6.保存学生信息至记录文件              ");
        System.out.println("               7.从记录文件读取学生信息              ");
        System.out.println("               8.新建学生信息文件                        ");
        System.out.println("               9.退出系统                                     ");
        System.out.println("***************************************");    
        //输入选项
        System.out.print("您要执行的操作是（0-9）：");
        int order; 
        order=in.nextInt();
        while(order < 0 || order > 9) {
            System.out.print("输入无效，请重新输入:");
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
	//增加学生信息
	public void add(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("请按照顺序依次输入：学号 姓名 性别 高数成绩 线代成绩 Java成绩 数据库成绩 计组成绩");
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
		//名次要等到信息添加到集合中参与排序来决定
		//给新增学生信息中，随便给rank赋一个整形数
		Student s = new Student(sno,sname,ssex,math,linear,java,database,construction,ave,sum,9999);
		students.add(s);
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	//修改学生信息
	public void modify(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		//个人认为，学号姓名性别属于基本信息，一旦对应不上应该仔细检查，不能随随便便加以修改
		//因而在修改信息时，设定只修改成绩，如果后续需要，再添加相应功能
		System.out.println("请输入需要修改成绩的学生学号");
		in.nextLine();
		String recent_sno = in.nextLine();
		for(int i=0;i<students.size();++i) {
			if(students.get(i).getSno().equals(recent_sno)) {
				System.out.println("1.高等数学成绩 2.线性代数成绩 3.Java成绩 4.数据库成绩 5.计算机组成原理成绩");
				System.out.print("请输入需要修改的信息编号：");
				int order = in.nextInt();
				while(order < 1 || order > 5) {
		            System.out.print("输入无效，请重新输入:");
		            order = in.nextInt();
		        }
				System.out.print("请输入新成绩：");
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
	//显示所有学生信息
	public void show(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		students.stream()
			.forEach(s -> {
				System.out.println(s.toString());
			});
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	//查找某一条或几条学生信息
	public void search(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("1.学号 2.姓名 3.名次");
		System.out.print("请输入查找标准：");
		int order = in.nextInt();
		while(order < 1 || order > 3) {
            System.out.print("输入无效，请重新输入:");
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
	//按名次查找
	private void searchRank(List<Student> students) {
		System.out.println("您可以选择的名次范围为：0-"+(students.size()-1));
		int searchrank = in.nextInt();
		if(searchrank>=0 && searchrank<students.size()) {
			for(int i=0;i<students.size();++i) {
				if(students.get(i).getRank( )== searchrank) {
					String lname = null;
					if(students.get(i).getSsex().equals("男"))
						lname = "他";
					else if(students.get(i).getSsex().equals("女"))
						lname = "她";
					System.out.println(lname+"的信息如下：");
					System.out.println(students.get(i).toString());
				}
			}
		}
		else {
			System.out.println("超出现有人数范围，请重新输入...");
			searchRank(students);
		}
		
	}
	//按姓名查找
	private void searchSname(List<Student> students) {
		int flag = 0;
		in.nextLine();
		System.out.print("请输入想要查找的学生姓名：");
		String searchsname = in.nextLine();
		for(int i=0;i<students.size();++i) {
			if(students.get(i).getSname().equals(searchsname)) {
				String lname = null;
				if(students.get(i).getSsex().equals("男"))
					lname = "他";
				else if(students.get(i).getSsex().equals("女"))
					lname = "她";
				System.out.println(lname+"的信息如下：");
				System.out.println(students.get(i).toString());
			}
			else
				flag++;
		}
		if(flag == students.size()) {
			System.out.println("未在当前学生信息表中找到匹配学生");
			System.out.println("1.查找其他姓名 2.返回主菜单 3.退出系统");
			System.out.print("您要进行的下一步操作是：");
			int order = in.nextInt();
			while(order < 0 || order > 3) {
	            System.out.print("输入无效，请重新输入:");
	            order = in.nextInt();
	        }
			switch(order) {
				case 1:searchSname(students);break;
				case 2:this.menu(students);
				case 3:exit();
			}
		}
	}
	//按学号查找
	private void searchSno(List<Student> students) {
		int flag = 0;
		in.nextLine();
		System.out.print("请输入想要查找的学生学号：");
		String searchsno = in.nextLine();
		for(int i=0;i<students.size();++i) {
			if(students.get(i).getSno().equals(searchsno)) {
				String lname = null;
				if(students.get(i).getSsex().equals("男"))
					lname = "他";
				else if(students.get(i).getSsex().equals("女"))
					lname = "她";
				System.out.println(lname+"的信息如下：");
				System.out.println(students.get(i).toString());
			}
			else
				flag++;
		}
		if(flag == students.size()) {
			System.out.println("未在当前学生信息表中找到匹配学生");
			System.out.println("1.查找其他学号 2.返回主菜单 3.退出系统");
			System.out.print("您要进行的下一步操作是：");
			int order = in.nextInt();
			while(order < 1 || order > 3) {
	            System.out.print("输入无效，请重新输入:");
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
	//删除某一条学生信息
	public void delete(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		System.out.print("请输入需要删除的学生学号：");
		in.nextLine();
		String delsno = in.nextLine();
		for(int i=0;i<students.size();++i) {
			if(students.get(i).getSno().equals(delsno)) {
				System.out.print("确认要删除该条信息吗？");
				String check = in.nextLine();
				if(check == "y" || check == "Y")
					students.remove(i);
				else if(check == "n" || check == "N") {
					System.out.println("1.继续删除该信息 2.删除其他信息 3.返回主菜单 4.退出系统");
					System.out.print("您要进行的下一步操作是：");
					int order = in.nextInt();
					while(order < 1 || order > 4) {
			            System.out.print("输入无效，请重新输入:");
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
	//排序
	public void sort(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("1.高等数学成绩 2.线性代数成绩 3.Java成绩 4.数据库成绩 5.计算机组成原理成绩 6.名次 7.学号 8.姓名");
		System.out.print("请选择排序标准：");
		int order = in.nextInt();
		if(order < 1 || order > 8) {
			System.out.print("输入无效，请重新输入:");
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
	//按高数成绩升序/降序排序
	private void sortbyMath(List<Student> students) {
		System.out.println("1.升序（从小到大） 2.降序（由大到小）");
		System.out.print("请选择排序方式：");
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
			System.out.println("请输入正确数字...");
			sortbyMath(students);
		}
	}
	//按线代成绩升序/降序排序
	private void sortbyLinear(List<Student> students) {
		System.out.println("1.升序（从小到大） 2.降序（由大到小）");
		System.out.print("请选择排序方式：");
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
			System.out.println("请输入正确数字...");
			sortbyLinear(students);
		}
	}
	//按Java成绩升序/降序排序
	private void sortbyJava(List<Student> students) {
		System.out.println("1.升序（从小到大） 2.降序（由大到小）");
		System.out.print("请选择排序方式：");
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
			System.out.println("请输入正确数字...");
			sortbyJava(students);
		}
	}
	//按数据库成绩升序/降序排序
	private void sortbyDB(List<Student> students) {
		System.out.println("1.升序（从小到大） 2.降序（由大到小）");
		System.out.print("请选择排序方式：");
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
			System.out.println("请输入正确数字...");
			sortbyDB(students);
		}
	}
	//按计组成绩升序/降序排序
	private void sortbyCon(List<Student> students) {
		System.out.println("1.升序（从小到大） 2.降序（由大到小）");
		System.out.print("请选择排序方式：");
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
			System.out.println("请输入正确数字...");
			sortbyCon(students);
		}
	}
	//按学号升序/降序排序
	private void sortbySno(List<Student> students) {
		System.out.println("1.升序（从小到大） 2.降序（由大到小）");
		System.out.print("请选择排序方式：");
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
			System.out.println("请输入正确数字...");
			sortbySno(students);
		}
	}
	//按名次升序/降序排序
	private void sortbySum(List<Student> students) {
		System.out.println("1.升序（从小到大） 2.降序（由大到小）");
		System.out.print("请选择排序方式：");
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
			System.out.println("请输入正确数字...");
			sortbySum(students);
		}
	}
	//按姓名A-Z/Z-A排序
	private void sortbySname(List<Student> students) {
		System.out.println("1.升序（A-Z） 2.降序（Z-A）");
		System.out.print("请选择排序方式：");
		int way = in.nextInt();
		if(way == 1) {
			Comparator<Object> comparator = Collator.getInstance(Locale.CHINA);
	        // 排序实现
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
			System.out.println("请输入正确数字...");
			sortbySname(students);
		}
	}

	//提前指定路径创建新文件
	private void newfile(List<Student> students) {
		//D:/SIMS/
		System.out.println("-----------------------------------------------------------------");
		System.out.println("请输入新文件名称（文件名.txt）：");
		String filename = "D:/SIMS/"+in.next();
		File file = new File(filename);
		if(!file.exists()){
			//先得到文件的上级目录，并创建上级目录，在创建文件
			file.getParentFile().mkdir();
			try {
				//创建文件
				file.createNewFile();
				System.out.println("创建成功！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	//在写入文件时，如果没有该路径，直接创建一个
	private void newfile() {
		//D:/SIMS/
		System.out.println("请输入新文件名称（文件名.txt）：");
		String filename = "D:/SIMS/"+in.next();
		File file = new File(filename);
		if(!file.exists()){
			//先得到文件的上级目录，并创建上级目录，在创建文件
			file.getParentFile().mkdir();
			try {
				//创建文件
				file.createNewFile();
				System.out.println("创建成功！");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//保存信息，附加到指定路径下的文件上
	private void save(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		//D:/SIMS/
		System.out.println("将学生信息保存至（文件名.txt）：");
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
			fw = new FileWriter(fileName, true);//加true
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
	//读取文件内容
	private void read(List<Student> students) {
		System.out.println("-----------------------------------------------------------------");
		try {			
			System.out.print("请输入读取文件名称（文件名.txt）：");
			String filename = "D:/SIMS/"+in.next();
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filename));
			byte[] b = new byte[bis.available()];
			bis.read(b);
			System.out.println(new String(b));
			bis.close();
		} catch (FileNotFoundException e) {			
			// TODO Auto-generated catch block			
			//系统强制解决的问题：文件没有找到			
			e.printStackTrace();		
		} catch (IOException e) {			
			//文件读写异常			
			// TODO Auto-generated catch block			
			e.printStackTrace();		
		}
		System.out.println("-----------------------------------------------------------------");
		this.menu(students);
	}
	//退出系统
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
