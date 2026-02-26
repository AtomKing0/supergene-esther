package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbbu implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzg;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;

    @VisibleForTesting
    volatile boolean zza = false;

    @Nullable
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;
    private boolean zzj = false;

    private final void zzg(final SharedPreferences sharedPreferences) {
        if (sharedPreferences == null) {
            return;
        }
        try {
            this.zzh = new JSONObject((String) zzbby.zza(new zzfvk() { // from class: com.google.android.gms.internal.ads.zzbbr
                @Override // com.google.android.gms.internal.ads.zzfvk
                public final Object zza() {
                    return sharedPreferences.getString("flag_configuration", JsonUtils.EMPTY_JSON);
                }
            }));
        } catch (JSONException unused) {
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzg(sharedPreferences);
        }
    }

    public final Object zza(final zzbbn zzbbnVar) {
        if (!this.zzc.block(5000L)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null || this.zzj) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null && !this.zzj) {
                }
                return zzbbnVar.zzm();
            }
        }
        if (zzbbnVar.zze() != 2) {
            return (zzbbnVar.zze() == 1 && this.zzh.has(zzbbnVar.zzn())) ? zzbbnVar.zza(this.zzh) : zzbby.zza(new zzfvk() { // from class: com.google.android.gms.internal.ads.zzbbs
                @Override // com.google.android.gms.internal.ads.zzfvk
                public final Object zza() {
                    return this.zza.zzc(zzbbnVar);
                }
            });
        }
        Bundle bundle = this.zzf;
        return bundle == null ? zzbbnVar.zzm() : zzbbnVar.zzb(bundle);
    }

    public final Object zzb(zzbbn zzbbnVar) {
        return (this.zzd || this.zza) ? zza(zzbbnVar) : zzbbnVar.zzm();
    }

    final /* synthetic */ Object zzc(zzbbn zzbbnVar) {
        return zzbbnVar.zzc(this.zze);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0119 A[Catch: all -> 0x0159, DONT_GENERATE, TRY_ENTER, TryCatch #2 {, blocks: (B:7:0x0008, B:9:0x000c, B:11:0x000e, B:13:0x0013, B:14:0x0015, B:16:0x0027, B:17:0x002b, B:18:0x002d, B:38:0x0097, B:39:0x009e, B:48:0x00cd, B:49:0x00d4, B:63:0x0119, B:64:0x0120, B:72:0x0147, B:73:0x014e, B:76:0x0151, B:77:0x0158, B:20:0x0042, B:23:0x004c, B:27:0x0055, B:30:0x0060, B:31:0x0068, B:33:0x006e, B:35:0x007e, B:37:0x0093, B:41:0x00a0, B:43:0x00a4, B:45:0x00b4, B:47:0x00c9, B:51:0x00d6, B:61:0x0115, B:66:0x0122, B:68:0x0139, B:70:0x013d, B:71:0x0140, B:54:0x00e7, B:56:0x00f5, B:58:0x00fd, B:59:0x0108), top: B:86:0x0008, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0122 A[Catch: all -> 0x0150, TRY_ENTER, TryCatch #0 {all -> 0x0150, blocks: (B:20:0x0042, B:23:0x004c, B:27:0x0055, B:30:0x0060, B:31:0x0068, B:33:0x006e, B:35:0x007e, B:37:0x0093, B:41:0x00a0, B:43:0x00a4, B:45:0x00b4, B:47:0x00c9, B:51:0x00d6, B:61:0x0115, B:66:0x0122, B:68:0x0139, B:70:0x013d, B:71:0x0140, B:54:0x00e7, B:56:0x00f5, B:58:0x00fd, B:59:0x0108), top: B:83:0x0042, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzd(android.content.Context r11) {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbu.zzd(android.content.Context):void");
    }

    public final boolean zze() {
        return this.zzj;
    }

    final boolean zzf() {
        return this.zzi;
    }
}
