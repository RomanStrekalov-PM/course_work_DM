package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.FileManager.Mass_B; //импортируем листы из других классов
import static com.company.FileManager.Mass_A; //для возможности работы с методами
import static com.company.OperationsOnSets.result_operations;

public class Main {



    public static void main(String[] args) {
        FileManager fileManager = new FileManager(); //ссылки на классы
        OperationsOnSets operations = new OperationsOnSets();

        Scanner _scanner = new Scanner(System.in); //сканер (_ для отличия)
        ShowMenu(); //метод показа меню
        int ans = _scanner.nextInt(); //переменная для свитча

        while (ans != 0) { //пока пользователь не выйдет
            Scanner scanner = new Scanner(System.in); //зацикливаем меню

            switch (ans) { //свитч кейс
                case 1 -> { //кейс для считывания txt файла
                    System.out.println("Введите название файла");
                    String fileName = scanner.nextLine(); //считывание название файла
                    fileManager.ShowLinesFromFile(fileName); //метод
                }
                case 2 -> fileManager.Show_mas(Mass_A); //вывести на экран множество А/В
                case 3 -> fileManager.Show_mas(Mass_B);
                case 4 -> operations.Intersection(Mass_A, Mass_B); //Пересечение
                case 5 -> operations.Unification(); //Объединение
                case 6 -> operations.Difference(Mass_A, Mass_B); //Разность А \ В
                case 7 -> operations.Difference(Mass_B, Mass_A); // В \ А
                case 8 -> operations.Symmetric_difference(Mass_A, Mass_B); //симметрическая разность
                case 9 -> Show_result(); //отображение результата операций
                case 10 -> { //сохранеие листов
                    System.out.println("Введите название файла");
                    String fileName1 = scanner.nextLine(); //считываем название нового файла
                    ShowSave(); //показ подменю
                    int _ans = scanner.nextInt();
                    switch (_ans) { //выбор что сохранить
                        case 1 -> fileManager.WriteLines(Mass_A, fileName1);
                        case 2 -> fileManager.WriteLines(Mass_B, fileName1);
                        case 3 -> {
                            ArrayList<MusicalInstruments> county = new ArrayList<>(result_operations); //переопределяем HashSet
                            fileManager.WriteLines(county, fileName1); //в ArrayList для метода
                            county.clear(); //очищаем, чтобы не засорять память
                        }
                    }
                }
            }
            ShowMenu(); //вывод на экран основного меню
            ans = scanner.nextInt();
        }
    }

    public static void ShowMenu() //основное меню
    {
        System.out.println("1. Создать новое мн-во (прочитать + создать)"); //добавление
        System.out.println("2. Отобразить мн-во А"); //изменение
        System.out.println("3. Отобразить мн-во Б"); //поиск
        System.out.println("4. Найти пересечение мн-в"); //вывод
        System.out.println("5. Найти объединение мн-в"); //вывод числа записей
        System.out.println("6. Найти разность A \\ B");
        System.out.println("7. Найти разность B \\ A");
        System.out.println("8. Симметрическая разность"); //чтение из файла
        System.out.println("9. Отобразить результат посленей операции");
        System.out.println("10. Сохранить мн-во");
        System.out.println("0. Exit"); //выход
    }

    public static void ShowSave(){ //подменю для выбора сохранения
        System.out.println("1. Сохранить мн-во А");
        System.out.println("2. Сохранить мн-во B");
        System.out.println("3. Сохранить результат последней операции");
    }

    public static void ShowResultChoice(){ //подменю для возможности вывода операций по полям
        System.out.println("1. Отобразить результат полного мн-во");
        System.out.println("2. Отобразить результат по названию инструмента");
        System.out.println("3. Отобразить результат по группе");
        System.out.println("4. Отобразить результат по цене");
    }

    public static void Show_result(){ //метод для вывода на экран результата операций
        OperationsOnSets operations = new OperationsOnSets(); //доступ
        ShowResultChoice(); //вывод подменю
        Scanner scanner = new Scanner(System.in);
        int ans = scanner.nextInt();
        switch (ans) {
            case 1 -> operations.Show_mass(); //выбор как вывести результат
            case 2 -> operations.Show_mass_field_name(); //только названия
            case 3 -> operations.Show_mass_field_group(); //только по группам
            case 4 -> operations.Show_mass_field_price(); //только по цене
        }
    }
}
