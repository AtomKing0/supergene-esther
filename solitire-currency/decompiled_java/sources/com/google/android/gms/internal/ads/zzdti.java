package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.ironsource.bt;
import com.ironsource.v8;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdti implements AppEventListener, zzczo, com.google.android.gms.ads.internal.client.zza, zzcwq, zzcxk, zzcxl, zzcye, zzcwt, zzfjm {
    private final List zza;
    private final zzdsw zzb;
    private long zzc;

    public zzdti(zzdsw zzdswVar, zzcgj zzcgjVar) {
        this.zzb = zzdswVar;
        this.zza = Collections.singletonList(zzcgjVar);
    }

    private final void zzg(Class cls, String str, Object... objArr) {
        this.zzb.zza(this.zza, "Event-".concat(cls.getSimpleName()), str, objArr);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zzg(com.google.android.gms.ads.internal.client.zza.class, bt.f11466f, new Object[0]);
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void onAppEvent(String str, String str2) {
        zzg(AppEventListener.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zza() {
        zzg(zzcwq.class, bt.f11467g, new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzb() {
        zzg(zzcwq.class, bt.f11471k, new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzc() {
        zzg(zzcwq.class, bt.f11463c, new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzd(zzfjf zzfjfVar, String str) {
        zzg(zzfje.class, "onTaskSucceeded", str);
    }

    @Override // com.google.android.gms.internal.ads.zzcwt
    public final void zzdB(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzg(zzcwt.class, "onAdFailedToLoad", Integer.valueOf(zzeVar.zza), zzeVar.zzb, zzeVar.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdC(zzfjf zzfjfVar, String str) {
        zzg(zzfje.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdD(zzfjf zzfjfVar, String str, Throwable th) {
        zzg(zzfje.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzfjm
    public final void zzdE(zzfjf zzfjfVar, String str) {
        zzg(zzfje.class, "onTaskStarted", str);
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdj(Context context) {
        zzg(zzcxl.class, "onDestroy", context);
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdl(Context context) {
        zzg(zzcxl.class, v8.h.f15818t0, context);
    }

    @Override // com.google.android.gms.internal.ads.zzcxl
    public final void zzdm(Context context) {
        zzg(zzcxl.class, v8.h.f15820u0, context);
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdn(zzbvb zzbvbVar) {
        this.zzc = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime();
        zzg(zzczo.class, "onAdRequest", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzds(zzbvn zzbvnVar, String str, String str2) {
        zzg(zzcwq.class, "onRewarded", zzbvnVar, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zze() {
        zzg(zzcwq.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzf() {
        zzg(zzcwq.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcxk
    public final void zzr() {
        zzg(zzcxk.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcye
    public final void zzs() {
        com.google.android.gms.ads.internal.util.zze.zza("Ad Request Latency : " + (com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - this.zzc));
        zzg(zzcye.class, bt.f11470j, new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzczo
    public final void zzdo(zzfex zzfexVar) {
    }
}
