package com.example.market.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;

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

	public String executeCommands(String[] lines) throws IOException {
		String port = null;
		File tempScript = createTempScript(lines);

		ProcessBuilder processBuilder = new ProcessBuilder("bash", tempScript.toString());
		Process process;
		// pb.inheritIO();

		try {
			// Start a new java process
			process = processBuilder.start();

			// Read and print the standard output stream of the process
			try (BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				String line;
				while ((line = input.readLine()) != null) {
					System.out.println(line);
					port = line;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			tempScript.delete();
		}
		return port;

	}
}
