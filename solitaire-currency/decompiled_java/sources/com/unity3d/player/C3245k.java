package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.assetpacks.AssetPackException;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStates;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: renamed from: com.unity3d.player.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3245k implements OnCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAssetPackManagerDownloadStatusCallback f24133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Looper f24134b = Looper.myLooper();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f24135c;

    public C3245k(String str, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.f24133a = iAssetPackManagerDownloadStatusCallback;
        this.f24135c = str;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        int errorCode;
        try {
            AssetPackStates assetPackStates = (AssetPackStates) task.getResult();
            Map mapPackStates = assetPackStates.packStates();
            if (mapPackStates.size() == 0) {
                return;
            }
            for (AssetPackState assetPackState : mapPackStates.values()) {
                if (assetPackState.errorCode() != 0 || assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                    String strName = assetPackState.name();
                    int iStatus = assetPackState.status();
                    int iErrorCode = assetPackState.errorCode();
                    long j10 = assetPackStates.totalBytes();
                    new Handler(this.f24134b).post(new RunnableC3237g(Collections.singleton(this.f24133a), strName, iStatus, j10, iStatus == 4 ? j10 : 0L, 0, iErrorCode));
                } else {
                    C3251n c3251n = C3251n.f24159d;
                    String strName2 = assetPackState.name();
                    IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback = this.f24133a;
                    Looper looper = this.f24134b;
                    c3251n.getClass();
                    synchronized (C3251n.f24159d) {
                        Object obj = c3251n.f24162c;
                        if (obj == null) {
                            C3239h c3239h = new C3239h(c3251n, iAssetPackManagerDownloadStatusCallback, looper);
                            c3251n.f24160a.registerListener(c3239h);
                            c3251n.f24162c = c3239h;
                        } else {
                            ((C3239h) obj).a(iAssetPackManagerDownloadStatusCallback);
                        }
                        c3251n.f24161b.add(strName2);
                        c3251n.f24160a.fetch(Collections.singletonList(strName2));
                    }
                }
            }
        } catch (RuntimeExecutionException e10) {
            e = e10;
            String str = this.f24135c;
            while (true) {
                if (e instanceof AssetPackException) {
                    errorCode = e.getErrorCode();
                    break;
                }
                e = e.getCause();
                if (e == null) {
                    errorCode = -100;
                    break;
                }
            }
            new Handler(this.f24134b).post(new RunnableC3237g(Collections.singleton(this.f24133a), str, 0, 0L, 0L, 0, errorCode));
        }
    }
}
