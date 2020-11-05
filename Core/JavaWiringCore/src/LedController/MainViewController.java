package LedController;

import JavaWiringCore.JavaSoftPwm;
import JavaWiringCore.JavaWiring;
import JavaWiringCore.PinMode;
import javafx.event.ActionEvent;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

public class MainViewController {
    static {
        System.loadLibrary("javawiring");
        System.loadLibrary("javasoftpwm");
    }

    public Slider slider;

    private JavaWiring javaWiring;
    private JavaSoftPwm javaSoftPwm;

    public MainViewController() {
        javaWiring = new JavaWiring();
        javaSoftPwm = new JavaSoftPwm();
        javaWiring.wiringPiSetup();
        javaWiring.pinMode(0, PinMode.OUTPUT);
        javaWiring.pinMode(1, PinMode.OUTPUT);
        javaWiring.pinMode(2, PinMode.SOFT_PWM_OUTPUT);
        javaSoftPwm.softPwmCreate(2, 0, 100);
    }

    public void btnLed1Clicked(ActionEvent actionEvent) {
        changePinState(0);
    }

    public void btnLed2Clicked(ActionEvent actionEvent) {
        changePinState(1);
    }

    private void changePinState(int i) {
        if (javaWiring.digitalRead(i) == 1) {
            javaWiring.digitalWrite(i, PinMode.LOW);
        } else {
            javaWiring.digitalWrite(i, PinMode.HIGH);
        }
    }

    public void sliderDragged(MouseEvent mouseEvent) {
        javaSoftPwm.softPwmWrite(2, (int) slider.getValue());
    }
}
