package com.slyfox.services.embarque.impl;


import org.springframework.stereotype.Component;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.slyfox.dtos.transformers.EmbarqueTransformer;
import com.slyfox.embarque.Embarque;
import com.slyfox.services.embarque.IEmbarqueService;

@Component
public class EmbarqueServiceImpl implements IEmbarqueService {

	public void ToggleOutput(int npin, int nresistance) {
		Pin pin=EmbarqueTransformer.IntToPin(npin);
		PinState resistance= EmbarqueTransformer.IntToPinState(nresistance);
		GpioPinDigitalOutput output = Embarque.ToggleOutput(pin,resistance );
		Embarque.shutdown();
		Embarque.unprovisionPin(output);
	}

	public void PulseOutput(int npin, int nresistance, int num, boolean etat) {
		Pin pin=EmbarqueTransformer.IntToPin(npin);
		PinState resistance= EmbarqueTransformer.IntToPinState(nresistance);
		GpioPinDigitalOutput output =Embarque.PulseOutput(pin, resistance, num,
				etat);
		Embarque.shutdown();
		Embarque.unprovisionPin(output);
	}

	public void LowOutput(int npin, int nresistance) {
		Pin pin=EmbarqueTransformer.IntToPin(npin);
		PinState resistance= EmbarqueTransformer.IntToPinState(nresistance);
		GpioPinDigitalOutput output=Embarque.LowOutput(pin,resistance);
		Embarque.shutdown();
		Embarque.unprovisionPin(output);
	}

}