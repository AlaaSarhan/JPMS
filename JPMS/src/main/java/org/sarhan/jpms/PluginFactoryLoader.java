/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sarhan.jpms;

import java.util.Observable;

/**
 *
 * @author alaa
 */
public abstract class PluginFactoryLoader extends Observable {
    
    public abstract PluginFactory[] getLoadedFactories();
    
    public abstract void start();
    public abstract void stop();
    public abstract boolean isStarted();
    
    public final class LoaderNotification {

        private LoaderEvent event;
        private PluginFactory pluginFactory;
        
        public LoaderNotification(LoaderEvent event,
                PluginFactory pluginFactory){
            this.event = event;
            this.pluginFactory = pluginFactory;
        }
        
        public LoaderEvent getEvent(){
            return this.event;
        }
        
        public PluginFactory getPluginFactory(){
            return this.pluginFactory;
        }
    }

    public enum LoaderEvent {
        FACTORY_LOADED,
        FACTORY_UNLOADED,
        FACTORY_UPDATED
    }
}
