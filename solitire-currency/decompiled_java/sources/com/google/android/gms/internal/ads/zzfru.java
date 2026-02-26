package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.CallSuper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzfru extends Handler {
    public zzfru() {
        Looper.getMainLooper();
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        zza(message);
    }

    @CallSuper
    protected void zza(Message message) {
        super.dispatchMessage(message);
    }

    public zzfru(Looper looper) {
        super(looper);
        Looper.getMainLooper();
    }
}
