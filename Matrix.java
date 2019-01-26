/*******************************************************************************
* Program: Matrix.java                                                         *
********************************************************************************
* Author: Sabrina Chu                                                          *
* Due Date: 10/21/2018                                                         *
* Description: Matrix class that contains mathematical methods for matrix      *
*              operations                                                      *
*******************************************************************************/
public class Matrix 
{
    private double[][] matrixArray;

    // constructor
    public Matrix(int row, int col) 
    {
        matrixArray = new double[row][col];
    }

    // overloaded constructor
    public Matrix(double arr[][]) 
    {
        int arrayRow = arr.length;
        int arraryCol = arr[0].length;

        matrixArray = new double[arrayRow][arraryCol]; //instantiates a new 2D array 

        for (int row = 0; row < arr.length; row++) 
        {
            for (int col = 0; col < arr[row].length; col++) 
            {
                matrixArray[row][col] = arr[row][col]; //copies the values from the inputted array 
            }
        }
    }

    // toString method
    public String toString() 
    {
        String result = "";

        for (int row = 0; row < this.getNumRows(); row++) 
        {
            for (int col = 0; col < this.getNumCols(); col++) 
            {
                if (col == this.getNumCols() - 1) 
                {
                    result += this.get(row + 1, col + 1);
                } else
                    result += this.get(row + 1, col + 1) + ", ";
            }
            result += "\n"; // prints a new line for the matrix
        }

        return result;
    }

    // isEqual method
    public Boolean equals(Matrix other) 
    {
        boolean isEqual = true; // first assumes the matricies are unequal

        // satisfies the condition of equal rows and cols
        if (other.getNumRows() != this.getNumRows() || other.getNumCols() != this.getNumCols())                                                                                      
        {
            return false;
        }

        for (int row = 0; row < other.getNumRows(); row++) 
        {
            for (int col = 0; col < other.getNumCols(); col++) 
            {
                //checks that all the values in the array are equal
                if (other.get(row + 1, col + 1) != this.get(row + 1, col + 1)) 
                {
                    isEqual = false;
                    break;
                }
            }
        }
        return isEqual;
    }

    // accessor
    public double get(int row, int col) 
    {
        return matrixArray[row - 1][col - 1]; // Array index starts at 0 so it's necessary to subtract 1
    }

    // mutator
    public void set(int row, int col, double value) 
    {
        matrixArray[row - 1][col - 1] = value; // Array index starts at 0 so it's necessary to subtract 1
    }

    // returns row number
    public int getNumRows() 
    {
        return matrixArray.length;
    }

    // returns column number
    public int getNumCols() 
    {
        return matrixArray[0].length;
    }

    // adds two matricies 
    public Matrix add(Matrix other) 
    {

        if (this.getNumRows() != other.getNumRows() || this.getNumCols() != other.getNumCols()) 
        {
            throw new IllegalArgumentException("Matrices do not have the same number of rows and columns");
        }

        Matrix tempMatrix = new Matrix(this.getNumRows(), this.getNumCols());

        for (int row = 0; row < other.getNumRows(); row++) 
        {
            for (int col = 0; col < other.getNumCols(); col++) 
            {
                //adds the values and places it in the new matrix
                tempMatrix.set(row + 1, col + 1, other.get(row + 1, col + 1) + this.get(row + 1, col + 1));
            }
        }
        return tempMatrix;
    }

    // subtracts two matricies
    public Matrix subtract(Matrix other) {
        if (this.getNumRows() != other.getNumRows() || this.getNumCols() != other.getNumCols()) 
        {
            throw new IllegalArgumentException("Matrices do not have the same number of rows and columns");
        }

        Matrix tempMatrix = new Matrix(this.getNumRows(), this.getNumCols());

        for (int row = 0; row < other.getNumRows(); row++) 
        {
            for (int col = 0; col < other.getNumCols(); col++) 
            {
                //subtracts the values and places it in the new matrix
                tempMatrix.set(row + 1, col + 1, this.get(row + 1, col + 1) - other.get(row + 1, col + 1));
            }
        }

        return tempMatrix;
    }

