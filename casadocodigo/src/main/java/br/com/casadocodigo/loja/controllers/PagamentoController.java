package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.CarrinhoCompras;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {
	
	
	@Autowired
	private CarrinhoCompras carrinho;
	
	
	@RequestMapping(value="/finalizar", method=RequestMethod.POST)
	public ModelAndView finalizar(RedirectAttributes attributes) {
		
		System.out.println(carrinho.getTotal());
		
		attributes.addFlashAttribute("sucesso", "Pagamento Realizado com sucesso !");
		
		return  new ModelAndView("redirect:/produtos");		
	}
}
