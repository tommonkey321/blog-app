package com.tommonkey.utils.im;

import com.tommonkey.utils.bp.Constants;
import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitPushServer implements ServletContextListener {
    public void contextInitialized(ServletContextEvent arg0) {
        CometContext cc = CometContext.getInstance();
        cc.registChannel(Constants.Sys.CHANNEL);
        //下线监控线程
        Thread helloAppModule = new Thread(new outLineThread(), "Sender App Module");
        //消息发送线程
        Thread msgAppModule = new Thread(new SendMsgThread(), "msg App Module one");
        Thread msgAppModule_two = new Thread(new SendMsgThread(), "msg App Module two");
        Thread msgAppModule_three = new Thread(new SendMsgThread(), "msg App Module three");
        Thread msgAppModule_four = new Thread(new SendMsgThread(), "msg App Module four");
        Thread msgAppModule_five = new Thread(new SendMsgThread(), "msg App Module five");
        msgAppModule.setDaemon(true);//设置守护线程
        helloAppModule.setDaemon(true);//设置守护线程
        CometEngine engine = CometContext.getInstance().getEngine();
        engine.addConnectListener(new ConnJoinListener());//用户上线监听
        helloAppModule.start();
        msgAppModule.start();
        msgAppModule_two.start();
        msgAppModule_three.start();
        msgAppModule_four.start();
        msgAppModule_five.start();
    }

    public void contextDestroyed(ServletContextEvent arg0) {

    }
}