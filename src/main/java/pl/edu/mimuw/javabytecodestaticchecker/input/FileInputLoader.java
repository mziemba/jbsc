/**
 * @version 1.0.0
 * @date 2012-01-30, 21:15
 * @author M. Ziemba
 */
package pl.edu.mimuw.javabytecodestaticchecker.input;

import java.io.*;
import org.apache.log4j.Logger;

/**
 * Loads data from given file.
 *
 */
public class FileInputLoader implements InputLoader {

    private static final Logger log = Logger.getLogger(FileInputLoader.class);

    private String fileName;

    /**
     * Constructs new FileLoader instance with given file name.
     *
     * @param fileName name of file
     */
    public FileInputLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String load() {
        String result = "";
        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                result += strLine + "\n";
            }
            dis.close();
        } catch (FileNotFoundException fnfe) {
            log.error("File " + fileName + " not found");
        } catch (IOException ioe) {
            log.error("Cannot read from file");
        }

        return result;
    }
}
