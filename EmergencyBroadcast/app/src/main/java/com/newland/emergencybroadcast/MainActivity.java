package com.newland.emergencybroadcast;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends Activity {

    String str = "这是测试文本";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(str)) {
                    AudioUtils.getInstance().speakText(str);
                }



            }
        });

    }

    /**
     * 描述:播放语音
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 15:15
     */
    public void speakText(View view) {
        TextView text = (TextView) findViewById(R.id.main_content);
        String content = text.getText().toString().trim();
        if (!TextUtils.isEmpty(content)) {
            AudioUtils.getInstance().speakText(content);
        }
    }

}
