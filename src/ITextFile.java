import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public interface ITextFile {
    static String getDataFromFile(String filePath) {
        BufferedReader reader;
        String data = null;

        try {
            reader = new BufferedReader(new FileReader(filePath));
            data = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
