import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Clasa ce se ocupa cu outputul(scrisul in fisiere al rezultatelor)
 */
public class OutputHandler {
	private final static String extensionOfFileRead = ".ac";
	private PrintWriter writer;

	public OutputHandler(String fileName, String newExtension) {
		fileName = fileName.substring(fileName.lastIndexOf("/")+1,
				fileName.length());
		fileName = fileName.replace(extensionOfFileRead, newExtension);
		fileName = "output/" + fileName;
		try {
			writer = new PrintWriter(
					new FileOutputStream(new File(fileName), false));
		} catch (FileNotFoundException e) {
			System.out.println("nu s-a putut scrie in fisierul " + fileName);
		}
	}

	/**
	 * Scrie Stringul primit ca parametru in fisier
	 * 
	 * @param stringToBeWritten
	 *            Stringul pe care vrem sa-l scriem in fisier(nu include "\n")
	 * 
	 */
	public void writeStringToFile(String stringToBeWritten) {
		writer.print(stringToBeWritten);
		writer.flush(); // scepticism
	}

	/**
	 * Inchide fisierul in care scriem Folosit pentru a inchide fisierul(pentru
	 * a nu inchide si deschide fisierul de fiecare data,lucru destul de
	 * costisitor) la terminarea scrierii
	 */
	public void stopWritingToFile() {
		writer.close();
	}
}
