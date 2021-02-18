import javax.swing.plaf.nimbus.State;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskFirst {
    public static String flag="главную";

    public static void main(String[] args) {
           menu();

    }

    public static int menu(){
        Scanner in = new Scanner(System.in);
        start_title();
        int n=0;
        int action =  0;
        int [][] array= new int [n][n];
        try {
            do {
                action = in.nextInt();
                switch (action) {
                    case 1: n = size_array();break;
                    case 2: array = input_arrays(n);break;
                    case 3: output_arrays(array);break;
                    case 4: summarize_count(array);break;
                    case 5: changing_diagonal(array);break;
                    case 6: System.exit(0);break;
                    default: System.out.println("Ошибка! Вы ввели число, которого нет в меню.");
                        break;
                }
                start_title();
            } while (action != 6);
        }catch (InputMismatchException e){
            System.out.println("Вы ввели число не принадлежащее натуральным числам! ");
            menu();
        }

        return  action;
    }
    public static int size_array() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер n матрицы B(n,n): ");
        int n = in.nextInt();
        if (n < 0) {
            System.out.println("Введено отрицательное значение!");
            menu();
        }
            return n;
    }

    public static int[][] input_arrays(int n){
        Scanner in = new Scanner(System.in);
        int [][] array =new int [n][n];
        if (n>0) {
            System.out.printf("Введите значения матрицы B(%d,%d): \n", n, n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j]  = in.nextInt();
                }
            }
        }else if(n==0) {
            System.out.printf("Размер матрицы = %d, потому ввод значений не возможен!\n", n);
        }
        return array;
    }

    public static int [][] output_arrays( int [][] array){
        if(array.length>0){
        System.out.println("Ваша матрица:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(" " + array[i][j] + " "); //вывод элемента
            }
            System.out.println();
        }}else if(array.length==0)System.out.println("Размер матрицы = 0, потому вывод матрицы не возможен! ");
        //System.out.println(Arrays.deepToString(array));
        return array;
    }

    public  static double summarize_count(int [][] array){
        int sum = 0, count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if(i!=j) {

                    if (is_prime_number(array[i][j]) && array[i][j]!=1) {
                        sum += array[i][j];
                        count++;

                    }
                }
            }

        }
        System.out.printf("Сумма простых чисел: %d " +
                "\nКолличество простых чисел: %d \n", sum, count);
       return sum;
    }


    public static int[][] changing_diagonal(int [][] array){
        int tmp =0;
        int n =array.length;


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length/2; j++) {

                tmp = array[i][j];
                array[i][j] = array[i][array.length-j-1];
                array[i][array.length-j-1]= tmp;


            }
        }
        if (flag=="главную") flag="побочную";
        else flag="главную";
        System.out.printf("Диагональ изменена на %s!\n",flag);
        output_arrays(array);

        return array;
    }

    public static boolean is_prime_number(int number){
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;

    }
    public static void start_title(){
        System.out.printf("МЕНЮ: " +
                "\n1-задать размер массива " +
                "\n2-ввести элементы массива" +
                "\n3-вывести элементы массива" +
                "\n4-найти колличество и сумму простых чисел массива расположенные вне %.2s. диагонали" +
                "\n5-поменять диагональ" +
                "\n6-выход" +
                "\nВаш выбор: ", flag);

    }

}
