package br.com.schumaker.carla.build;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author Hudson Schumaker
 */
public class Terminal implements Bash {

    @Override
    public void executeCommand(String[] commands) {
        new Thread(() -> {
            ProcessBuilder builder = new ProcessBuilder("/bin/bash");
            Process process = null;
            try {
                process = builder.start();
                BufferedWriter input = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

                for (int i = 0; i < commands.length; i++) {
                    input.write(commands[i]);
                    input.newLine();
                    input.flush();
                }

                input.flush();
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                process.destroy();
            }
        }).start();
    }
}