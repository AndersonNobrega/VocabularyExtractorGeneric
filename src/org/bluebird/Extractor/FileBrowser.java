package org.bluebird.Extractor;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class FileBrowser {

    public static String readFile(File file, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(file.toPath());
        return new String(encoded, encoding);
    }

    public static void browseDirectory(LanguageWalker walker, File directory, String formato) throws IOException {
        for (File child : directory.listFiles()) {
            if (child.isDirectory()) {
                browseDirectory(walker, child, formato);
            } else {
                if (child.getName().endsWith("." + formato)) {
                    walker.walkFileTree(child);
                }
            }
        }
    }
}