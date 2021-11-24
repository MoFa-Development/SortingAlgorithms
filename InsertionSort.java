import java.util.Arrays;

public class InsertionSort {
    public static void main(String args[]) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int anfang = 0;
        int ende = arr.length-1;
        int bestes = -1;
        
        System.out.println(Arrays.toString(arr));

        while(anfang != ende)
        {
            for(int i = anfang; i <= ende; i++)
            {
                if(bestes == -1 || arr[bestes] > arr[i])
                {
                    bestes = i;
                }
            }
            // Tausche besten mit Anfangselement
            int zwischenspeicher = arr[anfang];
            arr[anfang] = arr[bestes];
            arr[bestes] = zwischenspeicher;
            
            anfang += 1;
            
        }

        System.out.println(Arrays.toString(arr));
    }
}