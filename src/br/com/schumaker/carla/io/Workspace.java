package br.com.schumaker.carla.io;

import java.io.File;

/**
 *
 * @author schumaker
 */
public class Workspace {
    
    public boolean createWorkspace(String atomName) {
        var path = System.getProperty("user.dir");
        var file = new File(path  + System.getProperty("file.separator") + atomName);
        return file.mkdir();
    }
}
