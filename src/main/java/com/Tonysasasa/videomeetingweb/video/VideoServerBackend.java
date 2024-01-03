package com.Tonysasasa.videomeetingweb.video;

import java.io.BufferedReader;
import java.io.File;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class VideoServerBackend {
    public static void runExecution() throws IOException, InterruptedException {

        final String dir = System.getProperty("user.dir");
        String destFolder = dir + "\\src\\main\\resources\\static\\server";

        String cmdPrompt = "cmd";
        String path = "/c";
        String npmUpdate = "npm run start";

        File jsFile = new File(destFolder);
        List<String> updateCommand = new ArrayList<String>();
        updateCommand.add(cmdPrompt);
        updateCommand.add(path);
        updateCommand.add(npmUpdate);

        ProcessBuilder executeProcess = new ProcessBuilder(updateCommand);
        executeProcess.directory(jsFile);
        Process resultExecution = executeProcess.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(resultExecution.getInputStream()));
        StringBuffer sb = new StringBuffer();

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + System.getProperty("line.separator"));
        }
        br.close();
        int resultStatust = resultExecution.waitFor();
        System.out.println("Result of Execution" + (resultStatust == 0 ? "\tSuccess" : "\tFailure"));

    }

}
