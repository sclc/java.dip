/*******************************************************************************
 * This software is provided as a supplement to the authors' textbooks on digital
 * image processing published by Springer-Verlag in various languages and editions.
 * Permission to use and distribute this software is granted under the BSD 2-Clause 
 * "Simplified" License (see http://opensource.org/licenses/BSD-2-Clause). 
 * Copyright (c) 2006-2015 Wilhelm Burger, Mark J. Burge. 
 * All rights reserved. Visit http://www.imagingbook.com for additional details.
 *  
 *******************************************************************************/

package imagingbook.lib.color;

import imagingbook.lib.color.CssColor;
import java.awt.Color;

public class CssColorSequencer {
	
	private int nextColorIndex = 0;
	
	static Color[] ColorSet = CssColor.PreferredColors;
	
	public CssColorSequencer() {
	}
	
	public CssColorSequencer(int firstIndex) {
		nextColorIndex = firstIndex % ColorSet.length;
	}
	
	public Color nextColor() {
		Color c = ColorSet[nextColorIndex];
		nextColorIndex = (nextColorIndex + 1) % ColorSet.length;
		return c;
	}
	
}
