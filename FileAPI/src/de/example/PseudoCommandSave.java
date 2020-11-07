package de.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import de.confuse.FileManager;

public class PseudoCommandSave {

	private FileManager fileManager = Main.getFileManager();
	
	// Simulating a Config chat command or something here
	public PseudoCommandSave()
	{
		try
		{
			// Here we're using the
			// 'Main.getFileManager().createTempFile(Main.instance.dir2.getAbsolutePath(),
			// "yeet")' method to create a new File in the directory with the name "config",
			// the Files name is "yeet"
			PrintWriter var1 = new PrintWriter(new FileWriter(fileManager
					.createTempFile(fileManager.getDirectory("config").getAbsolutePath(), "yeet")));

			var1.println("Yikes");
			var1.close();

			System.out.println("Pseudo Command finished!");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
