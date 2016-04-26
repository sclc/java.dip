/*******************************************************************************
 * This software is provided as a supplement to the authors' textbooks on digital
 * image processing published by Springer-Verlag in various languages and editions.
 * Permission to use and distribute this software is granted under the BSD 2-Clause 
 * "Simplified" License (see http://opensource.org/licenses/BSD-2-Clause). 
 * Copyright (c) 2006-2015 Wilhelm Burger, Mark J. Burge. 
 * All rights reserved. Visit http://www.imagingbook.com for additional details.
 *  
 *******************************************************************************/

package imagingbook.lib.math;

//import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.stat.correlation.Covariance;


public abstract class Statistics {
	
	public static int getMax(int[] A) {
		int maxVal = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] > maxVal)
				maxVal = A[i];
		}
		return maxVal;
	}
	
	public static int getMin(int[] A) {
		int minVal = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] < minVal)
				minVal = A[i];
		}
		return minVal;
	}
	
	public static float getMax(float[] A) {
		float maxVal = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] > maxVal)
				maxVal = A[i];
		}
		return maxVal;
	}
	
	public static float getMin(float[] A) {
		float minVal = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] < minVal)
				minVal = A[i];
		}
		return minVal;
	}
	
	public static double getMax(double[] A) {
		double maxVal = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] > maxVal)
				maxVal = A[i];
		}
		return maxVal;
	}
	
	public static double getMin(double[] A) {
		double minVal = A[0];
		for (int i = 1; i < A.length; i++) {
			if (A[i] < minVal)
				minVal = A[i];
		}
		return minVal;
	}
	
	// --------------------------------------------------------------------
	
	//TODO: mean, variance for int, float, double arrays
	
	
	
	
	private static boolean UseBiasCorrection = false; // we use NO bias-correction here
	
	/**
	 * Calculates the covariance matrix for a sequence of sample vectors.
	 * Takes a sequence of n data samples, each of dimension m.
	 * The data element samples[i][j] refers to the j-th component
	 * of sample i.
	 * 
	 * @param samples Array of m-dimensional vectors (double[n][m]).
	 * @return The covariance matrix (of dimension double{m][m]).
	 */
	public static double[][] covarianceMatrix(double[][] samples) {
		Covariance cov = new Covariance(samples, UseBiasCorrection);	
		return cov.getCovarianceMatrix().getData();
	}
	
	
	/** 
	 * example from UTICS-C Appendix:
	 * N = 4 samples
	 * K = 3 dimensions
	 * @param args
	 */
//	public static void main(String[] args) {
//		
//		// example: n = 4 samples of dimension m = 3:
//		// samples[i][j], i = column (sample index), j = row (dimension index).
//		double[][] samples = { 
//				{75, 37, 12},	// i = 0
//				{41, 27, 20},	// i = 1
//				{93, 81, 11},	// i = 2
//				{12, 48, 52}	// i = 3
//		};
//		
//		// covariance matrix Cov (3x3)
//		double[][] cov = covarianceMatrix(samples);
//		System.out.println("cov = " + Matrix.toString(cov));
//		
//		System.out.println();
//		
//		double[][] icov = Matrix.inverse(cov);
//		System.out.println("icov = " + Matrix.toString(icov));
//		
//		double trace = MatrixUtils.createRealMatrix(cov).getTrace();
//		System.out.println("trace(cov) = " + trace);
//		
////		double trace2 = Matrix.trace(cov);
////		System.out.println("trace2(cov) = " + trace2);
//		
//		double Fnorm = MatrixUtils.createRealMatrix(cov).getFrobeniusNorm();
//		System.out.println("Fnorm(cov) = " + Fnorm);
//		
////		double Fnorm2 = Matrix.froebeniusNorm(cov);
////		System.out.println("Fnorm2(cov) = " + Fnorm2);
//	}
	
/* Results (bias-corrected):
cov = {{1296.250, 442.583, -627.250}, 
{442.583, 550.250, -70.917}, 
{-627.250, -70.917, 370.917}}

icov = {{0.024, -0.014, 0.038}, 
{-0.014, 0.011, -0.022}, 
{0.038, -0.022, 0.063}}
*/
	
/* verified with Mathematica
X1 = {75, 37, 12}; X2 = {41, 27, 20}; X3 = {93, 81, 11}; X4 = {12, 48, 52};
samples = {X1, X2, X3, X4}
N[Covariance[samples]]
-> {{1296.25, 442.583, -627.25}, {442.583, 550.25, -70.9167}, {-627.25, -70.9167, 370.917}}
*/
	
/* Results (NON bias-corrected):
cov = {{972.188, 331.938, -470.438}, 
{331.938, 412.688, -53.188}, 
{-470.438, -53.188, 278.188}}

icov = {{0.032, -0.019, 0.051}, 
{-0.019, 0.014, -0.030}, 
{0.051, -0.030, 0.083}}
*/

}
