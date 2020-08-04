package br.com.schumaker.carla.o3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents the functions of O³ pl. Ex: f: main() { ; some code
 * here... }
 *
 * @author schumaker
 */
@Data
@AllArgsConstructor
public class O3Function {

    private String name;
    private String internalName;
    private boolean isMain;
    //private List<O3Variable> params; 
    private IO3Statement statement;

    @Override
    public String toString() {
        return "{\n"
                + "Name : " + name + ",\n"
                + "Internal Name : " + internalName + ",\n"
                + "Is Main : " + isMain + ",\n"
                + "Variables : " + ((O3FunctionStatement)statement).getVariables()
                + "\n}";
    }
}
