package com.example.latte_core.app;

import java.util.WeakHashMap;

/**
 * @author 田纪元
 * 配置文件存储或获取
 */
public class Configurator {

    private static final WeakHashMap<String,Object> LATTE_CONFIGS = new WeakHashMap<>();

    private Configurator(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    final WeakHashMap<String,Object> getLatteConfigs(){
        return LATTE_CONFIGS;
    }

    /**
     * 静态内部类单例模式的初始化——线程安全的懒汉模式
     */
    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure(){
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Configurator withApiHost(String host){
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    @SuppressWarnings("ConstantConditions")
    private void checkConfiguration(){
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    /**
     * 再获取配置时调用checkConfiguration()，保证配置的正确性和完整性
     */
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }
}
