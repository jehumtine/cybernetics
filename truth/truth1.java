import java.util.Random;

public class truth1 {
    public static void main(String[] args) {
        int target = 42; // The correct result we want to achieve
        int maxIterations = 100; // Maximum number of iterations
        
        Random random = new Random();
        int unit1Guess, unit2Guess;

        // Initialize the guesses with random values
        unit1Guess = random.nextInt(100);
        unit2Guess = random.nextInt(100);

        for (int i = 0; i < maxIterations; i++) {
            // Calculate the sum of the current guesses
            int sum = unit1Guess + unit2Guess;

            // Check if the sum matches the target
            if (sum == target) {
                System.out.println("Correct result found: " + unit1Guess + " + " + unit2Guess + " = " + sum);
                break; // Exit the loop since the correct result is found
            } else {
                // Adjust the guesses based on the feedback
                int difference = target - sum;

                // Randomly choose which unit to adjust based on the sign of the difference
                if (difference > 0) {
                    unit1Guess += random.nextInt(difference + 1);
                } else {
                    unit2Guess += random.nextInt(Math.abs(difference) + 1);
                }
            }
        }
    }
}

