package org.sarhan.jpms.plugins;


import org.sarhan.jpms.PluginFactory;
import org.sarhan.jpms.PluginFactoryMethod;
import org.sarhan.jpms.api_types.T5;
import org.sarhan.jpms.api_types.T6;

/**
 *
 * @author alaa
 */
public class PF4 implements PluginFactory{
    
    @PluginFactoryMethod
    public P6 createPlugin(T5 t5, T6 t6){
        System.out.println(String.format("PF3.createPlugin(" + t5 + " : T5, "
                + t6 + " : T6)",
                t5.getClass().getName(), t6.getClass().getName()));
        
        return new P6();
    }
}
