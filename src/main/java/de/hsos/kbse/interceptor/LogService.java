/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.interceptor;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class LogService {

	// Receives the class name decorated with @Log 

	public void log(final String clazz, final LogLevel level, final String message) {
		// Logger from package java.util.logging
		Logger log = Logger.getLogger(clazz);
		log.log(Level.parse(level.toString()), message);
	}
}
