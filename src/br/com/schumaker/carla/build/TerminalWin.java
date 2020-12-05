package br.com.schumaker.carla.build;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hudson Schumaker
 */
public final class TerminalWin implements Cmd {

    @Getter
    private List<String> output = new ArrayList<>();

    @Override
    public void executeCommand(String[] commands) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Process process = null;
                try {
                    for (int i = 0; i < commands.length; i++) {
                        process = Runtime.getRuntime().exec(commands[i]);
                        var in = process.getInputStream();
                        var buffer = new BufferedReader(new InputStreamReader(in));
                        String line;
                        while ((line = buffer.readLine()) != null) {
                            System.out.println(line);
                            output.add(line);
                        }
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                } finally {
                    process.destroy();
                }
            }
        }).start();
    }
}
