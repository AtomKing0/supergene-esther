package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.google.android.play.core.assetpacks.AssetPackLocation;
import com.google.android.play.core.assetpacks.AssetPackManager;
import com.google.android.play.core.assetpacks.AssetPackManagerFactory;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/* JADX INFO: renamed from: com.unity3d.player.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3251n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static C3251n f24159d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AssetPackManager f24160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashSet f24161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f24162c;

    private C3251n(Context context) {
        if (f24159d != null) {
            throw new RuntimeException("AssetPackManagerWrapper should be created only once. Use getInstance() instead.");
        }
        this.f24160a = AssetPackManagerFactory.getInstance(context);
        this.f24161b = new HashSet();
    }

    public static C3251n a(Context context) {
        if (f24159d == null) {
            f24159d = new C3251n(context);
        }
        return f24159d;
    }

    public final void b(String str) {
        this.f24160a.removePack(str);
    }

    public final Object a(IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        C3239h c3239h = new C3239h(this, iAssetPackManagerDownloadStatusCallback, Looper.myLooper());
        this.f24160a.registerListener(c3239h);
        return c3239h;
    }

    public final String a(String str) {
        AssetPackLocation packLocation = this.f24160a.getPackLocation(str);
        return packLocation == null ? "" : packLocation.assetsPath();
    }

    public final void a(Activity activity, IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        this.f24160a.showCellularDataConfirmation(activity).addOnSuccessListener(new C3243j(iAssetPackManagerMobileDataConfirmationCallback));
    }

    public final void a(Object obj) {
        if (obj instanceof C3239h) {
            this.f24160a.unregisterListener((C3239h) obj);
        }
    }

    public final void a(String[] strArr) {
        this.f24160a.cancel(Arrays.asList(strArr));
    }

    public final void a(String[] strArr, IAssetPackManagerDownloadStatusCallback iAssetPackManagerDownloadStatusCallback) {
        for (String str : strArr) {
            this.f24160a.getPackStates(Collections.singletonList(str)).addOnCompleteListener(new C3245k(str, iAssetPackManagerDownloadStatusCallback));
        }
    }

    public final void a(String[] strArr, IAssetPackManagerStatusQueryCallback iAssetPackManagerStatusQueryCallback) {
        this.f24160a.getPackStates(Arrays.asList(strArr)).addOnCompleteListener(new C3249m(strArr, iAssetPackManagerStatusQueryCallback));
    }
}
