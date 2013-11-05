package org.sarhan.jpms.plugins;

import org.sarhan.jpms.PluginFactory;
import org.sarhan.jpms.PluginFactoryMethod;
import org.sarhan.jpms.api_types.T4;
import org.sarhan.jpms.api_types.T5;
import org.sarhan.jpms.api_types.T6;

/**
 *
 * @author alaa
 */
public class PF3 implements PluginFactory {

    @PluginFactoryMethod
    public P7 createPlugin(T6 t6) {
        System.out.println(String.format("PF3.createPlugin(" + t6 + " : T6)",
                t6.getClass().getName()));

        return new P7();
    }

    @PluginFactoryMethod
    public P8 createPlugin(T6 t6, T5 t5) {
        System.out.println(String.format("PF3.createPlugin(" + t6 + " : T6, "
                + t5 + " : T5)",
                t6.getClass().getName(), t5.getClass().getName()));

        return new P8();
    }

    @PluginFactoryMethod
    public P8 createPlugin(T6 t6, T5 t5, T4 t4) {
        System.out.println(String.format("PF3.createPlugin(" + t6 + " : T6, "
                + t5 + " : T5, " + t4 + " : T4)",
                t6.getClass().getName(), t5.getClass().getName(), t4.getClass().getName()));

        return new P8();
    }
}
