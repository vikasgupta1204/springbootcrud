package io.github.jiangdequan;

public class Test {
    public static void main(String[] args) {
    int arr[][]=new int[10][15];
    for(int i=0;i<arr.length;i++)
    {
        for(int j=0;j<arr[0].length;j++){
            System.out.println(i+" "+j);
        }
    }
    }
}