package br.com.schumaker.carla.build;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
public class TerminalMacOs implements Bash {

    @Getter
    private List<String> out = new ArrayList<>();

    @Override
    public void executeCommand(String[] commands) {
        new Thread(() -> {
            var builder = new ProcessBuilder("/bin/bash");
            Process process = null;
            try {
                process = builder.start();
                var input = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

                for (int i = 0; i < commands.length; i++) {
                    input.write(commands[i]);
                    input.newLine();
                    input.flush();
                }

                input.flush();
                var br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    this.out.add(line);
                }
            } catch (IOException e) {
                System.err.println(e);
            } finally {
                process.destroy();
            }
        }).start();
    }
}
