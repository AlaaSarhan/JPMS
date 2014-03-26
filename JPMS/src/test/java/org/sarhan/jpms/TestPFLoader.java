package org.sarhan.jpms;

import org.sarhan.jpms.plugins.PF1;
import org.sarhan.jpms.plugins.PF2;
import org.sarhan.jpms.plugins.PF3;
import org.sarhan.jpms.plugins.PF4;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alaa
 */
public class TestPFLoader extends PluginFactoryLoader{

    private PluginFactory[] factories;
    
    public TestPFLoader(){
        factories = new PluginFactory[4];
        factories[0] = new PF1();
        factories[1] = new PF2();
        factories[2] = new PF3();
        factories[3] = new PF4();
    }
    
    @Override
    public PluginFactory[] getLoadedFactories() {
        return this.factories;
    }

    @Override
    public void start() {
        
    }

    @Override
    public void stop() {
        
    }

    @Override
    public boolean isStarted() {
        return true;
    }
    
}
