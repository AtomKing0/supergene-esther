package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfyh {
    public static ArrayList zza(int i10) {
        zzfwo.zza(i10, "initialArraySize");
        return new ArrayList(i10);
    }

    public static List zzb(List list, zzful zzfulVar) {
        return list instanceof RandomAccess ? new zzfye(list, zzfulVar) : new zzfyg(list, zzfulVar);
    }
}
