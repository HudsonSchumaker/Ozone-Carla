package br.com.schumaker.carla.io;

import java.io.File;

/**
 * Creates a directory to be used as workspace for the atom program.
 *
 * @author Hudson Schumaker
 */
public class Workspace {

    public static boolean createWorkspace(String path, String atomName) {
        var file = new File(path + System.getProperty("file.separator") + atomName);
        return file.mkdir();
    }
    
    public static boolean createWorkspace(String atomName) {
        var path = System.getProperty("user.dir");
        var file = new File(path + System.getProperty("file.separator") + atomName);
        return file.mkdir();
    }
}
