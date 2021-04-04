package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.lexer.ILexerArithmetic;
import br.com.schumaker.carla.o3.enums.MemoryType;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Hudson Schumaker
 */
public final class LexerArithmetic implements ILexerArithmetic {

    private static final String TYPE_STRING = "java.lang.String";
    private static final String TYPE_FLOAT = "java.lang.Float";
    private static final String TYPE_DOUBLE = "java.lang.Double";
    private final ScriptEngineManager sem;
    private final ScriptEngine v8engine;

    public LexerArithmetic() {
        this.sem = new ScriptEngineManager();
        this.v8engine = sem.getEngineByName("JavaScript");
    }

    @Override
    public MemoryType getReturnTypeExpression(String data) {
        var clean = data.replaceAll(" ", "");
        try {
            var val = v8engine.eval(clean);
            var name = val.getClass().getName();

            if (name.contains(TYPE_STRING)) {
                return MemoryType.STRING;
            }

            if (name.contains(TYPE_FLOAT)) {
                return MemoryType.FLOAT;
            }

            return MemoryType.INT;
        } catch (ScriptException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public Integer getIntegerValueFromExpression(String data) {
        var clean = data.replaceAll(" ", "");
        try {
            var val = v8engine.eval(clean);
            return (Integer) val;

        } catch (ScriptException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
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

    @Override
    public Double getDoubleValueFromExpression(String data) {
        var clean = data.replaceAll(" ", "");
        try {
            var val = v8engine.eval(clean);
            return (Double) val;

        } catch (ScriptException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public String getStringValueFromExpression(String data) {
        try {
            var val = v8engine.eval(data);
            return (String) "\"" + val + "\"";

        } catch (ScriptException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
