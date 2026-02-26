package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcbl {
    private static final boolean zza;
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;

    @Nullable
    private final zzbci zze;

    @Nullable
    private final zzbcl zzf;
    private final com.google.android.gms.ads.internal.util.zzbh zzg;
    private final long[] zzh;
    private final String[] zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private zzcaq zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;

    static {
        zza = com.google.android.gms.ads.internal.client.zzay.zze().nextInt(100) < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzlK)).intValue();
    }

    public zzcbl(Context context, VersionInfoParcel versionInfoParcel, String str, @Nullable zzbcl zzbclVar, @Nullable zzbci zzbciVar) {
        com.google.android.gms.ads.internal.util.zzbf zzbfVar = new com.google.android.gms.ads.internal.util.zzbf();
        zzbfVar.zza("min_1", Double.MIN_VALUE, 1.0d);
        zzbfVar.zza("1_5", 1.0d, 5.0d);
        zzbfVar.zza("5_10", 5.0d, 10.0d);
        zzbfVar.zza("10_20", 10.0d, 20.0d);
        zzbfVar.zza("20_30", 20.0d, 30.0d);
        zzbfVar.zza("30_max", 30.0d, Double.MAX_VALUE);
        this.zzg = zzbfVar.zzb();
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzr = -1L;
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zzc = str;
        this.zzf = zzbclVar;
        this.zze = zzbciVar;
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzu);
        if (str2 == null) {
            this.zzi = new String[0];
            this.zzh = new long[0];
            return;
        }
        String[] strArrSplit = TextUtils.split(str2, ",");
        int length = strArrSplit.length;
        this.zzi = new String[length];
        this.zzh = new long[length];
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            try {
                this.zzh[i10] = Long.parseLong(strArrSplit[i10]);
            } catch (NumberFormatException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Unable to parse frame hash target time number.", e10);
                this.zzh[i10] = -1;
            }
        }
    }

    public final void zza(zzcaq zzcaqVar) {
        zzbcd.zza(this.zzf, this.zze, "vpc2");
        this.zzj = true;
        this.zzf.zzd("vpn", zzcaqVar.zzj());
        this.zzo = zzcaqVar;
    }

    public final void zzb() {
        if (!this.zzj || this.zzk) {
            return;
        }
        zzbcd.zza(this.zzf, this.zze, "vfr2");
        this.zzk = true;
    }

    public final void zzc() {
        this.zzn = true;
        if (!this.zzk || this.zzl) {
            return;
        }
        zzbcd.zza(this.zzf, this.zze, "vfp2");
        this.zzl = true;
    }

    public final void zzd() {
        if (!zza || this.zzp) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString(com.vungle.ads.internal.ui.a.REQUEST_KEY_EXTRA, this.zzc);
        bundle.putString("player", this.zzo.zzj());
        for (com.google.android.gms.ads.internal.util.zzbe zzbeVar : this.zzg.zza()) {
            String strValueOf = String.valueOf(zzbeVar.zza);
            bundle.putString("fps_c_".concat(strValueOf), Integer.toString(zzbeVar.zze));
            String strValueOf2 = String.valueOf(zzbeVar.zza);
            bundle.putString("fps_p_".concat(strValueOf2), Double.toString(zzbeVar.zzd));
        }
        int i10 = 0;
        while (true) {
            long[] jArr = this.zzh;
            if (i10 >= jArr.length) {
                com.google.android.gms.ads.internal.zzu.zzp().zzh(this.zzb, this.zzd.afmaVersion, "gmob-apps", bundle, true);
                this.zzp = true;
                return;
            }
            String str = this.zzi[i10];
            if (str != null) {
                bundle.putString("fh_".concat(Long.valueOf(jArr[i10]).toString()), str);
            }
            i10++;
        }
    }

    public final void zze() {
        this.zzn = false;
    }

    public final void zzf(zzcaq zzcaqVar) {
        if (this.zzl && !this.zzm) {
            if (com.google.android.gms.ads.internal.util.zze.zzc() && !this.zzm) {
                com.google.android.gms.ads.internal.util.zze.zza("VideoMetricsMixin first frame");
            }
            zzbcd.zza(this.zzf, this.zze, "vff2");
            this.zzm = true;
        }
        long jNanoTime = com.google.android.gms.ads.internal.zzu.zzB().nanoTime();
        if (this.zzn && this.zzq && this.zzr != -1) {
            this.zzg.zzb(TimeUnit.SECONDS.toNanos(1L) / (jNanoTime - this.zzr));
        }
        this.zzq = this.zzn;
        this.zzr = jNanoTime;
        long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzv)).longValue();
        long jZza = zzcaqVar.zza();
        int i10 = 0;
        while (true) {
            String[] strArr = this.zzi;
            if (i10 >= strArr.length) {
                return;
            }
            if (strArr[i10] == null && jLongValue > Math.abs(jZza - this.zzh[i10])) {
                String[] strArr2 = this.zzi;
                int i11 = 8;
                Bitmap bitmap = zzcaqVar.getBitmap(8, 8);
                long j10 = 63;
                int i12 = 0;
                long j11 = 0;
                while (i12 < i11) {
                    int i13 = 0;
                    while (i13 < i11) {
                        int pixel = bitmap.getPixel(i13, i12);
                        j11 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j10);
                        j10--;
                        i13++;
                        i11 = 8;
                    }
                    i12++;
                    i11 = 8;
                }
                strArr2[i10] = String.format("%016X", Long.valueOf(j11));
                return;
            }
            i10++;
        }
    }
}
