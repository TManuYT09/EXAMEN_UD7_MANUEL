package org.example.chatbot;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AppChatbot {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Chatbot: Bienvenido! Escribe <salir> cuando quieras acabar la conversación...");
        HashMap<String,String> opciones = new HashMap<>();

        opciones.put("hola","Hola, ¿En qué te puedo ayudar?");
        opciones.put("¿cómo estás?","¡Estoy listo para ayudarte!");
        opciones.put("adiós","¡Hasta luego!");
        opciones.put("gracias","¡De nada! Que tengas un buen día.");
        opciones.put("salir","¡Adiós!");
        opciones.put("null","No te entiendo :(");

        String valor;
        boolean nul;

        do {
            System.out.print("Tú: ");
            valor = entrada.nextLine();
            nul=true;

            for (Map.Entry<String,String> opcion : opciones.entrySet()){
                if (valor.equalsIgnoreCase(opcion.getKey())){
                    System.out.println("Chatbot: "+opcion.getValue());
                    nul=false;
                }
            }

            if (nul){
                System.out.println("Chatbot: "+opciones.get("null"));
            }

        }while (!valor.equalsIgnoreCase("salir"));
    }
}
