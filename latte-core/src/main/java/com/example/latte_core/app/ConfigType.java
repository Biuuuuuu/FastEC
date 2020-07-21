package com.example.latte_core.app;

/**
 * @author 田纪元
 * 枚举类是唯一单例，只能被初始化一次
 * 多线程操作时可使用枚举类进行安全的惰性初始化
 */

public enum ConfigType {
    API_HOST,   //网络请求域名
    APPLICATION_CONTEXT,    //全局上下文
    CONFIG_READY,   //控制初始或是否完成
    ICON    //存储自己的初始化项目
}
