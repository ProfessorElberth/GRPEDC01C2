package br.edu.infnet.apppedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.apppedido.model.domain.Solicitante;
import br.edu.infnet.apppedido.model.domain.Usuario;
import br.edu.infnet.apppedido.model.service.SolicitanteService;

@Controller
public class SolicitanteController {
	
	@Autowired
	private SolicitanteService solicitanteService;

	@GetMapping(value = "/solicitante")
	public String telaCadastro() {
		return "solicitante/cadastro";
	}
	
	@GetMapping(value = "/solicitantes")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("solicitanteLista", solicitanteService.obterLista(usuario));

		return "solicitante/lista";
	}

	@PostMapping(value = "/solicitante/incluir")
	public String incluir(Solicitante solicitante, Model model, @SessionAttribute("user") Usuario usuario){
		
		solicitante.setUsuario(usuario);

		solicitanteService.incluir(solicitante);

		model.addAttribute("mensagem", "O solicitante " + solicitante.getNome() + " foi incluído com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/solicitante/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {
		
		Solicitante solicitante = solicitanteService.obterPorId(id);
				
		if(solicitante != null) {			
			solicitanteService.excluir(id);			
			model.addAttribute("mensagem", "O solicitante "+solicitante.getNome()+" foi excluído com sucesso!!!");
		} else {
			model.addAttribute("mensagem", "Solicitante inexistente.. impossível realizar a exclusão!!!");			
		}
		
		return telaLista(model, usuario);
	}
}