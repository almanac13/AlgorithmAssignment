import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {

    public static void append(Metrics metrics, String filename) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(metrics.toCsvRow());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
