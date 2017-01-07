import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Ionut-Cristian Bucur, 323CA
 * 
 *         Implementeaza un sistem de Input din fisier
 */
public final class InputHandler {

	private FileReader file;
	private BufferedReader reader;

	public InputHandler(String nameOfFile) {

		try {
			file = new FileReader(nameOfFile);
		} catch (FileNotFoundException e1) {
			System.out.println("nu se poate deschide fisierul");
		}

		reader = new BufferedReader(file);

	}

	/**
	 * Implementeaza citirea urmatoarea linii din fisier
	 * 
	 * @return urmatoarea linie din fisier
	 */
	public String getNextLine() {
		String line = null;
		try {
			line = reader.readLine();
		} catch (IOException e) {
			System.out.println("nu se poate citi");
		}
		if (line != null) { // daca mai exista linia

			if (line.length() == 0) {// e cheala linia "\n"
				return this.getNextLine();
			}

			// scapam de spatiile suplimentare
			line = line.trim().replaceAll(" +", " ");
		}
		return line;

	}

}
