import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//Jednostavna binarna pretraga niza.
//Popravi kad budes imao vremena rekurzivnu pretragu koja baca stack overflow kada ne nadje element.
//Isto nadji pravo resenje a ne hack za iterativnu kada ne nadje element.
//DK

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Jel zelis iz 1.fajla(Mora biti sortiran) ili iz 2.konzole i 3.Pretvori nesortirani fajl u sortiran fajl.");


        int izbor = scan.nextInt();

        ArrayList UcitanNiz;
        if (izbor == 1) {
            UcitanNiz = ReadFromFile();

            System.out.println("Unesi broj koji trazis:");
            int broj = scan.nextInt();

            Integer[] NoviNiz = new Integer[UcitanNiz.size()];
            UcitanNiz.toArray(NoviNiz);

            int intniz[] = Arrays.stream(NoviNiz).mapToInt(Integer::intValue).toArray();

            int SortiranNiz[] = Sort(intniz);
            IterativeBinarySearch(SortiranNiz, SortiranNiz.length, 0, broj);
        } else if (izbor == 2) {


            System.out.println("Unesite velicinu niza:");

            int n = scan.nextInt();

            int[] niz = new int[n];

            System.out.println("Unesi broj u niz:");
            for (int i = 0; i < n; i++) {
                int k = scan.nextInt();
                niz[i] = k;
            }
            System.out.println("Unesi broj koji trazis:");
            int broj = scan.nextInt();


            int[] SortiranNiz = Sort(niz);

            System.out.println("Sortiran niz:");
            for (int i = 0; i < SortiranNiz.length; i++) {
                System.out.println(SortiranNiz[i]);
            }

            IterativeBinarySearch(SortiranNiz, SortiranNiz.length, 0, broj);

        }




        }



    public static int IterativeBinarySearch(int[] Niz, int max, int min, int number) {
        int mid = (max + min) / 2;
        int p = 0;
        while (number != Niz[mid]) {
            p++;
            mid = (max + min) / 2;
            if (number == Niz[mid]) {
                mid += 1;
                System.out.println("Element se nalazi na " + mid + "." + " poziciji.");
                break;
            } else if (number < Niz[mid]) {

                max = mid;


            } else if (number > Niz[mid]) {
                min = mid;
            }
            if (p > 20) {
                System.out.println("Nema broja kojeg trazis.");
                break;
            }

        }

        return 0;
    }

    public static int BinarySearch(int[] Niz, int min, int max, int number) {

        try {
            int mid = (max + min) / 2;


            if (number == Niz[mid]) {
                mid += 1;
                System.out.println("Element se nalazi na " + mid + " poziciji.");

            } else if (number < Niz[mid]) {
                BinarySearch(Niz, min, mid, number);


            } else if (number > Niz[mid]) {
                BinarySearch(Niz, mid, max, number);
            }


        } catch (StackOverflowError e) {
            System.out.println("Ako je stack overflow u 99% slucajeva nije nasao element posto ga nema u nizu.");
        }
        return 0;
    }


    public static int[] Sort(int[] input) {
        int[] ar = input;


        int swap;
        for (int j = 0; j < ar.length - 1; j++) {

            for (int i = 0; i < ar.length - 1; i++) {
                if (ar[i] > ar[i + 1]) {
                    swap = ar[i + 1];
                    ar[i + 1] = ar[i];
                    ar[i] = swap;
                }


            }
        }
        return ar;


    }

    public static ArrayList ReadFromFile() {
        Scanner scan;
        ArrayList Niz = new ArrayList<Integer>();
        try {

            scan = new Scanner(new FileReader("brojevi.txt"));
            while (scan.hasNextInt()) {
                int broj = scan.nextInt();
                Niz.add(broj);

            }

            scan = new Scanner(new FileReader("brojevi.txt"));
            while (scan.hasNextInt()) {
                int broj = scan.nextInt();
                Niz.add(broj);


            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return Niz;
    }


}