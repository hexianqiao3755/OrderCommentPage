package com.hq.hsmwan.ordercommentpage.tools;

import android.net.Uri;

import com.facebook.drawee.view.SimpleDraweeView;

public class FrescoUtils {

    /**
     * 指定本地图片让SimpleDraweeView显示
     *
     * @param simpleDraweeView
     * @param paramString      本地图片路径
     */
    public static void setImageLocal(SimpleDraweeView simpleDraweeView, String paramString) {
        simpleDraweeView.setImageURI(Uri.parse("file://" + paramString));
    }
}
