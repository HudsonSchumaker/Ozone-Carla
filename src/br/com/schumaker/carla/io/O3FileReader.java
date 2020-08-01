package br.com.schumaker.carla.io;

import br.com.schumaker.carla.files.O3File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validExtension(String path) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> read(String path) throws Exception {
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