    // multiplies a matrix by a factor
    public Matrix multiply(double factor) 
    {
        Matrix tempMatrix = new Matrix(this.getNumRows(), this.getNumCols());

        for (int row = 0; row < this.getNumRows(); row++) 
        {
            for (int col = 0; col < this.getNumCols(); col++) 
            {
                // multiplies each number in the matrix by the factor 
                tempMatrix.set(row + 1, col + 1, this.get(row + 1, col + 1) * factor); 
            }
        }
        return tempMatrix;
    }

    // multiplies a matrix by another matrix
    public Matrix multiply(Matrix other) 
    {
        if (this.getNumCols() != other.getNumRows()) 
        {
            throw new IllegalArgumentException(
                    "Number of Columns in the first Matrix doesn't match the row number in the second Matrix");
        }

        Matrix tempMatrix = new Matrix(this.getNumRows(), other.getNumCols()); // creates a new matrix
        double total = 0; 

        for (int row = 0; row < this.getNumRows(); row++) // goes through the rows in "this" matrix
        {
            for (int col = 0; col < other.getNumCols(); col++) // goes through the columns in "other" matrix
            {
                total = 0; // resets the total
                for (int counter = 0; counter < this.getNumCols(); counter++) // goes through the columns in "this" matrix 
                {
                    // multiplies the numbers in the first matrix with the numbers in the second 
                    total += this.get(row + 1, counter + 1) * other.get(counter + 1, col + 1);                                                                                       
                }
                // sets the added values into the new matrix
                tempMatrix.set(row + 1, col + 1, total); 
            }
        }

        return tempMatrix;
    }

    // returns the negative matrix
    public Matrix negative() 
    {
        Matrix tempMatrix = new Matrix(this.getNumRows(), this.getNumCols());
        for (int row = 0; row < this.getNumRows(); row++) 
        {
            for (int col = 0; col < this.getNumCols(); col++) 
            {
                //multiplies all the values in the matrix by -1
                tempMatrix.set(row + 1, col + 1, -1 * this.get(row + 1, col + 1));
            }

        }
        return tempMatrix;
    }

    // shifts the numbers in the matrix 
    public Matrix transpose() 
    {
        //creates a new Matrix with the opposite dimensions 
        Matrix tempMatrix = new Matrix(this.getNumCols(), this.getNumRows()); 

        for (int row = 0; row < this.getNumRows(); row++) 
        {
            for (int col = 0; col < this.getNumCols(); col++) 
            {
                tempMatrix.set(col + 1, row + 1, this.get(row + 1, col + 1));
            }
        }

        return tempMatrix;
    }

    // return the identity of the matrix 
    public static Matrix identity(int size) 
    {
        Matrix tempMatrix = new Matrix(size, size); //creates the square matrix

        for (int row = 0; row < size; row++) 
        {
            for (int col = 0; col < size; col++) 
            {
                if (row == col) 
                {
                    //adds the ones in a diagonal
                    tempMatrix.set(row + 1, col + 1, 1);
                } 
                else
                    //places the zeros everywhere else
                    tempMatrix.set(row + 1, col + 1, 0);
            }

        }
        return tempMatrix;
    }

    // multiplies a matrix a certain amount of times
    public Matrix power(int exponent) 
    {
        if (this.getNumRows() != this.getNumCols()) {
            throw new IllegalArgumentException("Matrix is not a square");
        }

        if (exponent < 0) {
            throw new IllegalArgumentException("exponent can't be negative");
        }

        Matrix tempMatrix = new Matrix(matrixArray);

        if (exponent == 0) 
        {
            return identity(this.getNumCols());
        } 
        else if (exponent == 1) 
        {
            //returns the newly created Matrix that is a copy of matrixArray
            return tempMatrix;
        }

        //runs until the exponental value is reached
        for (int i = 1; i < exponent; i++) 
        {
            //uses the multiply method to multiply the matricies
            tempMatrix = tempMatrix.multiply(this);
        }

        return tempMatrix;

    }

}