
package com.io;

import java.io.File;
import java.nio.file.Path;

public class Helper {
    public static String clientStorageDir() {
        String currentDir = Path.of("").toAbsolutePath().toString();
        System.out.println(currentDir);
        String newDir = currentDir + "/client";
        File theDir = new File(newDir);
        if (!theDir.exists()) {
            theDir.mkdirs();
        };
        return newDir;
    }

}
