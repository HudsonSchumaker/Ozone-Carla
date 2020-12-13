package br.com.schumaker.carla.build;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hudson Schumaker
 */
public class TerminalLinux implements Bash {

    @Getter
    private List<String> output = new ArrayList<>();

    @Override
    public void executeCommand(String[] commands) {
        //TODO
    }
}
