package br.com.schumaker.carla.lexer.o3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents the arguments of function call O³ pl.
 *
 * @author schumaker
 */
@Data
@AllArgsConstructor
public class O3Argument {

    private O3TypeValue<?, ?> argument;

    @Override
    public String toString() {
        return "{\n"
                + "\tArgument  : " + argument + "\n"
                + "}";
    }
}
