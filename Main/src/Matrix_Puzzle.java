import java.util.Random;

public class Matrix_Puzzle {
    public static void main(String[] args){
        Random random = new Random();
        int[][] arr = new int[5][5];
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                arr[i][j]=(random.nextInt(15))+1;
            }
        }
        print(arr);
        System.out.println("---------------");
        System.out.println(detectEquivalentAdjacentPairs(arr));
        checkDuplicate(arr);
        shiftRight(arr,2,3);
        print(arr);
        System.out.println("---------------");
        shiftUp(arr,3,1);
        print(arr);
        System.out.println("---------------");
        reverseRow(arr,2);
        print(arr);
        System.out.println("---------------");
        reverseColumn(arr,2);
        print(arr);
    }
    public static int detectEquivalentAdjacentPairs(int[][] arr){
        int c=0;
        for (int[] i:arr){
            for (int j=0;j<i.length-1;j++){
                if (i[j]==i[j+1]){
                    c++;
                }
            }
        }
        return c;
    }
    public static void checkDuplicate(int[][] arr){
        for (int a=1;a<=15;a++){
            int c=0;
            for (int[] i:arr){
                for (int j:i){
                    if (j==a){
                        c++;
                    }
                }
            }
            if (c>1){
                System.out.println(a+": "+c);
            }
        }
    }
    public static void shiftRight(int[][] arr, int shift, int row){
        int hold=arr[row][0];
        int hold1=0;
        int j=0;
        for (int i = 0; i<5; i++) {
            hold1=arr[row][(j+shift)%5];
            arr[row][(j+shift)%5]=hold;
            j=(j+shift)%5;
            hold=hold1;
        }
    }
    public static void shiftUp(int[][] arr, int shift, int col){
        shift=5-shift;
        int hold=arr[0][col];
        int hold1=0;
        int j=0;
        for (int i = 0; i<5; i++) {
            hold1=arr[(j+shift)%5][col];
            arr[(j+shift)%5][col]=hold;
            j=(j+shift)%5;
            hold=hold1;
        }
    }
    public static void reverseRow(int[][] arr, int row){
        int hold=arr[row][0];
        arr[row][0]=arr[row][4];
        arr[row][4]=hold;
        hold=arr[row][1];
        arr[row][1]=arr[row][3];
        arr[row][3]=hold;
    }
    public static void reverseColumn(int[][] arr, int col){
        int hold=arr[0][col];
        arr[0][col]=arr[4][col];
        arr[4][col]=hold;
        hold=arr[1][col];
        arr[1][col]=arr[3][col];
        arr[3][col]=hold;
    }
    public static void print(int[][] arr){
        for (int[] r:arr){
            for (int c:r){
                System.out.print(c+", ");
            }
            System.out.println();
        }
    }
}