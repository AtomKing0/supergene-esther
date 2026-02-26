package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzelg {

    @GuardedBy("this")
    private final Map zza = new HashMap();

    @GuardedBy("this")
    private final Map zzb = new HashMap();

    @GuardedBy("this")
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private final Map zze = new HashMap();
    private final Executor zzf;
    private JSONObject zzg;

    zzelg(Executor executor) {
        this.zzf = executor;
    }

    private final synchronized zzfxu zzh(String str) {
        HashMap map;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(com.google.android.gms.ads.internal.zzu.zzo().zzi().zzh().zzc())) {
            boolean zMatches = Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcP), str);
            boolean zMatches2 = Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcQ), str);
            if (zMatches) {
                map = new HashMap(this.zze);
            } else if (zMatches2) {
                map = new HashMap(this.zzd);
            }
            return zzfxu.zzc(map);
        }
        return zzfxu.zzd();
    }

    private final synchronized List zzi(JSONObject jSONObject, String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (jSONObject != null) {
            Bundle bundleZzo = zzo(jSONObject.optJSONObject("data"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rtb_adapters");
            if (jSONArrayOptJSONArray != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                    String strOptString = jSONArrayOptJSONArray.optString(i10, "");
                    if (!TextUtils.isEmpty(strOptString)) {
                        arrayList2.add(strOptString);
                    }
                }
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    String str2 = (String) arrayList2.get(i11);
                    zzg(str2);
                    if (((zzeli) this.zza.get(str2)) != null) {
                        arrayList.add(new zzeli(str2, str, bundleZzo));
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzj() {
        this.zzb.clear();
        this.zza.clear();
        this.zze.clear();
        this.zzd.clear();
        zzm();
        zzn();
        zzk();
    }

    private final synchronized void zzk() {
        JSONObject jSONObjectZzf;
        if (!((Boolean) zzbdy.zzb.zze()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbC)).booleanValue() && (jSONObjectZzf = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzh().zzf()) != null) {
                try {
                    JSONArray jSONArray = jSONObjectZzf.getJSONArray("adapter_settings");
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i10);
                        String strOptString = jSONObject.optString("adapter_class_name");
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("permission_set");
                        if (!TextUtils.isEmpty(strOptString)) {
                            for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i11);
                                boolean zOptBoolean = jSONObject2.optBoolean("enable_rendering", false);
                                boolean zOptBoolean2 = jSONObject2.optBoolean("collect_secure_signals", false);
                                boolean zOptBoolean3 = jSONObject2.optBoolean("collect_secure_signals_on_full_app", false);
                                String strOptString2 = jSONObject2.optString("platform");
                                zzelk zzelkVar = new zzelk(strOptString, zOptBoolean2, zOptBoolean, zOptBoolean3, new Bundle());
                                if (strOptString2.equals("ADMOB")) {
                                    this.zzd.put(strOptString, zzelkVar);
                                } else if (strOptString2.equals("AD_MANAGER")) {
                                    this.zze.put(strOptString, zzelkVar);
                                }
                            }
                        }
                    }
                } catch (JSONException e10) {
                    com.google.android.gms.ads.internal.util.zze.zzb("Malformed config loading JSON.", e10);
                }
            }
        }
    }

    private final synchronized void zzl(String str, String str2, List list) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        Map map = (Map) this.zzc.get(str);
        if (map == null) {
            map = new HashMap();
        }
        this.zzc.put(str, map);
        List arrayList = (List) map.get(str2);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        arrayList.addAll(list);
        map.put(str2, arrayList);
    }

    private final synchronized void zzm() {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectZzf = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzh().zzf();
        if (jSONObjectZzf != null) {
            try {
                JSONArray jSONArrayOptJSONArray2 = jSONObjectZzf.optJSONArray("ad_unit_id_settings");
                this.zzg = jSONObjectZzf.optJSONObject("ad_unit_patterns");
                if (jSONArrayOptJSONArray2 != null) {
                    for (int i10 = 0; i10 < jSONArrayOptJSONArray2.length(); i10++) {
                        JSONObject jSONObject = jSONArrayOptJSONArray2.getJSONObject(i10);
                        String lowerCase = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjW)).booleanValue() ? jSONObject.optString("ad_unit_id", "").toLowerCase(Locale.ROOT) : jSONObject.optString("ad_unit_id", "");
                        String strOptString = jSONObject.optString("format", "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("ad_networks")) != null) {
                            for (int i11 = 0; i11 < jSONArrayOptJSONArray.length(); i11++) {
                                arrayList.addAll(zzi(jSONArrayOptJSONArray.getJSONObject(i11), strOptString));
                            }
                        }
                        zzl(strOptString, lowerCase, arrayList);
                    }
                }
            } catch (JSONException e10) {
                com.google.android.gms.ads.internal.util.zze.zzb("Malformed config loading JSON.", e10);
            }
        }
    }

    private final synchronized void zzn() {
        JSONObject jSONObjectZzf;
        if (!((Boolean) zzbdy.zzf.zze()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbB)).booleanValue() && (jSONObjectZzf = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzh().zzf()) != null) {
                try {
                    JSONArray jSONArray = jSONObjectZzf.getJSONArray("signal_adapters");
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i10);
                        Bundle bundleZzo = zzo(jSONObject.optJSONObject("data"));
                        String strOptString = jSONObject.optString("adapter_class_name");
                        boolean zOptBoolean = jSONObject.optBoolean("render", false);
                        boolean zOptBoolean2 = jSONObject.optBoolean("collect_signals", false);
                        if (!TextUtils.isEmpty(strOptString)) {
                            this.zzb.put(strOptString, new zzelk(strOptString, zOptBoolean2, zOptBoolean, true, bundleZzo));
                        }
                    }
                } catch (JSONException e10) {
                    com.google.android.gms.ads.internal.util.zze.zzb("Malformed config loading JSON.", e10);
                }
            }
        }
    }

    private static final Bundle zzo(JSONObject jSONObject) {
        Bundle bundle = new Bundle();
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle.putString(next, jSONObject.optString(next, ""));
            }
        }
        return bundle;
    }

    public final synchronized Map zza(String str, String str2) {
        HashMap map;
        Map mapZzb = zzb(str, str2);
        zzfxu zzfxuVarZzh = zzh(str2);
        map = new HashMap();
        for (Map.Entry entry : ((zzfxu) mapZzb).entrySet()) {
            String str3 = (String) entry.getKey();
            if (zzfxuVarZzh.containsKey(str3)) {
                zzelk zzelkVar = (zzelk) zzfxuVarZzh.get(str3);
                List list = (List) entry.getValue();
                map.put(str3, new zzelk(str3, zzelkVar.zzb, zzelkVar.zzc, zzelkVar.zzd, (list == null || list.isEmpty()) ? new Bundle() : (Bundle) list.get(0)));
            }
        }
        zzfzx zzfzxVarZze = zzfxuVarZzh.entrySet().iterator();
        while (zzfzxVarZze.hasNext()) {
            Map.Entry entry2 = (Map.Entry) zzfzxVarZze.next();
            String str4 = (String) entry2.getKey();
            if (!map.containsKey(str4) && ((zzelk) entry2.getValue()).zzd) {
                map.put(str4, (zzelk) entry2.getValue());
            }
        }
        return map;
    }

    public final synchronized Map zzb(String str, String str2) {
        Map map;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(com.google.android.gms.ads.internal.zzu.zzo().zzi().zzh().zzc()) && (map = (Map) this.zzc.get(str)) != null) {
            List<zzeli> list = (List) map.get(str2);
            if (list == null) {
                String strZza = zzdqi.zza(this.zzg, str2, str);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjW)).booleanValue()) {
                    strZza = strZza.toLowerCase(Locale.ROOT);
                }
                list = (List) map.get(strZza);
            }
            if (list != null) {
                HashMap map2 = new HashMap();
                for (zzeli zzeliVar : list) {
                    String str3 = zzeliVar.zza;
                    if (!map2.containsKey(str3)) {
                        map2.put(str3, new ArrayList());
                    }
                    ((List) map2.get(str3)).add(zzeliVar.zzb);
                }
                return zzfxu.zzc(map2);
            }
        }
        return zzfxu.zzd();
    }

    public final synchronized Map zzc() {
        if (TextUtils.isEmpty(com.google.android.gms.ads.internal.zzu.zzo().zzi().zzh().zzc())) {
            return zzfxu.zzd();
        }
        return zzfxu.zzc(this.zzb);
    }

    public final void zze() {
        com.google.android.gms.ads.internal.zzu.zzo().zzi().zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzelf
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzf();
            }
        });
        this.zzf.execute(new zzele(this));
    }

    final /* synthetic */ void zzf() {
        this.zzf.execute(new zzele(this));
    }

    public final synchronized void zzg(String str) {
        if (!TextUtils.isEmpty(str) && !this.zza.containsKey(str)) {
            this.zza.put(str, new zzeli(str, "", new Bundle()));
        }
    }
}
