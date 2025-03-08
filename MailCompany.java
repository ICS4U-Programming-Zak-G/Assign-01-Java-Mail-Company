// Import scanner class to get input.
import java.util.Scanner;

// Import random class for random functions
import java.util.Random;

/** .
* Check if a package is valid in size and weight.
*
* @author  Zak Goneau
* @version 1.0
* @since   2025-03-05
*/

// Creating class
public final class MailCompany {

    /** .
     * MAX_WEIGHT is the max weight a package can be.
     */
    private static final int MAX_WEIGHT = 27;

    /** .
     * MAX_SIZE is the max size a package can be.
     */
    private static final double MAX_SIZE = 10000.0;

    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private MailCompany() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) {

        // Declare and initialize variables
        String widthString = "";
        String heightString = "";
        String lengthString = "";
        String weightString = "";
        double volumeResult = 0;
        double width = 0;
        double height = 0;
        double length = 0;
        double weight = 0;
        String answer = "";
        int maxMeasure = 35;
        int minMeasure = 1;
        int minWeight = 1;
        int maxWeight = 50;
        double bonusPackageResult = 0;
        double bonusPackageLength = 0;
        double bonusPackageWidth = 0;
        double bonusPackageHeight = 0;
        double bonusPackageWeight = 0;

        // Create instance of random class
        Random rand = new Random();

        // Welcome user and get input
        System.out.print("This is a mail company! We");
        System.out.print(" only take certain packages ");
        System.out.println(" based on weight and size. ");

        // Create scanner object
        Scanner scanner = new Scanner(System.in);

        do {

            // Generate random length, width, height and weight for bonus package
            // https://www.baeldung.com/java-generating-random-numbers-in-range
            bonusPackageLength = rand.nextInt(maxMeasure
                    - minMeasure + 1) + minMeasure;
            bonusPackageWidth = rand.nextInt(maxMeasure
                    - minMeasure + 1) + minMeasure;
            bonusPackageHeight = rand.nextInt(maxMeasure
                    - minMeasure + 1) + minMeasure;
            bonusPackageWeight = rand.nextInt(maxWeight
                    - minWeight + 1) + minWeight;

            // Get weight from user and assign to variable
            System.out.println("Please enter a weight(kg): ");
            weightString = scanner.nextLine();

            // Get width from user and assign to variable
            System.out.println("Please enter a width(cm): ");
            widthString = scanner.nextLine();

            // Get length from user and assign to variable
            System.out.println("Please enter a length(cm): ");
            lengthString = scanner.nextLine();

            // Get height from user and assign to variable
            System.out.println("Please enter a height(cm): ");
            heightString = scanner.nextLine();

            // try converting weight to double
            try {

                // Try casting input to double and assigning to variable
                weight = Double.parseDouble(weightString);

                // Check if weight is negative
                if (weight < 0) {

                    // If negative tell user
                    System.out.println(weight + " cannot be negative weight");

                    // Check if weight is over limit
                } else if (weight > MAX_WEIGHT) {

                    // If over limit tell user
                    System.out.println(weight + "kg is over 27kg");
                } else {
                    // Try converting width to double
                    try {

                        // Try casting input to double and assigning to variable
                        width = Double.parseDouble(widthString);

                        // Check if width is negative
                        if (width < 0) {

                            // If negative tell user
                            System.out.println(width + " cannot be negative width");
                        } else {
                            // Try converting length to double
                            try {

                                // Try casting input to double and assigning to variable
                                length = Double.parseDouble(lengthString);

                                // Check if length is negative
                                if (length < 0) {

                                    // If negative tell user
                                    System.out.println(length + " cannot be negative length");
                                } else {
                                    // Try converting height to double
                                    try {

                                        // Try casting input to double and assigning to variable
                                        height = Double.parseDouble(heightString);

                                        // Check if height is negative
                                        if (height < 0) {

                                            // If negative tell user
                                            System.out.println(height + " cannot be negative height");
                                        } else {
                                            // Call function to calculate volume
                                            volumeResult = calculateVolume(width, height, length);

                                            // Check if volume is over limit
                                            if (volumeResult > MAX_SIZE) {

                                                // Tell user package too big
                                                System.out.println("Package is too big");
                                            } else {
                                                // Call function to calculate if bonus package is valid
                                                bonusPackageResult = calculateBonusResult(bonusPackageWidth,
                                                        bonusPackageHeight, bonusPackageLength);

                                                // Print result to user
                                                System.out.print("The volume of a package with ");
                                                System.out.print("a width of " + width + "cm, ");
                                                System.out.print("a height of " + height + "cm, ");
                                                System.out.print("a length of " + length + "cm, is ");
                                                System.out.format("%.2f", volumeResult);
                                                System.out.println("cm^3");

                                                // Check if bonus package is too heavy
                                                if (bonusPackageWeight > MAX_WEIGHT) {
                                                    // Tell user package too heavy
                                                    System.out.println("You got a forgot an extra package of "
                                                            + bonusPackageWeight + "kg but the total is too heavy");

                                                    // Check if bonus package is too big
                                                } else if (bonusPackageResult > MAX_SIZE) {
                                                    // Tell user package too big
                                                    System.out.println("You got a forgot an extra package of "
                                                            + bonusPackageResult + "cm^3 but it's too big");

                                                    // Otherwise package is valid
                                                } else {
                                                    // Print result to user
                                                    System.out.print("You forgot an extra package of ");
                                                    System.out.print(bonusPackageWeight + "kg and "
                                                            + bonusPackageResult + "cm^3 ");
                                                    System.out.println("and it's valid!");
                                                }

                                                // Ask user if they want to continue
                                                System.out.print("Would you like to continue? ");
                                                System.out.println("q to quit): ");
                                                answer = scanner.nextLine();
                                            }
                                        }
                                    // Catch invalid height and tell user
                                    } catch (NumberFormatException error) {
                                        System.out.println("Heights not a positive number. "
                                                + error.getMessage());
                                    }
                                }
                            // Catch invalid length and tell user
                            } catch (NumberFormatException error) {
                                System.out.println("Lengths not a positive number."
                                        + error.getMessage());
                            }
                        }
                    // Catch invalid width and tell user
                    } catch (NumberFormatException error) {
                        System.out.println("Enter a positive number for width."
                                + error.getMessage());
                    }
                }
            // Catch invalid weight and tell user
            } catch (NumberFormatException error) {
                System.out.println("Please enter a positive number for weight."
                        + error.getMessage());
            }

        // Loop while answer user doesn't want to quit
        } while (!answer.equalsIgnoreCase("q"));


        // Thank user for playing
        System.out.println("Thank you for playing!");

        // Close scanner
        scanner.close();
    }

    /**
     * This is the method for calculating volume.
     *
     * @param width
     * @param height
     * @param length
     * @return volume
     */

    // Declare function to calculate volume
    public static double calculateVolume(final double width,
        final double height, final double length) {

        // Declare volume
        double volume = 0;

        // Calculate volume
        volume = width * height * length;

        // Return volume
        return volume;
    }

    /**
     * This is the bonus volume calculation method.
     *
     * @param width
     * @param height
     * @param length
     * @return bonusPackageVolume
     */

    // Declare function for calculating volume of bonus package
    public static double calculateBonusResult(final double width,
        final double height, final double length) {

        // Initialize bonus package volume
        double bonusPackageVolume = 0;

        // Calculate bonus package volume
        bonusPackageVolume = (width * height * length);

        // Return bonus volume
        return bonusPackageVolume;
    }
}
