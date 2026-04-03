package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.InputEvent;
import androidx.annotation.VisibleForTesting;
import com.google.common.util.concurrent.m;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcni {

    @VisibleForTesting
    zzbts zza;

    @VisibleForTesting
    zzbts zzb;
    private final Context zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;
    private final zzeep zze;
    private final zzdpq zzf;
    private final zzgcu zzg;
    private final Executor zzh;
    private final ScheduledExecutorService zzi;

    zzcni(Context context, com.google.android.gms.ads.internal.util.zzg zzgVar, zzeep zzeepVar, zzdpq zzdpqVar, zzgcu zzgcuVar, zzgcu zzgcuVar2, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = context;
        this.zzd = zzgVar;
        this.zze = zzeepVar;
        this.zzf = zzdpqVar;
        this.zzg = zzgcuVar;
        this.zzh = zzgcuVar2;
        this.zzi = scheduledExecutorService;
    }

    public static boolean zzj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjn));
    }

    private final m zzk(final String str, final InputEvent inputEvent, Random random) {
        try {
            if (!str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjn)) || this.zzd.zzS()) {
                return zzgcj.zzh(str);
            }
            final Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
            builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjo), String.valueOf(random.nextInt(Integer.MAX_VALUE)));
            if (inputEvent != null) {
                return zzgcj.zzf(zzgcj.zzn(zzgca.zzu(this.zze.zza()), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcnc
                    @Override // com.google.android.gms.internal.ads.zzgbq
                    public final m zza(Object obj) {
                        return this.zza.zzd(builderBuildUpon, str, inputEvent, (Integer) obj);
                    }
                }, this.zzh), Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcnd
                    @Override // com.google.android.gms.internal.ads.zzgbq
                    public final m zza(Object obj) {
                        return this.zza.zze(builderBuildUpon, (Throwable) obj);
                    }
                }, this.zzg);
            }
            builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjp), "11");
            return zzgcj.zzh(builderBuildUpon.toString());
        } catch (Exception e10) {
            return zzgcj.zzg(e10);
        }
    }

    public final m zzb(final String str, Random random) {
        return TextUtils.isEmpty(str) ? zzgcj.zzh(str) : zzgcj.zzf(zzk(str, this.zzf.zza(), random), Throwable.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcmz
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzc(str, (Throwable) obj);
            }
        }, this.zzg);
    }

    final /* synthetic */ m zzc(String str, final Throwable th) throws Exception {
        this.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcnb
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzg(th);
            }
        });
        return zzgcj.zzh(str);
    }

    final /* synthetic */ m zzd(final Uri.Builder builder, String str, InputEvent inputEvent, Integer num) throws Exception {
        if (num.intValue() != 1) {
            builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjp), "10");
            return zzgcj.zzh(builder.toString());
        }
        Uri.Builder builderBuildUpon = builder.build().buildUpon();
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjq), "1");
        builderBuildUpon.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjp), "12");
        if (str.contains((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjr))) {
            builderBuildUpon.authority((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjs));
        }
        return zzgcj.zzn(zzgca.zzu(this.zze.zzb(builderBuildUpon.build(), inputEvent)), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzcne
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjp);
                Uri.Builder builder2 = builder;
                builder2.appendQueryParameter(str2, "12");
                return zzgcj.zzh(builder2.toString());
            }
        }, this.zzh);
    }

    final /* synthetic */ m zze(Uri.Builder builder, final Throwable th) throws Exception {
        this.zzg.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcna
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzh(th);
            }
        });
        builder.appendQueryParameter((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjp), "9");
        return zzgcj.zzh(builder.toString());
    }

    final /* synthetic */ void zzg(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzju)).booleanValue()) {
            zzbts zzbtsVarZzc = zzbtq.zzc(this.zzc);
            this.zzb = zzbtsVarZzc;
            zzbtsVarZzc.zzh(th, "AttributionReporting.getUpdatedUrlAndRegisterSource");
        } else {
            zzbts zzbtsVarZza = zzbtq.zza(this.zzc);
            this.zza = zzbtsVarZza;
            zzbtsVarZza.zzh(th, "AttributionReportingSampled.getUpdatedUrlAndRegisterSource");
        }
    }

    final /* synthetic */ void zzh(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzju)).booleanValue()) {
            zzbts zzbtsVarZzc = zzbtq.zzc(this.zzc);
            this.zzb = zzbtsVarZzc;
            zzbtsVarZzc.zzh(th, "AttributionReporting");
        } else {
            zzbts zzbtsVarZza = zzbtq.zza(this.zzc);
            this.zza = zzbtsVarZza;
            zzbtsVarZza.zzh(th, "AttributionReportingSampled");
        }
    }

    public final void zzi(String str, zzfll zzfllVar, Random random) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzgcj.zzr(zzgcj.zzo(zzk(str, this.zzf.zza(), random), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjt)).intValue(), TimeUnit.MILLISECONDS, this.zzi), new zzcnh(this, zzfllVar, str), this.zzg);
    }
}
