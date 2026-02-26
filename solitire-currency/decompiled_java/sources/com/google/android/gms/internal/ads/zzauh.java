package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzauh implements zzauk {

    @Nullable
    private static zzauh zzb;
    private final Context zzc;
    private final zzfpw zzd;
    private final zzfqd zze;
    private final zzfqf zzf;
    private final zzavj zzg;
    private final zzfoh zzh;
    private final Executor zzi;
    private final zzfqc zzj;
    private final zzavy zzl;

    @Nullable
    private final zzavq zzm;

    @Nullable
    private final zzavh zzn;
    private volatile boolean zzp;
    private volatile boolean zzq;
    private final int zzr;

    @VisibleForTesting
    volatile long zza = 0;
    private final Object zzo = new Object();
    private final CountDownLatch zzk = new CountDownLatch(1);

    @VisibleForTesting
    zzauh(@NonNull Context context, @NonNull zzfoh zzfohVar, @NonNull zzfpw zzfpwVar, @NonNull zzfqd zzfqdVar, @NonNull zzfqf zzfqfVar, @NonNull zzavj zzavjVar, @NonNull Executor executor, @NonNull zzfoc zzfocVar, int i10, @Nullable zzavy zzavyVar, @Nullable zzavq zzavqVar, @Nullable zzavh zzavhVar) {
        this.zzq = false;
        this.zzc = context;
        this.zzh = zzfohVar;
        this.zzd = zzfpwVar;
        this.zze = zzfqdVar;
        this.zzf = zzfqfVar;
        this.zzg = zzavjVar;
        this.zzi = executor;
        this.zzr = i10;
        this.zzl = zzavyVar;
        this.zzm = zzavqVar;
        this.zzn = zzavhVar;
        this.zzq = false;
        this.zzj = new zzauf(this, zzfocVar);
    }

    public static synchronized zzauh zza(@NonNull String str, @NonNull Context context, boolean z10, boolean z11) {
        return zzb(str, context, Executors.newCachedThreadPool(), z10, z11);
    }

    @Deprecated
    public static synchronized zzauh zzb(@NonNull String str, @NonNull Context context, @NonNull Executor executor, boolean z10, boolean z11) {
        if (zzb == null) {
            zzfoi zzfoiVarZza = zzfoj.zza();
            zzfoiVarZza.zza(str);
            zzfoiVarZza.zzc(z10);
            zzfoj zzfojVarZzd = zzfoiVarZza.zzd();
            zzfoh zzfohVarZza = zzfoh.zza(context, executor, z11);
            zzaus zzausVarZzc = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcY)).booleanValue() ? zzaus.zzc(context) : null;
            zzavy zzavyVarZzd = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcZ)).booleanValue() ? zzavy.zzd(context, executor) : null;
            zzavq zzavqVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcs)).booleanValue() ? new zzavq() : null;
            zzavh zzavhVar = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzct)).booleanValue() ? new zzavh() : null;
            zzfpa zzfpaVarZze = zzfpa.zze(context, executor, zzfohVarZza, zzfojVarZzd);
            zzavi zzaviVar = new zzavi(context);
            zzavj zzavjVar = new zzavj(zzfojVarZzd, zzfpaVarZze, new zzavw(context, zzaviVar), zzaviVar, zzausVarZzc, zzavyVarZzd, zzavqVar, zzavhVar);
            int iZzb = zzfpj.zzb(context, zzfohVarZza);
            zzfoc zzfocVar = new zzfoc();
            zzauh zzauhVar = new zzauh(context, zzfohVarZza, new zzfpw(context, iZzb), new zzfqd(context, iZzb, new zzaue(zzfohVarZza), ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcc)).booleanValue()), new zzfqf(context, zzavjVar, zzfohVarZza, zzfocVar), zzavjVar, executor, zzfocVar, iZzb, zzavyVarZzd, zzavqVar, zzavhVar);
            zzb = zzauhVar;
            zzauhVar.zzm();
            zzb.zzp();
        }
        return zzb;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00f5 A[Catch: all -> 0x011c, zzgyn -> 0x011e, TryCatch #2 {zzgyn -> 0x011e, blocks: (B:6:0x0021, B:8:0x0032, B:12:0x0038, B:13:0x0044, B:15:0x0052, B:17:0x0060, B:20:0x006d, B:27:0x009c, B:31:0x00b5, B:37:0x00ce, B:38:0x00db, B:40:0x00e1, B:42:0x00e9, B:43:0x00eb, B:34:0x00bf, B:35:0x00c6, B:23:0x0074, B:25:0x008a, B:44:0x00f5, B:45:0x0102, B:46:0x010f), top: B:58:0x0021, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* bridge */ /* synthetic */ void zzj(com.google.android.gms.internal.ads.zzauh r12) {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzauh.zzj(com.google.android.gms.internal.ads.zzauh):void");
    }

    private final void zzs() {
        zzavy zzavyVar = this.zzl;
        if (zzavyVar != null) {
            zzavyVar.zzh();
        }
    }

    private final zzfpv zzt(int i10) {
        if (zzfpj.zza(this.zzr)) {
            return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzca)).booleanValue() ? this.zze.zzc(1) : this.zzd.zzc(1);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zze(Context context, @Nullable String str, @Nullable View view) {
        return zzf(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzf(Context context, String str, @Nullable View view, @Nullable Activity activity) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcs)).booleanValue()) {
            this.zzm.zzi();
        }
        zzp();
        zzfok zzfokVarZza = this.zzf.zza();
        if (zzfokVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZza = zzfokVarZza.zza(context, null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - jCurrentTimeMillis, strZza, null);
        return strZza;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzg(Context context) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcs)).booleanValue()) {
            this.zzm.zzj();
        }
        zzp();
        zzfok zzfokVarZza = this.zzf.zza();
        if (zzfokVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzc = zzfokVarZza.zzc(context, null);
        this.zzh.zzf(5001, System.currentTimeMillis() - jCurrentTimeMillis, strZzc, null);
        return strZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final String zzh(Context context, @Nullable View view, @Nullable Activity activity) {
        zzs();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcs)).booleanValue()) {
            this.zzm.zzk(context, view);
        }
        zzp();
        zzfok zzfokVarZza = this.zzf.zza();
        if (zzfokVarZza == null) {
            return "";
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strZzb = zzfokVarZza.zzb(context, null, view, activity);
        this.zzh.zzf(5002, System.currentTimeMillis() - jCurrentTimeMillis, strZzb, null);
        return strZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzk(@Nullable MotionEvent motionEvent) {
        zzfok zzfokVarZza = this.zzf.zza();
        if (zzfokVarZza != null) {
            try {
                zzfokVarZza.zzd(null, motionEvent);
            } catch (zzfqe e10) {
                this.zzh.zzc(e10.zza(), -1L, e10);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzl(int i10, int i11, int i12) {
        DisplayMetrics displayMetrics;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzkY)).booleanValue() || (displayMetrics = this.zzc.getResources().getDisplayMetrics()) == null) {
            return;
        }
        float f10 = i10;
        float f11 = displayMetrics.density;
        float f12 = i11;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, f10 * f11, f12 * f11, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain);
        motionEventObtain.recycle();
        float f13 = displayMetrics.density;
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, 0L, 2, f10 * f13, f12 * f13, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain2);
        motionEventObtain2.recycle();
        float f14 = displayMetrics.density;
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, i12, 1, f10 * f14, f12 * f14, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        zzk(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    final synchronized void zzm() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        zzfpv zzfpvVarZzt = zzt(1);
        if (zzfpvVarZzt == null) {
            this.zzh.zzd(4013, System.currentTimeMillis() - jCurrentTimeMillis);
        } else if (this.zzf.zzc(zzfpvVarZzt)) {
            this.zzq = true;
            this.zzk.countDown();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzavh zzavhVar = this.zzn;
        if (zzavhVar != null) {
            zzavhVar.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauk
    public final void zzo(@Nullable View view) {
        this.zzg.zzd(view);
    }

    public final void zzp() {
        if (this.zzp) {
            return;
        }
        synchronized (this.zzo) {
            if (!this.zzp) {
                if ((System.currentTimeMillis() / 1000) - this.zza < 3600) {
                    return;
                }
                zzfpv zzfpvVarZzb = this.zzf.zzb();
                if ((zzfpvVarZzb == null || zzfpvVarZzb.zzd(3600L)) && zzfpj.zza(this.zzr)) {
                    this.zzi.execute(new zzaug(this));
                }
            }
        }
    }

    public final synchronized boolean zzr() {
        return this.zzq;
    }
}
