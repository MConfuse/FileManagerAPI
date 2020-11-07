package de.confuse;

import java.io.File;
import java.io.IOException;

/**
 * CustomFiles for easy File handling.
 * 
 * @version 1.0
 * @author Confuse/xXConfusedJenni#5117
 *
 */
public abstract class CustomFile {

	private final File file;
	private final String name;
	private boolean load;

	public CustomFile(final String name, final String filePath, final boolean loadOnStart)
	{
		this.name = name;
		this.load = loadOnStart;

		file = new File(filePath, name + FileManager.fileType);

		if (!file.exists())
		{
			try
			{
				saveFile();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}
		else if (load)
		{
			try
			{
				loadFile();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}

	}

	public final File getFile()
	{
		return this.file;
	}

	public final String getName()
	{
		return this.name;
	}

	public abstract void loadFile() throws IOException;

	public abstract void saveFile() throws IOException;
}
