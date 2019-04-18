/*
package com.utils.huigui;

public class Bansuijuzhen {

//原文:https://blog.csdn.net/u013547304/article/details/80378405

    */
/**如果采用无参构造，则需要通过set输入相应的矩阵
     * @param X x的矩阵
     * @param Y y的矩阵
     *//*

    public void set(double X[][], double Y[]){
        this.X = new double[X.length][X[0].length + 1];
        for(int i = 0; i < X.length; i++){
            this.X[i][0] = 1;
            for(int j = 0; j < X[0].length; j++){
                this.X[i][j + 1] = X[i][j];
            }
        }
        this.Y = Y;
    }


    */
/**求转置矩阵
     * @param A 要求解的矩阵
     * @return 转置矩阵
     *//*

    public double[][] matrix_transpoistion(double A[][]){
        int row = A.length;
        int col = A[0].length;
        double A_T[][] = new double[col][row];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                A_T[j][i] = A[i][j];
            }
        }
        return A_T;
    }


    */
/**计算相应的系数
     * @return 包含b的系数组
     *//*

    public double[] cal_coefficient(){
        int row = X.length;
        int col = X[0].length;
        //使用矩阵计算相应结果
        Matrix_cal mc = new Matrix_cal();
        //求X的转置
        double X_T[][] = mc.matrix_transpoistion(X);
        //求XT*X;
        mc.set(X_T);
        double temp[][] = mc.matrix_multriple(X);
        //求逆矩阵
        if(temp.length > 1){
            //如果X_T*X的矩阵行列数不为1
            mc.set(temp);
            temp = mc.inverse_Matrix();
        }
        else{
            //如果矩阵行列式为1，则temp不变
            temp[0][0] = 1/temp[0][0];
        }
        //求temp*X_T;
        mc.set(temp);
        temp = mc.matrix_multriple(X_T);
        //mc.show(temp);
        //求temp*Y
        mc.set(temp);
        B = mc.matrix_multriple(Y);
        return B;
    }
}



    */
/**计算逆矩阵，求逆矩阵必须是n*n，因此放在行列式中求解
     * @param A 要求解的矩阵
     * @return 逆矩阵
     *//*

    public double[][] inverse_Matrix(double A[][]){
        double result = get_Result(A);
        if(result == 0){
            System.out.println("行列式为0，不符合计算要求");
            return null;
        }
        double B[][] = new double[A.length][A.length];
        // 求伴随矩阵
        B = adjoint_Matrix(A.length);
        //求逆矩阵
        for(int i = 0; i < B.length; i++){
            for(int j = 0; j < B.length; j++){
                B[i][j] = B[i][j]/result;
            }
        }
        return B;
    }



    */
/**求伴随矩阵
     * @param length 矩阵的行数
     * @return 伴随矩阵
     *//*

    private double[][] adjoint_Matrix(int length){
        double B[][] = new double[length][length];
        //如果是二阶
        if(length == 2){
            B[0][0] = A[1][1];
            B[0][1] = - A[1][0];
            B[1][0] = - A[0][1];
            B[1][1] = A[0][0];
            return B;
        }
        double sub_A[][] = new double[length - 1][length - 1];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                //获取当前行列式对应元素的子矩阵
                sub_A = get_SubMatrix(A, i, j, A.length);
                B[j][i] = Math.pow(-1, (i + j)) * get_Result(sub_A);
            }
        }
        return B;
    }

    */
/**获取当前矩阵某个元素的子矩阵
     * @param A 当前矩阵
     * @param m 第m行
     * @param n 第n列
     * @param length 矩阵的行
     * @return 子矩阵
     *//*

    public double[][] get_SubMatrix(double A[][], int m, int n, int length){
        double B[][] = new double[length - 1][length - 1];
        int i_b = 0;
        int j_b = 0;
        for(int i = 0; i < length; i++){
            //去掉第m行元素
            if(i == m)continue;
            for(int j = 0; j < length; j++){
                //去掉第n列元素
                if(j == n)continue;
                B[i_b][j_b] = A[i][j];
                j_b++;
            }
            i_b++;
            j_b = 0;
        }
        return B;
    }


}
*/
