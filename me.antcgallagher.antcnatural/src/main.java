import java.util.Scanner;
import java.math.*;

public class main {

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args){
		String input;
		System.out.println("Generating required numbers...");
		System.out.println();

		BigDecimal pi = getPi();
		BigDecimal phi = getPhi();
		BigDecimal e = getE();

		System.out.println("Done.");
		System.out.println();
		System.out.println("Welcome to AntCNaturalNumbers v0.1! Calculating your favourite natural numbers to 1000 decimal places!");
		System.out.println();

		while(true){
			System.out.println("Do you want to (V)iew or (P)lay the numbers Pi, Phi and e? Or do you wish to e(X)it");
			input = sc.next();
			checkInput(input);
			while (!checkInput(input)){
				System.out.println("Input not registered, please enter V to View numbers, P to Play numbers, or X to exit.");
				input = sc.next();
			}
			if (input.equalsIgnoreCase("V")){

				viewNumbers(pi, phi, e);
			}
			else if (input.equalsIgnoreCase("P")){
				playNumbers(pi, phi, e);
			}
			else{
				break;
			}
		}

	}

	public static boolean checkInput(String input){
		if (input.equalsIgnoreCase("V") || input.equalsIgnoreCase("P") || input.equalsIgnoreCase("X")){
			return true;
		}
		return false;
	}

	public static BigDecimal getPi(){
		BigDecimal pi = BigDecimal.valueOf(3);
		BigDecimal nila, a, b, c, ab, abc;
		for (int i = 1; i <= 100000; i++){
			a = BigDecimal.valueOf(2 * i);
			b = BigDecimal.valueOf((2 * i) + 1);
			c = BigDecimal.valueOf((2 * i) + 2);
			ab = a.multiply(b);
			abc = ab.multiply(c);

			nila = BigDecimal.valueOf(4).divide(abc, 1000, RoundingMode.HALF_UP);

			checkEven(i);

			if(checkEven(i)){
				pi = pi.add(nila);
			}
			else{
				pi = pi.subtract(nila);
			}
		}
		return pi;
	}

	public static boolean checkEven(int i){
		try{
			int b = i / 2;
		}catch (Exception e) {
				return false;
			}
		return true;
	}

	public static BigDecimal getPhi(){
		BigDecimal phi = BigDecimal.ONE;
		BigDecimal rootFive = getRoot(BigDecimal.valueOf(5));
		phi = phi.add(rootFive);
		phi = phi.divide(new BigDecimal("2"));
		return phi;
	}

	public static BigDecimal getE(){
		BigDecimal e = BigDecimal.ONE;
		for (int i = 1; i < 127; i++){
			e = e.add(BigDecimal.ONE.divide(new BigDecimal(getFactorial(i)), 1000, RoundingMode.HALF_UP));
		}
		return e;
	}

	public static BigInteger getFactorial(int input){
		BigInteger fact = BigInteger.ONE;
		for (int i = 1; i <= input; i++){
			fact = fact.multiply(new BigInteger(Integer.toString(i)));
		}
		return fact;
	}

	public static BigDecimal getRoot(BigDecimal x){
		BigDecimal g = x.divide(BigDecimal.valueOf(2), 1000, RoundingMode.HALF_UP);
		boolean done = false;
		final int maxIterations = 1000;
		for (int i = 0; !done && i < maxIterations; i++) {
			BigDecimal r = x.divide(g, 1000, RoundingMode.HALF_UP);
			r = r.add(g);
			r = r.divide(BigDecimal.valueOf(2), 1000, RoundingMode.HALF_UP);
			done = r.equals(g);
			g = r;
		}
		return g;
	}

	public static void viewNumbers(BigDecimal pi, BigDecimal phi, BigDecimal e){
		System.out.println("Pi = " + pi);
		System.out.println("Phi = " + phi);
		System.out.println("E = " + e);
		System.out.println();
	}

	public static void playNumbers(BigDecimal pi, BigDecimal phi, BigDecimal e){
		String temp;
		char[] charpi;
		char[] charphi;
		char[] chare;

		temp = pi.toString();
		charpi = temp.toCharArray();
		temp = phi.toString();
		charphi = temp.toCharArray();
		temp = e.toString();
		chare = temp.toCharArray();
	}

}
