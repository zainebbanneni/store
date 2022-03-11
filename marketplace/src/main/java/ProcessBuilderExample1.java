import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderExample1 {

	public static void main(String[] args) throws IOException {
		String[] cmd = { "bash", "ls" };
		ProcessBuilder probuilder = new ProcessBuilder(cmd);
		Process p = probuilder.start();

		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null)
			sb.append(line);
		System.out.println(sb.toString());
	}

}