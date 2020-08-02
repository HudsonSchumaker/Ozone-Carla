package br.com.schumaker.carla.o3;

import br.com.schumaker.carla.files.O3FileLine;
import java.util.List;
import lombok.Data;

/**
 * This class represents the functions of O3 pl.
 * Ex:
 * 
 * f: main() {
 *      ; some code here...
 * }
 * 
 * @author schumaker
 */

@Data
public class O3Function {
    
    private String name;
    private O3Statement statement;
}
