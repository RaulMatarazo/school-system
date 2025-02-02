package com.api.escolaapi.funcionario;

import com.api.escolaapi.Enums.TipoEnum;
import com.api.escolaapi.repositorys.FuncionarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService implements UserDetailsService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca funcionários ativos e com o primeiro_nome correspondente ao username
        var funcionario = repository.findAllByAtivoTrue()
                .stream()
                .filter(f -> f.getEmail().equalsIgnoreCase(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("Funcionário não encontrado"));

        if (funcionario.getTipo() != TipoEnum.ADMIN){
            System.out.println("Acesso negado!");
            throw new UsernameNotFoundException("Acesso negado: apenas administradores podem acessar");

        }

        return User.builder()
                .username(funcionario.getPrimeiro_nome())
                .password(funcionario.getSenha()) // Senha em texto puro
                .roles("ADMIN")
                .build();
    }
}

