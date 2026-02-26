package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: renamed from: com.unity3d.player.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
final class C3243j implements OnSuccessListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAssetPackManagerMobileDataConfirmationCallback f24130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Looper f24131b = Looper.myLooper();

    public C3243j(IAssetPackManagerMobileDataConfirmationCallback iAssetPackManagerMobileDataConfirmationCallback) {
        this.f24130a = iAssetPackManagerMobileDataConfirmationCallback;
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        Integer num = (Integer) obj;
        if (this.f24130a != null) {
            new Handler(this.f24131b).post(new RunnableC3241i(this.f24130a, num.intValue() == -1));
        }
    }
}
