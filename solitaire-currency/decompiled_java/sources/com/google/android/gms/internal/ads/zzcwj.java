package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcwj extends com.google.android.gms.ads.internal.client.zzdm {
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final List zze;
    private final long zzf;
    private final String zzg;
    private final zzeey zzh;
    private final Bundle zzi;

    public zzcwj(zzfel zzfelVar, String str, zzeey zzeeyVar, zzfeo zzfeoVar, String str2) {
        String string = null;
        this.zzb = zzfelVar == null ? null : zzfelVar.zzab;
        this.zzc = str2;
        this.zzd = zzfeoVar == null ? null : zzfeoVar.zzb;
        if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                string = zzfelVar.zzv.getString("class_name");
            } catch (JSONException unused) {
            }
        }
        this.zza = string != null ? string : str;
        this.zze = zzeeyVar.zzc();
        this.zzh = zzeeyVar;
        this.zzf = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() / 1000;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgf)).booleanValue() || zzfeoVar == null) {
            this.zzi = new Bundle();
        } else {
            this.zzi = zzfeoVar.zzk;
        }
        this.zzg = (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzir)).booleanValue() || zzfeoVar == null || TextUtils.isEmpty(zzfeoVar.zzi)) ? "" : zzfeoVar.zzi;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final Bundle zze() {
        return this.zzi;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzu zzf() {
        zzeey zzeeyVar = this.zzh;
        if (zzeeyVar != null) {
            return zzeeyVar.zza();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final String zzg() {
        return this.zza;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final String zzh() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final String zzi() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final List zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
