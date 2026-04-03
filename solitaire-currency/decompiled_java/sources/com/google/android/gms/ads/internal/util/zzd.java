package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.ads.zzbdo;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.common.util.concurrent.m;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzd {
    public static void zza(Context context) {
        int i10 = com.google.android.gms.ads.internal.util.client.zzl.zza;
        if (((Boolean) zzbdo.zza.zze()).booleanValue()) {
            try {
                if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) == 0 || com.google.android.gms.ads.internal.util.client.zzl.zzl()) {
                    return;
                }
                m mVarZzb = new zzc(context).zzb();
                com.google.android.gms.ads.internal.util.client.zzm.zzi("Updating ad debug logging enablement.");
                zzbzr.zza(mVarZzb, "AdDebugLogUpdater.updateEnablement");
            } catch (Exception e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Fail to determine debug setting.", e10);
            }
        }
    }
}
