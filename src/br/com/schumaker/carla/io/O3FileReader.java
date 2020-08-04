package br.com.schumaker.carla.io;

import br.com.schumaker.carla.exception.FileNotSupportedException;
import br.com.schumaker.carla.files.FileUtils;
import br.com.schumaker.carla.files.O3File;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is the concrete reader of O³ source files. 
 * Ex: main.o3
 * @author schumaker
 */
public class O3FileReader implements Reader<List<String>> {

    @Override
    public boolean fileExists(String path) {
        File f = new File(path);
        return f.exists();
    }

    @Override
    public boolean validExtension(String path) {
        return O3File.EXT.equals(FileUtils.getFileExtension(path));
    }
    
    /**
     * Reads the lines from a .o3 source file. Reads line by line and return in
     * raw.
     * @param path
     * @return
     * @throws Exception 
     */
    @Override
    public List<String> read(String path) throws Exception {
        if (!this.fileExists(path)) {
            throw new FileNotFoundException();
        }
        
        if (!this.validExtension(path)) {
            throw new FileNotSupportedException();
        }
                
        var fis = new FileInputStream(path);
        var isr = new InputStreamReader(fis, "UTF-8");
        var br = new BufferedReader(isr);
        
        var rawLines = new ArrayList<String>();
        var rawLine = "";
        while (null != rawLine) {
            rawLine = br.readLine();
            if (null != rawLine) {
                rawLines.add(rawLine);
            }
        }
        br.close();
        return rawLines;
    }
}
