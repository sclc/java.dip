/*******************************************************************************
 * This software is provided as a supplement to the authors' textbooks on digital
 * image processing published by Springer-Verlag in various languages and editions.
 * Permission to use and distribute this software is granted under the BSD 2-Clause 
 * "Simplified" License (see http://opensource.org/licenses/BSD-2-Clause). 
 * Copyright (c) 2006-2015 Wilhelm Burger, Mark J. Burge. 
 * All rights reserved. Visit http://www.imagingbook.com for additional details.
 *  
 *******************************************************************************/
package Ch15_Color_Filters;


import ij.ImagePlus;
import ij.plugin.filter.PlugInFilter;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;
import imagingbook.pub.color.image.HsvConverter;

/**
 * Accepts an RGB image and shows only its hue distribution,
 * using constant saturation and value.
 * @author WB
 *
 */

public class Hsv_Show_Hue_Only implements PlugInFilter {
	
	static float DEFAULT_SATURATION = 1.0f;
	static float DEFAULT_VALUE = 1.0f;
	

	public int setup(String arg, ImagePlus imp) {
		return DOES_RGB;
	}

	public void run(ImageProcessor ip) {
		ColorProcessor cp = (ColorProcessor) ip;
		final int w = ip.getWidth();
		final int h = ip.getHeight();
		
		ColorProcessor result = new ColorProcessor(w, h);

		// Create Cos/Sin images from the hue angle:
		HsvConverter cc = new HsvConverter();
		final int[] RGB = new int[3];
		
		for (int v = 0; v < h; v++) {
			for (int u = 0; u < w; u++) {
				cp.getPixel(u, v, RGB);
				float[] HSV = cc.RGBtoHSV(RGB); 	// all HSV components are in [0,1]
				HSV[1] = DEFAULT_SATURATION;
				HSV[2] = DEFAULT_VALUE;
				result.putPixel(u, v, cc.HSVtoRGB(HSV));
			}
		}

		new ImagePlus("Hue only", result).show();

	}
	
	

}