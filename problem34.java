package JZoffer;

public class problem34 {
    public int GetUglyNumber_Solution(int index) {
        if (index < 1) {
        	return 0;
        }
        int[] base = {1,2,3,4,5,6,8,9};
        if (index < 9) {
        	return base[index - 1];
        }
        //initial 
        int[] number = new int[index];
        for (int i = 0; i < 8; i++) {
        	number[i] = base[i];
        }
        int T5 = 1;
        int T3 = 3;
        int T2 = 4;
        
        //calculate
        for (int i = 8; i < index; i++) {
        	int M2 = number[T2] * 2;
        	int M3 = number[T3] * 3;
        	int M5 = number[T5] * 5;
        	int min = Math.min(Math.min(M2, M3), M5);
        	number[i] = min;
        	if (M2 == min) {
        		T2++;
        	}
        	if (M3 == min) {
        		T3++;
        	}
        	if (M5 == min) {
        		T5++;
        	}
        }
        
        return number[index - 1];
    }
}
