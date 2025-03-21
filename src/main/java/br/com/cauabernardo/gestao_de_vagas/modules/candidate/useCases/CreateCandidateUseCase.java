package br.com.cauabernardo.gestao_de_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cauabernardo.gestao_de_vagas.exceptions.UserFoundExeption;
import br.com.cauabernardo.gestao_de_vagas.modules.candidate.CandidateEntity;
import br.com.cauabernardo.gestao_de_vagas.modules.candidate.controllers.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
            .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
            .ifPresent((user) -> {
                throw new UserFoundExeption();
            });
        return this.candidateRepository.save(candidateEntity);
    }

}
