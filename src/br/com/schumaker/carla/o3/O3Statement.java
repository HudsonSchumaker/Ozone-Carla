package br.com.schumaker.carla.o3;

import br.com.schumaker.carla.files.O3FileLine;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents the statement of O3 pl.
 * Ex: 
 * {
 *    print("some text...")
 * }
 * @author schumaker
 */

@Data
@AllArgsConstructor
public class O3Statement implements IO3Statement {
    private List<O3FileLine> lines;
}
