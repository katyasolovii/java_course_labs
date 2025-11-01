package hw07;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;

public class t07_01 {

    /*
    Створити бінарний файл F, компонентами якого є дійсні числа.
    Описати функцію, що зчитує масив дійсних чисел з цього файлу.
    Побудувати файл G, який містив би всі компоненти файлу F, що більші за задане число a.
    Порядок чисел має зберігатись.
    */
    public static void main(String[] args) {
        String inp = "/Users/katyasolovii/Documents/univer/3course/java/hw07/input.double64";
        String out = "/Users/katyasolovii/Documents/univer/3course/java/hw07/output.double64";

        double[] array = {2.5, -1.3, 0.0, 10.2, 5.5, 3.14, 8.9};
        double a = 3.1; 

        write(inp, array);
        array = read(inp);
        System.out.println("Файл F: " + Arrays.toString(array));

        var lst = new ArrayList<Double>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > a) {
                lst.add(array[i]);
            }
        }

        writeWithByteBuffer(out, lst);
        double[] res = readWithByteBuffer(out);
        System.out.println("res: " + Arrays.toString(res));
    }

    public static double[] read(String inp) {
        double[] result;
        try {
            var finp = new DataInputStream(
                new FileInputStream(inp)
            );
            int count = (int) (new File(inp).length() / Double.BYTES);
            result = new double[count];
            for (int i = 0; i < count; i++) {
                result[i] = finp.readDouble();
            }
            finp.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void write(String out, double[] array) {
        try {
            var fout = new DataOutputStream(new FileOutputStream(out));
            for (int i = 0; i < array.length; i++) {
                fout.writeDouble(array[i]);
            }
            fout.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static double[] readWithByteBuffer(String inp) {
        double[] result;
        try {
            var finp = new FileInputStream(inp);
            ByteBuffer bb = ByteBuffer.wrap(finp.readAllBytes());
            result = new double[bb.capacity() / Double.BYTES];
            for (int i = 0; i < result.length; i++) {
                result[i] = bb.getDouble();
            }
            finp.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void writeWithByteBuffer(String out, ArrayList<Double> lst) {
        try {
            var fout = new FileOutputStream(out);
            ByteBuffer bb = ByteBuffer.allocate(lst.size() * Double.BYTES);
            for (int i = 0; i < lst.size(); i++) {
                bb.putDouble(lst.get(i));
            }
            fout.write(bb.array());
            fout.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

