import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CGPACalculatorTest {

    @Test
    void testCalculateCGPA_NormalInput() {
        CGPACalculator calculator = new CGPACalculator();
        double[] grades = {3.0, 3.5, 4.0, 2.5};
        double result = calculator.calculateCGPA(grades);
        assertEquals(3.25, result, "CGPA should be the average of grades");
    }

    @Test
    void testCalculateCGPA_BoundaryConditions() {
        CGPACalculator calculator = new CGPACalculator();
        double[] grades = {0.0, 4.0, 4.0, 0.0};
        double result = calculator.calculateCGPA(grades);
        assertEquals(2.0, result, "CGPA should handle boundary values correctly");
    }

    @Test
    void testCalculateCGPA_EmptyInput() {
        CGPACalculator calculator = new CGPACalculator();
        double[] grades = {};
        double result = calculator.calculateCGPA(grades);
        assertEquals(0.0, result, "CGPA should be 0.0 for an empty array");
    }

    @Test
    void testCalculateCGPA_InvalidInput() {
        CGPACalculator calculator = new CGPACalculator();
        double[] grades = {3.0, -1.0, 4.5}; // Invalid grades
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateCGPA(grades),
                "CGPA calculation should throw IllegalArgumentException for invalid grades");
    }
}
