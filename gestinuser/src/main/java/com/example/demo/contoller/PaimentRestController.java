package com.example.demo.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Compte;
import com.example.demo.entities.Operation;
import com.example.demo.service.Ipaiment;

@RestController
public class PaimentRestController {
	@Autowired
	private Ipaiment ipaiment;
	@GetMapping("/consulterCompte/{codecp}")
	@ResponseBody
	public Optional<Compte> consulterCompter(@PathVariable("codecp")String codeCpte) {
		return ipaiment.consulterCompter(codeCpte);
	}
	@RequestMapping(value="/versement",method=RequestMethod.PUT)
	public void verser(@RequestParam  String codeCpte,@RequestParam  double montant) {
		ipaiment.verser(codeCpte, montant);
	}
	@RequestMapping(value="/reterait",method=RequestMethod.PUT)
	public void reterait(@RequestParam  String codeCpte, @RequestParam double montant) {
		ipaiment.reterait(codeCpte, montant);
	}
	@RequestMapping(value="/verement",method=RequestMethod.PUT)
	public void verement(@RequestParam String codeCpte1, @RequestParam String codeCpte2, @RequestParam double montant) {
		ipaiment.verement(codeCpte1, codeCpte2, montant);
	}
	@RequestMapping(value="/chercherOperation",method=RequestMethod.GET)
	public Page<Operation> listOperation(@RequestParam(name="codeCpte",defaultValue="")String codeCpte,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="3")int size) {
		return ipaiment.listOperation(codeCpte, page, size);
	}

	@GetMapping("/findcompte/{codecp}")
	@ResponseBody
	public Optional<Compte> findById(@PathVariable("codecp")String id) {
		return ipaiment.findById(id);
	}

}
