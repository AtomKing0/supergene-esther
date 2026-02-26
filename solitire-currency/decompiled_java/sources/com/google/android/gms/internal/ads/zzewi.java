package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.m;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzewi implements zzevo {
    private final com.google.android.gms.ads.internal.util.zzg zza;
    private final Context zzb;
    private final zzgcu zzc;
    private final ScheduledExecutorService zzd;
    private final zzeer zze;
    private final zzffg zzf;
    private final VersionInfoParcel zzg;

    zzewi(com.google.android.gms.ads.internal.util.zzg zzgVar, Context context, zzgcu zzgcuVar, ScheduledExecutorService scheduledExecutorService, zzeer zzeerVar, zzffg zzffgVar, VersionInfoParcel versionInfoParcel) {
        this.zza = zzgVar;
        this.zzb = context;
        this.zzc = zzgcuVar;
        this.zzd = scheduledExecutorService;
        this.zze = zzeerVar;
        this.zzf = zzffgVar;
        this.zzg = versionInfoParcel;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 56;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009e, code lost:
    
        if (java.util.Arrays.asList(r0.split(",")).contains(r5.zzb.getPackageName()) == false) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    @Override // com.google.android.gms.internal.ads.zzevo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.common.util.concurrent.m zzb() {
        /*
            Method dump skipped, instruction units count: 266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzewi.zzb():com.google.common.util.concurrent.m");
    }

    final /* synthetic */ m zzc(final Throwable th) throws Exception {
        this.zzc.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzewf
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjA)).booleanValue();
                Throwable th2 = th;
                if (zBooleanValue) {
                    com.google.android.gms.ads.internal.zzu.zzo().zzx(th2, "TopicsSignalUnsampled.fetchTopicsSignal");
                } else {
                    com.google.android.gms.ads.internal.zzu.zzo().zzv(th2, "TopicsSignal.fetchTopicsSignal");
                }
            }
        });
        return zzgcj.zzh(th instanceof SecurityException ? new zzewk("", 2, null) : th instanceof IllegalStateException ? new zzewk("", 3, null) : th instanceof IllegalArgumentException ? new zzewk("", 4, null) : th instanceof TimeoutException ? new zzewk("", 5, null) : new zzewk("", 0, null));
    }
}
