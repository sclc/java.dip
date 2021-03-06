/*******************************************************************************
 * This software is provided as a supplement to the authors' textbooks on digital
 * image processing published by Springer-Verlag in various languages and editions.
 * Permission to use and distribute this software is granted under the BSD 2-Clause 
 * "Simplified" License (see http://opensource.org/licenses/BSD-2-Clause). 
 * Copyright (c) 2006-2015 Wilhelm Burger, Mark J. Burge. 
 * All rights reserved. Visit http://www.imagingbook.com for additional details.
 *  
 *******************************************************************************/
package Ch11_Automatic_Thresholding;

import ij.IJ;
import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ByteProcessor;
import ij.process.ImageProcessor;
import imagingbook.pub.threshold.global.GlobalThresholder;
import imagingbook.pub.threshold.global.QuantileThresholder;

/**
 * Demo plugin showing the use of the QuantileThresholder class.
 * @author W. Burger
 * @version 2013/05/30
 */
public class Threshold_Global_Quantile implements PlugInFilter {
	
	static double quantile = 0.5;

	public int setup(String arg, ImagePlus imp) {
		return DOES_8G;
	}
	
	public void run(ImageProcessor ip) {
		ByteProcessor bp = (ByteProcessor) ip;
		
		quantile = IJ.getNumber("Black quantile [0,1]", quantile);
		if (quantile < 0) quantile = 0;
		if (quantile > 1) quantile = 1;
		
		GlobalThresholder thr = new QuantileThresholder(quantile);
		int q = thr.getThreshold(bp);
		if (q >= 0) {
			IJ.log("threshold = " + q);
			ip.threshold(q);
		}
		else {
			IJ.showMessage("no threshold found");
		}
	}
}
