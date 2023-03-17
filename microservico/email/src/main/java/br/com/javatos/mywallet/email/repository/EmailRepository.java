package br.com.javatos.mywallet.email.repository;

import br.com.javatos.mywallet.email.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
