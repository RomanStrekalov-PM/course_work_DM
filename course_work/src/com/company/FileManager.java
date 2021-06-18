package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    public static ArrayList<MusicalInstruments> Mass_A = new ArrayList<>();
    public static ArrayList<MusicalInstruments> Mass_B = new ArrayList<>();

    public void ShowLinesFromFile (String fileName) { //считывание файлов
        fileName += ".txt"; //добавляем к названию расширение файла

        try (FileReader fileReader = new FileReader(fileName)) //чтение файла проверка
        {
            BufferedReader bufferedReader = new BufferedReader(fileReader); //функция чтения
            String line = bufferedReader.readLine(); //строка считывания

            Scanner scanner = new Scanner(System.in); //выбор заполнения одного из можеств
            System.out.println("1. Считать файл для мн-ва А");
            System.out.println("2. Считать файл для мн-ва Б");
            int ans = scanner.nextInt();
            System.out.println("Укажите вероятность считывания от 0 до 1"); //выбор вероятности считывания в обратном
            double check = scanner.nextDouble();
            switch (ans) {
                case 1 -> {
                    Mass_A.clear(); //чтобы при перезаписи не сохранялись прошлые объекты
                    while (line != null) //цикл пока строка не будет пустой
                    {
                        String_delimiter(Mass_A, Mass_B, line, check); //метод
                        line = bufferedReader.readLine();
                    }
                }
                case 2 -> {
                    Mass_B.clear();
                    while (line != null) //цикл пока строка не будет пустой
                    {
                        String_delimiter(Mass_B, Mass_A, line, check);
                        line = bufferedReader.readLine();
                    }
                }
            }
        }
        catch (IOException e) { //если ошибка
            System.out.println(e.getMessage());
        }

        System.out.println(); //пропуск строки
    }


    public void WriteLines(ArrayList<MusicalInstruments> lines, String fileName) //метод (список для записи, название файла для поиска)
    {
        fileName += ".txt"; //определение файла

        try (FileWriter fileWriter = new FileWriter(fileName)) //конструктор с созданием объекта
        {
            for (MusicalInstruments s : lines)
            {
                fileWriter.write(s.getName() + ", " + s.getGroup() + ", " + s.getPrice() + System.getProperty("line.separator")); //запись в файл + задача опр аргумента
            }
        }
        catch (IOException e) //если не нашел путь
        {
            System.out.println(e.getMessage()); // вывод ошибки
        }
    }

    public void String_delimiter (ArrayList<MusicalInstruments> file, ArrayList<MusicalInstruments> test, String line, double check) { //запись в мн-во А
        double random = Math.random(); //генерация рандомного числа для вероятности
        String[] arrSplit = line.split(", "); //метод разделения строки на массив
        boolean coincidence = true; //для проверки наличия объекта в другом множестве
        if (random > check) {
                for (MusicalInstruments tes : test) {
                    if (arrSplit[0].equals(tes.getName())) { //сверка объектов по имени
                        file.add(tes); //если аналогичный объект нашелся в другом мн-ве
                        coincidence = false; //делаем ложной, для проверки ниже
                        break; //выход из цикла for
                    }
                }
                if (coincidence) //если аналогичный не нашелся, создаем новый
                    file.add(new MusicalInstruments(arrSplit));
        }
    }

    public void Show_mas(ArrayList<MusicalInstruments> lines){ //отправляем сюда список который хотим отобразиить
        IsEmpty(); //проверка на пустоту
        for(MusicalInstruments line : lines ){ //цикл для всех записей
            line.show(); //
        }
        System.out.println(lines);
    }

    public void IsEmpty(){ //проверка на пустоту множеств
        if (Mass_A.size() == 0)
            System.out.println("Мн-во А пустое.");
        if (Mass_B.size() == 0)
            System.out.println("Мн-во B пустое.");
    }

}
