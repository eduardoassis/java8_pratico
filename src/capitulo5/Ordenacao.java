package capitulo5;

import models.Usuario;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

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

        System.out.println("-------------------------------------");

        // Default method sort da interface List
        usuarios.sort((o1, o2) -> o2.getNome().compareTo(o1.getNome()));

        usuarios.forEach(usuario -> System.out.println(usuario.getNome()));

        System.out.println("-------------------------------------");

        // Métodos estáticos nas interface comparator
        usuarios.sort(comparing(usuario -> usuario.getNome()));

        usuarios.forEach(usuario -> System.out.println(usuario.getNome()));

        System.out.println("-------------------------------------");
    }
}
