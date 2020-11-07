package de.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.confuse.CustomFile;
import de.confuse.FileManager;
import de.example.customFiles.TestFile;

public class Main {

	// When not using an Instance you have to make the File/CustomFile 'public
	// static'
	public static Main instance;

	private static FileManager fileManager;
	
	// Arrays for directories and Customfiles, there might be better ways out there but I can't think of any at 3am lol.
	List<File> directories = new ArrayList<File>();
	List<CustomFile> cFiles = new ArrayList<CustomFile>();

	public static void main(String[] args)
	{
		new Main();
	}

	public Main()
	{
		instance = this;

		// Creating a new FileManager
		fileManager = new FileManager();

		// Creating directories
		File dir1 = new File("Test");
		File dir2 = new File(dir1.getAbsolutePath() + "\\Config");
		directories.add(dir1);
		directories.add(dir2);
		fileManager.addDirectorys(directories);
		
		// Don't use the same File over and over like I do here, I was a bit lazy :)
		CustomFile file1 = new TestFile("File1", dir1.getAbsolutePath() + "\\", true);
		CustomFile file2 = new TestFile("Config", dir2.getAbsolutePath() + "\\", true);
		CustomFile file3 = new TestFile("vickwaporup", dir2.getAbsolutePath() + "\\", true);
		cFiles.add(file1);
		cFiles.add(file2);
		cFiles.add(file3);
		fileManager.addFiles(file1, file2, file3);

		// Example of how a Config System might look like
		new PseudoCommandSave();
		new PseudoCommandLoad("yeet");
	}

	public static FileManager getFileManager()
	{
		return fileManager;
	}

	public static void setFileManager(FileManager fileManager)
	{
		Main.fileManager = fileManager;
	}

}
