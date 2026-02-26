package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdkn {
    private final zzdpl zza;
    private final zzdoa zzb;
    private final zzcop zzc;
    private final zzdjj zzd;

    public zzdkn(zzdpl zzdplVar, zzdoa zzdoaVar, zzcop zzcopVar, zzdjj zzdjjVar) {
        this.zza = zzdplVar;
        this.zzb = zzdoaVar;
        this.zzc = zzcopVar;
        this.zzd = zzdjjVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View zza() throws zzcev {
        zzcej zzcejVarZza = this.zza.zza(com.google.android.gms.ads.internal.client.zzq.zzc(), null, null);
        ((View) zzcejVarZza).setVisibility(8);
        zzcejVarZza.zzag("/sendMessageToSdk", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdki
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzb((zzcej) obj, map);
            }
        });
        zzcejVarZza.zzag("/adMuted", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkj
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzc((zzcej) obj, map);
            }
        });
        this.zzb.zzm(new WeakReference(zzcejVarZza), "/loadHtml", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkk
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, final Map map) {
                zzcej zzcejVar = (zzcej) obj;
                zzcgb zzcgbVarZzN = zzcejVar.zzN();
                final zzdkn zzdknVar = this.zza;
                zzcgbVarZzN.zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzdkh
                    @Override // com.google.android.gms.internal.ads.zzcfz
                    public final void zza(boolean z10, int i10, String str, String str2) {
                        zzdknVar.zzd(map, z10, i10, str, str2);
                    }
                });
                String str = (String) map.get("overlayHtml");
                String str2 = (String) map.get("baseUrl");
                if (TextUtils.isEmpty(str2)) {
                    zzcejVar.loadData(str, "text/html", "UTF-8");
                } else {
                    zzcejVar.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", null);
                }
            }
        });
        this.zzb.zzm(new WeakReference(zzcejVarZza), "/showOverlay", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkl
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zze((zzcej) obj, map);
            }
        });
        this.zzb.zzm(new WeakReference(zzcejVarZza), "/hideOverlay", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdkm
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzf((zzcej) obj, map);
            }
        });
        return (View) zzcejVarZza;
    }

    final /* synthetic */ void zzb(zzcej zzcejVar, Map map) {
        this.zzb.zzj("sendMessageToNativeJs", map);
    }

    final /* synthetic */ void zzc(zzcej zzcejVar, Map map) {
        this.zzd.zzg();
    }

    final /* synthetic */ void zzd(Map map, boolean z10, int i10, String str, String str2) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "htmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzb.zzj("sendMessageToNativeJs", map2);
    }

    final /* synthetic */ void zze(zzcej zzcejVar, Map map) {
        com.google.android.gms.ads.internal.util.client.zzm.zzi("Showing native ads overlay.");
        zzcejVar.zzF().setVisibility(0);
        this.zzc.zze(true);
    }

    final /* synthetic */ void zzf(zzcej zzcejVar, Map map) {
        com.google.android.gms.ads.internal.util.client.zzm.zzi("Hiding native ads overlay.");
        zzcejVar.zzF().setVisibility(8);
        this.zzc.zze(false);
    }
}
