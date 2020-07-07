package com.frame.lib.sparsearray;

public class SparseArray {
    public static void main(String[] args) {

//        //一维数组初始化方式
//        int[] arr = {1,2,3,4} ;
//        int[] arr1 = new int[]{1,2,3,4} ;
//        int[] arr2 = null;
//        arr2 = new int[1] ;
//
//        //二维数组
//        int[][] arr3 =
//                {
//                        {1,2,3},
//                        {4,5,6},
//                        {7,8,9},
//                        {10,11,12}
//                } ;
//        System.out.println(arr3[1][2]);
//        System.out.println("数组的长度(有几行）:"+arr3.length);
//        System.out.println("数组的列数(i.length):"+arr3[0].length);
//
//        for (int i = 0;i <arr3.length;i++){
//            for (int j = 0;j<arr3[i].length;j++){
//                System.out.printf("%d\f",arr3[i][j]);
//            }
//            System.out.println("");
//        }


        //创建一个原始数组11*11
        //0：表示没有棋子，1表示 黑子 2表示蓝子
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 4;
        //输出原始数组
        System.out.println("原始的二位数组:");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\f", data);
            }
            System.out.println("");
        }
        //将二维数组转换成稀疏数组
        //1.先遍历二维组，等到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }

        System.out.println("sum=" + sum);
        //2.创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //给稀疏数组赋值
        //第一行
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //二维数组的行：
        System.out.println("二维数组chessArr的行:" + chessArr.length);
        System.out.println("二维数组chessArr的列:" + chessArr[0].length);
        //遍历二维数组，将非0的值存放到稀疏数组中
        int count = 0;
        for (int i = 0; i < chessArr.length; i++) { //外部表示行
            for (int j = 0; j < chessArr[i].length; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                }
            }
        }

        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                System.out.printf("%d\f", anInt);
            }
            System.out.println("");
        }

        System.out.println("将稀疏数组恢复成原始数组");

        int[][] res = new int[sparseArray[0][0]][sparseArray[0][1]];

        for (int i = 1; i < sparseArray.length; i++) {
            int row = sparseArray[i][0];
            int column = sparseArray[i][1];
            int value = sparseArray[i][2];
            res[row][column] = value;

        }

        System.out.println("-----------------`-");

        for (int[] ints : res) {
            for (int anInt : ints) {
                System.out.printf("%d\f", anInt);
            }
            System.out.println("");
        }
    }
}