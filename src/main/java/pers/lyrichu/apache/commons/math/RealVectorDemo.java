package pers.lyrichu.apache.commons.math;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class RealVectorDemo {
    public static void main(String[] args) {
        int size = 3;
        double defaultValue = 1.2;// 默认值
        RealVector rv1 = new ArrayRealVector(size,defaultValue);
        rv1.setEntry(0,1.1);
        double[] data = {2.3,3.1,3.7};
        RealVector rv2 = new ArrayRealVector(data);
        System.out.println(rv1);
        System.out.println(rv2);
        // 创建一个matrix
        double[][] mData = {{1.1,2.2,3.3},{2.2,4.2,6.3},{3.3,5.4,7.1}};
        RealMatrix matrix = new Array2DRowRealMatrix(mData);
        System.out.println("matrix[0][1]:"+matrix.getEntry(0,1));
        System.out.println("matrix size:"+matrix.getRowDimension()+"*"+matrix.getColumnDimension());
        // matrix 设置default value
        int row = 3;
        int col = 5;
        double mDefault = 10;
        RealMatrix matrix1 = new Array2DRowRealMatrix(row,col);
        matrix1 = matrix1.scalarAdd(mDefault);
        System.out.println("matrix1:");
        for(int i = 0;i<matrix1.getRowDimension();i++){
            for(int j = 0;j<matrix1.getColumnDimension();j++){
                System.out.print(matrix1.getEntry(i,j)+"\t");
            }
            System.out.println();
        }

    }
}
