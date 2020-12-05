package br.com.schumaker.carla.io.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * This class holds the O3 file source.
 *
 * @author Hudson Schumaker
 */

@Getter
@Setter
@AllArgsConstructor
public class O3File {
    public static final String EXT = "o3";

    private String name;
    private String path;
    private List<FileLine> lines;
}
