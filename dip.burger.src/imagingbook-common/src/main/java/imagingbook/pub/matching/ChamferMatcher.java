/*******************************************************************************
 * This software is provided as a supplement to the authors' textbooks on digital
 * image processing published by Springer-Verlag in various languages and editions.
 * Permission to use and distribute this software is granted under the BSD 2-Clause 
 * "Simplified" License (see http://opensource.org/licenses/BSD-2-Clause). 
 * Copyright (c) 2006-2015 Wilhelm Burger, Mark J. Burge. 
 * All rights reserved. Visit http://www.imagingbook.com for additional details.
 *  
 *******************************************************************************/

package imagingbook.pub.matching;
import ij.process.ByteProcessor;
import imagingbook.pub.matching.DistanceTransform.Norm;

import java.awt.Point;

/**
 * This class performs chamfer matching on binary images.
 * @author W. Burger
 * @version 2014-04-20
 */
public class ChamferMatcher {
	
	private final ByteProcessor I;
	private final int MI, NI;
	private final float[][] D;				// distance transform of I
	
	public ChamferMatcher(ByteProcessor I) {
		this(I, Norm.L2);
	}
	
	public ChamferMatcher(ByteProcessor I, Norm norm) {
		this.I = I;
		this.MI = this.I.getWidth();
		this.NI = this.I.getHeight();
		this.D = (new DistanceTransform(I, norm)).getDistanceMap();
	}
	
	public float[][] getMatch(ByteProcessor R) {
		final int MR = R.getWidth();
		final int NR = R.getHeight();
		final int[][] Ra = R.getIntArray();
		float[][] Q = new float[MI - MR + 1][NI - NR + 1];
		for (int r = 0; r <= MI - MR; r++) {
			for (int s = 0; s <= NI - NR; s++) {
				float q = getMatchValue(Ra, r, s);
				Q[r][s] = q;
			}	
		}	
		return Q;
	}

	private float getMatchValue(int[][] R, int r, int s) {
		float q = 0.0f;
		for (int i = 0; i < R.length; i++) {
			for (int j = 0; j < R[i].length; j++) {
				if (R[i][j] > 0) {	// foreground pixel in reference image
					q = q + D[r + i][s + j];
				}
			}
		}
		return q;
	}  	
	
	public float[][] getMatch(Point[] points, int width, int height) {
		float[][] Q = new float[width][height];
		for (int r = 0; r <= width; r++) {
			for (int s = 0; s <= height; s++) {
				float q = getMatchValue(points, r, s);
				Q[r][s] = q;
			}	
		}	
		return Q;
	}
	
	private float getMatchValue(Point[] points, int r, int s) {
		float q = 0.0f;
		for (Point p : points) {
			final int u = r + p.x;
			final int v = s + p.y;
			if (0 <= u && u < MI && 0 <= v && v < NI) {
				q = q + D[u][v];
			}
		}
		return q;
	}

}
