package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzfrz {
    static final String zza = new UUID(0, 0).toString();
    final zzfsa zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;

    zzfrz(Context context, String str, String str2, String str3) {
        this.zzb = zzfsa.zzb(context);
        this.zzc = str;
        this.zzd = str.concat("_3p");
        this.zze = str2;
        this.zzf = str2.concat("_3p");
        this.zzg = str3;
    }

    private final String zzh(String str, String str2, String str3) {
        if (str2 != null && str3 != null) {
            return UUID.nameUUIDFromBytes((str + str2 + str3).getBytes(StandardCharsets.UTF_8)).toString();
        }
        String str4 = this.zzg;
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append(": Invalid argument to generate PAIDv1 on 3p traffic, Ad ID is not null, package name is ");
        sb.append(str2 == null ? "null" : "not null");
        sb.append(", hashKey is ");
        sb.append(str3 != null ? "not null" : "null");
        throw new IllegalArgumentException(sb.toString());
    }

    final long zza(boolean z10) {
        return this.zzb.zza(z10 ? this.zzf : this.zze, -1L);
    }

    final zzfry zzb(@Nullable String str, @Nullable String str2, long j10, boolean z10) throws IOException {
        if (str != null) {
            try {
                UUID.fromString(str);
                if (!str.equals(zza)) {
                    String strZze = zze(true);
                    String strZzc = this.zzb.zzc("paid_3p_hash_key", null);
                    if (strZze != null && strZzc != null && !strZze.equals(zzh(str, str2, strZzc))) {
                        return zzc(str, str2);
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
            return new zzfry();
        }
        boolean z11 = str != null;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            throw new IllegalStateException(this.zzg.concat(": Invalid negative current timestamp. Updating PAID failed"));
        }
        long jZza = zza(z11);
        if (jZza != -1) {
            if (jCurrentTimeMillis < jZza) {
                this.zzb.zzd(z11 ? this.zzf : this.zze, Long.valueOf(jCurrentTimeMillis));
            } else if (jCurrentTimeMillis >= jZza + j10) {
                return zzc(str, str2);
            }
        }
        String strZze2 = zze(z11);
        return (strZze2 != null || z10) ? new zzfry(strZze2, zza(z11)) : zzc(str, str2);
    }

    final zzfry zzc(String str, String str2) throws IOException {
        if (str == null) {
            return zzd(UUID.randomUUID().toString(), false);
        }
        String string = UUID.randomUUID().toString();
        this.zzb.zzd("paid_3p_hash_key", string);
        return zzd(zzh(str, str2, string), true);
    }

    final zzfry zzd(String str, boolean z10) throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            throw new IllegalStateException(this.zzg.concat(": Invalid negative current timestamp. Updating PAID failed"));
        }
        this.zzb.zzd(z10 ? this.zzf : this.zze, Long.valueOf(jCurrentTimeMillis));
        this.zzb.zzd(z10 ? this.zzd : this.zzc, str);
        return new zzfry(str, jCurrentTimeMillis);
    }

    final String zze(boolean z10) {
        return this.zzb.zzc(z10 ? this.zzd : this.zzc, null);
    }

    final void zzf(boolean z10) throws IOException {
        this.zzb.zze(z10 ? this.zzf : this.zze);
        this.zzb.zze(z10 ? this.zzd : this.zzc);
    }

    final boolean zzg(boolean z10) {
        return this.zzb.zzg(this.zzc);
    }
}
