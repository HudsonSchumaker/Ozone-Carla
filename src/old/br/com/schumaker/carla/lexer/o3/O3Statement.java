package old.br.com.schumaker.carla.lexer.o3;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import old.br.com.schumaker.carla.files.O3FileLine;

/**
 * This class represents the raw statement of O³ pl.
 * Ex: 
 * {
 *    print("some text...")
 * }
 * @author Hudson Schumaker
 */

@Data
@ToString
@AllArgsConstructor
public class O3Statement implements IO3Statement {
    private List<O3FileLine> lines;
}
