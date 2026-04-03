package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzacy {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            int i10 = zzet.zza;
            int i11 = Integer.parseInt(strGroup, 16);
            int i12 = Integer.parseInt(matcher.group(2), 16);
            if (i11 <= 0 && i12 <= 0) {
                return false;
            }
            this.zza = i11;
            this.zzb = i12;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean zza() {
        return (this.zza == -1 || this.zzb == -1) ? false : true;
    }

    public final boolean zzb(zzbk zzbkVar) {
        for (int i10 = 0; i10 < zzbkVar.zza(); i10++) {
            zzbj zzbjVarZzb = zzbkVar.zzb(i10);
            if (zzbjVarZzb instanceof zzafx) {
                zzafx zzafxVar = (zzafx) zzbjVarZzb;
                if ("iTunSMPB".equals(zzafxVar.zzb) && zzc(zzafxVar.zzc)) {
                    return true;
                }
            } else if (zzbjVarZzb instanceof zzagg) {
                zzagg zzaggVar = (zzagg) zzbjVarZzb;
                if ("com.apple.iTunes".equals(zzaggVar.zza) && "iTunSMPB".equals(zzaggVar.zzb) && zzc(zzaggVar.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
