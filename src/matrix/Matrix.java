package matrix;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


public class Matrix <E> implements Iterable{


    private List <List<E>> matrix;
    private int lengthX;
    private int lengthY;
    private Matrix(int lengthX, int lengthY){
        if (lengthX<1 || lengthY<1) {
            throw new ArraySizeLowerThanOneException();
        }
        matrix = new ArrayList<>();
        for (int i=0; i<lengthX; i++){
            matrix.add(new ArrayList<>(lengthY));
            for (int j=0; j<lengthY; j++){
                matrix.get(i).add(null);
            }
        }
    }

    public Matrix(E [][] array){

        this.lengthX = array.length;
        if (array.length<1 || array[0].length<1) {
            new ArraySizeLowerThanOneException().printStackTrace();
        }
        matrix = new ArrayList<>();
        this.lengthY = array[0].length;
        for (int i=0; i<array.length; i++){
            matrix.add(new ArrayList<>());
            if (this.lengthY != array[i].length){
                throw new ArrayNotRectangularException();
            }
            for (int j=0; j<array[i].length; j++){

                matrix.get(i).add(array[i][j]);
            }
        }
    }

    @Override
    public Iterator <E> iterator() {
        return new Itr();
    }
    private class Itr implements Iterator <E>{
        Iterator  <List<E>> outerIterator;
        Iterator  <E> innerIterator;
        @Override
        public boolean hasNext() {
            return innerIterator.hasNext() || outerIterator.hasNext();
        }

        @Override
        public E next() {
            if(!innerIterator.hasNext()){
                innerIterator =  outerIterator.next().iterator();
            }

            return innerIterator.next();
        }
        Itr(){
            outerIterator = matrix.iterator();
            innerIterator =  outerIterator.next().iterator();
        }

    }
    public void changeElement(int x, int y, E element){
        matrix.get(x).set(y, element);
    }
    public void print(){
        for (List list : matrix){
            System.out.println(list);
        }
    }
    public Matrix add(Matrix anotherMatrix){
        if (this.lengthX!= anotherMatrix.lengthX || this.lengthY!= anotherMatrix.lengthY){
            throw new DifferentSizesException(this.lengthX, this.lengthY, anotherMatrix.lengthX, anotherMatrix.lengthY);
        }
        if (!this.iterator().next().getClass().equals(anotherMatrix.iterator().next().getClass())){ //mismatch of matrixes types
            throw new ClassCastException();
        }
        Matrix returnedMatrix = new Matrix(this.lengthX, this.lengthY);
        Iterator <E> iteratorThis = this.iterator();
        Iterator <E> iteratorAnotherMatrix = anotherMatrix.iterator();
        for (int i=0; i<this.lengthX; i++){
            for (int j=0; j<this.lengthY; j++){
                if (this.matrix.get(0).get(0) instanceof BigDecimal){
                    BigDecimal t1 = (BigDecimal) iteratorThis.next();
                    t1=t1.add((BigDecimal) iteratorAnotherMatrix.next());
                    returnedMatrix.changeElement(i, j,t1);
                }
                else if (this.matrix.get(0).get(0) instanceof BigInteger){
                    BigInteger t1 = (BigInteger) iteratorThis.next();
                    t1=t1.add((BigInteger) iteratorAnotherMatrix.next());
                    returnedMatrix.changeElement(i, j,t1);
                }
                else if (this.iterator().next() instanceof  String){
                    returnedMatrix.changeElement(i,j,(String)iteratorThis.next()+iteratorAnotherMatrix.next());
                }
                else if (this.iterator().next() instanceof  Number){
                    returnedMatrix.changeElement(i,j, (Double) iteratorThis.next() + (Double) iteratorAnotherMatrix.next());
                }
                else throw new IllegalArgumentException("Adding only subclasses of Number and String is supported; you tried to add "
                            + this.iterator().next().getClass());
            }
        }
        return returnedMatrix;
    }
}
