package br.com.javatos.mywallet.lancamentos.service;

import br.com.javatos.mywallet.lancamentos.model.Lancamento;
import br.com.javatos.mywallet.lancamentos.repository.LancamentosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentosService {

  private final LancamentosRepository lancamentosRepository;

  public LancamentosService(LancamentosRepository lancamentosRepository) {
    this.lancamentosRepository = lancamentosRepository;
  }

  public Lancamento salvar(Lancamento lancamento){
    return lancamentosRepository.save(lancamento);
  }

  public List<Lancamento> consultar(){
    return lancamentosRepository.findAll();
  }

  public void deletar(Long code){
    lancamentosRepository.deleteById(code);
  }
}
