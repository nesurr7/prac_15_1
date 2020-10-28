package classes;

import java.util.Arrays;

public class MyArrayList<E> {

     //Значение по умолчанию
     private static final int DEFAULT_SIZE = 5;
     //Элементы
     private Object[] elements;
     //Массив по умолчанию присваиваемый главному
     private static final Object[] EMPTY_ELEMENTDATA = {};
     //Кол-во элементов not null
     private int countOfElements;

     MyArrayList(int initialCapacity) {
          if (initialCapacity > 0) {
               this.elements = new Object[initialCapacity];
          } else if (initialCapacity == 0) {
               this.elements = EMPTY_ELEMENTDATA;
          } else throw new IllegalArgumentException("Неверный размер: " +
                  initialCapacity);
     }

     MyArrayList() {
          elements = EMPTY_ELEMENTDATA;
     }

     public void add(E e) {
          if (countOfElements == elements.length)
               elements = grow(elements.length + 1);
          elements[countOfElements] = e;
          countOfElements += 1;
     }


     private Object[] grow(int minCapacity) {
          int oldCapacity = elements.length;
          if (oldCapacity > 0 || elements != EMPTY_ELEMENTDATA) {
               int newCapacity = oldCapacity << 1;
               return elements = Arrays.copyOf(elements, newCapacity);
          } else {
               return elements = new Object[Math.max(DEFAULT_SIZE, minCapacity)];
          }
     }

     public int getCountOfElements() {
          return countOfElements;
     }

     public E get(int index) {
          if (index > elements.length - 1 || index < 0)
               throw new IndexOutOfBoundsException("Неверный индекс");
          return (E) elements[index];
     }

     public int getLength() {
          return elements.length;
     }

     public boolean isEmpty() {
          return (countOfElements == 0);
     }

     public void clear() {
          for (int i = 0; i < countOfElements; i++) {
               elements[i] = null;
          }
     }

     public void remove(int index) {
          if (index > elements.length - 1 || index < 0)
               throw new IndexOutOfBoundsException("Неверный индекс");
          int newSize;
          if ((newSize = elements.length - 1) > index)
               System.arraycopy(elements, index + 1, elements, index, newSize - index);
          elements[newSize] = null;
          countOfElements -= 1;
     }

     public void set(int index, E e) {
          if (++countOfElements > elements.length) grow(elements.length + 1);
          System.arraycopy(elements, index, elements, index + 1, elements.length - index - 1);
          elements[index] = e;

     }

     @Override
     public String toString() {
          String finString = "";
          for (int i = 0; i < countOfElements; i++) {
               finString += (elements[i]).toString() + "\n";
          }
          return finString;
     }
}
