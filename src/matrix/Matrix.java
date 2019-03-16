package matrix;
import java.lang.reflect.Array;
import java.util.*;


public class Matrix <E extends  Number> implements Iterable{


    private List <List<Number>> matrix;
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

    public Matrix(Number [][] array){

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
    public Iterator <Number> iterator() {
        return new Itr();
    }
    private class Itr implements Iterator <Number>{
        Iterator  <List<Number>> outerIterator;
        Iterator  <Number> innerIterator;
        @Override
        public boolean hasNext() {
            return innerIterator.hasNext() || outerIterator.hasNext();
        }

        @Override
        public Number next() {
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
    private double add(E e1, E e2){
        return e1.doubleValue();
    }
    public Matrix add(Matrix anotherMatrix){
        if (this.lengthX!= anotherMatrix.lengthX || this.lengthY!= anotherMatrix.lengthY){
            throw new DifferentSizesException(this.lengthX, this.lengthY, anotherMatrix.lengthX, anotherMatrix.lengthY);
        }

        Matrix returnedMatrix = new Matrix(this.lengthX, this.lengthY);
        Iterator <Number> iteratorThis = this.iterator();
        Iterator <Number> iteratorAnotherMatrix = anotherMatrix.iterator();
        for (int i=0; i<this.lengthX; i++){
            for (int j=0; j<this.lengthY; j++){
                returnedMatrix.changeElement(i, j, iteratorThis.next().doubleValue()+ iteratorAnotherMatrix.next().doubleValue());
            }
        }
        return returnedMatrix;
    }
}
