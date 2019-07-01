package capitulo5;

import models.Usuario;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ordenacao {

    public static void main(String ... args) {

        comparatorAsLambda();
    }

    private static void comparatorAsLambda() {

        Usuario user1 = new Usuario("Paulo	Silveira",	50);
        Usuario	user2 = new Usuario("Rodrigo	Turini",	20);
        Usuario	user3 = new Usuario("Guilherme	Silveira",	29);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Collections.sort(usuarios, (u1, u2) -> u1.getNome().compareTo(u2.getNome()));

        usuarios.forEach(usuario -> System.out.println(usuario.getNome()));
    }
}
