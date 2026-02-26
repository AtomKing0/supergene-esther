package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeiu implements zzgbq {
    private final zzfjl zza;
    private final zzcws zzb;
    private final zzflh zzc;
    private final zzfll zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcrx zzg;
    private final zzein zzh;
    private final zzeey zzi;
    private final Context zzj;
    private final zzfkf zzk;
    private final zzehx zzl;
    private final zzdsf zzm;

    zzeiu(Context context, zzfjl zzfjlVar, zzein zzeinVar, zzcws zzcwsVar, zzflh zzflhVar, zzfll zzfllVar, zzcrx zzcrxVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzeey zzeeyVar, zzfkf zzfkfVar, zzehx zzehxVar, zzdsf zzdsfVar) {
        this.zzj = context;
        this.zza = zzfjlVar;
        this.zzh = zzeinVar;
        this.zzb = zzcwsVar;
        this.zzc = zzflhVar;
        this.zzd = zzfllVar;
        this.zzg = zzcrxVar;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzeeyVar;
        this.zzk = zzfkfVar;
        this.zzl = zzehxVar;
        this.zzm = zzdsfVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static java.lang.String zzc(com.google.android.gms.internal.ads.zzfex r5) {
        /*
            com.google.android.gms.internal.ads.zzbbn r0 = com.google.android.gms.internal.ads.zzbbw.zzeS
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.String r1 = "No fill."
            r2 = 1
            if (r2 == r0) goto L18
            java.lang.String r0 = "No ad config."
            goto L19
        L18:
            r0 = r1
        L19:
            com.google.android.gms.internal.ads.zzfew r2 = r5.zzb
            com.google.android.gms.internal.ads.zzfeo r2 = r2.zzb
            int r2 = r2.zzf
            if (r2 == 0) goto L57
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 < r3) goto L3c
            if (r2 >= r4) goto L3c
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzeR
            com.google.android.gms.internal.ads.zzbbu r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L57
            goto L58
        L3c:
            if (r2 < r4) goto L45
            r0 = 400(0x190, float:5.6E-43)
            if (r2 >= r0) goto L45
            java.lang.String r1 = "No location header to follow redirect or too many redirects."
            goto L58
        L45:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Received error HTTP response code: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r1 = r0.toString()
            goto L58
        L57:
            r1 = r0
        L58:
            com.google.android.gms.internal.ads.zzfew r5 = r5.zzb
            com.google.android.gms.internal.ads.zzfeo r5 = r5.zzb
            com.google.android.gms.internal.ads.zzfen r5 = r5.zzj
            if (r5 == 0) goto L65
            java.lang.String r5 = r5.zza()
            return r5
        L65:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiu.zzc(com.google.android.gms.internal.ads.zzfex):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
    @Override // com.google.android.gms.internal.ads.zzgbq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ com.google.common.util.concurrent.m zza(java.lang.Object r9) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeiu.zza(java.lang.Object):com.google.common.util.concurrent.m");
    }

    final /* synthetic */ m zzb(zzfel zzfelVar, zzfex zzfexVar, zzeet zzeetVar, Throwable th) throws Exception {
        zzfju zzfjuVarZza = zzfjt.zza(this.zzj, 12);
        zzfjuVarZza.zzd(zzfelVar.zzE);
        zzfjuVarZza.zzi();
        m mVarZzo = zzgcj.zzo(zzeetVar.zza(zzfexVar, zzfelVar), zzfelVar.zzR, TimeUnit.MILLISECONDS, this.zzf);
        this.zzh.zzf(zzfexVar, zzfelVar, mVarZzo, this.zzc);
        zzfke.zza(mVarZzo, this.zzk, zzfjuVarZza);
        return mVarZzo;
    }
}
