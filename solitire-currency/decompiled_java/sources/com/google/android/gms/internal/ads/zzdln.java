package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdln {
    private final com.google.android.gms.ads.internal.util.zzbo zza;
    private final Clock zzb;
    private final Executor zzc;

    public zzdln(com.google.android.gms.ads.internal.util.zzbo zzboVar, Clock clock, Executor executor) {
        this.zza = zzboVar;
        this.zzb = clock;
        this.zzc = executor;
    }

    private final Bitmap zzc(byte[] bArr, BitmapFactory.Options options) {
        long jElapsedRealtime = this.zzb.elapsedRealtime();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long jElapsedRealtime2 = this.zzb.elapsedRealtime();
        if (bitmapDecodeByteArray != null) {
            long j10 = jElapsedRealtime2 - jElapsedRealtime;
            com.google.android.gms.ads.internal.util.zze.zza("Decoded image w: " + bitmapDecodeByteArray.getWidth() + " h:" + bitmapDecodeByteArray.getHeight() + " bytes: " + bitmapDecodeByteArray.getAllocationByteCount() + " time: " + j10 + " on ui thread: " + (Looper.getMainLooper().getThread() == Thread.currentThread()));
        }
        return bitmapDecodeByteArray;
    }

    final /* synthetic */ Bitmap zza(double d10, boolean z10, zzapd zzapdVar) {
        byte[] bArr = zzapdVar.zzb;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d10 * 160.0d);
        if (!z10) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfy)).booleanValue()) {
            options.inJustDecodeBounds = true;
            zzc(bArr, options);
            options.inJustDecodeBounds = false;
            int i10 = options.outWidth * options.outHeight;
            if (i10 > 0) {
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros((i10 - 1) / ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzfz)).intValue())) / 2);
            }
        }
        return zzc(bArr, options);
    }

    public final m zzb(String str, final double d10, final boolean z10) {
        return zzgcj.zzm(this.zza.zza(str), new zzful() { // from class: com.google.android.gms.internal.ads.zzdlm
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return this.zza.zza(d10, z10, (zzapd) obj);
            }
        }, this.zzc);
    }
}
