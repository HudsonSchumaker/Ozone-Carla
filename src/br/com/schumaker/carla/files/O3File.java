package br.com.schumaker.carla.files;

import java.util.List;
import lombok.Data;

/** 
 *  This class holds the O3 file source.
 *  @author schumaker
 */

@Data
public class O3File {
    
    public static final String EXT = "o3";
    
    private String name;
    private String path;
    private List<O3FileLine> lines;
    
    public O3File(String name, String path, List<O3FileLine> lines) {
        this.name = name;
        this.path = path;
        this.lines = lines;
    }
}
