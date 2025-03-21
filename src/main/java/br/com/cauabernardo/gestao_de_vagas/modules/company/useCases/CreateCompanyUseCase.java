package br.com.cauabernardo.gestao_de_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cauabernardo.gestao_de_vagas.exceptions.UserFoundExeption;
import br.com.cauabernardo.gestao_de_vagas.modules.company.entities.CompanyEntity;
import br.com.cauabernardo.gestao_de_vagas.modules.company.repository.CompanyRepository;

@Service
public class CreateCompanyUseCase {
    
    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {

        this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent((user) -> {
            throw new UserFoundExeption();
        });

        return this.companyRepository.save(companyEntity);
    }
}
