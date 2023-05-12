import java.util.Random;

public class truth3{
    public static void main(String[] args) {
        Random random = new Random();
        
        double target = 50.0; // Initial target value
        double epsilon = 0.00001; // Convergence threshold

        double unit1Guess, unit2Guess;
        unit1Guess = random.nextDouble() * target;
        unit2Guess = random.nextDouble() * target;
        
        for (int i = 1; i <= 10; i++) {
            // Simulate a changing environment by updating the target value in each iteration
            target = generateNewTarget(target, i);

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
            
            
            
            

        }
    }

    private static double generateNewTarget(double previousTarget, int iteration) {
        // Generate a new target value based on the previous target and the iteration number
        // You can customize this method according to the desired behavior of the changing environment
        return previousTarget + iteration * 10;
    }
}
