/*******************************************************************************
 * This software is provided as a supplement to the authors' textbooks on digital
 * image processing published by Springer-Verlag in various languages and editions.
 * Permission to use and distribute this software is granted under the BSD 2-Clause 
 * "Simplified" License (see http://opensource.org/licenses/BSD-2-Clause). 
 * Copyright (c) 2006-2015 Wilhelm Burger, Mark J. Burge. 
 * All rights reserved. Visit http://www.imagingbook.com for additional details.
 *  
 *******************************************************************************/

package imagingbook.lib.ij;

/**
 * @author wilbur
 * To be implemented by ImageJ plugins for supporting a simple callback mechanism.
 * Examples can be found in classes IjPlugin_Handling_Callbacks and ClassCreatingCallbacks.
 * 
 * @see CallbackSender
 *
 */

public interface CallbackHandler {
	
	public void handleCallback(CallbackSender source, int id);

}


 

