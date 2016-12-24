package com.slyfox.embarque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;

public class Embarque {

	private static final Logger log = LoggerFactory.getLogger(Embarque.class);

	static GpioController gpio= null;

	private static void Embarque() {
		gpio= GpioFactory.getInstance();
	}
	public static void unprovisionPin(GpioPin pin){
		gpio.unprovisionPin(pin);
	}
	public static void shutdown(){
		gpio.shutdown(); 
	}
	/**
	 * 
	 * @param pin
	 * @param resistance
	 * @return
	 */
	public static GpioPinDigitalOutput Output(Pin pin, PinState resistance) {
		Embarque();
		final GpioPinDigitalOutput output = gpio.provisionDigitalOutputPin(pin, "MyLED", resistance);
		return output;
	}

	/**
	 * 
	 * @param pin
	 * @param resistance
	 * @return
	 */
	public static GpioPinDigitalInput Input(Pin pin, PinPullResistance resistance) {
		Embarque();		
		final GpioPinDigitalInput Input = gpio.provisionDigitalInputPin(pin, resistance.getName());
		return Input;
	}

	/**
	 * Basculer
	 * 
	 * @param pin
	 * @param resistance
	 */
	public static GpioPinDigitalOutput ToggleOutput(Pin pin, PinState resistance) {
		GpioPinDigitalOutput output = Output(pin, resistance);
		output.toggle();
		return output;
	}

	/**
	 * turn off
	 * 
	 * @param pin
	 * @param resistance
	 */
	public static void ShutdownOptions(Pin pin, PinState resistance, PinState etat, Boolean b) {
		GpioPinDigitalOutput output = Output(pin, resistance);
		output.setShutdownOptions(b, etat);
	}

	/**
	 * impulsion
	 * 
	 * @param pin
	 * @param resistance
	 */
	public static GpioPinDigitalOutput PulseOutput(Pin pin, PinState resistance, int num, Boolean b) {
		GpioPinDigitalOutput output = Output(pin, resistance);
		output.pulse(num, b);
		return output;
	}

	/**
	 * turn off
	 * 
	 * @param pin
	 * @param resistance
	 */
	public static GpioPinDigitalOutput LowOutput(Pin pin, PinState resistance) {
		GpioPinDigitalOutput output = Output(pin, resistance);
		output.low();
		return output;
	}

	/**
	 * create a gpio control trigger on the input pin ; when the input goes
	 * HIGH, also set gpio pin #04 to HIG
	 * 
	 * @param pin
	 * @param resistance
	 * @param targetPin
	 */
	public static void LowOutput(Pin pin, PinPullResistance resistance, GpioPinDigitalOutput targetPin, PinState etat1,
			PinState etat2) {
		final GpioPinDigitalInput Input = Input(pin, resistance);
		Input.addTrigger(new GpioSetStateTrigger(etat1, targetPin, etat2));
	}

}
