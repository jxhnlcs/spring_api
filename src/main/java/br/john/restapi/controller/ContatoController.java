package br.john.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.john.restapi.db.ContatoDB;
import br.john.restapi.model.Contato;

@RestController
@RequestMapping("contatos")
public class ContatoController {

  @Autowired
  private ContatoDB db;

  @GetMapping
  public List<Contato> listar() {
    return db.findAll();
  }

  @PostMapping
  public Contato adicionar(@RequestBody Contato contato) {
    return db.save(contato);
  }

  @PutMapping
  public Contato alterar(@RequestBody Contato contato) {
    if (contato.getId() > 0)
      return db.save(contato);
    return null;
  }

  @DeleteMapping
  public String deletar(@RequestBody Contato contato) {
    if (contato.getId() > 0) {
      db.delete(contato);
      return "Removido com sucesso";
    }
    return "Usuário não encontrado";
  }

}
