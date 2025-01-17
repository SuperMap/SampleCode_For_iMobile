
package com.supermap.cartograph;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public final class PermissionHelper {
    private static final int CAMERA_PERMISSION_CODE = 0;
    private static final int STORAGE_PERMISSION_CODE = 1;
    private static final String CAMERA_PERMISSION = Manifest.permission.CAMERA;
    private static final String STORAGE_PERMISSION = Manifest.permission.WRITE_EXTERNAL_STORAGE;

    /**
     * 是否有相机权限
     * @param activity
     * @return
     */
    public static boolean hasCameraPermission(Activity activity) {
        return ContextCompat.checkSelfPermission(activity, CAMERA_PERMISSION)
                == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 请求相机权限
     * @param activity
     */
    public static void requestCameraPermission(Activity activity) {
        ActivityCompat.requestPermissions(
                activity, new String[]{CAMERA_PERMISSION}, CAMERA_PERMISSION_CODE);
    }

    /**
     * 是否有内存卡写入权限
     * @param activity
     * @return
     */
    public static boolean hasStoragePermission(Activity activity){
        return ContextCompat.checkSelfPermission(activity,STORAGE_PERMISSION)
                ==PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 请求内存卡写入权限
     * @param activity
     */
    public static void requestStoragePermission(Activity activity) {
        ActivityCompat.requestPermissions(
                activity, new String[]{STORAGE_PERMISSION}, STORAGE_PERMISSION_CODE
        );
    }

    /**
     * 请求权限
     * @param activity
     * @param permissions 权限名称
     * @param requestcode 请求码
     */
    public static void requestPermission(Activity activity,String [] permissions,int requestcode){
        ActivityCompat.requestPermissions(activity, permissions, requestcode);
    }

    /**
     * 是否有权限
     * @param activity
     * @param permission 权限名
     * @return
     */
    public static boolean hasPermission(Activity activity,String permission){
        return ContextCompat.checkSelfPermission(activity,permission)
                ==PackageManager.PERMISSION_GRANTED;
    }

    /**
     * 打开设置界面
     *
     * @param activity
     */
    public static void launchPermissionSettings(Activity activity) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
        activity.startActivity(intent);
    }
}
