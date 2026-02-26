package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.VisibleForTesting;
import com.google.ads.mediation.admob.AdMobAdapter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdqb {
    private final zzfgc zza;
    private final zzdpy zzb;

    zzdqb(zzfgc zzfgcVar, zzdpy zzdpyVar) {
        this.zza = zzfgcVar;
        this.zzb = zzdpyVar;
    }

    @VisibleForTesting
    final zzbom zza() throws RemoteException {
        zzbom zzbomVarZzb = this.zza.zzb();
        if (zzbomVarZzb != null) {
            return zzbomVarZzb;
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    public final zzbql zzb(String str) throws RemoteException {
        zzbql zzbqlVarZzc = zza().zzc(str);
        this.zzb.zzd(str, zzbqlVarZzc);
        return zzbqlVarZzc;
    }

    public final zzfge zzc(String str, JSONObject jSONObject) throws zzffn {
        zzbop zzbopVarZzb;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzbopVarZzb = new zzbpn(new AdMobAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzbopVarZzb = new zzbpn(new zzbre());
            } else {
                zzbom zzbomVarZza = zza();
                if ("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
                    try {
                        String string = jSONObject.getString("class_name");
                        zzbopVarZzb = zzbomVarZza.zze(string) ? zzbomVarZza.zzb("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") : zzbomVarZza.zzd(string) ? zzbomVarZza.zzb(string) : zzbomVarZza.zzb("com.google.ads.mediation.customevent.CustomEventAdapter");
                    } catch (JSONException e10) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzh("Invalid custom event.", e10);
                        zzbopVarZzb = zzbomVarZza.zzb(str);
                    }
                } else {
                    zzbopVarZzb = zzbomVarZza.zzb(str);
                }
            }
            zzfge zzfgeVar = new zzfge(zzbopVarZzb);
            this.zzb.zzc(str, zzfgeVar);
            return zzfgeVar;
        } catch (Throwable th) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzix)).booleanValue()) {
                this.zzb.zzc(str, null);
            }
            throw new zzffn(th);
        }
    }

    public final boolean zzd() {
        return this.zza.zzb() != null;
    }
}
