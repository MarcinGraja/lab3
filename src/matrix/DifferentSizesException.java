package matrix;

public class DifferentSizesException extends RuntimeException {
    int matrixSizeX;
    int matrixSizeY;
    int anotherMatrixSizeX;
    int anotherMatrixSizeY;
    DifferentSizesException(int matrixSizeX, int matrixSizeY, int anotherMatrixSizeX, int anotherMatrixSizeY){
        this.matrixSizeX = matrixSizeX;
        this.matrixSizeY = matrixSizeY;
        this.anotherMatrixSizeX = anotherMatrixSizeX;
        this.anotherMatrixSizeY = anotherMatrixSizeY;
    }
    @Override
    public String toString(){
        return "DifferentSizesException: this.sizeX: \t" + this.matrixSizeX + "\tthis.sizeY: \t" + this.matrixSizeY +
                "\nDifferentSizesException: anotherMatrix.sizeX: \t" + this.anotherMatrixSizeX + "\tAnotherMatrix.sizeY:\t" + anotherMatrixSizeY;
    }
}
