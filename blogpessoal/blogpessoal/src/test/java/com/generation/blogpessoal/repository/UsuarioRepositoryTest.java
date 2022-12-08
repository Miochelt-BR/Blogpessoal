package com.generation.blogpessoal.repository;


import com.generation.blogpessoal.model.Usuario;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeAll
    void start(){

        usuarioRepository.deleteAll();
        usuarioRepository.save(new Usuario(0L, "Weden o ninja", "weden@gmail.com", "12345678", " " ));
        usuarioRepository.save(new Usuario(0L, "EduRachaElenco", "Edu@gmail.com", "12345678", " " ));
        usuarioRepository.save(new Usuario(0L, "Batomzim", "Batomzim@gmail.com", "12345678", " " ));
        usuarioRepository.save(new Usuario(0L, "Gabriel o primeiro", "GabrielElPrimieri@gmail.com", "12345678", " " ));
    }

    @Test
    @DisplayName("Retorna 1 usuario")
    public void deveRetornarUmUsuario(){

        Optional<Usuario> usuario = usuarioRepository.findByUsuario("weden@gmail.com");

        assertTrue(usuario.get().getUsuario().equals("weden@gmail.com"));
    }

    @Test
    @DisplayName("Retorna 4 usuarios")
    public void deveRetornarTresUsuarios(){

        List<Usuario> listadeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Batomzim");

        assertEquals(4, listadeUsuarios.size());

        assertTrue(listadeUsuarios.get(0).getNome().equals("Weden o ninja"));
        assertTrue(listadeUsuarios.get(1).getNome().equals("EduRachaElenco"));
        assertTrue(listadeUsuarios.get(2).getNome().equals("EduRachaElenco"));
        assertTrue(listadeUsuarios.get(3).getNome().equals("Batomzim"));

    }


    @AfterAll
    public void end(){
        usuarioRepository.deleteAll();
    }


}
