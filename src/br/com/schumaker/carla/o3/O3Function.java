package br.com.schumaker.carla.o3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents the functions of O³ pl.
 * Ex:
 * f: main() {
 *      ; some code here...
 * }
 * 
 * @author schumaker
 */

@Data
@AllArgsConstructor
public class O3Function {
    
    private String name;
    private boolean isMain;
    //private List<O3Variable> params; 
    private IO3Statement statement;
}