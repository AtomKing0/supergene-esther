package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbzo;
import com.google.android.gms.internal.ads.zzdsf;
import com.google.android.gms.internal.ads.zzdsp;
import com.ironsource.mediationsdk.metadata.a;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzl {
    private final zzdsp zzh;
    private Map zzi;
    private final ArrayDeque zzf = new ArrayDeque();
    private final ArrayDeque zzg = new ArrayDeque();
    private final int zza = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgm)).intValue();
    private final long zzb = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgn)).longValue();
    private final boolean zzc = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgr)).booleanValue();
    private final boolean zzd = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgq)).booleanValue();
    private final Map zze = Collections.synchronizedMap(new zzj(this));

    public zzl(zzdsp zzdspVar) {
        this.zzh = zzdspVar;
    }

    private final synchronized void zzi(final zzdsf zzdsfVar) {
        if (this.zzc) {
            ArrayDeque arrayDeque = this.zzg;
            final ArrayDeque arrayDequeClone = arrayDeque.clone();
            arrayDeque.clear();
            ArrayDeque arrayDeque2 = this.zzf;
            final ArrayDeque arrayDequeClone2 = arrayDeque2.clone();
            arrayDeque2.clear();
            zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzi
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zze(zzdsfVar, arrayDequeClone, arrayDequeClone2);
                }
            });
        }
    }

    private final void zzj(zzdsf zzdsfVar, ArrayDeque arrayDeque, String str) {
        Pair pair;
        while (!arrayDeque.isEmpty()) {
            Pair pair2 = (Pair) arrayDeque.poll();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(zzdsfVar.zzb());
            this.zzi = concurrentHashMap;
            concurrentHashMap.put("action", "ev");
            this.zzi.put("e_r", str);
            this.zzi.put("e_id", (String) pair2.first);
            if (this.zzd) {
                try {
                    JSONObject jSONObject = new JSONObject((String) pair2.second);
                    pair = new Pair(zzq.zzb(jSONObject.getJSONObject("extras").getString("query_info_type")), jSONObject.getString("request_agent"));
                } catch (JSONException unused) {
                    pair = new Pair("", "");
                }
                zzl(this.zzi, "e_type", (String) pair.first);
                zzl(this.zzi, "e_agent", (String) pair.second);
            }
            this.zzh.zzf(this.zzi);
        }
    }

    private final synchronized void zzk() {
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
        try {
            Iterator it = this.zze.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (jCurrentTimeMillis - ((zzk) entry.getValue()).zza.longValue() <= this.zzb) {
                    break;
                }
                this.zzg.add(new Pair((String) entry.getKey(), ((zzk) entry.getValue()).zzb));
                it.remove();
            }
        } catch (ConcurrentModificationException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "QueryJsonMap.removeExpiredEntries");
        }
    }

    private static final void zzl(Map map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    @Nullable
    public final synchronized String zzb(String str, zzdsf zzdsfVar) {
        zzk zzkVar = (zzk) this.zze.get(str);
        zzdsfVar.zzb().put("request_id", str);
        if (zzkVar == null) {
            zzdsfVar.zzb().put("mhit", "false");
            return null;
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgL)).booleanValue()) {
            this.zze.remove(str);
        }
        String str2 = zzkVar.zzb;
        zzdsfVar.zzb().put("mhit", a.f13688g);
        return str2;
    }

    public final synchronized void zzd(String str, String str2, zzdsf zzdsfVar) {
        this.zze.put(str, new zzk(Long.valueOf(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis()), str2, new HashSet()));
        zzk();
        zzi(zzdsfVar);
    }

    final /* synthetic */ void zze(zzdsf zzdsfVar, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        zzj(zzdsfVar, arrayDeque, TypedValues.TransitionType.S_TO);
        zzj(zzdsfVar, arrayDeque2, "of");
    }

    public final synchronized void zzf(String str) {
        this.zze.remove(str);
    }

    public final synchronized boolean zzg(String str, String str2, int i10) {
        zzk zzkVar = (zzk) this.zze.get(str);
        if (zzkVar == null) {
            return false;
        }
        zzkVar.zzc.add(str2);
        return zzkVar.zzc.size() < i10;
    }

    public final synchronized boolean zzh(String str, String str2) {
        zzk zzkVar = (zzk) this.zze.get(str);
        if (zzkVar != null) {
            if (zzkVar.zzc.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
