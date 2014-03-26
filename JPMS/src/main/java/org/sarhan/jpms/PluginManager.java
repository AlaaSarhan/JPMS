package org.sarhan.jpms;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alaa sarhan
 */
public class PluginManager implements Observer {

    private PluginFactoryLoader pluginFactoryLoader;
    
    private Map<Class<? extends Plugin>, Set<Method>> pfm;
    
    public PluginManager(PluginFactoryLoader pluginFactoryLoader) {
        if (pluginFactoryLoader == null) {
            throw new NullPointerException("pluginFactoryLoader can't be null");
        }

        this.pluginFactoryLoader = pluginFactoryLoader;

        this.pluginFactoryLoader.addObserver(this);

        if (!this.pluginFactoryLoader.isStarted()) {
            this.pluginFactoryLoader.start();
        }
    }

    public List<Plugin> getPlugins(Class<? extends Plugin> pluginType) {

        List<Plugin> createdPlugins = new LinkedList<Plugin>();

        for (PluginFactory factory
                : this.pluginFactoryLoader.getLoadedFactories()) {
            try {
                Method factoryMethod = factory.getClass()
                        .getMethod("createPlugin", PluginManager.class);
                
                if(factoryMethod.isAnnotationPresent(PluginFactoryMethod.class)
                        && pluginType
                        .isAssignableFrom(factoryMethod.getReturnType())){
                    
                    createdPlugins.add(
                            (Plugin) factoryMethod.invoke(factory, this));
                } else {
                    throw new NoSuchMethodException();
                }
                
            } catch (NoSuchMethodException ex) {
                
                try {
                    Method factoryMethod = factory.getClass()
                     .getMethod("createPlugin");
                    
                    if(factoryMethod.isAnnotationPresent(PluginFactoryMethod.class)
                        && pluginType
                        .isAssignableFrom(factoryMethod.getReturnType())){
                        createdPlugins.add(
                                (Plugin) factoryMethod.invoke(factory));
                    } else {
                        throw new NoSuchMethodException();
                    }
                    
                } catch (NoSuchMethodException ex1) {
                    
                } catch (SecurityException ex1) {
                    Logger.getLogger(PluginManager.class.getName())
                            .log(Level.SEVERE, null, ex1);
                } catch (IllegalAccessException ex1) {
                    Logger.getLogger(PluginManager.class.getName())
                            .log(Level.SEVERE, null, ex1);
                } catch (IllegalArgumentException ex1) {
                    Logger.getLogger(PluginManager.class.getName())
                            .log(Level.SEVERE, null, ex1);
                } catch (InvocationTargetException ex1) {
                    Logger.getLogger(PluginManager.class.getName())
                            .log(Level.SEVERE, null, ex1);
                }
                
            } catch (SecurityException ex) {
                Logger.getLogger(PluginManager.class.getName())
                        .log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(PluginManager.class.getName()).log(Level
                        .SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(PluginManager.class.getName()).log(Level
                        .SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(PluginManager.class.getName()).log(Level
                        .SEVERE, null, ex);
            }
        }

        return createdPlugins;
    }

    public List<Plugin> getPlugins(Class<? extends Plugin> pluginType,
            Object... obj) {

        if (obj == null || obj.length == 0) {
            return getPlugins(pluginType);
        }

        List<Plugin> createdPlugins = new LinkedList<Plugin>();
        Map<Class, Object> matchedObjectsCache = new HashMap<Class, Object>();

        for (PluginFactory factory
                : this.pluginFactoryLoader.getLoadedFactories()) {

            Method[] methods = factory.getClass().getDeclaredMethods();

            Arrays.sort(methods, new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {

                    if (o1 == null) {
                        return 1;
                    } else if (o2 == null) {
                        return -1;
                    }

                    return o2.getParameterTypes().length
                            - o1.getParameterTypes().length;
                }
            });

            for (Method factoryMethod : methods) {

                List<Object> matchedObjects = new LinkedList<Object>();

                if (factoryMethod.getName().equals("createPlugin")
                        && factoryMethod.isAnnotationPresent(PluginFactoryMethod.class)
                        && pluginType
                        .isAssignableFrom(factoryMethod.getReturnType())) {

                    Class[] parameterTypes = factoryMethod.getParameterTypes();

                    for (Class paramType : parameterTypes) {

                        if (PluginManager.class.isAssignableFrom(paramType)) {
                            matchedObjects.add(this);
                        } else if (matchedObjectsCache.containsKey(paramType)) {
                            matchedObjects.add(matchedObjectsCache.get(paramType));
                        } else {
                            for (Object o : obj) {
                                if (paramType.isAssignableFrom(o.getClass())) {
                                    matchedObjectsCache.put(paramType, o);
                                    matchedObjects.add(o);
                                    break;
                                }
                            }

                            if (!matchedObjectsCache.containsKey(paramType)) {
                                break;
                            }
                        }

                    }
                    
                    try {
                        if (parameterTypes.length == 0) {
                            createdPlugins.add((Plugin) factoryMethod
                                    .invoke(factory));
                            break;
                        } else if (parameterTypes.length == 1
                                && parameterTypes[0].equals(PluginManager.class)) {
                            createdPlugins.add((Plugin) factoryMethod
                                    .invoke(factory, this));
                            break;
                        } else if (parameterTypes.length
                                == matchedObjects.size()) {

                            createdPlugins.add((Plugin) factoryMethod
                                    .invoke(factory, matchedObjects.toArray()));
                            break;
                        }
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(PluginManager.class.getName())
                                .log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(PluginManager.class.getName())
                                .log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(PluginManager.class.getName())
                                .log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

        return createdPlugins;
    }

    public List<PluginFactory> getFactories(
            Class<? extends Plugin> pluginType){
        
        return null;
    }
    
    public List<PluginFactory> getFactories(
            Class<? extends Plugin> pluginType,
            Object... obj){
        
        return null;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof PluginFactoryLoader
                && arg instanceof PluginFactoryLoader.LoaderNotification) {

            PluginFactoryLoader pfl = (PluginFactoryLoader) o;
            PluginFactoryLoader.LoaderNotification not =
                    (PluginFactoryLoader.LoaderNotification) arg;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        this.pluginFactoryLoader.deleteObserver(this);

        super.finalize();
    }

    public PluginFactoryLoader getPluginFactoryLoader() {
        return this.pluginFactoryLoader;
    }
}
