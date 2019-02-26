package demo.framework.manager;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AsyncManager {
    private final int OPERATE_DELAY_TIME=10;
    private static AsyncManager asyncManager=new AsyncManager();
    public static AsyncManager getAsyncManager(){
        return asyncManager;
    }
    private ScheduledThreadPoolExecutor executor=new ScheduledThreadPoolExecutor(5);
    public void execute(TimerTask task){
        executor.schedule(task,OPERATE_DELAY_TIME, TimeUnit.MILLISECONDS);
    }
}
