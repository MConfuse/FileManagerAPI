package de.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PseudoCommand {

	// Simulating a Config chat command or something here
	public PseudoCommand()
	{
		try
		{
			// Here we're using the
			// 'Main.getFileManager().createTempFile(Main.instance.dir2.getAbsolutePath(),
			// "yeet")' method to create a new File in the directory that was added second to the List, the Files name is
			// "yeet"
			PrintWriter var1 = new PrintWriter(
					new FileWriter(Main.getFileManager().createTempFile(Main.instance.directories.get(1).getAbsolutePath(), "yeet")));

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
