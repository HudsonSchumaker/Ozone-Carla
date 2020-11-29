package br.com.schumaker.carla.io;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * This class holds the O3 file source.
 *
 * @author Hudson Schumaker
 */
@Data
@AllArgsConstructor
public class SourceFile {
    public static final String EXT = "o3";

    private String name;
    private String path;
    private List<FileLine> lines;
}
