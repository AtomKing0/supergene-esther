package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzccw implements zzbix {
    @Nullable
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str)));
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzccv zzccyVar;
        zzccn zzccnVarZza;
        zzcbk zzcbkVar = (zzcbk) obj;
        if (com.google.android.gms.ads.internal.util.client.zzm.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            com.google.android.gms.ads.internal.util.client.zzm.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcco zzccoVarZzy = com.google.android.gms.ads.internal.zzu.zzy();
        if (map.containsKey("abort")) {
            if (zzccoVarZzy.zzd(zzcbkVar)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Precache abort but no precache task running.");
            return;
        }
        String str = (String) map.get("src");
        Integer numZzb = zzb(map, "periodicReportIntervalMs");
        Integer numZzb2 = zzb(map, "exoPlayerRenderingIntervalMs");
        Integer numZzb3 = zzb(map, "exoPlayerIdleIntervalMs");
        zzcbj zzcbjVar = new zzcbj((String) map.get("flags"));
        boolean z10 = zzcbjVar.zzk;
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        strArr2[i10] = jSONArray.getString(i10);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Malformed demuxed URL list for precache: ".concat(str2));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (z10) {
                Iterator it = zzccoVarZzy.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        zzccnVarZza = null;
                        break;
                    }
                    zzccn zzccnVar = (zzccn) it.next();
                    if (zzccnVar.zza == zzcbkVar && str.equals(zzccnVar.zze())) {
                        zzccnVarZza = zzccnVar;
                        break;
                    }
                }
            } else {
                zzccnVarZza = zzccoVarZzy.zza(zzcbkVar);
            }
            if (zzccnVarZza != null) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Precache task is already running.");
                return;
            }
            if (zzcbkVar.zzj() == null) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Precache requires a dependency provider.");
                return;
            }
            Integer numZzb4 = zzb(map, "player");
            if (numZzb4 == null) {
                numZzb4 = 0;
            }
            if (numZzb != null) {
                zzcbkVar.zzA(numZzb.intValue());
            }
            if (numZzb2 != null) {
                zzcbkVar.zzy(numZzb2.intValue());
            }
            if (numZzb3 != null) {
                zzcbkVar.zzx(numZzb3.intValue());
            }
            int iIntValue = numZzb4.intValue();
            zzcch zzcchVar = zzcbkVar.zzj().zzb;
            if (iIntValue > 0) {
                int i11 = zzcbjVar.zzg;
                int iZzu = zzcbb.zzu();
                zzccyVar = iZzu < i11 ? new zzcde(zzcbkVar, zzcbjVar) : iZzu < zzcbjVar.zzb ? new zzcdb(zzcbkVar, zzcbjVar) : new zzccz(zzcbkVar);
            } else {
                zzccyVar = new zzccy(zzcbkVar);
            }
            new zzccn(zzcbkVar, zzccyVar, str, strArr).zzb();
        } else {
            zzccn zzccnVarZza2 = zzccoVarZzy.zza(zzcbkVar);
            if (zzccnVarZza2 == null) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Precache must specify a source.");
                return;
            }
            zzccyVar = zzccnVarZza2.zzb;
        }
        Integer numZzb5 = zzb(map, "minBufferMs");
        if (numZzb5 != null) {
            zzccyVar.zzs(numZzb5.intValue());
        }
        Integer numZzb6 = zzb(map, "maxBufferMs");
        if (numZzb6 != null) {
            zzccyVar.zzr(numZzb6.intValue());
        }
        Integer numZzb7 = zzb(map, "bufferForPlaybackMs");
        if (numZzb7 != null) {
            zzccyVar.zzp(numZzb7.intValue());
        }
        Integer numZzb8 = zzb(map, "bufferForPlaybackAfterRebufferMs");
        if (numZzb8 != null) {
            zzccyVar.zzq(numZzb8.intValue());
        }
    }
}
