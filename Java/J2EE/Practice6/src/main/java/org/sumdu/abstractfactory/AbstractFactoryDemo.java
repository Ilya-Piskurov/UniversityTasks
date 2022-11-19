package org.sumdu.abstractfactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        Character jsnow = new Character("John Snow", ClassAbstractFactory.getClass("Bard"));
        jsnow.talk();

        System.out.println("\nJohn Snow activated his bonus\n");
        jsnow.talk();

        System.out.println("\nJohn Snow changed his class\n\n");


        jsnow = new Character("John Snow", ClassAbstractFactory.getClass("Barbarian"));
        jsnow.talk();

        System.out.println("\nJohn Snow activated his bonus\n");
        jsnow.talk();
    }
}
