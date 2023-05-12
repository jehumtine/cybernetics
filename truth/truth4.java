import static java.lang.System.out;
import java.util.*;

// too cohesive, little or no movement towards target

public class truth4{

	public static void main(String args[]){
	 Random random = new Random();

        double target = 75.0; // Constant target value
        double epsilon = 0.00001; // Convergence threshold

        double unit1Guess, unit2Guess, unit3Guess, unit4Guess;
        unit1Guess = random.nextDouble() * target;
        out.println("Unit 1 initial guess: " + unit1Guess);
        unit2Guess = random.nextDouble() * target;
        out.println("Unit 2 initial guess: " + unit2Guess);
        unit3Guess = random.nextDouble() * target;
        out.println("Unit 3 initial guess: " + unit1Guess);
        unit4Guess = random.nextDouble() * target;
        out.println("Unit 4 initial guess: " + unit1Guess);

        do {
            // Adjust the guesses to maintain cohesion among the units
            unit1Guess = adjustGuess(unit1Guess, unit2Guess, unit3Guess, unit4Guess, random);
            unit2Guess = adjustGuess(unit2Guess, unit1Guess, unit3Guess, unit4Guess, random);
            unit3Guess = adjustGuess(unit3Guess, unit1Guess, unit2Guess, unit4Guess, random);
            unit4Guess = adjustGuess(unit4Guess, unit1Guess, unit2Guess, unit3Guess, random);
            
            
 	    out.println("Target: " + target);
            out.println("Unit 1 guess: " + unit1Guess);
            out.println("Unit 2 guess: " + unit2Guess);
            out.println("Unit 3 guess: " + unit3Guess);
            out.println("Unit 4 guess: " + unit4Guess);
            
        } while (Math.abs(unit1Guess - target) > epsilon || Math.abs(unit2Guess - target) > epsilon ||
                Math.abs(unit3Guess - target) > epsilon || Math.abs(unit4Guess - target) > epsilon);

    }

    private static double adjustGuess(double currentGuess, double otherGuess1, double otherGuess2, double otherGuess3, Random random) {
        double adjustmentFactor = random.nextDouble() * 1; // Random adjustment factor between 0 and 0.1
        return currentGuess + adjustmentFactor * (otherGuess1 + otherGuess2 + otherGuess3 - 3 * currentGuess);
    }
}
