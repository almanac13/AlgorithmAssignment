import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter {
    public static void init(String file) {
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write("algo,n,trial,mode,time_ms,max_depth,comparisons,allocations\n");
        } catch(IOException e) { e.printStackTrace(); }
    }

    public static void append(Metrics metrics, String file) {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(metrics.toCsvRow());
        } catch(IOException e) { e.printStackTrace(); }
    }
}
