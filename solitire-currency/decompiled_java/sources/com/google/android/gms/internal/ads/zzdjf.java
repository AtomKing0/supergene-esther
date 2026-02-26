package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.w8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdjf extends zzdjg {
    private final JSONObject zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;

    @Nullable
    private final JSONObject zzh;

    public zzdjf(zzfel zzfelVar, JSONObject jSONObject) {
        super(zzfelVar);
        this.zzb = com.google.android.gms.ads.internal.util.zzbs.zzh(jSONObject, "tracking_urls_and_actions", "active_view");
        this.zzc = com.google.android.gms.ads.internal.util.zzbs.zzl(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzd = com.google.android.gms.ads.internal.util.zzbs.zzl(false, jSONObject, w8.f16020c, "allow_pub_rendering");
        this.zze = com.google.android.gms.ads.internal.util.zzbs.zzl(false, jSONObject, "enable_omid");
        this.zzg = com.google.android.gms.ads.internal.util.zzbs.zzb("", jSONObject, "watermark_overlay_png_base64");
        this.zzf = jSONObject.optJSONObject("overlay") != null;
        this.zzh = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeF)).booleanValue() ? jSONObject.optJSONObject("omid_settings") : null;
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final zzffj zza() {
        JSONObject jSONObject = this.zzh;
        return jSONObject != null ? new zzffj(jSONObject) : this.zza.zzV;
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final String zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    @Nullable
    public final JSONObject zzc() {
        JSONObject jSONObject = this.zzb;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zza.zzz);
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final boolean zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final boolean zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final boolean zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdjg
    public final boolean zzg() {
        return this.zzf;
    }
}
