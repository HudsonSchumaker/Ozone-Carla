package br.com.schumaker.carla.files;

import lombok.Data;

/**
 *
 * @author schumaker
 */

@Data
public class O3FileLine {
    
    private String data;
    private boolean functionHeader;
    private Integer originalNumber;

    public O3FileLine(String data, Integer originalNumber) {
        this.data = data;
        this.originalNumber = originalNumber;
    }
}