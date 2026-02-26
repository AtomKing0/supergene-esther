package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeud implements zzevo {
    private final Context zza;
    private final zzgcu zzb;
    private final zzffg zzc;
    private final VersionInfoParcel zzd;

    zzeud(Context context, zzgcu zzgcuVar, zzffg zzffgVar, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzgcuVar;
        this.zzc = zzffgVar;
        this.zzd = versionInfoParcel;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 53;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return this.zzb.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056 A[Catch: IOException -> 0x0122, TryCatch #0 {IOException -> 0x0122, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00eb, B:28:0x010f, B:30:0x011a, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1 A[Catch: IOException -> 0x0122, TryCatch #0 {IOException -> 0x0122, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:8:0x0030, B:13:0x0056, B:14:0x007a, B:16:0x008c, B:18:0x00a2, B:20:0x00ab, B:25:0x00d1, B:27:0x00eb, B:28:0x010f, B:30:0x011a, B:23:0x00bf, B:11:0x0044), top: B:35:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ com.google.android.gms.internal.ads.zzeue zzc() throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeud.zzc():com.google.android.gms.internal.ads.zzeue");
    }
}
