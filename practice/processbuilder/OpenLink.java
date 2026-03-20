import java.io.IOException;

public class OpenLink {
	public static void main(String[] args) {
		String bravePath = "/mnt/c/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe";
		String url = "https://www.youtube.com/watch?v=Ce4rHZo3mAs";
		try{
			new ProcessBuilder(bravePath, url).start();
			System.out.println("Abriendo documentacion ...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
