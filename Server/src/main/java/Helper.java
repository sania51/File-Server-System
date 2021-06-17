
import java.io.File;
import java.nio.file.Path;

public class Helper {

    public static String serverStorageDir() {
        String currentDir = Path.of("").toAbsolutePath().toString();
        System.out.println(currentDir);
        System.out.println(currentDir);
        String newDir = currentDir + "/store";
        File theDir = new File(newDir);
        if (!theDir.exists()) {
            theDir.mkdirs();
        };
        return newDir;
    }

}
