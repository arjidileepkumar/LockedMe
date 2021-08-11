package com.lockedme;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMe {
	// creating a folder path
	static final String folderpath="G:\\My project phase 1\\LockedMeFiles";
	
	// main menu calling for other methods
	public static void main(String[] args) 
	{
		int proceed=1;
		//do while looping for menu display reapetly 
		do
		{
	
		//variable declaration
		 int d;
		 
		 //Display Menu 
		d= displayMenu();
		
		
		// switch case to calling the methods
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
	
		//variable declaration
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

/**
 * calling the get files into main method
 */
public static void getAllFiles()
{
	//Get files names
	 List<String> fileNames = FileManager.getAllFiles(folderpath);
     
     for(String f:fileNames)
     System.out.println(f);
}

/**
 * calling adding files into main method
 */
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

/**
 * deleting method added to main method
 */
public static void deleteFile()

{
	//variable declaration
			String fileName;
			Scanner s = new Scanner(System.in);
			
			//Read File name from the user
			System.out.println("enter file name:");
			fileName = s.nextLine();
			
			//deleting the file
			boolean isDeleted = FileManager.deleteFile(folderpath, fileName);
			if (isDeleted)
				System.out.println("File sucessfully deleted");
			else
				System.out.println("File is not their");
			 //s.close();
	
}


/**
 * searching method added to main method
 */
public static void searchingFiles()

{
	//Variable declaration
	String fileName;
	Scanner s = new Scanner(System.in);
	
	//Read file name from the user
	System.out.println("enter file name to be search:");
	fileName = s.nextLine();
	
	//searching the File
	boolean isSearched = FileManager.searcFile(folderpath, fileName);
	if (isSearched)
		System.out.println("File is present in the folder");
	else
		System.out.println("File is not present in the folder");
	 //s.close();
	
}
}
