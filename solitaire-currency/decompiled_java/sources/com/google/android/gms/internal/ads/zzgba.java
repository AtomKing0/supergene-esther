package com.google.android.gms.internal.ads;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzgba {
    public static /* synthetic */ boolean zza(Unsafe unsafe, Object obj, long j10, Object obj2, Object obj3) {
        while (!l.a(unsafe, obj, j10, obj2, obj3)) {
            if (unsafe.getObject(obj, j10) != obj2) {
                return false;
            }
        }
        return true;
    }
}
