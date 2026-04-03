package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbvi {
    private final WeakHashMap zza = new WeakHashMap();

    public final Future zzb(Context context) {
        return zzbzo.zza.zzb(new zzbvg(this, context));
    }
}
