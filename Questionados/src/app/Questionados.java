package app;

import java.util.*;

public class Questionados {
    private List<Pregunta> preguntas = new ArrayList<>();

    public static Scanner Teclado = new Scanner(System.in);

    private int maximosPreguntasIncorrectas = 3;

    public void inicializarJuego() {
        this.inicializarCategoriaGastronomia();
        this.inicializarCategoriaFarandula();
    }

    public void inicializarCategoriaGastronomia() {
        Categoria gastronomia = new Categoria("Gastronomia", "Preguntas sobre morfi");

        Pregunta pregunta1 = new Pregunta("Cual de estos ingredientes no lleva la torta galesa?");

        pregunta1.agregarOpcion("Maizena", true);
        pregunta1.agregarOpcion("Mermelada");
        pregunta1.agregarOpcion("Whisky");

        this.preguntas.add(pregunta1);

        Pregunta pregunta2 = new Pregunta("Que es el chivito a la chanfaina?");

        pregunta2.agregarOpcion("Un chivito uruguayo", true);
        pregunta2.agregarOpcion("Es un chivito vestido de papa noel?");
        pregunta2.agregarOpcion("Una comida puntana");

        this.preguntas.add(pregunta2);

        Pregunta pregunta3 = new Pregunta("Cuanto tarda un huevo duro en hacerse?");

        pregunta3.agregarOpcion("10", true);
        pregunta3.agregarOpcion("6");
        pregunta3.agregarOpcion("20");

        this.preguntas.add(pregunta3);

    }

    public void inicializarCategoriaFarandula() {
        Categoria farandula = new Categoria("Farandula", "Preguntas sobre la tv y la vida celebrity");

        Pregunta pregunta1 = new Pregunta("Quien dijo cutu cuchillo?");

        pregunta1.agregarOpcion("Ricardo 'Comandante' Fort", true);
        pregunta1.agregarOpcion("Tinelli");
        pregunta1.agregarOpcion("El Mago sin Dientes");

        this.preguntas.add(pregunta1);

        Pregunta pregunta2 = new Pregunta("Quien dice 'para para para , explicame como si fuera un nene de 4 años'?");

        pregunta2.agregarOpcion("Denzel", true);
        pregunta2.agregarOpcion("Fantino");
        pregunta2.agregarOpcion("Ventura");

        this.preguntas.add(pregunta2);

        Pregunta pregunta3 = new Pregunta("Quien conduce Masterchef?");

        pregunta3.agregarOpcion("Del Moro", true);
        pregunta3.agregarOpcion("Marley");
        pregunta3.agregarOpcion("Carmen Barbieri");

        this.preguntas.add(pregunta3);

    }

    public void jugar() {

        this.inicializarJuego();
        //dar bienvenida
        this.imprimirBienvenida();

        int cantidadIntentosFallidos = 0;

        do {

            Pregunta pregunta = this.obtenerPreguntaRandom();

            this.imprimirPregunta(pregunta);

            int opcion = getOpcionElegida();

            if (pregunta.getOpciones().get(opcion - 1).getEsCorrecta()) {
                System.out.println("Respuesta correcta");

            } else {
                System.out.println("Respuesta incorrecta");
                cantidadIntentosFallidos++;
            }

        } while (cantidadIntentosFallidos < this.maximosPreguntasIncorrectas);

        this.chauchau();
    }

    public void imprimirBienvenida() {
        System.out.println("========================");

        System.out.println("Bienvenidas a Questionadas");
        System.out.println("========================");

    }

    public Pregunta obtenerPreguntaRandom() {

        int max = this.preguntas.size();
        int min = 1;

        int random = (int) (Math.random() * ((max - min) + 1)) + min;
        return this.preguntas.get(random - 1);
    }

    public void imprimirPregunta(Pregunta pregunta) {
        System.out.println(pregunta.getEnunciado());

        /*for (int i = 0; i < pregunta.getOpciones().size(); i++) {
            System.out.println((i + 1) + ")" + pregunta.getOpciones().get(i).getTexto());
        }*/

        int contador = 1;
        for (Respuesta opcion : pregunta.getOpciones()) {
            System.out.println(contador + ")" + opcion.getTexto());
            contador++;
        }

    }

    public int getOpcionElegida() {
        System.out.println("Ingrese el nro de respuesta elegida");
        int opcion = Teclado.nextInt();
        Teclado.nextLine();

        return opcion;
    }

    public void chauchau() {

        System.out.println("Gracias por jugar");
    }

}
