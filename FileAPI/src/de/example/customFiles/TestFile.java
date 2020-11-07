package de.example.customFiles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import de.confuse.CustomFile;

public class TestFile extends CustomFile {

	// You can also remove the Arguments here and do that in the 'super', I just
	// like seeing it in the Main.
	public TestFile(String name, String filePath, boolean loadOnStart)
	{
		super(name, filePath, loadOnStart);
	}

	@Override
	public void loadFile() throws IOException // Gets called when loading is happening
	{

	}

	@Override
	public void saveFile() throws IOException // Gets called when saving is happening
	{
		// Just a small example of how it works
		PrintWriter var1 = new PrintWriter(new FileWriter(this.getFile()));
		var1.println("Sike!");
		var1.close();

		System.out.println("File saved");
	}

}
