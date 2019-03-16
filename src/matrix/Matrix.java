package matrix;
import java.util.*;


public class Matrix <E> implements Iterable{


    private List <List<E>> matrix;

    public Matrix(int sizeX, int sizeY){
        if (sizeX<1 || sizeY<1) {
            throw new ArraySizeLowerThanOneException();
        }

        matrix = new ArrayList<>(sizeX);
        for (List list: matrix){
            list = new ArrayList<>(sizeY);
        }
    }
    public Matrix(E [][] array){
        matrix = new ArrayList<>();
        if (array.length<1 || array[0].length<1)
            new ArraySizeLowerThanOneException().printStackTrace();

        int ySize=array[0].length;
        for (int i=0; i<array.length; i++){
            if (ySize != array[i].length){
                throw new ArrayNotRectangularException();
            }
            for (int j=0; j<array[i].length; j++){

                matrix.get(i).add(array[i][j]);
            }
        }
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }
    private class Itr implements Iterator<E>{
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        //int expectedModCount = modCount;
        @Override
        public boolean hasNext() {
            return cursor!=matrix.size()*matrix.get(0).size();
        }

        @Override
        public E next() {
            return null;
        }
    }
    public void changeElement(int x, int y, E element){
        matrix.get(x).set(y, element);
    }
    public E get(int x, int y){
        return matrix.get(x).get(y);
    }
    public void add(Matrix anotherMatrix){
        Iterator outerIterator = matrix.iterator();
        System.out.println("hi");
        while(outerIterator.hasNext()){
            System.out.println("hi");
        }
    }
}
