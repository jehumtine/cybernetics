import static java.lang.System.out;
import java.util.*;


public class truth2{

	public static void main(String args[]){
	Random random = new Random();

        double initialGuess = 25.0; // Initial guess value
        double epsilon = 0.00001; // Convergence threshold

        double unit1Guess, unit2Guess;
        unit1Guess = initialGuess;
        unit2Guess = initialGuess;

        double target = generateNewTarget(unit1Guess, unit2Guess, 1);

        for (int i = 1; i <= 10; i++) {
            while (Math.abs(unit1Guess - target) > epsilon && Math.abs(unit2Guess - target) > epsilon) {
                // Adjust the guesses to maintain cohesion with the changing target
                unit1Guess += (target - unit1Guess) * random.nextDouble();
                unit2Guess += (target - unit2Guess) * random.nextDouble();
            }

            System.out.println("Iteration " + i);
            System.out.println("Target: " + target);
            System.out.println("Unit 1 guess: " + unit1Guess);
            System.out.println("Unit 2 guess: " + unit2Guess);
            System.out.println();

            // Generate a new target based on the current unit guesses and the iteration number
            target = generateNewTarget(unit1Guess, unit2Guess, i + 1);
        }
    }

    private static double generateNewTarget(double unit1Guess, double unit2Guess, int iteration) {
        // Generate a new target value based on the unit guesses and the iteration number
        // You can customize this method according to the desired behavior of the changing environment
        return (unit1Guess + unit2Guess) / 2.0 + iteration * 10;
    }
}


