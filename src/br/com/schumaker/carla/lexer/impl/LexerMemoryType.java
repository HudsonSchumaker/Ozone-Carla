package br.com.schumaker.carla.lexer.impl;

import br.com.schumaker.carla.lexer.ILexerMemoryType;
import br.com.schumaker.carla.o3.enums.MemoryType;
import br.com.schumaker.carla.o3.impl.O3Keyword;

/**
 * @author Hudson Schumaker
 */
public class LexerMemoryType implements ILexerMemoryType {

    @Override
    public MemoryType getType(String data) {
        var value = data.substring(data.indexOf(O3Keyword.ASSIGN) + 1, data.length()).trim();

        if (data.contains("\"") && !value.contains(O3Keyword.PLUS)) {
            return MemoryType.STRING;
        } else {
            if (value.contains(O3Keyword.TRUE) || value.contains(O3Keyword.FALSE)) {
                return MemoryType.BOOL;
            }

            if (value.contains(O3Keyword.FLOATING_POINT_SIGN)) {
                if (data.contains(O3Keyword.FLOAT_SIGN)) {
                    return MemoryType.FLOAT;
                }
            }

            if (value.contains(O3Keyword.FLOATING_POINT_SIGN)) {
                if (data.contains(O3Keyword.DOUBLE_SIGN)) {
                    return MemoryType.DOUBLE;
                }
            }


            return MemoryType.INT;
        }
    }

    @Override
    public boolean isInitialized(String data) {
        var value = data.substring(data.indexOf(O3Keyword.ASSIGN) + 1, data.length()).trim();
        if (value.contains("\"")) {
            return true;
        }

        if (value.contains(O3Keyword.TRUE) || value.contains(O3Keyword.FALSE)) {
            return true;
        }

        if (value.contains(O3Keyword.FLOATING_POINT_SIGN)) {
            if (data.contains(O3Keyword.FLOAT_SIGN)) {
                return true;
            }

            if (data.contains(O3Keyword.DOUBLE_SIGN)) {
                return true;
            }
        }

        return !data.contains(O3Keyword.OPEN_EXPRESSION)
                || !data.contains(O3Keyword.CLOSE_EXPRESSION);
    }

    @Override
    public String getValueString(String data) {
        var clean = data.trim();
        return clean.substring(clean.indexOf(O3Keyword.ASSIGN) + 1, clean.length()).trim();
    }

    @Override
    public Boolean getValueBoolean(String data) {
        var clean = data.trim();
        var value = clean.substring(clean.indexOf(O3Keyword.ASSIGN) + 1, clean.length()).trim();
        return Boolean.valueOf(value);
    }

    @Override
    public Integer getValueInteger(String data) {
        var clean = data.trim();
        var value = clean.substring(clean.indexOf(O3Keyword.ASSIGN) + 1, clean.length()).trim();
        return Integer.valueOf(value);
    }

    @Override
    public Float getValueFloat(String data) {
        var clean = data.trim();
        var value = clean.substring(clean.indexOf(O3Keyword.ASSIGN) + 1, clean.length() - 1).trim();
        return Float.valueOf(value);
    }

    @Override
    public Double getValueDouble(String data) {
        var clean = data.trim();
        var value = clean.substring(clean.indexOf(O3Keyword.ASSIGN) + 1, clean.length() - 1).trim();
        return Double.valueOf(value);
    }
}