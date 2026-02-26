package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class PlayAssetDeliveryUnityWrapper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static PlayAssetDeliveryUnityWrapper f23986b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C3251n f23987a;

    private PlayAssetDeliveryUnityWrapper(Context context) {
        this.f23987a = null;
        if (f23986b != null) {
            throw new RuntimeException("PlayAssetDeliveryUnityWrapper should be created only once. Use getInstance() instead.");
        }
        try {
            if (getClass().getClassLoader().loadClass("com.google.android.play.core.assetpacks.AssetPackManager").getMethod("getPackStates", List.class).getReturnType().getName().equals("com.google.android.gms.tasks.Task")) {
                this.f23987a = a(context);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException unused) {
        }
    }

    private static C3251n a(Context context) {
        return C3251n.a(context);
    }

    public static synchronized PlayAssetDeliveryUnityWrapper getInstance() {
        PlayAssetDeliveryUnityWrapper playAssetDeliveryUnityWrapper;
        while (true) {
            playAssetDeliveryUnityWrapper = f23986b;
            if (playAssetDeliveryUnityWrapper == null) {
                try {
                    PlayAssetDeliveryUnityWrapper.class.wait(androidx.media3.common.C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                } catch (InterruptedException e10) {
                    AbstractC3275z.Log(6, e10.getMessage());
                }
            }
        }
        return playAssetDeliveryUnityWrapper;
    }

    public static synchronized PlayAssetDeliveryUnityWrapper init(Context context) {
        if (f23986b != null) {
            throw new RuntimeException("PlayAssetDeliveryUnityWrapper.init() should be called only once. Use getInstance() instead.");
        }
        f23986b = new PlayAssetDeliveryUnityWrapper(context);
        PlayAssetDeliveryUnityWrapper.class.notifyAll();
        return f23986b;
    }

    public void cancelAssetPackDownload(String str) {
        cancelAssetPackDownloads(new String[]{str});
    }

    public void cancelAssetPackDownloads(String[] strArr) {
        a();
        this.f23987a.a(strArr);
    }

    public void downloadAssetPack(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        downloadAssetPacks(new String[]{str}, iAssetPackManagerDownloadStatusCallback);
    }

    public void downloadAssetPacks(String[] strArr, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        a();
        this.f23987a.a(strArr, iAssetPackManagerDownloadStatusCallback);
    }

    public String getAssetPackPath(String str) {
        a();
        return this.f23987a.a(str);
    }

    public void getAssetPackState(String str, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        getAssetPackStates(new String[]{str}, iAssetPackManagerStatusQueryCallback);
    }

    public void getAssetPackStates(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        a();
        this.f23987a.a(strArr, iAssetPackManagerStatusQueryCallback);
    }

    public boolean playCoreApiMissing() {
        return this.f23987a == null;
    }

    public Object registerDownloadStatusListener(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        a();
        return this.f23987a.a(iAssetPackManagerDownloadStatusCallback);
    }

    public void removeAssetPack(String str) {
        a();
        this.f23987a.b(str);
    }

    public void requestToUseMobileData(Activity activity, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        a();
        this.f23987a.a(activity, iAssetPackManagerMobileDataConfirmationCallback);
    }

    public void unregisterDownloadStatusListener(Object obj) {
        a();
        this.f23987a.a(obj);
    }

    private void a() {
        if (playCoreApiMissing()) {
            throw new RuntimeException("AssetPackManager API is not available! Make sure your gradle project includes 'com.google.android.play:asset-delivery' dependency.");
        }
    }
}
