package br.com.schumaker.carla.build;

import lombok.Getter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hudson Schumaker
 */
public final class TerminalMacOs implements Bash {

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
                System.err.println(e.getMessage());
            } finally {
                process.destroy();
            }
        }).start();
    }
}
