package br.com.schumaker.carla.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> read(String path) throws Exception {
        
        if (!this.fileExists(path)) {
            throw new FileNotFoundException();
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
