package br.com.schumaker.carla.utils;

import br.com.schumaker.carla.exception.O3SourceFileNotFound;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Util class for work with files.
 *
 * @author Hudson Schumaker
 */
public class FileUtils {

    private FileUtils() {
    }

    public static List<String> getFilePathsFromRoot(String path) {

        if (fileExists(path)) {
            File file = new File(path);
            File[] list = file.listFiles();

            List<String> files = new ArrayList<>();
            for (File f : list) {
                files.add(f.getAbsolutePath());
            }
            return new ArrayList<String>(files);
        }

        throw new O3SourceFileNotFound();
    }

    public static boolean fileExists(String path) {
        return fileExists(new File(path));
    }

    public static boolean fileExists(File file) {
        return file.exists();
    }

    public static String getClearName(File file) {
        return file.getName().split("\\.")[0];
    }

    public static String getClearName(String path) {
        return getClearName(new File(path));
    }

    public static String getName(String path) {
        File file = new File(path);
        return file.getName();
    }

    public static String getClearPath(String path) {
        int pos = path.lastIndexOf(System.getProperty("file.separator"));
        return path.substring(0, pos + 1);
    }

    public static String getFileExtension(File file) {
        return getFileExtension(file.getAbsolutePath());
    }

    public static String getFileExtension(String fileName) {
        String[] ext = fileName.split("\\.");
        int size = ext.length;
        String result = "";
        if (size > 1) {
            result = ext[size - 1];
        }
        return result.toLowerCase();
    }
}
