package pr.tongson.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * <b>Create Date:</b> 2018/2/23<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author mmc_Kongming_Tongson
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
    }

    /**
     * 初始化路由器
     */
    private void initARouter() {
        if (true) {
            ARouter.openLog();
            ARouter.openDebug();
            ARouter.printStackTrace();
        }
        ARouter.init(this);
    }
}
