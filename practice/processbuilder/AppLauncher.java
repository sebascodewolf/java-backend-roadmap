import java.io.IOException;

public class AppLauncher {
	public static void main(String[] args) {
		String bravePath = "/mnt/c/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe";

		try{
			ProcessBuilder pb = new ProcessBuilder(bravePath);
			pb.start();
			System.out.println("Brave se esta activando ...");
		} catch (IOException e) {
			System.out.println("No se pude encontrar el archivo en: " + bravePath);
			e.printStackTrace();
		}
	}
}
