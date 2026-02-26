package com.google.android.gms.ads.internal.util;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzaop;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.common.util.concurrent.m;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbo {
    private static zzapk zza;
    private static final Object zzb = new Object();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[Catch: all -> 0x003d, TryCatch #0 {, blocks: (B:7:0x0010, B:9:0x0014, B:11:0x001d, B:13:0x002f, B:15:0x0039, B:14:0x0034, B:16:0x003b), top: B:21:0x0010 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzbo(android.content.Context r4) {
        /*
            r3 = this;
            r3.<init>()
            android.content.Context r0 = r4.getApplicationContext()
            if (r0 == 0) goto Ld
            android.content.Context r4 = r4.getApplicationContext()
        Ld:
            java.lang.Object r0 = com.google.android.gms.ads.internal.util.zzbo.zzb
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzapk r1 = com.google.android.gms.ads.internal.util.zzbo.zza     // Catch: java.lang.Throwable -> L3d
            if (r1 != 0) goto L3b
            com.google.android.gms.internal.ads.zzbbw.zza(r4)     // Catch: java.lang.Throwable -> L3d
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch: java.lang.Throwable -> L3d
            if (r1 != 0) goto L34
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzdW     // Catch: java.lang.Throwable -> L3d
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L3d
            java.lang.Object r1 = r2.zza(r1)     // Catch: java.lang.Throwable -> L3d
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L3d
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L34
            com.google.android.gms.internal.ads.zzapk r4 = com.google.android.gms.ads.internal.util.zzaz.zzb(r4)     // Catch: java.lang.Throwable -> L3d
            goto L39
        L34:
            r1 = 0
            com.google.android.gms.internal.ads.zzapk r4 = com.google.android.gms.internal.ads.zzaqo.zza(r4, r1)     // Catch: java.lang.Throwable -> L3d
        L39:
            com.google.android.gms.ads.internal.util.zzbo.zza = r4     // Catch: java.lang.Throwable -> L3d
        L3b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3d
            return
        L3d:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3d
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzbo.<init>(android.content.Context):void");
    }

    public final m zza(String str) {
        zzbzt zzbztVar = new zzbzt();
        zza.zza(new zzbn(str, null, zzbztVar));
        return zzbztVar;
    }

    public final m zzb(int i10, String str, @Nullable Map map, @Nullable byte[] bArr) {
        zzbl zzblVar = new zzbl(null);
        zzbi zzbiVar = new zzbi(this, str, zzblVar);
        com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
        zzbj zzbjVar = new zzbj(this, i10, str, zzblVar, zzbiVar, bArr, map, zzlVar);
        if (com.google.android.gms.ads.internal.util.client.zzl.zzk()) {
            try {
                zzlVar.zzd(str, "GET", zzbjVar.zzl(), zzbjVar.zzx());
            } catch (zzaop e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj(e10.getMessage());
            }
        }
        zza.zza(zzbjVar);
        return zzblVar;
    }
}
