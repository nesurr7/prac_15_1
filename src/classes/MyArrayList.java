package classes;

import jdk.internal.util.ArraysSupport;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class MyArrayList<E> {

     //Значение по умолчанию
     private static final int DEFAULT_SIZE = 5;
     //Элементы
     private Object[] elements;
     //Массив по умолчанию присваиваемый главному
     private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
     private static final Object[] EMPTY_ELEMENTDATA = {};
     //Кол-во элементов not null
     private int countOfElements;
     MyArrayList(int initialCapacity) {
          if (initialCapacity > 0) {
               this.elements = new Object[initialCapacity];
          } else if (initialCapacity == 0) {
               this.elements = EMPTY_ELEMENTDATA;
          } else throw new IllegalArgumentException("Illegal Capacity: " +
                  initialCapacity);
     }
     MyArrayList(){
          elements = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
     }

     private void add(E e, Object[] elements, int s) {
          if (s == elements.length)
               elements = grow();
          System.out.println(elements.length);
          elements[s] = e;
          countOfElements = s + 1;
     }

//     public void ensureCapacity(int minCapacity) {
//          if (minCapacity > elements.length
//                  && !(elements == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
//                  && minCapacity <= size)) {
//               grow(minCapacity);
//          }
//     }


     public boolean add(E e) {
          add(e, elements, countOfElements);
          return true;
     }

     private Object[] grow(int minCapacity) {
          int oldCapacity = elements.length;
          if (oldCapacity > 0 || elements != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
               int newCapacity = ArraysSupport.newLength(oldCapacity, minCapacity - oldCapacity,
                       oldCapacity >> 1);
               return elements = Arrays.copyOf(elements, newCapacity);
          } else {
               return elements = new Object[Math.max(DEFAULT_SIZE, minCapacity)];
          }
     }

     private Object[] grow() {
          return grow(countOfElements + 1);
     }

     public int getCountOfElements() {
          return countOfElements;
     }

     public E get(int index) {
          Objects.checkIndex(index, countOfElements);
          return elements(index);
     }

     public int getLength() {
          return elements.length;
     }

     E elements(int index) {
          return (E) elements[index];
     }

}