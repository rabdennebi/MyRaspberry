package com.slyfox.services.embarque;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

public interface IEmbarqueService {
	void ToggleOutput(int pin, int resistance);

	void PulseOutput(int pin, int resistance, int num, boolean etat);

	void LowOutput(int pin, int resistance);

}