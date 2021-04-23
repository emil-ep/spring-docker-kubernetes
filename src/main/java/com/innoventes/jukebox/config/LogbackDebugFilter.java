/**
 * [2014] - [2019] WiSilica Incorporated  All Rights Reserved.
 * NOTICE:  All information contained herein is, and remains the property of WiSilica Incorporated and its suppliers,
 *  if any.  The intellectual and technical concepts contained herein are proprietary to WiSilica Incorporated
 *  and its suppliers and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
 *  Dissemination of this information or reproduction of this material is strictly forbidden unless prior written permission is obtained
 *  from WiSilica Incorporated.
 **/
package com.innoventes.jukebox.config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.MDC;
import org.slf4j.Marker;

public class LogbackDebugFilter extends TurboFilter {

	public static final String MDC_DEBUG_LOG_ENABLED_ON_REQUEST = "DEBUG_LOG_ENABLED_ON_REQUEST";
	@Override
	public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {

		if (!isStarted()) {
			return FilterReply.NEUTRAL;
		}
		
		if(Level.DEBUG.equals(level) && Boolean.parseBoolean(MDC.get(MDC_DEBUG_LOG_ENABLED_ON_REQUEST))) {
			return FilterReply.ACCEPT;
		}

		return FilterReply.NEUTRAL;
	}
}
