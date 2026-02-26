package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.ironsource.v8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaoz {
    private final String zza;
    private final String zzb;

    public zzaoz(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaoz.class == obj.getClass()) {
            zzaoz zzaozVar = (zzaoz) obj;
            if (TextUtils.equals(this.zza, zzaozVar.zza) && TextUtils.equals(this.zzb, zzaozVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.zza + ",value=" + this.zzb + v8.i.f15839e;
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
