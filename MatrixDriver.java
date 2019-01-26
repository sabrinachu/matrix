/*******************************************************************************
* Program: MatrixDriver.java                                                   *
********************************************************************************
* Author: Sabrina Chu                                                          *
* Due Date: 10/21/2018                                                         *
* Description: Driver class to test Matrix class                               *
*******************************************************************************/
public class MatrixDriver
{
  public static void main(String [] args)
  {
    double[][] t1 = {
      {1,2,3},
      {4,5,6},
      {7,8,9},
    };

    double[][] t2 = {
      {1,2,3},
      {4,8,5},
      {2,4,6},
    };

    // test data set for nonsquare matricies
    // double[][] t1 = {
    //   {1,2,3},
    //   {4,5,6},
    // };

    // double[][] t2 = {
    //   {1,2,3},
    //   {4,8,5},
    // };

    
    Matrix m1 = new Matrix(t1);
    Matrix m2 = new Matrix(t2);
    
    //tests the methods
    System.out.println("matrix 1: \n" + m1); 
    System.out.println("matrix 2: \n" + m2); 
    System.out.println("get: " + m1.get(2,3) + "\n");
    System.out.println("is equal or not: " + m1.equals(m2) + "\n");
    System.out.println("add: \n" + m1.add(m2));
    System.out.println("subtract: \n" + m1.subtract(m2));
    System.out.println("multiply by factor: \n" + m1.multiply(2));
    System.out.println("multiply by other matrix: \n" + m1.multiply(m2)); 
    System.out.println("negative matrix: \n" + m1.negative());
    System.out.println("matrix transpose: \n" + m1.transpose()); 
    System.out.println("matrix identity: \n" + Matrix.identity(2));
    System.out.println("power: \n" + m1.power(2));

  }
  
}
