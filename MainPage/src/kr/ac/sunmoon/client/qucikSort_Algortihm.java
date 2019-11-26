package kr.ac.sunmoon.client;

public class qucikSort_Algortihm {

	static int i=0;
    static int size;

    public static int partition(int[] array, int start, int end) {
        int pivot, current, Left, Right;
        i++; //���� Ƚ��
        Left = start;
        Right = end;
        pivot = (int)((start+end)/2);
        System.out.println(i+"�ܰ�: pivot="+array[pivot]);
         //1. while(L<R)�ΰ��
        while(Left<Right) {
            while((array[Left]<=array[pivot]) && (Left<=Right)) Left++;
            while((array[Right]>array[pivot]) && (Left<=Right)) Right--;
            if(Left<=Right) { 
                current = array[Left];
                array[Left] = array[Right];
                array[Right] = current;
                if(Right == pivot) { // L�� R ���Ҹ� ��ȯ�Ͽ� ��������� pivot ������ ��ġ�� ����� ���
                    for(int t=0;t<size;t++) {
                        System.out.print(array[t]+" ");
                    }
                    System.out.println();
                    return Left; // L�� Ȯ���� pivot�� ��ġ
                }
            }
        }
        //2. while(L>R)�� ���
        current = array[pivot];
        array[pivot] = array[Right];
        array[Right] = current;
        for(int t=0;t<size;t++) {
            System.out.print(array[t]+" ");
        }
        System.out.println();
        return Right;//R�� Ȯ
    }
    public static void quickSort(int[] array, int start, int end) {
        if(start<end) {
            int partition = partition(array, start, end); 
            quickSort(array, start, partition-1);// pivot�� ���� �κ����տ� ���� �� ���� ���ȣ��
            quickSort(array, partition+1, end);//pivot�� ������ �κ����տ� ���� �� ���� ���ȣ��
        }
    }
    public static void main(String[] args) {
        int[] list = {69, 10, 30, 2, 16, 8, 31, 22};
        size = list.length;
        quickSort(list, 0, size-1);
    }
 
}


