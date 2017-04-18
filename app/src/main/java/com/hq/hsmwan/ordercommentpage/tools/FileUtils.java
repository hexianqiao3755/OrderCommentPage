package com.hq.hsmwan.ordercommentpage.tools;

import android.content.Context;

import java.io.File;

public class FileUtils {
    /**
     * 获取一个jpg图片的缓存路径
     * <p>图片名根据时间轴生成
     * @param context
     * @return
     */
    public static String getCachePath(Context context) {
        return context.getExternalCacheDir().getAbsolutePath() + File.separator + System.currentTimeMillis() + ".jpg";
    }
}
