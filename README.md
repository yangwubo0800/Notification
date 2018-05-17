# Notification
集成极光推送以及安卓Notification的使用

Jpush需要集成三方的SDK，推送通知需要在其网站上注册账号进行推送，在集成时遇到的问题时so库打包集成的问题：
    sourceSets {
        main {
            jniLibs.srcDirs = ['libs']
        }
    }
    
    其推送支持TAG 和 Alias 区分推送
    
    
    
    在调试安卓通知的使用时，需要注意安卓8.0之后的版本增加了通知渠道的概念，需要先创建渠道。
    使用自定义布局通知时注意需要设置setSmallIcon，否则会抛出如下异常：
    java.lang.IllegalArgumentException: Invalid notification (no valid small icon):
    
    
    通知工具中使用了单例模式，并且属于懒汉加载方式，为了减少每次创建Builder对象的次数，同时也像实际了解下单例模式的优点。
    
    
