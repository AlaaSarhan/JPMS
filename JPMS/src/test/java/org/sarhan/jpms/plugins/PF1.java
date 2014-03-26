package org.sarhan.jpms.plugins;

import org.sarhan.jpms.PluginFactory;
import org.sarhan.jpms.PluginFactoryMethod;
import org.sarhan.jpms.PluginManager;
import org.sarhan.jpms.api_types.T1;
import org.sarhan.jpms.api_types.T2;
import org.sarhan.jpms.api_types.T3;

/**
 *
 * @author alaa sarhan
 */
public class PF1 implements PluginFactory {

    @PluginFactoryMethod
    public P1 createPlugin(T1 t1, T2 t2) {

        System.out.println(String.format("PF1.createPlugin(" + t1 + " : T1, " + t2 + " : T2)",
                t1.getClass().getName(), t2.getClass().getName()));

        return new P1() {
        };
    }

    @PluginFactoryMethod
    public P1 createPlugin(T1 t1, T2 t2, T3 t3) {

        System.out.println("PF1.createPlugin(" + t1 + " : T1, " + t2 + " : T2, "
                + t3 + " : T3)");

        return new P1() {
        };
    }

    @PluginFactoryMethod
    public P1 createPlugin() {
        System.out.println(String.format("PF1.createPlugin()"));

        return new P4();
    }

    @PluginFactoryMethod
    public P1 createPlugin(PluginManager pm) {
        System.out.println(String.format("PF1.createPlugin(PluginManager)"));

        return new P1() {
        };
    }
}
