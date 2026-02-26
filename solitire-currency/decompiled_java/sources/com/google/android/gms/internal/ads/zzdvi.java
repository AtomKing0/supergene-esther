package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinMediationProvider;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.m;
import com.ironsource.ad;
import com.ironsource.f5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdvi implements zzdwj, zzdut {
    private final zzdvt zza;
    private final zzdwk zzb;
    private final zzduu zzc;
    private final zzdvd zzd;
    private final zzdus zze;
    private final zzdwf zzf;
    private final zzdvp zzg;
    private final zzdvp zzh;
    private final String zzi;
    private final Context zzj;
    private final String zzk;
    private JSONObject zzp;
    private boolean zzs;
    private int zzt;
    private boolean zzu;
    private final Map zzl = new HashMap();
    private final Map zzm = new HashMap();
    private final Map zzn = new HashMap();
    private String zzo = JsonUtils.EMPTY_JSON;
    private long zzq = Long.MAX_VALUE;
    private zzdve zzr = zzdve.NONE;
    private zzdvh zzv = zzdvh.UNKNOWN;
    private long zzw = 0;
    private String zzx = "";

    zzdvi(zzdvt zzdvtVar, zzdwk zzdwkVar, zzduu zzduuVar, Context context, VersionInfoParcel versionInfoParcel, zzdvd zzdvdVar, zzdwf zzdwfVar, zzdvp zzdvpVar, zzdvp zzdvpVar2, String str) {
        this.zza = zzdvtVar;
        this.zzb = zzdwkVar;
        this.zzc = zzduuVar;
        this.zze = new zzdus(context);
        this.zzi = versionInfoParcel.afmaVersion;
        this.zzk = str;
        this.zzd = zzdvdVar;
        this.zzf = zzdwfVar;
        this.zzg = zzdvpVar;
        this.zzh = zzdvpVar2;
        this.zzj = context;
        com.google.android.gms.ads.internal.zzu.zzs().zzg(this);
    }

    private final synchronized void zzA(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzx(jSONObject.optBoolean("isTestMode", false), false);
            zzw((zzdve) Enum.valueOf(zzdve.class, jSONObject.optString("gesture", "NONE")), false);
            this.zzo = jSONObject.optString("networkExtras", JsonUtils.EMPTY_JSON);
            this.zzq = jSONObject.optLong("networkExtrasExpirationSecs", Long.MAX_VALUE);
        } catch (JSONException unused) {
        }
    }

    private final synchronized JSONObject zzt() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        for (Map.Entry entry : this.zzl.entrySet()) {
            JSONArray jSONArray = new JSONArray();
            for (zzduw zzduwVar : (List) entry.getValue()) {
                if (zzduwVar.zzg()) {
                    jSONArray.put(zzduwVar.zzd());
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put((String) entry.getKey(), jSONArray);
            }
        }
        return jSONObject;
    }

    private final void zzu() {
        this.zzu = true;
        this.zzd.zzc();
        this.zza.zzh(this);
        this.zzb.zzd(this);
        this.zzc.zzd(this);
        this.zzf.zzf(this);
        zzbbn zzbbnVar = zzbbw.zziD;
        if (!TextUtils.isEmpty((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar))) {
            this.zzg.zzb(PreferenceManager.getDefaultSharedPreferences(this.zzj), Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).split(",")));
        }
        zzbbn zzbbnVar2 = zzbbw.zziE;
        if (!TextUtils.isEmpty((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar2))) {
            this.zzh.zzb(this.zzj.getSharedPreferences(AppLovinMediationProvider.ADMOB, 0), Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar2)).split(",")));
        }
        zzA(com.google.android.gms.ads.internal.zzu.zzo().zzi().zzn());
        this.zzx = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzo();
    }

    private final void zzv() {
        com.google.android.gms.ads.internal.zzu.zzo().zzi().zzG(zzd());
    }

    private final synchronized void zzw(zzdve zzdveVar, boolean z10) {
        if (this.zzr != zzdveVar) {
            if (zzq()) {
                zzy();
            }
            this.zzr = zzdveVar;
            if (zzq()) {
                zzz();
            }
            if (z10) {
                zzv();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0006, B:8:0x000a, B:10:0x001c, B:12:0x0026, B:17:0x0035, B:13:0x002a, B:15:0x0030), top: B:25:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final synchronized void zzx(boolean r2, boolean r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzs     // Catch: java.lang.Throwable -> L3c
            if (r0 != r2) goto L6
            goto L3a
        L6:
            r1.zzs = r2     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L2a
            com.google.android.gms.internal.ads.zzbbn r2 = com.google.android.gms.internal.ads.zzbbw.zzip     // Catch: java.lang.Throwable -> L3c
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r2 = r0.zza(r2)     // Catch: java.lang.Throwable -> L3c
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> L3c
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L26
            com.google.android.gms.ads.internal.util.zzay r2 = com.google.android.gms.ads.internal.zzu.zzs()     // Catch: java.lang.Throwable -> L3c
            boolean r2 = r2.zzl()     // Catch: java.lang.Throwable -> L3c
            if (r2 != 0) goto L2a
        L26:
            r1.zzz()     // Catch: java.lang.Throwable -> L3c
            goto L33
        L2a:
            boolean r2 = r1.zzq()     // Catch: java.lang.Throwable -> L3c
            if (r2 != 0) goto L33
            r1.zzy()     // Catch: java.lang.Throwable -> L3c
        L33:
            if (r3 == 0) goto L3a
            r1.zzv()     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r1)
            return
        L3a:
            monitor-exit(r1)
            return
        L3c:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvi.zzx(boolean, boolean):void");
    }

    private final synchronized void zzy() {
        int iOrdinal = this.zzr.ordinal();
        if (iOrdinal == 1) {
            this.zzb.zzb();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.zzc.zzb();
        }
    }

    private final synchronized void zzz() {
        int iOrdinal = this.zzr.ordinal();
        if (iOrdinal == 1) {
            this.zzb.zzc();
        } else {
            if (iOrdinal != 2) {
                return;
            }
            this.zzc.zzc();
        }
    }

    public final zzdve zza() {
        return this.zzr;
    }

    public final synchronized m zzb(String str) {
        zzbzt zzbztVar;
        zzbztVar = new zzbzt();
        if (this.zzm.containsKey(str)) {
            zzbztVar.zzc((zzduw) this.zzm.get(str));
        } else {
            if (!this.zzn.containsKey(str)) {
                this.zzn.put(str, new ArrayList());
            }
            ((List) this.zzn.get(str)).add(zzbztVar);
        }
        return zzbztVar;
    }

    public final synchronized String zzc() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzia)).booleanValue() && zzq()) {
            if (this.zzq < com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() / 1000) {
                this.zzo = JsonUtils.EMPTY_JSON;
                this.zzq = Long.MAX_VALUE;
                return "";
            }
            if (!this.zzo.equals(JsonUtils.EMPTY_JSON)) {
                return this.zzo;
            }
        }
        return "";
    }

    public final synchronized String zzd() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("isTestMode", this.zzs);
            jSONObject.put("gesture", this.zzr);
            if (this.zzq > com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() / 1000) {
                jSONObject.put("networkExtras", this.zzo);
                jSONObject.put("networkExtrasExpirationSecs", this.zzq);
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public final synchronized JSONObject zze() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "ANDROID");
            if (!TextUtils.isEmpty(this.zzk)) {
                jSONObject.put("sdkVersion", "afma-sdk-a-v" + this.zzk);
            }
            jSONObject.put("internalSdkVersion", this.zzi);
            jSONObject.put("osVersion", Build.VERSION.RELEASE);
            jSONObject.put("adapters", this.zzd.zza());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziA)).booleanValue()) {
                String strZzn = com.google.android.gms.ads.internal.zzu.zzo().zzn();
                if (!TextUtils.isEmpty(strZzn)) {
                    jSONObject.put(ad.E, strZzn);
                }
            }
            if (this.zzq < com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() / 1000) {
                this.zzo = JsonUtils.EMPTY_JSON;
            }
            jSONObject.put("networkExtras", this.zzo);
            jSONObject.put("adSlots", zzt());
            jSONObject.put("appInfo", this.zze.zza());
            String strZzc = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzh().zzc();
            if (!TextUtils.isEmpty(strZzc)) {
                jSONObject.put("cld", new JSONObject(strZzc));
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziq)).booleanValue() && (jSONObject2 = this.zzp) != null) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Server data: " + jSONObject2.toString());
                jSONObject.put(f5.f12051r, this.zzp);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzip)).booleanValue()) {
                jSONObject.put("openAction", this.zzv);
                jSONObject.put("gesture", this.zzr);
            }
            jSONObject.put("isGamRegisteredTestDevice", com.google.android.gms.ads.internal.zzu.zzs().zzl());
            com.google.android.gms.ads.internal.zzu.zzp();
            com.google.android.gms.ads.internal.client.zzay.zzb();
            jSONObject.put("isSimulator", com.google.android.gms.ads.internal.util.client.zzf.zzs());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziC)).booleanValue()) {
                jSONObject.put("uiStorage", new JSONObject(this.zzx));
            }
            if (!TextUtils.isEmpty((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziE))) {
                jSONObject.put("gmaDisk", this.zzh.zza());
            }
            if (!TextUtils.isEmpty((CharSequence) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziD))) {
                jSONObject.put("userDisk", this.zzg.zza());
            }
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzv(e10, "Inspector.toJson");
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Ad inspector encountered an error", e10);
        }
        return jSONObject;
    }

    public final synchronized void zzf(String str, zzduw zzduwVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzia)).booleanValue() && zzq()) {
            if (this.zzt >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzic)).intValue()) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Maximum number of ad requests stored reached. Dropping the current request.");
                return;
            }
            if (!this.zzl.containsKey(str)) {
                this.zzl.put(str, new ArrayList());
            }
            this.zzt++;
            ((List) this.zzl.get(str)).add(zzduwVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziy)).booleanValue()) {
                String strZzc = zzduwVar.zzc();
                this.zzm.put(strZzc, zzduwVar);
                if (this.zzn.containsKey(strZzc)) {
                    List list = (List) this.zzn.get(strZzc);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((zzbzt) it.next()).zzc(zzduwVar);
                    }
                    list.clear();
                }
            }
        }
    }

    public final void zzg() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzia)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzip)).booleanValue() && com.google.android.gms.ads.internal.zzu.zzo().zzi().zzR()) {
                zzu();
                return;
            }
            String strZzn = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzn();
            if (TextUtils.isEmpty(strZzn)) {
                return;
            }
            try {
                if (new JSONObject(strZzn).optBoolean("isTestMode", false)) {
                    zzu();
                }
            } catch (JSONException unused) {
            }
        }
    }

    public final synchronized void zzh(com.google.android.gms.ads.internal.client.zzda zzdaVar, zzdvh zzdvhVar) {
        if (!zzq()) {
            try {
                zzdaVar.zze(zzfgi.zzd(18, null, null));
                return;
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
                return;
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzia)).booleanValue()) {
            this.zzv = zzdvhVar;
            this.zza.zzj(zzdaVar, new zzbjr(this), new zzbjk(this.zzf), new zzbiy(this));
            return;
        } else {
            try {
                zzdaVar.zze(zzfgi.zzd(1, null, null));
                return;
            } catch (RemoteException unused2) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Ad inspector had an internal error.");
                return;
            }
        }
    }

    public final synchronized void zzi(String str, long j10) {
        this.zzo = str;
        this.zzq = j10;
        zzv();
    }

    public final synchronized void zzj(String str) {
        this.zzx = str;
        com.google.android.gms.ads.internal.zzu.zzo().zzi().zzH(this.zzx);
    }

    public final synchronized void zzk(long j10) {
        this.zzw += j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzl(boolean r2) {
        /*
            r1 = this;
            boolean r0 = r1.zzu
            if (r0 != 0) goto La
            if (r2 == 0) goto L15
            r1.zzu()
            goto Lc
        La:
            if (r2 == 0) goto L15
        Lc:
            boolean r2 = r1.zzs
            if (r2 == 0) goto L11
            goto L15
        L11:
            r1.zzz()
            return
        L15:
            boolean r2 = r1.zzq()
            if (r2 != 0) goto L1e
            r1.zzy()
        L1e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvi.zzl(boolean):void");
    }

    public final void zzm(zzdve zzdveVar) {
        zzw(zzdveVar, true);
    }

    public final synchronized void zzn(JSONObject jSONObject) {
        this.zzp = jSONObject;
    }

    public final void zzo(boolean z10) {
        if (!this.zzu && z10) {
            zzu();
        }
        zzx(z10, true);
    }

    public final boolean zzp() {
        return this.zzp != null;
    }

    public final synchronized boolean zzq() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzip)).booleanValue()) {
            return this.zzs || com.google.android.gms.ads.internal.zzu.zzs().zzl();
        }
        return this.zzs;
    }

    public final synchronized boolean zzr() {
        return this.zzs;
    }

    public final boolean zzs() {
        return this.zzw < ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziv)).longValue();
    }
}
