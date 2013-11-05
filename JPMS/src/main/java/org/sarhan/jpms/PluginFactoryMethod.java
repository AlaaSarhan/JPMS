package org.sarhan.jpms;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author alaa sarhan
 */
@java.lang.annotation.Retention(value = RetentionPolicy.RUNTIME)
@java.lang.annotation.Target(value = ElementType.METHOD)
public @interface PluginFactoryMethod { }
