package com.slyfox.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.slyfox.dao.IProduitRepository;
import com.slyfox.dtos.transformers.EmbarqueTransformer;
import com.slyfox.embarque.Embarque;
import com.slyfox.entities.Produit;
import com.slyfox.services.embarque.IEmbarqueService;

@RestController
public class CatalogueController {

	@Autowired
	private IProduitRepository produitRespository;
	@Autowired
	private IEmbarqueService embarqueServiceImpl;
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	@RequestMapping("/save")
	public Produit saveProduit(Produit p){
		produitRespository.save(p);
		return p;
	}
	@RequestMapping("/all")
	public List<Produit> getProduits(){
		return produitRespository.findAll();
	}
	@RequestMapping("/produits")
	public Page<Produit> getProduits(int page){
		return produitRespository.findAll(new PageRequest(page, 5));
	}
	@RequestMapping("/produitsParMC")
	public Page<Produit> getProduits(String mc, int page){
		return produitRespository.produitParMC("%"+mc+"%", new PageRequest(page, 5));
	}
	@RequestMapping("/ToggleOutput")
	public void ToggleOutput(int pin, int resistance){
		embarqueServiceImpl.ToggleOutput(pin, resistance);
	}
	@RequestMapping("/PulseOutput")
	public void PulseOutput(int pin, int resistance,int num, boolean etat){
		embarqueServiceImpl.PulseOutput(pin, resistance, num, etat);
	}
	@RequestMapping("/LowOutput")
	public void LowOutput(int pin, int resistance){
		embarqueServiceImpl.LowOutput(pin, resistance);
	}
	@RequestMapping("/get")
	public Produit getProduits(Long ref){
		return produitRespository.findOne(ref);
	}
	@RequestMapping("/delete")
	public boolean delete(Long ref){
		produitRespository.delete((ref));
		return true ;
	}
	@RequestMapping("/update")
	public Produit update(Produit p){
		produitRespository.saveAndFlush(p);
		return p;
	}
}
