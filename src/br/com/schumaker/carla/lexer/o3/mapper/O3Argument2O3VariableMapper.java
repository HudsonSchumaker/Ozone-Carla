package br.com.schumaker.carla.lexer.o3.mapper;

import br.com.schumaker.carla.lexer.o3.O3Argument;
import br.com.schumaker.carla.lexer.o3.O3Variable;
import br.com.schumaker.carla.lexer.o3.O3VariableType;
import br.com.schumaker.carla.lexer.o3.O3VariableTypeValue;

/**
 * Map an O3Argument object to an O3Variable object.
 *
 * @author Hudson Schumaker
 */
public class O3Argument2O3VariableMapper implements IO3Mapper<O3Argument, O3Variable> {

    @Override
    public O3Variable from(O3Argument source) {
        O3Variable target = O3Variable.getBlankO3Variable();
        this.map(source, target);
        return target;
    }

    @Override
    public void map(O3Argument source, O3Variable target) {
        target.setName(source.getName());
        target.setInternalName(source.getName());
        target.setInitialized(source.isInitialized());

        var sourceType = source.getType();
        var sourceValue = source.getTypeAndValue().getValue();
        var targetTypeAndValue = O3VariableTypeValue.of(this.getVariableType(sourceType), sourceValue);

        target.setTypeValue(targetTypeAndValue);
    }

    private O3VariableType getVariableType(O3VariableType type) {
        return O3VariableType.getByReference(type);
    }
}
