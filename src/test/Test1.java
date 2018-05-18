package test;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.math.optimization.GoalType;
import org.apache.commons.math.optimization.OptimizationException;
import org.apache.commons.math.optimization.RealPointValuePair;
import org.apache.commons.math.optimization.linear.LinearConstraint;
import org.apache.commons.math.optimization.linear.LinearObjectiveFunction;
import org.apache.commons.math.optimization.linear.Relationship;
import org.apache.commons.math.optimization.linear.SimplexSolver;

public class Test1 {

	public static void main(String[] args) {
		
		
		Integer numero_ciudades = 10;
		double[][] matriz = new double[numero_ciudades][numero_ciudades];
		
		// Rellenar de ceros
		for (int i = 0; i < numero_ciudades; i++) {
			for (int j = 0; j < numero_ciudades; j++) {
				matriz[i][j] = 0;
			}
		}
		
		
		
		SimplexSolver simplex_solver = new SimplexSolver();
		boolean restrictToNonNegative = true;
		GoalType goalType = GoalType.MAXIMIZE;
		double[] coefficients = {4.0, 4.0};
		LinearConstraint lc = new LinearConstraint(coefficients, Relationship.LEQ, 5.0);
		Collection<LinearConstraint> constraints = new ArrayList<>();
		constraints.add(lc);
		double[] coefficients2 = {3.0, 4.0};
		double constantTerm = 16.0;
		LinearObjectiveFunction f = new LinearObjectiveFunction(coefficients2, constantTerm);
		try {
			RealPointValuePair rvpp = simplex_solver.optimize(f, constraints, goalType, restrictToNonNegative);
			System.out.println(rvpp.getPoint()[1] + ", " + rvpp.getPoint()[0]);	
		} catch (OptimizationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
