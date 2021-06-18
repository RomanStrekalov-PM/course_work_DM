package com.company;

public class MusicalInstruments {

        private String name;
        private String group;
        private String price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGroup() {
            return group;
        }

        public void setGroup(String group) { this.group = group; }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        MusicalInstruments(String[] arrSplit){ //запись в список
            name = arrSplit[0];
            group = arrSplit[1];
            price = arrSplit[2];
            setGroup(group);
            setName(name);
            setPrice(price);
        }

        public void show(){ //вывод на экран мн-ва
            System.out.print("name: " + getName() + " "); //вывод записи в строчку
            System.out.print("group: " + getGroup()+ " ");
            System.out.println("price: " + getPrice() + " "); // += переход на следующую строку
        }
}
