package com.slyfox.dtos.transformers;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class EmbarqueTransformer {
	
	public static PinState IntToPinState(int i) {
		if (i != 1 && i != 0) {
			throw new IllegalArgumentException("i est pas compris entre 1 a 31 ");
		}
		if (i == 0) {
			return PinState.LOW;
		}
		return PinState.HIGH;

	}

	public static Pin IntToPin(int i) {
		Pin pin;
		switch (i) {
		case 0:
			pin = RaspiPin.GPIO_00;
			break;
		case 1:
			pin = RaspiPin.GPIO_01;
			break;

		case 2:
			pin = RaspiPin.GPIO_02;
			break;

		case 3:
			pin = RaspiPin.GPIO_03;
			break;

		case 4:
			pin = RaspiPin.GPIO_04;
			break;

		case 5:
			pin = RaspiPin.GPIO_05;
			break;

		case 6:
			pin = RaspiPin.GPIO_06;
			break;

		case 7:
			pin = RaspiPin.GPIO_07;
			break;

		case 8:
			pin = RaspiPin.GPIO_08;
			break;

		case 9:
			pin = RaspiPin.GPIO_09;
			break;

		case 10:
			pin = RaspiPin.GPIO_10;
			break;

		case 11:
			pin = RaspiPin.GPIO_11;
			break;

		case 12:
			pin = RaspiPin.GPIO_12;
			break;

		case 13:
			pin = RaspiPin.GPIO_13;
			break;

		case 14:
			pin = RaspiPin.GPIO_14;
			break;

		case 15:
			pin = RaspiPin.GPIO_15;
			break;

		case 16:
			pin = RaspiPin.GPIO_16;
			break;

		case 17:
			pin = RaspiPin.GPIO_17;
			break;

		case 18:
			pin = RaspiPin.GPIO_18;
			break;

		case 19:
			pin = RaspiPin.GPIO_19;
			break;

		case 20:
			pin = RaspiPin.GPIO_20;
			break;

		case 21:
			pin = RaspiPin.GPIO_21;
			break;

		case 22:
			pin = RaspiPin.GPIO_22;
			break;

		case 23:
			pin = RaspiPin.GPIO_23;
			break;

		case 24:
			pin = RaspiPin.GPIO_24;
			break;

		case 25:
			pin = RaspiPin.GPIO_25;
			break;

		case 26:
			pin = RaspiPin.GPIO_26;
			break;

		case 27:
			pin = RaspiPin.GPIO_27;
			break;

		case 28:
			pin = RaspiPin.GPIO_28;
			break;

		case 29:
			pin = RaspiPin.GPIO_29;
			break;

		case 30:
			pin = RaspiPin.GPIO_30;
			break;

		case 31:
			pin = RaspiPin.GPIO_31;
			break;
		default:
			throw new IllegalArgumentException("i est pas compris entre 1 a 31 ");
		}
		return pin;
	}

}
