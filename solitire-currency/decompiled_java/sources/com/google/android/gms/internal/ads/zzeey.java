package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeey {
    private final String zzc;
    private zzfeo zzd = null;
    private zzfel zze = null;
    private com.google.android.gms.ads.internal.client.zzu zzf = null;
    private final Map zzb = Collections.synchronizedMap(new HashMap());
    private final List zza = Collections.synchronizedList(new ArrayList());

    public zzeey(String str) {
        this.zzc = str;
    }

    private static String zzj(zzfel zzfelVar) {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdi)).booleanValue() ? zzfelVar.zzap : zzfelVar.zzw;
    }

    private final synchronized void zzk(zzfel zzfelVar, int i10) {
        String str;
        String str2;
        String str3;
        String str4;
        Map map = this.zzb;
        String strZzj = zzj(zzfelVar);
        if (map.containsKey(strZzj)) {
            return;
        }
        Bundle bundle = new Bundle();
        Iterator<String> itKeys = zzfelVar.zzv.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                bundle.putString(next, zzfelVar.zzv.getString(next));
            } catch (JSONException unused) {
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgd)).booleanValue()) {
            str = zzfelVar.zzF;
            str2 = zzfelVar.zzG;
            str3 = zzfelVar.zzH;
            str4 = zzfelVar.zzI;
        } else {
            str = "";
            str2 = "";
            str3 = "";
            str4 = "";
        }
        com.google.android.gms.ads.internal.client.zzu zzuVar = new com.google.android.gms.ads.internal.client.zzu(zzfelVar.zzE, 0L, null, bundle, str, str2, str3, str4);
        try {
            this.zza.add(i10, zzuVar);
        } catch (IndexOutOfBoundsException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AdapterResponseInfoCollector.addAdapterResponseInfoEntryAtLocation");
        }
        this.zzb.put(strZzj, zzuVar);
    }

    private final void zzl(zzfel zzfelVar, long j10, @Nullable com.google.android.gms.ads.internal.client.zze zzeVar, boolean z10) {
        Map map = this.zzb;
        String strZzj = zzj(zzfelVar);
        if (map.containsKey(strZzj)) {
            if (this.zze == null) {
                this.zze = zzfelVar;
            }
            com.google.android.gms.ads.internal.client.zzu zzuVar = (com.google.android.gms.ads.internal.client.zzu) this.zzb.get(strZzj);
            zzuVar.zzb = j10;
            zzuVar.zzc = zzeVar;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzge)).booleanValue() && z10) {
                this.zzf = zzuVar;
            }
        }
    }

    @Nullable
    public final com.google.android.gms.ads.internal.client.zzu zza() {
        return this.zzf;
    }

    public final zzcwj zzb() {
        return new zzcwj(this.zze, "", this, this.zzd, this.zzc);
    }

    public final List zzc() {
        return this.zza;
    }

    public final void zzd(zzfel zzfelVar) {
        zzk(zzfelVar, this.zza.size());
    }

    public final void zze(zzfel zzfelVar) {
        int iIndexOf = this.zza.indexOf(this.zzb.get(zzj(zzfelVar)));
        if (iIndexOf < 0 || iIndexOf >= this.zzb.size()) {
            iIndexOf = this.zza.indexOf(this.zzf);
        }
        if (iIndexOf < 0 || iIndexOf >= this.zzb.size()) {
            return;
        }
        this.zzf = (com.google.android.gms.ads.internal.client.zzu) this.zza.get(iIndexOf);
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.zza.size()) {
                return;
            }
            com.google.android.gms.ads.internal.client.zzu zzuVar = (com.google.android.gms.ads.internal.client.zzu) this.zza.get(iIndexOf);
            zzuVar.zzb = 0L;
            zzuVar.zzc = null;
        }
    }

    public final void zzf(zzfel zzfelVar, long j10, @Nullable com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzl(zzfelVar, j10, zzeVar, false);
    }

    public final void zzg(zzfel zzfelVar, long j10, @Nullable com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzl(zzfelVar, j10, null, true);
    }

    public final synchronized void zzh(String str, List list) {
        if (this.zzb.containsKey(str)) {
            int iIndexOf = this.zza.indexOf((com.google.android.gms.ads.internal.client.zzu) this.zzb.get(str));
            try {
                this.zza.remove(iIndexOf);
            } catch (IndexOutOfBoundsException e10) {
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "AdapterResponseInfoCollector.replaceAdapterResponseInfoEntry");
            }
            this.zzb.remove(str);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzk((zzfel) it.next(), iIndexOf);
                iIndexOf++;
            }
        }
    }

    public final void zzi(zzfeo zzfeoVar) {
        this.zzd = zzfeoVar;
    }
}
