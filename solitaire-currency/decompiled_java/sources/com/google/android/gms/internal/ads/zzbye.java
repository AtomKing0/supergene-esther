package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbye implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzbyf zza;
    private final String zzb;

    public zzbye(zzbyf zzbyfVar, String str) {
        this.zza = zzbyfVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzbyd zzbydVar : this.zza.zzb) {
                zzbydVar.zza.zzb(zzbydVar.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}
