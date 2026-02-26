package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.Hex;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfpw {

    @VisibleForTesting
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final int zzd;

    public zzfpw(@NonNull Context context, int i10) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzfpx.zza(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzfpx.zza(dir2, true);
        this.zza = dir2;
        this.zzd = i10;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(this.zzd - 1));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        StringBuilder sb = new StringBuilder();
        sb.append("FBAMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    private final String zzf() {
        StringBuilder sb = new StringBuilder();
        sb.append("LATMTD");
        sb.append(this.zzd - 1);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zza(@androidx.annotation.NonNull com.google.android.gms.internal.ads.zzaxi r8, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzfqc r9) {
        /*
            Method dump skipped, instruction units count: 390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfpw.zza(com.google.android.gms.internal.ads.zzaxi, com.google.android.gms.internal.ads.zzfqc):boolean");
    }

    @Nullable
    @VisibleForTesting
    final zzaxl zzb(int i10) {
        String string = i10 == 1 ? this.zzc.getString(zzf(), null) : this.zzc.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzgwm zzgwmVar = zzgwm.zzb;
            zzaxl zzaxlVarZzh = zzaxl.zzh(zzgwm.zzv(bArrStringToBytes, 0, bArrStringToBytes.length));
            String strZzk = zzaxlVarZzh.zzk();
            File fileZzb = zzfpx.zzb(strZzk, "pcam.jar", zzd());
            if (!fileZzb.exists()) {
                fileZzb = zzfpx.zzb(strZzk, "pcam", zzd());
            }
            File fileZzb2 = zzfpx.zzb(strZzk, "pcbc", zzd());
            if (fileZzb.exists()) {
                if (fileZzb2.exists()) {
                    return zzaxlVarZzh;
                }
            }
        } catch (zzgyn unused) {
        }
        return null;
    }

    @Nullable
    public final zzfpv zzc(int i10) {
        zzaxl zzaxlVarZzb = zzb(1);
        if (zzaxlVarZzb == null) {
            return null;
        }
        String strZzk = zzaxlVarZzb.zzk();
        File fileZzb = zzfpx.zzb(strZzk, "pcam.jar", zzd());
        if (!fileZzb.exists()) {
            fileZzb = zzfpx.zzb(strZzk, "pcam", zzd());
        }
        return new zzfpv(zzaxlVarZzb, fileZzb, zzfpx.zzb(strZzk, "pcbc", zzd()), zzfpx.zzb(strZzk, "pcopt", zzd()));
    }
}
