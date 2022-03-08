package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.stereotype.Service;

@Service
public class TT {

	private String result;

	// create a temp script to execute commands since Process builder can't execute
	// complex commands
	public File createTempScript(String[] lines) throws IOException {
		File tempScript = File.createTempFile("script", null);

		Writer streamWriter = new OutputStreamWriter(new FileOutputStream(tempScript));
		PrintWriter printWriter = new PrintWriter(streamWriter);

		printWriter.println("#!/bin/bash");
		for (int i = 0; i < lines.length; i++) {
			printWriter.println(lines[i]);
		}

		printWriter.close();

		return tempScript;
	}

	public String executeCommands(String[] lines) throws IOException, InterruptedException {

		File tempScript = createTempScript(lines);

		try {
			ProcessBuilder pb = new ProcessBuilder("bash", tempScript.toString());
			pb.inheritIO();
			Process process = pb.start();
			process.waitFor();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				builder.append(line);
				builder.append(System.getProperty("line.separator"));
			}
			System.out.println("**************");
			System.out.println(builder.toString());
			return builder.toString();

		} finally {
			tempScript.delete();
		}
		
		
	}



	// Call sample
	// String sedCommand = "sed -e 's/{USER}/" + tfName.getText() + "/g'"
//	                                + " -e 's/{NS}/" + selectedNS.getName() + "/g'"
//	                                + " -e 's/{USER_EMAIL}/" + tfMail.getText() + "/g'"
//	                                + " roles/adminAppBindings/" + selectedRole.getName() + ".yaml > roleFile";
//	                        // +" >roleFile";
	//
//	                        String[] applycommands = {sedCommand, "kubectl apply -f roleFile"};
	// CommandTools.executeCommands(applycommands);

}
