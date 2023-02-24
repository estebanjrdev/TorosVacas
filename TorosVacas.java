package torosvacas;

import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class TorosVacas {
    
    public static LinkedList<Integer> list = new LinkedList<>();
    public static LinkedList<Integer> list2 = new LinkedList<>();
    static int intentos = 1;

    public void ejemplo(){
        System.out.println("Probando Github.dev");
        // comentario
    }

    public static void main(String[] args) {
        String numAleatorio = generador();
        Scanner sc = new Scanner(System.in);
        System.out.println(numAleatorio);
        System.out.println("Entre un numero de 4 digitos");
        String numEntrado = sc.nextLine();
        TOROVACA(numAleatorio, numEntrado);
        while (list.size() != 4) {
            System.out.println("Entre un numero de 4 digitos");
            intentos++;
            TOROVACA(numAleatorio, sc.nextLine());
        }
    }

    public static boolean estan(String num1, char num2) {
        boolean ver = false;
        char[] arr1 = num1.toCharArray();
        for (int i = 0; i < num1.length(); i++) {
            if (arr1[i] == num2) {
                ver = true;
            }
        }
        return ver;
    }

    public static void TOROVACA(String num1, String num2) {
        LinkedList<Boolean> vaca = new LinkedList<>();
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                list.add(i);
            }
        }

        for (int i = 0; i < arr1.length; i++) {
            boolean estan = estan(num1, arr2[i]);
            vaca.add(estan);
        }

        for (int i = 0; i < vaca.size(); i++) {
            boolean difer = difer(list, i);
            if (vaca.get(i) == true && difer == false) {
                list2.add(i);
            }
        }
        String toros = Integer.toString(list.size());
        String vacas = Integer.toString(list2.size());

        if (list.size() != 4) {
            System.out.println(toros + " Toros" + " " + vacas + " Vacas");
            list.clear();
            list2.clear();
        } else {
            System.out.println("!!!FELICIDADES HA GANADO EN " + intentos + " !!!");
            System.out.println("EL NUMERO ES " + num1);
        }

    }

    public static boolean difer(LinkedList<Integer> nom, int num) {
        boolean ver = false;
        for (int i = 0; i < nom.size(); i++) {
            if (nom.get(i) == num) {
                ver = true;
            }
        }
        return ver;
    }

    public static String generador() {
        String cad = new String();
        Random rm = new Random();
        int t = 0;
        int n = 10;
        int numeros[] = new int[10];
        int resutaldo[] = new int[4];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = i;
        }
        for (int i = 0; i < 4; i++) {
            t = rm.nextInt(n);
            resutaldo[i] = numeros[t];

            for (int j = t; j < numeros.length - 1; j++) {
                numeros[j] = numeros[j + 1];
            }
            n--;
        }
        for (int i = 0; i < resutaldo.length; i++) {
            String str = Integer.toString(resutaldo[i]);
            cad += str;
        }
        return cad;
    }

    // probando
}
