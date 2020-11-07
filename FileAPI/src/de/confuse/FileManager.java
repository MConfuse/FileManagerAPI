package de.confuse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * A File Manager used to easily access and save Files!
 * 
 * @version 1.0
 * @author Confuse/xXConfusedJenni#5117
 *
 */
public class FileManager {

	public static final String fileType = ".cfg";

	// Files in here will be used to create directory's
	private List<File> directorys = new ArrayList<File>();
	// Files need to be added here to keep track of the Files
	private List<CustomFile> files = new ArrayList<CustomFile>();

	public FileManager()
	{
		System.out.println("File Manager was created!");
	}

	/**
	 * Creates directory's using the specified File paths.
	 * 
	 * @param {@link File}
	 * @see #addDirectorys(List)
	 */
	public void addDirectorys(File... files)
	{
		for (File file : files)
		{
			directorys.add(file);

			makeDirs();
		}

	}

	/**
	 * Creates directory's using the specified File paths.
	 * 
	 * @param List {@link File}
	 * @see #addDirectorys(File...)
	 */
	public void addDirectorys(List<File> files)
	{
		directorys.addAll(files);
		makeDirs();
	}

	/**
	 * Adds the Custom files to the FileManager so we can load the Files using the
	 * {@link #loadFiles()} Method. This requires the
	 * {@link #addDirectorys(File...)} method to have completed it's work or you
	 * having already created the needed directory's
	 * 
	 * @param cFiles
	 */
	public void addFiles(CustomFile... cFiles)
	{
		for (CustomFile file : cFiles)
		{
			files.add(file);
		}

	}

	/**
	 * Adds the Custom files to the FileManager so we can load the Files using the
	 * {@link #loadFiles()} Method. This requires the
	 * {@link #addDirectorys(File...)} method to have completed it's work or you
	 * having already created the needed directory's
	 * 
	 * @param cFiles
	 */
	public void addFiles(List<CustomFile> cFiles)
	{
		files.addAll(cFiles);
	}

	/**
	 * Loads all manually added Files.
	 * 
	 * @see {@link #addFiles(CustomFile...)}
	 */
	public void loadFiles()
	{
		for (CustomFile file : files)
		{
			try
			{
				file.loadFile();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}

	}

	/**
	 * Saves all the data to the previously added Files.
	 * 
	 * @see {@link #addFiles(CustomFile...)}
	 */
	public void saveFiles()
	{
		for (CustomFile file : files)
		{
			try
			{
				file.saveFile();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}

	}

	/**
	 * Returns a new File with the given path and name. Usually used for
	 * Configurations or similar Files that are created/loaded during runtime.
	 * 
	 * @param filePath
	 * @param name
	 * @return new File
	 */
	public File createTempFile(String filePath, String name)
	{
		return new File(filePath, name + fileType);
	}

	/**
	 * Returns a List containing all currently added Directories. Only works for
	 * directories added with the {@link #addDirectorys(File...)} method!
	 * 
	 * @return List {@link File}
	 */
	public List<File> getDirectories()
	{
		return directorys;
	}

	/**
	 * Returns the directory with the specific name. Only works for directories
	 * added with the {@link #addDirectorys(File...)} method!
	 * 
	 * @param name
	 * @return {@link File} | null
	 */
	public File getDirectory(String name)
	{
		for (File file : directorys)
		{
			if (file.getName().equalsIgnoreCase(name))
			{
				return file;
			}

		}

		return null;
	}
	
	/**
	 * Returns the directory with the position in the List. Only works for directories
	 * added with the {@link #addDirectorys(File...)} method!
	 * 
	 * @param index
	 * @return {@link File} | null
	 */
	public File getDirectory(int index)
	{
		return directorys.get(index);
	}

	/**
	 * Retrieves a CustomFile using the Class it's from (F. ex.: TestFile.class).
	 * Only searches the manually added Files!
	 * 
	 * @param clazz
	 * @return CustomFile | null
	 */
	public CustomFile getCustomFile(final Class<? extends CustomFile> clazz)
	{
		for (CustomFile file : files)
		{
			if (file.getClass() == clazz)
			{
				return file;
			}

		}

		return null;
	}

	/**
	 * Retrieves a CustomFile using the Files name. Only searches the manually added
	 * Files!
	 * 
	 * @param name
	 * @return CustomFile | null
	 */
	public CustomFile getCustomFile(String name)
	{
		for (CustomFile file : files)
		{
			if (file.getName().equalsIgnoreCase(name))
			{
				return file;
			}

		}

		return null;
	}

	/**
	 * Searches for a File in a specific location. Returns a List containing all the
	 * Files containing the name (Ignoring capitalization).
	 * 
	 * @param name
	 * @param filePath
	 * @return List {@link File}
	 */
	public List<File> getFiles(String filePath, String name)
	{
		// All files in the filePath
		File[] folderFiles = new File(filePath).listFiles();
		List<File> files = new ArrayList<File>();

		for (File file : folderFiles)
		{
			if (file.getName().contains(name))
			{
				files.add(file);
			}

		}

		return files;
	}

	/**
	 * Returns a List containing all Files inside the Folder.
	 * 
	 * NOTE: Only files will be retrieved, Folders will be ignored.
	 * 
	 * @param filePath
	 * @return List {@link File}
	 */
	public List<File> getFiles(String filePath)
	{
		// All files in the filePath
		File[] folderFiles = new File(filePath).listFiles();
		List<File> files = new ArrayList<File>();

		for (File file : folderFiles)
		{
			if (file.isFile())
				files.add(file);
		}

		return files;
	}

	/**
	 * Retrieves the first File out of the target directory matching the name
	 * (Ignoring capitalization).
	 * 
	 * @param filePath
	 * @param name
	 * @return File | null
	 */
	public File getFile(String filePath, String name)
	{
		// All files in the filePath
		File[] folderFiles = new File(filePath).listFiles();

		for (File file : folderFiles)
		{
			if (file.isFile() && file.getName().substring(0, file.getName().lastIndexOf(".")).equalsIgnoreCase(name))
			{
				return file;
			}

		}

		return null;
	}

	/**
	 * Creates the directory's
	 * 
	 */
	private void makeDirs()
	{
		for (File file : directorys)
		{
			if (!file.exists())
				file.mkdir();
		}

	}

}
