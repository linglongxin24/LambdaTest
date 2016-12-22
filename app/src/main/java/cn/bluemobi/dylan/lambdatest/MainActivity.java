package cn.bluemobi.dylan.lambdatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        threadTest();
        setOnClick();
        setOnChecked();
    }

    /**
     * 第一种方式,无参数+语句(代码块)：适用于匿名内部类中方法无参数的情况
     * () -> 语句
     * 或
     * () -> {代码块}
     **/
    private void threadTest() {
        /**普通写法**/
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        /**使用lambda表达式写法**/
        new Thread(() -> Log.d(TAG, "this is a lambda Thread")).start();
    }

    /**
     * 第二种方式，有参数+语句：适用于匿名内部类中方法只有一个参数的情况
     * 方法参数 -> 语句
     * 或
     * 方法参数 -> {代码块}
     */
    private void setOnClick() {
        /**普通写法**/
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "this is a general onClick");
            }
        });
        /**使用lambda表达式写法**/
        findViewById(R.id.button).setOnClickListener(v -> Log.d(TAG, "this is a lambda onClick"));
    }

    /**
     * 第三种方式，有参数+代码块：适用于匿名内部类中方法不止一个参数的情况
     * (参数1, 参数2) -> 语句
     * 或
     * (参数1, 参数2) -> {代码块}
     */
    private void setOnChecked() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        /**普通写法**/
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(TAG, "this is a general onCheckedChanged");
            }
        });
        /**使用lambda表达式写法**/
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.d(TAG, "this is a lambda onCheckedChanged");
            Log.d(TAG, "this is a lambda onCheckedChanged_isChecked=" + isChecked);
        });
    }
}
