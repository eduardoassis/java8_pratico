package capitulo3;

import models.Usuario;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class InterfacesFuncionais {

    public static void main(String ... args) {
        interfaceConsumer();
        minhaInterfaceFuncional();
        acessaVariaveisFinaisViaLambda();
    }

    private static void interfaceConsumer() {
        Usuario	user1 = new Usuario("Paulo	Silveira",	50);
        Usuario	user2 = new Usuario("Rodrigo	Turini",	20);
        Usuario	user3 = new Usuario("Guilherme	Silveira",	29);

        List<Usuario> usuarios = Arrays.asList(user1, user2, user3);

        Consumer<Usuario> imprimiNome = new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getNome());
            }
        };

        usuarios.forEach(imprimiNome);

        System.out.println("-----------------------");

        usuarios.forEach(new Consumer<Usuario>() {
            @Override
            public void accept(Usuario usuario) {
                System.out.println(usuario.getIdade());
            }
        });

        System.out.println("-----------------------");

        usuarios.forEach(usuario -> System.out.println(usuario.getNome()));
    }

    private static void minhaInterfaceFuncional(){
        Validator<String> validadorCEP = new Validator<String>() {
            @Override
            public boolean valida(String valor) {
                return valor.matches("[0-9]{5}-[0-9]{3}");
            }
        };

        System.out.println("Válido: " + validadorCEP.valida("05541-030"));

        validadorCEP = cep -> cep.matches("[0-9]{5}-[0-9]{3}");
        System.out.println("Válido: " + validadorCEP.valida("05541-030"));

        Runnable o = () -> {
          System.out.println("Test");
        };

        System.out.println(o);
        System.out.println(o.getClass());
    }

    private static void acessaVariaveisFinaisViaLambda() {
        final int variavelFinal = 5;
        new Thread(() -> System.out.println(variavelFinal)).start();

        int numero = 8;
        new Thread(() -> System.out.println(numero)).start();

        // Também é possível o acesso de variáveis que não são finais, no entanto não deve ser alterado o valor da mesma no método,
        // ou seja, a varíavel deve ser efetivamente final
//        numero = 9;

    }
}

@FunctionalInterface
interface Validator<T> {
    boolean valida(T t);
}