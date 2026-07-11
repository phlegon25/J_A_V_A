import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ----- Accept name and ID as strings -----
        System.out.print("Enter student full name: ");
        String studentName = input.nextLine();

        System.out.print("Enter student ID (e.g., S12345): ");
        String studentId = input.nextLine();

        // ----- Accept and validate assignment score (integer, 0-100) -----
        int assignmentScore = getValidatedIntScore(input, "Enter assignment score (0-100): ");

        // ----- Accept and validate midterm score (double, 0-100) -----
        double midtermScore = getValidatedDoubleScore(input, "Enter midterm exam score (0-100): ");

        // ----- Accept and validate final exam score (double, 0-100) -----
        double finalScore = getValidatedDoubleScore(input, "Enter final exam score (0-100): ");

        // ----- Compute weighted total -----
        double weightedTotal = (assignmentScore * 0.20) + (midtermScore * 0.20) + (finalScore * 0.60);

        // ----- Round weighted total to nearest integer for grade determination -----
        int roundedTotal = (int) Math.round(weightedTotal);

        // ----- Determine letter grade -----
        char letterGrade;
        if (roundedTotal >= 90) {
            letterGrade = 'A';
        } else if (roundedTotal >= 80) {
            letterGrade = 'B';
        } else if (roundedTotal >= 70) {
            letterGrade = 'C';
        } else if (roundedTotal >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }

        // ----- Formatted report -----
        System.out.println("\n===================================");
        System.out.println("         STUDENT GRADE REPORT");
        System.out.println("===================================");
        System.out.println("Name: " + studentName);
        System.out.println("ID:   " + studentId);
        System.out.println("-----------------------------------");
        System.out.printf("Assignment Score (20%%): %.2f%n", (double) assignmentScore);
        System.out.printf("Midterm Score    (20%%): %.2f%n", midtermScore);
        System.out.printf("Final Exam Score (60%%): %.2f%n", finalScore);
        System.out.println("-----------------------------------");
        System.out.printf("Weighted Total: %.2f%n", weightedTotal);
        System.out.println("Letter Grade:   " + letterGrade);
        System.out.println("===================================");

        input.close();
    }

    // Reads an integer score as a String, converts it, and validates range 0-100.
    // Re-prompts only for this value if invalid.
    private static int getValidatedIntScore(Scanner input, String prompt) {
        int score;
        while (true) {
            System.out.print(prompt);
            String raw = input.nextLine();
            try {
                score = Integer.parseInt(raw.trim());
                if (score < 0 || score > 100) {
                    System.out.println("Error: Score must be between 0 and 100. Please re-enter.");
                    continue;
                }
                return score;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please re-enter.");
            }
        }
    }

    // Reads a double score as a String, converts it, and validates range 0-100.
    // Re-prompts only for this value if invalid.
    private static double getValidatedDoubleScore(Scanner input, String prompt) {
        double score;
        while (true) {
            System.out.print(prompt);
            String raw = input.nextLine();
            try {
                score = Double.parseDouble(raw.trim());
                if (score < 0 || score > 100) {
                    System.out.println("Error: Score must be between 0 and 100. Please re-enter.");
                    continue;
                }
                return score;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format. Please re-enter.");
            }
        }
    }
}