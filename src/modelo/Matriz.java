/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Tiago Paiva
 */
public class Matriz<T> {

    private ArrayList<Element<T>> data; 
    private int lines,columns;

    public Matriz(int lines, int columns){
        data = new ArrayList();
        this.lines=lines;
        this.columns=columns;
    }

    public void set(int line, int column, T value){
        Element e = new Element();
        e.line=line;
        e.column=column;
        e.value = value;
        int index = data.indexOf(e);
        if (index == -1)
         data.add(e);
        else
         data.set(index,e);
    }

    public T get(int line, int column){
        Element e = new Element();
        e.line=line;
        e.column=column;
        int index = data.indexOf(e);
        if(index == -1)
         return null;
        else
         return data.get(index).value;

    }

    @Override
    public String toString() {
        return "MyMatrix{" + "data=" + data + '}';
    }


    private class Element<T>{
        int line, column;
        T value;

        @Override
        public String toString() {
            return "Element{" + "line=" + line + ", column=" + column + ", value=" + value + '}';
        }



        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Element other = (Element) obj;
            if (this.line != other.line) {
                return false;
            }
            return this.column == other.column;
        }


    }

    public static void main(String[] args) {
            Matriz m = new Matriz(10,10);
            m.set(1,1,2);
            m.set(1,3,4);
            System.out.println(m.get(1,1));
            System.out.println(m.get(1,3));  //Teste 
            System.out.println(m.get(1,6));
        }
}
