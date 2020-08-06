package br.com.schumaker.carla.lexer.o3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents the variables of O³ pl.
 * Ex:
 * v: pi = 3.14f
 * 
 * @author schumaker
 */

@Data
@AllArgsConstructor
public class O3Variable {
    
    private String name;
    private String internalName;
    private O3VariableTypeValue<O3VariableType, ?> typeValue;       
    
   @Override
   public String toString() {
       return "{\n"
               + "\tName : " + name + ",\n"
               + "\tInternal Name : " + internalName + ",\n"
               + "\tType : " + typeValue.getType().getName() + ",\n"
               + "\tValue: " + typeValue.getValue()
               + "\n}";
   }
}
