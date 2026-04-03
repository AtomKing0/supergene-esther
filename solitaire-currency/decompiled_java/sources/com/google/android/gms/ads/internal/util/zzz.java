package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.internal.ads.zzbbw;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(30)
public final class zzz extends zzy {
    @Override // com.google.android.gms.ads.internal.util.zzab
    public final int zzm(Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhL)).booleanValue()) {
            return 0;
        }
        return super.zzm(context);
    }
}
