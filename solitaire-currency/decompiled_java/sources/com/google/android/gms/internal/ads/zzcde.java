package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import com.unity3d.services.UnityAdsConstants;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcde extends zzccv implements zzcba {
    public static final /* synthetic */ int zzd = 0;
    private zzcbb zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzccn zzi;
    private long zzj;
    private long zzk;

    public zzcde(zzcbk zzcbkVar, zzcbj zzcbjVar) {
        super(zzcbkVar);
        zzcdw zzcdwVar = new zzcdw(zzcbkVar.getContext(), zzcbjVar, (zzcbk) this.zzc.get(), null);
        com.google.android.gms.ads.internal.util.client.zzm.zzi("ExoPlayerAdapter initialized.");
        this.zze = zzcdwVar;
        zzcdwVar.zzL(this);
    }

    protected static final String zzc(String str) {
        return "cache:".concat(String.valueOf(com.google.android.gms.ads.internal.util.client.zzf.zzf(str)));
    }

    private static String zzd(String str, Exception exc) {
        return str + UnityAdsConstants.DefaultUrls.AD_ASSET_PATH + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzx(long j10) {
        com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdd
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.zza.zzb();
            }
        }, j10);
    }

    @Override // com.google.android.gms.internal.ads.zzccv, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzcbb zzcbbVar = this.zze;
        if (zzcbbVar != null) {
            zzcbbVar.zzL(null);
            this.zze.zzH();
        }
    }

    public final zzcbb zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzL(null);
        zzcbb zzcbbVar = this.zze;
        this.zze = null;
        return zzcbbVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22, types: [com.google.android.gms.internal.ads.zzccv, com.google.android.gms.internal.ads.zzcde] */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26, types: [com.google.android.gms.internal.ads.zzcde] */
    /* JADX WARN: Type inference failed for: r2v31 */
    final /* synthetic */ void zzb() throws Throwable {
        String str;
        zzcde zzcdeVarBooleanValue;
        zzcde zzcdeVar;
        zzbbu zzbbuVarZzc;
        long jLongValue;
        long jIntValue;
        zzcde zzcdeVar2;
        long j10;
        long j11;
        String str2;
        long j12;
        String strZzc = zzc(this.zzf);
        Object obj = "error";
        try {
            zzbbn zzbbnVar = zzbbw.zzr;
            zzbbuVarZzc = com.google.android.gms.ads.internal.client.zzba.zzc();
            jLongValue = ((Long) zzbbuVarZzc.zza(zzbbnVar)).longValue() * 1000;
            jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzq)).intValue();
            zzcdeVarBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbG)).booleanValue();
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e10) {
            e = e10;
            str = strZzc;
            zzcdeVarBooleanValue = this;
        }
        synchronized (this) {
            try {
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
                long j13 = this.zzj;
                if (jCurrentTimeMillis - j13 <= jLongValue) {
                    try {
                        if (this.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (!this.zzh) {
                            if (!this.zze.zzV()) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            long jZzz = this.zze.zzz();
                            if (jZzz > 0) {
                                long jZzv = this.zze.zzv();
                                if (jZzv != this.zzk) {
                                    try {
                                        j11 = jIntValue;
                                        str2 = strZzc;
                                        try {
                                            zzo(this.zzf, strZzc, jZzv, jZzz, jZzv > 0, zzcdeVarBooleanValue != 0 ? this.zze.zzA() : -1L, zzcdeVarBooleanValue != 0 ? this.zze.zzx() : -1L, zzcdeVarBooleanValue != 0 ? this.zze.zzB() : -1L, zzcbb.zzs(), zzcbb.zzu());
                                            zzcdeVarBooleanValue = this;
                                            j10 = jZzv;
                                            try {
                                                zzcdeVarBooleanValue.zzk = j10;
                                                j12 = jZzz;
                                                zzcdeVarBooleanValue = zzcdeVarBooleanValue;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                str = str2;
                                                throw th;
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            zzcdeVarBooleanValue = this;
                                            str = str2;
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        zzcdeVarBooleanValue = this;
                                        str = strZzc;
                                        throw th;
                                    }
                                } else {
                                    j10 = jZzv;
                                    j11 = jIntValue;
                                    str2 = strZzc;
                                    zzcdeVarBooleanValue = this;
                                    j12 = jZzz;
                                }
                                if (j10 >= j12) {
                                    zzcdeVarBooleanValue.zzj(zzcdeVarBooleanValue.zzf, str2, j12);
                                    zzcdeVar = zzcdeVarBooleanValue;
                                } else {
                                    long jZzw = zzcdeVarBooleanValue.zze.zzw();
                                    zzcdeVar2 = zzcdeVarBooleanValue;
                                    if (jZzw >= j11) {
                                        zzcdeVar2 = zzcdeVarBooleanValue;
                                        if (j10 > 0) {
                                            zzcdeVar = zzcdeVarBooleanValue;
                                        }
                                    }
                                }
                            } else {
                                zzcdeVar2 = this;
                            }
                            zzcdeVar2.zzx(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzs)).longValue());
                            return;
                        }
                        zzcdeVar = this;
                        com.google.android.gms.ads.internal.zzu.zzy().zzc(zzcdeVar.zzi);
                    } catch (Throwable th5) {
                        th = th5;
                        obj = zzbbuVarZzc;
                        str = j13;
                    }
                } else {
                    str = strZzc;
                    zzcdeVarBooleanValue = this;
                    try {
                        throw new IOException("Timeout reached. Limit: " + jLongValue + " ms");
                    } catch (Throwable th6) {
                        th = th6;
                        obj = "downloadTimeout";
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                str = strZzc;
                zzcdeVarBooleanValue = this;
            }
            try {
                throw th;
            } catch (Exception e11) {
                e = e11;
                String str3 = obj;
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Failed to preload url " + zzcdeVarBooleanValue.zzf + " Exception: " + e.getMessage());
                com.google.android.gms.ads.internal.zzu.zzo().zzv(e, "VideoStreamExoPlayerCache.preload");
                release();
                zzcdeVarBooleanValue.zzg(zzcdeVarBooleanValue.zzf, str, str3, zzd(str3, e));
                zzcdeVar = zzcdeVarBooleanValue;
                com.google.android.gms.ads.internal.zzu.zzy().zzc(zzcdeVar.zzi);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzf() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzg(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzi(final boolean z10, final long j10) {
        final zzcbk zzcbkVar = (zzcbk) this.zzc.get();
        if (zzcbkVar != null) {
            zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcdc
                @Override // java.lang.Runnable
                public final void run() {
                    zzcbkVar.zzv(z10, j10);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzk(String str, Exception exc) {
        com.google.android.gms.ads.internal.util.client.zzm.zzk("Precache error", exc);
        com.google.android.gms.ads.internal.zzu.zzo().zzv(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzl(String str, Exception exc) {
        com.google.android.gms.ads.internal.util.client.zzm.zzk("Precache exception", exc);
        com.google.android.gms.ads.internal.zzu.zzo().zzv(exc, "VideoStreamExoPlayerCache.onException");
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzp(int i10) {
        this.zze.zzJ(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzq(int i10) {
        this.zze.zzK(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzr(int i10) {
        this.zze.zzM(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final void zzs(int i10) {
        this.zze.zzN(i10);
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final boolean zzt(String str) {
        return zzu(str, new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.google.android.gms.internal.ads.zzcbk] */
    /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.google.android.gms.internal.ads.zzccv, com.google.android.gms.internal.ads.zzcde] */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r15v2, types: [com.google.android.gms.internal.ads.zzcde] */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [long] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v36 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.android.gms.internal.ads.zzccv] */
    /* JADX WARN: Type inference failed for: r5v10, types: [int] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // com.google.android.gms.internal.ads.zzccv
    public final boolean zzu(String str, String[] strArr) throws Throwable {
        ?? r62;
        String str2;
        ?? r52;
        long j10;
        long j11;
        long j12;
        ?? r12;
        long j13;
        long j14;
        String str3;
        long j15;
        ?? r13;
        long j16;
        ?? r15 = this;
        ?? r132 = str;
        r15.zzf = r132;
        ?? r17 = "error";
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i10 = 0; i10 < strArr.length; i10++) {
                uriArr[i10] = Uri.parse(strArr[i10]);
            }
            r15.zze.zzF(uriArr, r15.zzb);
            ?? r02 = (zzcbk) r15.zzc.get();
            if (r02 != 0) {
                r02.zzt(strZzc, r15);
            }
            Clock clockZzB = com.google.android.gms.ads.internal.zzu.zzB();
            long jCurrentTimeMillis = clockZzB.currentTimeMillis();
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzs)).longValue();
            long jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzr)).longValue() * 1000;
            long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzq)).intValue();
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbG)).booleanValue();
            ?? r14 = -1;
            long j17 = jIntValue;
            r132 = r132;
            r15 = r15;
            while (true) {
                synchronized (this) {
                    try {
                        if (clockZzB.currentTimeMillis() - jCurrentTimeMillis > jLongValue2) {
                            throw new IOException("Timeout reached. Limit: " + jLongValue2 + " ms");
                        }
                        if (r15.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (r15.zzh) {
                            break;
                        }
                        if (!r15.zze.zzV()) {
                            throw new IOException("ExoPlayer was released during preloading.");
                        }
                        long jZzz = r15.zze.zzz();
                        if (jZzz > 0) {
                            long jZzv = r15.zze.zzv();
                            if (jZzv != r14) {
                                try {
                                    j13 = j17;
                                    j16 = jZzz;
                                    j11 = jLongValue2;
                                    j14 = jLongValue;
                                    str3 = strZzc;
                                } catch (Throwable th) {
                                    th = th;
                                    r52 = this;
                                    r62 = str;
                                    str2 = strZzc;
                                }
                                try {
                                    zzo(str, strZzc, jZzv, j16, jZzv > 0, zBooleanValue ? r15.zze.zzA() : -1L, zBooleanValue ? r15.zze.zzx() : -1L, zBooleanValue ? r15.zze.zzB() : -1L, zzcbb.zzs(), zzcbb.zzu());
                                    r13 = jZzv;
                                    j15 = jZzz;
                                    r62 = j16;
                                } catch (Throwable th2) {
                                    th = th2;
                                    r52 = this;
                                    r62 = str;
                                    str2 = str3;
                                    try {
                                        throw th;
                                    } catch (Exception e10) {
                                        e = e10;
                                        ?? r16 = r17;
                                        com.google.android.gms.ads.internal.util.client.zzm.zzj("Failed to preload url " + r62 + " Exception: " + e.getMessage());
                                        com.google.android.gms.ads.internal.zzu.zzo().zzv(e, "VideoStreamExoPlayerCache.preload");
                                        release();
                                        r52.zzg(r62, str2, r16, zzd(r16, e));
                                        return false;
                                    }
                                }
                            } else {
                                j13 = j17;
                                j11 = jLongValue2;
                                j14 = jLongValue;
                                str3 = strZzc;
                                j15 = jZzz;
                                r13 = r14;
                                r62 = j17;
                            }
                            r52 = (jZzv > j15 ? 1 : (jZzv == j15 ? 0 : -1));
                            if (r52 >= 0) {
                                zzj(str, str3, j15);
                            } else {
                                try {
                                    zzcde zzcdeVar = this;
                                    r62 = str;
                                    str2 = str3;
                                    if (zzcdeVar.zze.zzw() < j13 || jZzv <= 0) {
                                        j12 = j14;
                                        r12 = r13;
                                        r52 = zzcdeVar;
                                        j10 = j13;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    throw th;
                                }
                            }
                        } else {
                            j10 = j17;
                            j11 = jLongValue2;
                            r62 = r132;
                            str2 = strZzc;
                            r52 = r15;
                            j12 = jLongValue;
                            r12 = r14;
                        }
                        try {
                            try {
                                r52.wait(j12);
                            } catch (InterruptedException unused) {
                                throw new IOException("Wait interrupted.");
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            r17 = r12;
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        r62 = r132;
                        str2 = strZzc;
                        r52 = r15;
                    }
                }
                jLongValue = j12;
                r15 = r52;
                r132 = r62;
                strZzc = str2;
                j17 = j10;
                jLongValue2 = j11;
                r14 = r12;
            }
            return true;
        } catch (Exception e11) {
            e = e11;
            r62 = r132;
            str2 = strZzc;
            r52 = r15;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzv() {
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Precache onRenderedFirstFrame");
    }

    @Override // com.google.android.gms.internal.ads.zzccv
    public final boolean zzw(String str, String[] strArr, zzccn zzccnVar) {
        this.zzf = str;
        this.zzi = zzccnVar;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i10 = 0; i10 < strArr.length; i10++) {
                uriArr[i10] = Uri.parse(strArr[i10]);
            }
            this.zze.zzF(uriArr, this.zzb);
            zzcbk zzcbkVar = (zzcbk) this.zzc.get();
            if (zzcbkVar != null) {
                zzcbkVar.zzt(strZzc, this);
            }
            this.zzj = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
            this.zzk = -1L;
            zzx(0L);
            return true;
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Failed to preload url " + str + " Exception: " + e10.getMessage());
            com.google.android.gms.ads.internal.zzu.zzo().zzv(e10, "VideoStreamExoPlayerCache.preload");
            release();
            zzg(str, strZzc, "error", zzd("error", e10));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzm(int i10) {
    }

    @Override // com.google.android.gms.internal.ads.zzcba
    public final void zzD(int i10, int i11) {
    }
}
