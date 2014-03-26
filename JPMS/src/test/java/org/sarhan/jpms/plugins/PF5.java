package org.sarhan.jpms.plugins;


import org.sarhan.jpms.PluginFactory;
import org.sarhan.jpms.PluginFactoryMethod;
import org.sarhan.jpms.api_types.T1;
import org.sarhan.jpms.api_types.T2;
import org.sarhan.jpms.api_types.T3;
import org.sarhan.jpms.api_types.T4;
import org.sarhan.jpms.api_types.T5;
import org.sarhan.jpms.api_types.T6;

/**
 *
 * @author alaa
 */
public class PF5 implements PluginFactory{
    
    @PluginFactoryMethod
    public P1 createPlugin(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6){
        
        return new P1() {};
    }
    
    @PluginFactoryMethod
    public P1 createPlugin(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5){
        
        return new P1() {};
    }
    
    @PluginFactoryMethod
    public P1 createPlugin(T1 t1, T2 t2, T3 t3, T4 t4){
        
        return new P1() {};
    }
    
    @PluginFactoryMethod
    public P1 createPlugin(T1 t1, T2 t2, T3 t3){
        
        return new P1() {};
    }
    
    @PluginFactoryMethod
    public P1 createPlugin(T1 t1, T2 t2){
        
        return new P1() {};
    }
    
    @PluginFactoryMethod
    public P1 createPlugin(T1 t1){
        
        return new P1() {};
    }
    
    @PluginFactoryMethod
    public P1 createPlugin(){
        
        return new P1() {};
    }
}
