package org.Aston.hw1_CustomArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;

public class CustomArrayList<E> {
    private int size = 0;
    private Object[] array;
    private Comparator<? super E> c;

    public CustomArrayList() {
        array = new Object[10];
    }

    public CustomArrayList(int capacity) {
        array = new Object[capacity];
    }

    public boolean add(E element) {
        if (array.length == size) {
            expand(0);
        }
        array[size] = element;
        size++;
        return true;
    }

    public boolean add(int index, E element) {
        checkIndex(index);
        if (index == size) return add(element);
        size++;
        Object[] arr = new Object[array.length];
        System.arraycopy(array, 0, arr, 0, index);
        System.arraycopy(array, index, arr, index + 1, size - index);
        array = arr;
        array[index] = element;
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int s = a.length;
        if (s == 0) return false;
        expand(s);
        System.arraycopy(a, 0, array, size, s);
        size += s;
        return true;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public E get(int index) {
        checkIndex(index);
        return (E) array[index - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(int index) {
        checkIndex(index);
        E element = (E) array[index];
        Object[] arr = new Object[array.length];
        System.arraycopy(array, 0, arr, 0, index);
        System.arraycopy(array, index + 1, arr, index, size - index);
        size--;
        array = arr;
        return element;
    }

    public E remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return remove(i);
            }
        }
        System.out.println("This element doesn't exist");
        return null;
    }

    public void sort(Comparator<? super E> c) {
        this.c = c;
        mergeSort((E[]) array, size);
        this.c = null;
    }

    private void mergeSort(E[] array, int size) {
        if (size < 2) return;
        int middle = size / 2;
        E[] left = (E[]) new Object[middle];
        E[] right = (E[]) new Object[size - middle];
        System.arraycopy(array, 0, left, 0, middle);
        if (size - middle >= 0) System.arraycopy(array, middle, right, 0, size - middle);
        mergeSort(left, middle);
        mergeSort(right, size - middle);

        merge(array, left, right, middle, size - middle);
    }

    private void merge(E[] array, E[] l, E[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (c.compare(l[i], r[j]) <= 0) {
                array[k++] = l[i++];
            } else {
                array[k++] = r[j++];
            }
        }
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(array).filter(Objects::nonNull).toArray());
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index must be more than zero and less than or equal to list size: " + size);
        }
    }

    private void expand(int min) {
        min += 5;
        Object[] arr = new Object[size + min];
        System.arraycopy(array, 0, arr, 0, size);
        array = arr;
    }
}
