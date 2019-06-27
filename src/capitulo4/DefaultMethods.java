package capitulo4;

import models.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DefaultMethods {

    public static void main(String ... args){

        consumerMethodAndThen();
        removeIf();
    }

    private static void removeIf() {

        Usuario user1 = new Usuario("Paulo	Silveira",	50);
        Usuario	user2 = new Usuario("Rodrigo	Turini",	20);
        Usuario	user3 = new Usuario("Guilherme	Silveira",	29);

        List<Usuario> usuarios = new ArrayList<Usuario>(){{ add(user1); add(user2); add(user3); }};

        Predicate<Usuario> menorDe30Anos = usuario -> {
            Objects.requireNonNull(usuario);
            return usuario.getIdade() < 30;
        };

        usuarios.removeIf(menorDe30Anos);
        usuarios.forEach(usuario -> System.out.println(usuario.getNome() + ": " + usuario.getIdade()));
    }

    private static void consumerMethodAndThen() {

        Usuario user1 = new Usuario("Paulo	Silveira",	50);
        Usuario	user2 = new Usuario("Rodrigo	Turini",	20);
        Usuario	user3 = new Usuario("Guilherme	Silveira",	29);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Consumer<Usuario> mostraMensagem = usuario -> {
          System.out.println("Antes de imprimir os nomes");
        };

        Consumer<Usuario> imprimeNome = usuario -> {
            System.out.println(usuario.getNome());
        };

        usuarios.forEach(mostraMensagem.andThen(imprimeNome));

    }
}
