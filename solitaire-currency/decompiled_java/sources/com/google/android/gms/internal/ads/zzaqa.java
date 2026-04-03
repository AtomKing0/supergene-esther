package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
final class zzaqa {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    /* JADX WARN: Illegal instructions before constructor call */
    zzaqa(String str, zzaoq zzaoqVar) {
        String str2 = zzaoqVar.zzb;
        long j10 = zzaoqVar.zzc;
        long j11 = zzaoqVar.zzd;
        long j12 = zzaoqVar.zze;
        long j13 = zzaoqVar.zzf;
        List arrayList = zzaoqVar.zzh;
        if (arrayList == null) {
            Map map = zzaoqVar.zzg;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new zzaoz((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j10, j11, j12, j13, arrayList);
    }

    static zzaqa zza(zzaqb zzaqbVar) throws IOException {
        if (zzaqd.zze(zzaqbVar) != 538247942) {
            throw new IOException();
        }
        String strZzh = zzaqd.zzh(zzaqbVar);
        String strZzh2 = zzaqd.zzh(zzaqbVar);
        long jZzf = zzaqd.zzf(zzaqbVar);
        long jZzf2 = zzaqd.zzf(zzaqbVar);
        long jZzf3 = zzaqd.zzf(zzaqbVar);
        long jZzf4 = zzaqd.zzf(zzaqbVar);
        int iZze = zzaqd.zze(zzaqbVar);
        if (iZze < 0) {
            throw new IOException("readHeaderList size=" + iZze);
        }
        List listEmptyList = iZze == 0 ? Collections.emptyList() : new ArrayList();
        for (int i10 = 0; i10 < iZze; i10++) {
            listEmptyList.add(new zzaoz(zzaqd.zzh(zzaqbVar).intern(), zzaqd.zzh(zzaqbVar).intern()));
        }
        return new zzaqa(strZzh, strZzh2, jZzf, jZzf2, jZzf3, jZzf4, listEmptyList);
    }

    private zzaqa(String str, String str2, long j10, long j11, long j12, long j13, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j10;
        this.zze = j11;
        this.zzf = j12;
        this.zzg = j13;
        this.zzh = list;
    }
}
