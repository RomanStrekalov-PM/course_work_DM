package com.company;

import java.util.ArrayList;
import java.util.HashSet;

import static com.company.FileManager.Mass_A;
import static com.company.FileManager.Mass_B;

public class OperationsOnSets {

    public static HashSet<MusicalInstruments> result_operations = new HashSet<>(); //создание коллекции
    //пользуюсь HashSet, а не ArrayList, т.к. в него нельзя добавить одинаковые объекты
    //это упрощает работу со множествами

    public void Unification(){ //объединение
        if (!CheckFullness()) { //проверка на зполненность обоих мн-в
            System.out.println("Одно из множеств пустое"); //сообщение об ошибке
            return; //выход из метода в случае незаполненности мн-в
        }
        result_operations.clear(); //очищаем от предыдущих объектов
        result_operations.addAll(Mass_A); //полностью добавляем оба множества
        result_operations.addAll(Mass_B);
    }

    public void Intersection(ArrayList<MusicalInstruments> files, ArrayList<MusicalInstruments> sets){ //пересечение
        if (!CheckFullness()) { //проверка на заполненность массивов
            System.out.println("Одно из множеств пустое");
            return; //выход из метода в случае незаполненности мн-в
        }
        result_operations.clear(); //очищаем от предыдущих объектов
        for (MusicalInstruments file : files) { //два цикла для обхода всех объектов
            for (MusicalInstruments set : sets) {
                if (file.equals(set)) { //если нашлись два одинаковых
                    result_operations.add(file); //добавляем объект
                }
            }
        }
    }

    //разность
    public void Difference(ArrayList<MusicalInstruments> reduced_value, ArrayList<MusicalInstruments> deductible){ //уменьшаемое и вычитаемое
        if (!CheckFullness()) { //проверка на заполненность массивов
            System.out.println("Одно из множеств пустое");
            return; //выход из метода в случае незаполненности мн-в
        }
        result_operations.clear(); //очищаем от предыдущих объектов
        result_operations.addAll(reduced_value); //полностью добавляем уменьшаемое
        for (MusicalInstruments reduced :reduced_value) { //цикл для обхода всех объектов
            for (MusicalInstruments deducti : deductible) {
               if(reduced.equals(deducti)){ //если нашлись два одинаковых
                   result_operations.remove(reduced); //удаляем этот обект
               }
            }
        }
    }

    //симм разность
    public void Symmetric_difference (ArrayList<MusicalInstruments> reduced_value, ArrayList<MusicalInstruments> deductible){
        if (!CheckFullness()) { //проверка на заполненность массивов
            System.out.println("Одно из множеств пустое");
            return; //выход из метода в случае незаполненности мн-в
        }
        Unification(); //сначала производим объединение обоих множеств
        for (MusicalInstruments reduced :reduced_value) { //циклы для обхода всех объектов
            for (MusicalInstruments deducti : deductible) {
                if(reduced.equals(deducti)) //если нашлись одинаковые
                    result_operations.remove(reduced); //удаляем эти объекты
                if(deducti.equals(reduced))
                    result_operations.remove(deducti);
            }
        }
    }

    public void Show_mass (){ //вывод на экран построчно полного мн-ва
        for(MusicalInstruments countrySe : result_operations){
            countrySe.show();
        }
        System.out.println(result_operations);
    }

    public void Show_mass_field_name(){ //вывод на экран построчно названия множеств
        for(MusicalInstruments countrySe : result_operations){
            System.out.println("name: " + countrySe.getName());
        }
        System.out.println(result_operations);
    }

    public void Show_mass_field_group(){ //вывод на экран построчно группы множеств
        for(MusicalInstruments countrySe : result_operations){
            System.out.println("group: " + countrySe.getGroup());
        }
        System.out.println(result_operations);
    }

    public void Show_mass_field_price(){ //вывод на экран построчно цен множеств
        for(MusicalInstruments countrySe : result_operations){
            System.out.println("price: " + countrySe.getPrice());
        }
        System.out.println(result_operations);
    }

    public boolean CheckFullness () { //функция для проверки на заполненность множества
        return Mass_A.size() != 0 && Mass_B.size() != 0; //возвращаем информацию о размерах
    }
}
