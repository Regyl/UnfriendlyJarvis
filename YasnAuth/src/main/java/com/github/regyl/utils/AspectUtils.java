package com.github.regyl.utils;

import lombok.experimental.UtilityClass;
import org.aspectj.lang.JoinPoint;

/**
 * Utility class to use in aspects.
 */
@UtilityClass
public final class AspectUtils {

    /**
     * Get target method full name.
     *
     * @param jp target {@link JoinPoint}
     * @return full method name
     */
    public static String getMethodName(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        String className = jp.getTarget().getClass().toString().substring(6);
        return String.format("%s#%s()", className, methodName);
    }
}