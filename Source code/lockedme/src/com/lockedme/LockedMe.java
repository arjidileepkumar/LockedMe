package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMe {
	static final String folderpath="G:\\My project phase 1\\LockedMeFiles";
	
	public static void main(String[] args) 
	{
		int proceed=1;
		do
		{
	
		//variable declaration
		
		 int d;
		 
		 //Display Menu 
		d= displayMenu();
		
		
		
		 switch(d)
		 {
		 case 1 : getAllFiles();
		 			break;
		 case 2 : addFiles();
		 			break;
		 case 3 : deleteFile();
		 			break;
		 case 4 : searchingFiles();
		 			break;
		 case 5 : System.exit(0);
		 			break;
		 default : System.out.println("Invalid option");
		 				break;
		              
		 }
		 
	}while(proceed>0);
		
}
	
	
public static int displayMenu()
	{
	
	    Scanner s = new Scanner(System.in);
	    int d;
		//Menu
		System.out.println("================================================");
		System.out.println("\t\tcompanyLockerpvt.Ltd");
		System.out.println("================================================");
		System.out.println("1.Display all files");
		System.out.println("2.add new files");
		System.out.println("3.Delete a file");
		System.out.println("4.Search a file");
		System.out.println("5. Exit");
		System.out.println("=================================================");
		
		 System.out.println("Enter your choice:");
		d= Integer.parseInt(s.nextLine());
		return d;
		
	}
public static void getAllFiles()
{
	//Get files names
	 List<String> fileNames = FileManager.getAllFiles(folderpath);
     
     for(String f:fileNames)
     System.out.println(f);
}
public static void addFiles()
{
	//Adding files
	//Variable declaration
			Scanner s = new Scanner(System.in);
			String fileName;
			int linesCount;
			List<String> content = new ArrayList<String>();
			
			//Read file name from user
			System.out.println("enter file name");
			fileName =s.nextLine();
			
			//Read number of lines from user
			
			System.out.println("enter how many lines in the file:");
			linesCount = Integer.parseInt(s.nextLine());
			
			//Read Lines from user
			for (var i=1;i<=linesCount;i++)
			{
				System.out.println("enter line"+i+":");
				content.add(s.nextLine());
			}
			//save the content into the file
			boolean isSaved = FileManager.addFiles(folderpath, fileName, content);
			
			if (isSaved)
				System.out.println("file and data saved sucessfully");
			else
				System.out.println("some error occured. please contact dileep");
			
			//s.close();
	
}
public static void deleteFile()

{
	//code for deleting file
			String fileName;
			Scanner s = new Scanner(System.in);
			System.out.println("enter file name:");
			fileName = s.nextLine();
			
			boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
			if (isDeleted)
				System.out.println("File sucessfully deleted");
			else
				System.out.println("File is not their");
			 //s.close();
	
}
public static void searchingFiles()

{
	//code for search file
	String fileName;
	Scanner s = new Scanner(System.in);
	System.out.println("enter file name to be search:");
	fileName = s.nextLine();
	
	boolean isSearched = FileManager.deleteFile(folderpath, fileName);
	if (isSearched)
		System.out.println("File is present in the folder");
	else
		System.out.println("File is not present in the folder");
	 //s.close();
	
}
}
