package com.hq.hsmwan.ordercommentpage.tools;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;

import com.hq.hsmwan.ordercommentpage.activity.BaseActivity;

public class PermissionCheckUtil {
    /**
     * 检查是否有打开照相机和文件读写的权限
     * @param activity
     * @return true权限都已经开启, false没有全部开启
     */
    public static boolean checkCameraAndExternalStoragePermission(BaseActivity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (activity.checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
                    || activity.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
                    || activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                //检查没有打开照相机或文件读写权限就弹框请求打开这三个权限

                activity.requestPermissions(new String[]{Manifest.permission.CAMERA,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
                return false;
            }
            return true;
        }
        return true;
    }
}
