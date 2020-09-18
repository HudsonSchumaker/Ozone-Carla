package old.br.com.schumaker.carla.lexer.o3.mapper;

import br.com.schumaker.carla.exception.MapperOperationException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

/**
 *
 * @author Hudson Schumaker
 * @param <S> Source
 * @param <T> Target
 */
public interface IO3Mapper<S, T> {

    default T from(S source) {
        throw new UnsupportedOperationException("From(S) is not implemented.");
    }

    default List<T> from(Iterable<S> sources) {
        return from(sources, (s, t) -> {
        });
    }

    default List<T> from(Iterable<S> sources, BiConsumer<S, T> postProcessor) {
        List<T> targetList = new ArrayList<>();
        for (S entity : sources) {
            try {
                T dto = from(entity);
                postProcessor.accept(entity, dto);
                targetList.add(dto);
            } catch (Exception e) {
                throw new MapperOperationException();
            }
        }
        return targetList;
    }

    default void map(S source, T target) {
        throw new UnsupportedOperationException("map(S, T) is not implemented.");
    }
}
