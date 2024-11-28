package modelo;

import java.util.ArrayList;

public class Matriz<T> {

    private ArrayList<Element<T>> data;
    private int lines, columns;

    public Matriz(int lines, int columns) {
        data = new ArrayList<>(lines * columns);  // Inicializar com capacidade adequada
        this.lines = lines;
        this.columns = columns;
    }

    public void set(int line, int column, T value) {
        Element<T> e = new Element<>();
        e.line = line;
        e.column = column;
        e.value = value;

        int index = data.indexOf(e);  // Procura pelo elemento na lista
        if (index == -1) {
            data.add(e);  // Se o elemento não existe, adiciona
        } else {
            data.set(index, e);  // Se já existe, atualiza
        }
    }

    public T get(int line, int column) {
        Element<T> e = new Element<>();
        e.line = line;
        e.column = column;
        
        int index = data.indexOf(e);
        if (index == -1) {
            return null;  // Se não encontrar o elemento, retorna null
        } else {
            return data.get(index).value;  // Retorna o valor do elemento
        }
    }

    @Override
    public String toString() {
        return "Matriz{" + "data=" + data + '}';
    }

    private class Element<T> {
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
            return this.line == other.line && this.column == other.column;
        }

        @Override
        public int hashCode() {
            return 31 * line + column;  // Para garantir a comparação correta no ArrayList
        }
    }

    public static void main(String[] args) {
        Matriz<Integer> m = new Matriz<>(10, 10);  // Matriz de inteiros
        m.set(1, 1, 2);
        m.set(1, 3, 4);
        System.out.println(m.get(1, 1));  // Deve imprimir 2
        System.out.println(m.get(1, 3));  // Deve imprimir 4
        System.out.println(m.get(1, 6));  // Deve imprimir null
    }
}
