package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.m;
import com.ironsource.v8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbux extends zzbuv {
    private final Object zza = new Object();
    private final Context zzb;

    @Nullable
    private SharedPreferences zzc;
    private final zzbne zzd;
    private final VersionInfoParcel zze;

    public zzbux(Context context, zzbne zzbneVar, VersionInfoParcel versionInfoParcel) {
        this.zzb = context.getApplicationContext();
        this.zze = versionInfoParcel;
        this.zzd = zzbneVar;
    }

    public static JSONObject zzc(Context context, VersionInfoParcel versionInfoParcel) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (((Boolean) zzbds.zzb.zze()).booleanValue()) {
                jSONObject.put(v8.h.V, context.getPackageName());
            }
            jSONObject.put("js", versionInfoParcel.afmaVersion);
            jSONObject.put("mf", zzbds.zzc.zze());
            jSONObject.put("cl", "661295874");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 12451000);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzbuv
    public final m zza() {
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        SharedPreferences sharedPreferences = this.zzc;
        if (com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() - (sharedPreferences != null ? sharedPreferences.getLong("js_last_update", 0L) : 0L) < ((Long) zzbds.zzd.zze()).longValue()) {
            return zzgcj.zzh(null);
        }
        return zzgcj.zzm(this.zzd.zzb(zzc(this.zzb, this.zze)), new zzful() { // from class: com.google.android.gms.internal.ads.zzbuw
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                this.zza.zzb((JSONObject) obj);
                return null;
            }
        }, zzbzo.zzf);
    }

    final /* synthetic */ Void zzb(JSONObject jSONObject) {
        zzbbn zzbbnVar = zzbbw.zza;
        com.google.android.gms.ads.internal.client.zzba.zzb();
        SharedPreferences sharedPreferencesZza = zzbbp.zza(this.zzb);
        if (sharedPreferencesZza == null) {
            return null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesZza.edit();
        com.google.android.gms.ads.internal.client.zzba.zza();
        int i10 = zzbdi.zza;
        com.google.android.gms.ads.internal.client.zzba.zza().zze(editorEdit, 1, jSONObject);
        com.google.android.gms.ads.internal.client.zzba.zzb();
        editorEdit.commit();
        SharedPreferences sharedPreferences = this.zzc;
        if (sharedPreferences == null) {
            return null;
        }
        sharedPreferences.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis()).apply();
        return null;
    }
}
