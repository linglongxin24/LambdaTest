#Android中如何使用Lambda表达式高效开发
>当我们在Android开发中，使用Android Studio时，去写一个线程或者button的点击事件时，写完之后使用代码折叠功能，可以看到如下预览：
![折叠代码](https://github.com/linglongxin24/LambdaTest/blob/master/screeshot/previous.png?raw=true)
这个其实就是Lambda表达式的写法。我们发现，对于我们开发来说，不会去关心这个类以及方法，只会关心这个方法内的代码，所以其他的多余代码就显得多余了。那么，到底具体如何使用呢？

#一.在build.gradle中加入如下配置

```gradle
 jackOptions{
            enabled true
        }
compileOptions{
   sourceCompatibility JavaVersion.VERSION_1_8
   targetCompatibility JavaVersion.VERSION_1_8
 }
```

![折叠代码](https://github.com/linglongxin24/LambdaTest/blob/master/screeshot/config.png?raw=true)

#二.使用lambda表达式的三种写法

#####1.第一种方式,无参数+语句(代码块)：适用于匿名内部类中方法无参数的情况

```java
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
```

#####2.第二种方式，有参数+语句：适用于匿名内部类中方法只有一个参数的情况

```java
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
```

#####2.第二种方式，有参数+语句：适用于匿名内部类中方法只有一个参数的情况


```java
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
```

#[GitHub](https://github.com/linglongxin24/LambdaTest)