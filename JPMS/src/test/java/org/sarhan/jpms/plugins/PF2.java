package org.sarhan.jpms.plugins;

import org.sarhan.jpms.PluginFactory;
import org.sarhan.jpms.PluginFactoryMethod;
import org.sarhan.jpms.api_types.T1;
import org.sarhan.jpms.api_types.T3;
import org.sarhan.jpms.api_types.T5;

/**
 *
 * @author alaa
 */
public class PF2 implements PluginFactory {

    @PluginFactoryMethod
    public P2 createPlugin(T1 t1, T3 t3, T5 t5) {
        System.out.println(String.format("PF2.createPlugin(" + t1 + " : T1, "
                + t3 + " : T3, " + t5 + " : T5)",
                t1.getClass().getName(), t3.getClass().getName(), t5.getClass().getName()));

        return new P5();
    }

    @PluginFactoryMethod
    public P2 createPlugin() {
        System.out.println(String.format("PF2.createPlugin()"));

        return new P9();
    }
}
