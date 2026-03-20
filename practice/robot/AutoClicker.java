import java.awt.Robot;
import java.awt.event.InputEvent;

public class AutoClicker {
	public static void main(String[] args) throws Exception{
		Robot robot = new Robot();
		//Move the mouse by coordinates
		robot.mouseMove(500, 500);
		System.out.println("Mouse se mueve");
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
}
