package com.api.escolaapi.security;

import com.api.escolaapi.funcionario.FuncionarioClass;
import com.api.escolaapi.repositorys.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioUserDetailsService implements UserDetailsService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<FuncionarioClass> funcionarios = funcionarioRepository.findByEmail(email);

        if (funcionarios.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
        }

        // Considerando apenas o primeiro resultado da lista
        FuncionarioClass funcionario = funcionarios.get(0);
        return new FuncionarioUserDetails(funcionario);
    }
}
