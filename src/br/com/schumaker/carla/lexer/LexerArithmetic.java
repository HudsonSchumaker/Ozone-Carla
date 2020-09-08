package br.com.schumaker.carla.lexer;

import br.com.schumaker.carla.lexer.o3.O3VariableType;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * This class deal with arithmetic expressions.
 *
 * @author Hudson Schumaker
 */
public class LexerArithmetic {
    private static final String TYPE_STRING = "java.lang.String";
    private static final String TYPE_FLOAT = "java.lang.Float";
    private static final String TYPE_DOUBLE = "java.lang.Double";
    
    private final ScriptEngineManager sem;
    private final ScriptEngine v8engine;
    
    public LexerArithmetic() {
        this.sem = new ScriptEngineManager();
        this.v8engine = sem.getEngineByName("JavaScript");
    }
    

    public O3VariableType getReturnTypeExpression(String data) {
        var clean = data.replaceAll(" ", "");
        try {
            var val = v8engine.eval(clean);
            var name = val.getClass().getName();

            if (name.contains(TYPE_STRING)) {
                return O3VariableType.STRING;
            }

            if (name.contains(TYPE_FLOAT)) {
                return O3VariableType.FLOAT;
            }

            if (name.contains(TYPE_DOUBLE)) {
                return O3VariableType.DOUBLE;
            }

            return O3VariableType.INT;
        } catch (ScriptException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public Integer getIntegerValueFromExpression(String data) {
        var clean = data.replaceAll(" ", "");
         try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            var val = engine.eval(clean);
            return (Integer) val;
           
        } catch (ScriptException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public Float getFloatValueFromExpression(String data) {
        var clean = data.replaceAll(" ", "");
         try {
            var val = v8engine.eval(clean);
            var auxD = (Double) val;
            return auxD.floatValue();
           
        } catch (ScriptException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public Double getDoubleValueFromExpression(String data) {
        var clean = data.replaceAll(" ", "");
         try {
            var val = v8engine.eval(clean);
            return (Double) val;
           
        } catch (ScriptException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    public String getStringValueFromExpression(String data) {
        var clean = data.replaceAll(" ", "");
         try {
            var val = v8engine.eval(clean);
            return (String) val;
           
        } catch (ScriptException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
