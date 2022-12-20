package principal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {

        System.out.println("\nLIST 1");
        
        List<Integer> list = Arrays.asList(3, 4, 5, 6, 7);

        Stream<Integer> s1 = list.stream().map(x -> x * 10); // CONVERTER UMA LISTA PARA STREAM PASSANDO UMA FUNCAO
        System.out.println(Arrays.toString(s1.toArray()));  // EXIBIR UMA STREAM

        Stream<String> s2 = Stream.of("Maria", "Alex", "Bob"); // CRIAR UMA STREAM 
        System.out.println(Arrays.toString(s2.toArray()));

        Stream<Integer> s3 = Stream.iterate(0, x -> x + 2).limit(10);  // CRIANDO UMA STREAM COM UMA ITERACAO DE UM TAMANHO LIMIT
        System.out.println(Arrays.toString(s3.toArray()));  

        Stream<Long> s4 = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1], p[0]+p[1]}).map(p -> p[0]); // CRIANDO UMA STREAM COM UMA ITERACAO  { frequencia de fbonaci}
        System.out.println(Arrays.toString(s4.limit(20).toArray()));


        // PIPELINE

        System.out.println("\nLIST 2");


        List<Integer> list2 = Arrays.asList(3, 4, 5, 10, 7);

        Stream<Integer> st1 = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        int sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Sum = " + sum);

        List<Integer> newList = list.stream() // CRIAR UMA LISTA PASSANDO METODO PARA VIRAR STREAM
                .filter(x -> x % 2 == 0)  // METODO PARA FILTRAR OS VALOSRES DA LISTA
                .map(x -> x * 10)   // METODO PARA PASSAR UMA FUNCAO DO QUE VAI SER FEITO COM CADA VALOR
                .collect(Collectors.toList());  // PASSANDO O STREAM PARA LISTA NOVAMENTE
        System.out.println(Arrays.toString(newList.toArray()));


    }

}