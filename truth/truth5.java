/***
	Jehu Mtine .N
	Monday May 8 2023
	Truth and correctness
	In the below code, the adjustments of the guesses are influenced by the target value and the guesses of other units, but the impact of other units is reduced compared to the target influence.

	The `adjustGuess` method now calculates the adjustments based on three factors:

-   `	targetInfluence` determines the influence of the target on the adjustment. It is set to 0.7, indicating a higher impact of the target compared to the other units.
-   `	otherUnitsInfluence` determines the influence of other units on the adjustment. It is set to 0.1, indicating a lower impact of other units compared to the target.
-   `	adjustmentFactor` is a random adjustment factor between 0 and 0.1, which introduces variability and exploration.

	The adjustment of each unit's guess is a combination of the target adjustment (`targetAdjustment`) and the adjustment
*/



import static java.lang.System.out;
import java.util.*;

public class truth5{

	public static void main(String args[]){
	
	Random random = new Random();

        double target = 75.0; // Constant target value
        double epsilon = 0.00001; // Convergence threshold

        double unit1Guess, unit2Guess, unit3Guess, unit4Guess;
        unit1Guess = random.nextDouble() * target;
        unit2Guess = random.nextDouble() * target;
        unit3Guess = random.nextDouble() * target;
        unit4Guess = random.nextDouble() * target;

        do {
            // Adjust the guesses based on individual exploration, influence from other units, and the target
            unit1Guess = adjustGuess(unit1Guess, unit2Guess, unit3Guess, unit4Guess, target, random);
            unit2Guess = adjustGuess(unit2Guess, unit1Guess, unit3Guess, unit4Guess, target, random);
            unit3Guess = adjustGuess(unit3Guess, unit1Guess, unit2Guess, unit4Guess, target, random);
            unit4Guess = adjustGuess(unit4Guess, unit1Guess, unit2Guess, unit3Guess, target, random);
            
        System.out.println("Target: " + target);
        System.out.println("Unit 1 guess: " + unit1Guess);
        System.out.println("Unit 2 guess: " + unit2Guess);
        System.out.println("Unit 3 guess: " + unit3Guess);
        System.out.println("Unit 4 guess: " + unit4Guess);
            
        } while (Math.abs(unit1Guess - target) > epsilon || Math.abs(unit2Guess - target) > epsilon ||
                Math.abs(unit3Guess - target) > epsilon || Math.abs(unit4Guess - target) > epsilon);

        System.out.println("Target: " + target);
        System.out.println("Unit 1 guess: " + unit1Guess);
        System.out.println("Unit 2 guess: " + unit2Guess);
        System.out.println("Unit 3 guess: " + unit3Guess);
        System.out.println("Unit 4 guess: " + unit4Guess);
    }

    private static double adjustGuess(double currentGuess, double otherGuess1, double otherGuess2, double otherGuess3,
                                      double target, Random random) {
        double adjustmentFactor = random.nextDouble() * 0.1; // Random adjustment factor between 0 and 0.1
        double targetInfluence = 0.7; // Influence of the target on the adjustment
        double otherUnitsInfluence = 0.1; // Influence of other units on the adjustment

        double targetAdjustment = targetInfluence * (target - currentGuess);
        double otherUnitsAdjustment = otherUnitsInfluence * (otherGuess1 + otherGuess2 + otherGuess3 - 3 * currentGuess);

        return currentGuess + adjustmentFactor * (targetAdjustment + otherUnitsAdjustment);
    }
}
