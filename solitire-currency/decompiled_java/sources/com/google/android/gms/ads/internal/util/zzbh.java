package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbh {
    private final String[] zza;
    private final double[] zzb;
    private final double[] zzc;
    private final int[] zzd;
    private int zze;

    /* synthetic */ zzbh(zzbf zzbfVar, zzbg zzbgVar) {
        int size = zzbfVar.zzb.size();
        this.zza = (String[]) zzbfVar.zza.toArray(new String[size]);
        this.zzb = zzc(zzbfVar.zzb);
        this.zzc = zzc(zzbfVar.zzc);
        this.zzd = new int[size];
        this.zze = 0;
    }

    private static final double[] zzc(List list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i10 = 0; i10 < size; i10++) {
            dArr[i10] = ((Double) list.get(i10)).doubleValue();
        }
        return dArr;
    }

    public final List zza() {
        zzbh zzbhVar = this;
        ArrayList arrayList = new ArrayList(zzbhVar.zza.length);
        int i10 = 0;
        while (true) {
            String[] strArr = zzbhVar.zza;
            if (i10 >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i10];
            double[] dArr = zzbhVar.zzc;
            double[] dArr2 = zzbhVar.zzb;
            int[] iArr = zzbhVar.zzd;
            double d10 = dArr[i10];
            double d11 = dArr2[i10];
            int i11 = iArr[i10];
            arrayList.add(new zzbe(str, d10, d11, ((double) i11) / ((double) zzbhVar.zze), i11));
            i10++;
            zzbhVar = this;
        }
    }

    public final void zzb(double d10) {
        this.zze++;
        int i10 = 0;
        while (true) {
            double[] dArr = this.zzc;
            if (i10 >= dArr.length) {
                return;
            }
            double d11 = dArr[i10];
            if (d11 <= d10 && d10 < this.zzb[i10]) {
                int[] iArr = this.zzd;
                iArr[i10] = iArr[i10] + 1;
            }
            if (d10 < d11) {
                return;
            } else {
                i10++;
            }
        }
    }
}
