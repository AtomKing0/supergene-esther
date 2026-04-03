package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdpk {
    private final zzcwo zza;
    private final zzdeo zzb;
    private final zzcxx zzc;
    private final zzcyk zzd;
    private final zzcyw zze;
    private final zzdbn zzf;
    private final Executor zzg;
    private final zzdek zzh;
    private final zzcof zzi;
    private final com.google.android.gms.ads.internal.zzb zzj;
    private final zzbxl zzk;
    private final zzauo zzl;
    private final zzdbe zzm;
    private final zzedh zzn;
    private final zzfll zzo;
    private final zzdsk zzp;
    private final zzcni zzq;
    private final zzdpq zzr;

    public zzdpk(zzcwo zzcwoVar, zzcxx zzcxxVar, zzcyk zzcykVar, zzcyw zzcywVar, zzdbn zzdbnVar, Executor executor, zzdek zzdekVar, zzcof zzcofVar, com.google.android.gms.ads.internal.zzb zzbVar, @Nullable zzbxl zzbxlVar, zzauo zzauoVar, zzdbe zzdbeVar, zzedh zzedhVar, zzfll zzfllVar, zzdsk zzdskVar, zzdeo zzdeoVar, zzcni zzcniVar, zzdpq zzdpqVar) {
        this.zza = zzcwoVar;
        this.zzc = zzcxxVar;
        this.zzd = zzcykVar;
        this.zze = zzcywVar;
        this.zzf = zzdbnVar;
        this.zzg = executor;
        this.zzh = zzdekVar;
        this.zzi = zzcofVar;
        this.zzj = zzbVar;
        this.zzk = zzbxlVar;
        this.zzl = zzauoVar;
        this.zzm = zzdbeVar;
        this.zzn = zzedhVar;
        this.zzo = zzfllVar;
        this.zzp = zzdskVar;
        this.zzb = zzdeoVar;
        this.zzq = zzcniVar;
        this.zzr = zzdpqVar;
    }

    public static final m zzj(zzcej zzcejVar, String str, String str2) {
        final zzbzt zzbztVar = new zzbzt();
        zzcejVar.zzN().zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzdpb
            @Override // com.google.android.gms.internal.ads.zzcfz
            public final void zza(boolean z10, int i10, String str3, String str4) {
                zzbzt zzbztVar2 = zzbztVar;
                if (z10) {
                    zzbztVar2.zzc(null);
                    return;
                }
                zzbztVar2.zzd(new Exception("Ad Web View failed to load. Error code: " + i10 + ", Description: " + str3 + ", Failing URL: " + str4));
            }
        });
        zzcejVar.zzae(str, str2, null);
        return zzbztVar;
    }

    final /* synthetic */ void zzc() {
        this.zza.onAdClicked();
    }

    final /* synthetic */ void zzd(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    final /* synthetic */ void zze() {
        this.zzc.zzb();
    }

    final /* synthetic */ void zzf(View view) {
        this.zzj.zza();
    }

    final /* synthetic */ void zzg(zzcej zzcejVar, zzcej zzcejVar2, Map map) {
        this.zzi.zzh(zzcejVar);
    }

    final /* synthetic */ boolean zzh(View view, MotionEvent motionEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjg)).booleanValue() && motionEvent != null && motionEvent.getAction() == 0) {
            this.zzr.zzb(motionEvent);
        }
        this.zzj.zza();
        if (view == null) {
            return false;
        }
        view.performClick();
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzi(final zzcej zzcejVar, boolean z10, zzbja zzbjaVar) {
        zzauk zzaukVarZzc;
        zzcejVar.zzN().zzR(new com.google.android.gms.ads.internal.client.zza() { // from class: com.google.android.gms.internal.ads.zzdpc
            @Override // com.google.android.gms.ads.internal.client.zza
            public final void onAdClicked() {
                this.zza.zzc();
            }
        }, this.zzd, this.zze, new zzbhp() { // from class: com.google.android.gms.internal.ads.zzdpd
            @Override // com.google.android.gms.internal.ads.zzbhp
            public final void zzb(String str, String str2) {
                this.zza.zzd(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzaa() { // from class: com.google.android.gms.internal.ads.zzdpe
            @Override // com.google.android.gms.ads.internal.overlay.zzaa
            public final void zzg() {
                this.zza.zze();
            }
        }, z10, zzbjaVar, this.zzj, new zzdpj(this), this.zzk, this.zzn, this.zzo, this.zzp, null, this.zzb, null, null, null, this.zzq);
        zzcejVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.gms.internal.ads.zzdpf
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.zza.zzh(view, motionEvent);
                return false;
            }
        });
        zzcejVar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzdpg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.zza.zzf(view);
            }
        });
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcq)).booleanValue() && (zzaukVarZzc = this.zzl.zzc()) != null) {
            zzaukVarZzc.zzo((View) zzcejVar);
        }
        this.zzh.zzo(zzcejVar, this.zzg);
        this.zzh.zzo(new zzaxw() { // from class: com.google.android.gms.internal.ads.zzdph
            @Override // com.google.android.gms.internal.ads.zzaxw
            public final void zzdp(zzaxv zzaxvVar) {
                zzcgb zzcgbVarZzN = zzcejVar.zzN();
                Rect rect = zzaxvVar.zzd;
                zzcgbVarZzN.zzq(rect.left, rect.top, false);
            }
        }, this.zzg);
        this.zzh.zza((View) zzcejVar);
        zzcejVar.zzag("/trackActiveViewUnit", new zzbix() { // from class: com.google.android.gms.internal.ads.zzdpi
            @Override // com.google.android.gms.internal.ads.zzbix
            public final void zza(Object obj, Map map) {
                this.zza.zzg(zzcejVar, (zzcej) obj, map);
            }
        });
        this.zzi.zzi(zzcejVar);
    }
}
