package pers.lyrichu.apache.commons.math;

import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class BlockStorageDemo {
    public static void main(String[] args) {
        // 使用 block storage 存储的矩阵可以将
        // 很多大矩阵分解为小的block存储,更有效率
        RealMatrix blockMatrix = new BlockRealMatrix(100,100);
        blockMatrix = blockMatrix.scalarAdd(1);
        // copy a matrix
        RealMatrix copyMatrix = blockMatrix.copy();
        System.out.println("copyMatrix[10][10]:"+copyMatrix.getEntry(10,10));
    }
}
