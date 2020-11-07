package de.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import de.confuse.FileManager;

public class PseudoCommandLoad {

	private FileManager fileManager = Main.getFileManager();

	public PseudoCommandLoad(String name)
	{
		try
		{
			// This List now contains every File in the targeted Folder, from here you can
			// Iterate over the List and search for the File you need
			List<File> fileFolder = fileManager.getFiles(fileManager.getDirectory("config").getAbsolutePath());

			// This List only contains the Files of the target folder, which contain the
			// Search queue (Here the String name). The List should be sorted by matching
			// percentage.
			List<File> fileContainsName = fileManager.getFiles(fileManager.getDirectory("config").getAbsolutePath(),
					name);

			// Retrieves a File completely matching the (In this case) String name. Prone to
			// throw errors.
			File fileSpecific = fileManager.getFile(fileManager.getDirectory("config").getAbsolutePath(), name);

			String line;
			BufferedReader var1 = new BufferedReader(new FileReader(fileSpecific));

			while ((line = var1.readLine()) != null)
			{
				System.out.println("File contains: " + line);
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
