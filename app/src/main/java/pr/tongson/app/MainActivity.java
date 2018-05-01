package pr.tongson.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Config;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * http://blog.csdn.net/sjz4860402/article/details/51223057
 * https://www.cnblogs.com/baiqiantao/p/7256922.html
 * http://www.runoob.com/w3cnote/android-tutorial-contentprovider.html
 * http://www.runoob.com/w3cnote/android-tutorial-contentprovider-2.html
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv_click).setOnClickListener(this);

        //        Uri uri = Uri.parse("http://www.baidu.com");
        //        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        //        startActivity(it);

        viewUrl("geo:38.899533,-77.036476", null);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_click:
                ARouter.getInstance().build("/test/activity").navigation();
                break;
            default:
                break;
        }
    }

    public void viewUrl(String url, String mimeType) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(url), mimeType);
        if (getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                if (Config.LOGD) {
                    Log.d("666", "activity not found for " + mimeType + " over " + Uri.parse(url).getScheme(), e);
                }
            }
        }
    }
}
