package br.univille.projetohotelpracachorro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projetohotelpracachorro.entity.Usuario;

@Repository
public interface UsuarioRepository 
    extends JpaRepository<Usuario,Long>{

    //Usuario findByNome(String nome);

    //select * from usuario where usuario.usuario = 'zezinho'
    Usuario findByUsuario(String nome);
    
    //select * from usuario where 
    //usuario.usuario = "zezinho" and usuario.senha = "1234"
    Usuario findByUsuarioAndSenha(String nome, String senha);

}