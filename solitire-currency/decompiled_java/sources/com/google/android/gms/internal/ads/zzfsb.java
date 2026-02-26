package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfsb extends zzfrz {
    private static zzfsb zzc;

    private zzfsb(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzfsb zzj(Context context) {
        zzfsb zzfsbVar;
        synchronized (zzfsb.class) {
            if (zzc == null) {
                zzc = new zzfsb(context);
            }
            zzfsbVar = zzc;
        }
        return zzfsbVar;
    }

    public final zzfry zzh(long j10, boolean z10) throws IOException {
        zzfry zzfryVarZzb;
        synchronized (zzfsb.class) {
            zzfryVarZzb = zzb(null, null, j10, z10);
        }
        return zzfryVarZzb;
    }

    public final zzfry zzi(String str, String str2, long j10, boolean z10) throws IOException {
        zzfry zzfryVarZzb;
        synchronized (zzfsb.class) {
            zzfryVarZzb = zzb(str, str2, j10, z10);
        }
        return zzfryVarZzb;
    }

    public final void zzk() throws IOException {
        synchronized (zzfsb.class) {
            zzf(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzfsb.class) {
            zzf(true);
        }
    }
}
