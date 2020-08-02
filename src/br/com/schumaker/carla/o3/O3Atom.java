package br.com.schumaker.carla.o3;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This class represents the O3 program.
 * @author schumaker
 */

@Data
@AllArgsConstructor
public class O3Atom {
    
    private List<O3Function> functions;
}
