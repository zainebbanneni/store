package com.example.market.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class UtilityService {

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
		try {
			Process process = processBuilder.start();
			try (BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
				String line;
				while ((line = input.readLine()) != null) {
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
	
	public String generateRoandomNames() {
		 // create a string of uppercase and lowercase characters and numbers
	    String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
	    String numbers = "0123456789";

	    // combine all strings
	    String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 10;

	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphaNumeric.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphaNumeric.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	    String randomString = sb.toString();
	    System.out.println("Random String is: " + randomString);
		return randomString;

	  }
	
	}
