public class CGPACalculator {

    public double calculateCGPA(double[] grades) {
        if (grades.length == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (double grade : grades) {
            if (grade < 0.0 || grade > 4.0) {
                throw new IllegalArgumentException("Grade must be between 0.0 and 4.0");
            }
            sum += grade;
        }

        return sum / grades.length;
    }
}
