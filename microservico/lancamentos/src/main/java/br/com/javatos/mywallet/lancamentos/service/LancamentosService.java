package br.com.javatos.mywallet.lancamentos.service;

import br.com.javatos.mywallet.lancamentos.model.Lancamentos;
import br.com.javatos.mywallet.lancamentos.repository.LancamentosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentosService {

  private final LancamentosRepository lancamentosRepository;

  public LancamentosService(LancamentosRepository lancamentosRepository) {
    this.lancamentosRepository = lancamentosRepository;
  }

  public void salvar(Lancamentos lancamentos){
    lancamentosRepository.save(lancamentos);
  }

  public List<Lancamentos> consultar(){
    return lancamentosRepository.findAll();
  }

  public void deletar(Long code){
    lancamentosRepository.deleteById(code);
  }
}
