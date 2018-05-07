package com.newland.emergencybroadcast;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SynthesizerListener;

import java.io.File;

/**
 * Created by Administrator on 2018-4-18.
 */

public class AudioUtils {

    private static AudioUtils audioUtils;

    private SpeechSynthesizer mySynthesizer;

    private String sdDir = Environment.getExternalStorageDirectory() + "/test.pcm";
    private static File file;//我们运行这个程序需要创建的文件
    private String filename = "newfile";//我们这个程序运行的文件的文件名


    public AudioUtils() {
    }

    /**
     * 描述:单例
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 14:38
     */
    public static AudioUtils getInstance() {
        if (audioUtils == null) {
            synchronized (AudioUtils.class) {
                if (audioUtils == null) {
                    audioUtils = new AudioUtils();
                }
            }
        }
        return audioUtils;
    }

    private InitListener myInitListener = new InitListener() {
        @Override
        public void onInit(int code) {
            Log.d("mySynthesiezer:", "InitListener init() code = " + code);
        }
    };


    /**
     * 描述:初始化语音配置
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 14:38
     */
    public void init(Context context) {
        //处理语音合成关键类
        mySynthesizer = SpeechSynthesizer.createSynthesizer(context, myInitListener);
        //设置发音人
        mySynthesizer.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");
        //设置音调
        mySynthesizer.setParameter(SpeechConstant.PITCH, "50");
        //设置音量
        mySynthesizer.setParameter(SpeechConstant.VOLUME, "50");
        //设置语速
        mySynthesizer.setParameter(SpeechConstant.SPEED, "5");
        //
        Log.d("Mytest", "init: sdDir: " + sdDir);
        mySynthesizer.setParameter(SpeechConstant.ENGINE_TYPE, "cloud");
        ///storage/emulated/0/EmergencyBroadcast-Log/2018_03_30_16_22_36.log
        mySynthesizer.setParameter(SpeechConstant.PARAMS, "tts_audio_path=/storage/emulated/0/EmergencyBroadcast-Log/test.pcm");

        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + filename);

        if (!file.exists()) {
            try{
                file.mkdir();//关键的一步，创建以上路径下的该文件夹
            }catch (Exception E)
            {
                E.printStackTrace();
            }
        }

/*        String str = "/storage/emulated/0/EmergencyBroadcast-Log/test1";
        File file = new File(str);
        if (!file.exists()){
            file.mkdir();
        }*/

    }

    /**
     * 描述:根据传入的文本转换音频并播放
     * 作者:卜俊文
     * 邮箱:344176791@qq.com
     * 创建时间: 2016/8/19 14:39
     */
    public void speakText(String content) {
        int code = mySynthesizer.startSpeaking(content, new SynthesizerListener() {
            @Override
            public void onSpeakBegin() {

            }

            @Override
            public void onBufferProgress(int i, int i1, int i2, String s) {

            }

            @Override
            public void onSpeakPaused() {

            }

            @Override
            public void onSpeakResumed() {

            }

            @Override
            public void onSpeakProgress(int i, int i1, int i2) {

            }

            @Override
            public void onCompleted(SpeechError speechError) {

            }

            @Override
            public void onEvent(int i, int i1, int i2, Bundle bundle) {

            }
        });
    }

}
