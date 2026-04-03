package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzay {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final zzba zze;
    private final String zzf;

    zzay(zzho zzhoVar, String str, String str2, String str3, long j10, long j11, Bundle bundle) {
        zzba zzbaVar;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j10;
        this.zzd = j11;
        if (j11 != 0 && j11 > j10) {
            zzhoVar.zzj().zzu().zza("Event created with reverse previous/current timestamps. appId", zzgb.zza(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzbaVar = new zzba(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    zzhoVar.zzj().zzg().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object objZzb = zzhoVar.zzt().zzb(next, bundle2.get(next));
                    if (objZzb == null) {
                        zzhoVar.zzj().zzu().zza("Param value can't be null", zzhoVar.zzk().zzb(next));
                        it.remove();
                    } else {
                        zzhoVar.zzt().zza(bundle2, next, objZzb);
                    }
                }
            }
            zzbaVar = new zzba(bundle2);
        }
        this.zze = zzbaVar;
    }

    public final String toString() {
        return "Event{appId='" + this.zza + "', name='" + this.zzb + "', params=" + String.valueOf(this.zze) + "}";
    }

    final zzay zza(zzho zzhoVar, long j10) {
        return new zzay(zzhoVar, this.zzf, this.zza, this.zzb, this.zzc, j10, this.zze);
    }

    private zzay(zzho zzhoVar, String str, String str2, String str3, long j10, long j11, zzba zzbaVar) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzbaVar);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j10;
        this.zzd = j11;
        if (j11 != 0 && j11 > j10) {
            zzhoVar.zzj().zzu().zza("Event created with reverse previous/current timestamps. appId, name", zzgb.zza(str2), zzgb.zza(str3));
        }
        this.zze = zzbaVar;
    }
}
