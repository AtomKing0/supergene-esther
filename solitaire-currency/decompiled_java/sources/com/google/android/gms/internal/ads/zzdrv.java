package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdrv {
    public static Bundle zza(Pair... pairArr) {
        Bundle bundle = new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbS)).booleanValue()) {
            for (int i10 = 0; i10 < 2; i10++) {
                Pair pair = pairArr[i10];
                if (!TextUtils.isEmpty((CharSequence) pair.first) && ((Long) pair.second).longValue() > 0) {
                    bundle.putLong((String) pair.first, ((Long) pair.second).longValue());
                }
            }
        }
        return bundle;
    }
}
