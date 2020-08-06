package br.com.schumaker.carla.lexer.o3;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents the O³ program.
 * @author schumaker
 */

@Data
@AllArgsConstructor
public class O3Atom {
    
    private List<O3Function> functions;
}
