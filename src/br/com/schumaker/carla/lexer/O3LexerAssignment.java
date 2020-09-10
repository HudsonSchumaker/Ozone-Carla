package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.lexer.o3.O3VariableType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hudson Schumaker
 */
public class O3LexerAssignment {
    
    // key: number of variables, value number of signs.
    private Map<Integer, Integer> assignmentFormula = new HashMap<>();
    
    // key: number of variables, value list of the positions index of the variables in the expression.
    private Map<Integer, List<Integer>> variablePositions = new HashMap<>();
    
    // key: number of variables, value list of the positions index of the signs in the expression.
    private Map<Integer, List<Integer>> signPositions = new HashMap<>();
       
    public O3LexerAssignment() {
        this.assignmentFormula.put(2, 1);
        this.assignmentFormula.put(3, 2);
        this.assignmentFormula.put(4, 3);
        this.assignmentFormula.put(5, 4);
        this.assignmentFormula.put(6, 5);
        
        this.variablePositions.put(2, Arrays.asList(0, 2));
        this.variablePositions.put(3, Arrays.asList(0, 2, 4));
        this.variablePositions.put(4, Arrays.asList(0, 2, 4, 6));
        this.variablePositions.put(5, Arrays.asList(0, 2, 4, 6, 8));
        this.variablePositions.put(6, Arrays.asList(0, 2, 4, 6, 8, 10));  
        
        this.signPositions.put(2, Arrays.asList(1));
        this.signPositions.put(3, Arrays.asList(1, 3));
        this.signPositions.put(4, Arrays.asList(1, 3, 5));
        this.signPositions.put(5, Arrays.asList(1, 3, 5, 7));
        this.signPositions.put(6, Arrays.asList(1, 3, 5, 7, 9));
    }
    
    public int getNumberOfSigns(int varNumber) {
        return this.assignmentFormula.getOrDefault(varNumber, 0);
    }
    public List<Integer> getVariablePositions(int varNumber) {
        return this.variablePositions.getOrDefault(varNumber, null);
    }
    
    public List<Integer> getSignPositions(int varNumber) {
        return this.signPositions.getOrDefault(varNumber, null);
    }
    
    public O3VariableType getVariableReturnType(List<String> variables) {
        var string = 0;
        var o3int = 0;
        var o3float = 0;
        var o3double = 0;
        var o3bool = 0;
        
        for (var val : variables) {
            if (O3VariableType.STRING.getName().equalsIgnoreCase(val)) {
                string++;
                continue;
            }
            if (O3VariableType.INT.getName().equalsIgnoreCase(val)) {
                o3int++;
                continue;
            }
            
            if (O3VariableType.FLOAT.getName().equalsIgnoreCase(val)) {
                o3float++;
                continue;
            }
            
            if (O3VariableType.DOUBLE.getName().equalsIgnoreCase(val)) {
                o3double++;
                continue;
            }
            
            if (O3VariableType.BOOL.getName().equalsIgnoreCase(val)) {
                o3bool++;
            }
        }
        
        if (string > 0) {
            return O3VariableType.STRING;
        }
        
        if (o3double > 0) {
            return O3VariableType.DOUBLE;
        }
        
        if (o3float > 0) {
            return O3VariableType.FLOAT;
        } 
        
        if (o3int > 0) {
            return O3VariableType.INT;
        }
        
        return O3VariableType.VOID;
    }
}
