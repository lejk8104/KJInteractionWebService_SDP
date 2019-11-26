package kr.ac.sunmoon.client;

public class qucikSort_Algortihm {

	static int i=0;
    static int size;

    public static int partition(int[] array, int start, int end) {
        int pivot, current, Left, Right;
        i++; //연산 횟수
        Left = start;
        Right = end;
        pivot = (int)((start+end)/2);
        System.out.println(i+"단계: pivot="+array[pivot]);
         //1. while(L<R)인경우
        while(Left<Right) {
            while((array[Left]<=array[pivot]) && (Left<=Right)) Left++;
            while((array[Right]>array[pivot]) && (Left<=Right)) Right--;
            if(Left<=Right) { 
                current = array[Left];
                array[Left] = array[Right];
                array[Right] = current;
                if(Right == pivot) { // L과 R 원소를 교환하여 결과적으로 pivot 원소의 위치가 변경된 경우
                    for(int t=0;t<size;t++) {
                        System.out.print(array[t]+" ");
                    }
                    System.out.println();
                    return Left; // L은 확정된 pivot의 위치
                }
            }
        }
        //2. while(L>R)인 경우
        current = array[pivot];
        array[pivot] = array[Right];
        array[Right] = current;
        for(int t=0;t<size;t++) {
            System.out.print(array[t]+" ");
        }
        System.out.println();
        return Right;//R은 확
    }
    public static void quickSort(int[] array, int start, int end) {
        if(start<end) {
            int partition = partition(array, start, end); 
            quickSort(array, start, partition-1);// pivot의 왼쪽 부분집합에 대해 퀵 정렬 재귀호출
            quickSort(array, partition+1, end);//pivot의 오른쪽 부분집합에 대해 퀵 정렬 재귀호출
        }
    }
    public static void main(String[] args) {
        int[] list = {69, 10, 30, 2, 16, 8, 31, 22};
        size = list.length;
        quickSort(list, 0, size-1);
    }
 
}


