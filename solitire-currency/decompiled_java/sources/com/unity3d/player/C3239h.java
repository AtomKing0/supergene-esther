package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackState;
import com.google.android.play.core.assetpacks.AssetPackStateUpdateListener;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: renamed from: com.unity3d.player.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3239h implements AssetPackStateUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashSet f24112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Looper f24113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ C3251n f24114c;

    public C3239h(C3251n c3251n, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback, Looper looper) {
        this.f24114c = c3251n;
        HashSet hashSet = new HashSet();
        this.f24112a = hashSet;
        hashSet.add(iAssetPackManagerDownloadStatusCallback);
        this.f24113b = looper;
    }

    public final synchronized void a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        this.f24112a.add(iAssetPackManagerDownloadStatusCallback);
    }

    public final void onStateUpdate(Object obj) {
        AssetPackState assetPackState = (AssetPackState) obj;
        synchronized (this) {
            if (assetPackState.status() == 4 || assetPackState.status() == 5 || assetPackState.status() == 0) {
                synchronized (C3251n.f24159d) {
                    this.f24114c.f24161b.remove(assetPackState.name());
                    if (this.f24114c.f24161b.isEmpty()) {
                        C3251n c3251n = this.f24114c;
                        c3251n.a(c3251n.f24162c);
                        this.f24114c.f24162c = null;
                    }
                }
            }
            if (this.f24112a.size() != 0) {
                new Handler(this.f24113b).post(new RunnableC3237g((Set) this.f24112a.clone(), assetPackState.name(), assetPackState.status(), assetPackState.totalBytesToDownload(), assetPackState.bytesDownloaded(), assetPackState.transferProgressPercentage(), assetPackState.errorCode()));
            }
        }
    }
}
