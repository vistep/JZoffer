package JZoffer;

public class problem11 {
	
	public static double power(double base, int exponent) {
		if (base == 0) {
			return 0;
		}
		if (exponent < 0) {
			return 1/powerCore(base, -1*exponent);
		} else {
			return powerCore(base, exponent);
		}
	}
	
	public static double powerCore(double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		double result = powerCore(base, exponent >> 1);
		result *= result;
		if ((exponent & 0x1) == 1) {
			result *= base;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(power(4,5));
		System.out.println(power(-4,5));
		System.out.println(power(4,0));
		System.out.println(power(4,-5));
		System.out.println(power(0,5));
		System.out.println(power(-4,-5));
		

	}

}
