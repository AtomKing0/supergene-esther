package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.m;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdzc {
    private final zzgcu zza;
    private final zzdyg zzb;
    private final zzhew zzc;
    private final zzfki zzd;
    private final Context zze;
    private final VersionInfoParcel zzf;

    public zzdzc(zzgcu zzgcuVar, zzdyg zzdygVar, zzhew zzhewVar, zzfki zzfkiVar, Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = zzgcuVar;
        this.zzb = zzdygVar;
        this.zzc = zzhewVar;
        this.zzd = zzfkiVar;
        this.zze = context;
        this.zzf = versionInfoParcel;
    }

    private final m zzh(final zzbvb zzbvbVar, zzdzb zzdzbVar, final zzdzb zzdzbVar2, final zzgbq zzgbqVar) {
        String str = zzbvbVar.zzd;
        com.google.android.gms.ads.internal.zzu.zzp();
        return zzgcj.zzf(zzgcj.zzn(zzgcj.zzn(zzgca.zzu(com.google.android.gms.ads.internal.util.zzt.zzC(str) ? zzgcj.zzg(new zzdyp(1)) : zzgcj.zzf(zzdzbVar.zza(zzbvbVar), ExecutionException.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdza
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                Throwable cause = (ExecutionException) obj;
                if (cause.getCause() != null) {
                    cause = cause.getCause();
                }
                return zzgcj.zzg(cause);
            }
        }, this.zza)), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdyy
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzgcj.zzh(((zzdyq) obj).zzb());
            }
        }, this.zza), zzgbqVar, this.zza), zzdyp.class, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdyz
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzc(zzdzbVar2, zzbvbVar, zzgbqVar, (zzdyp) obj);
            }
        }, this.zza);
    }

    public final m zza(final zzbvb zzbvbVar) {
        zzgbq zzgbqVar = new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdyv
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                String str = new String(zzgab.zzb((InputStream) obj), zzfuj.zzc);
                zzbvb zzbvbVar2 = zzbvbVar;
                zzbvbVar2.zzj = str;
                return zzgcj.zzh(zzbvbVar2);
            }
        };
        final zzdyg zzdygVar = this.zzb;
        Objects.requireNonNull(zzdygVar);
        return zzh(zzbvbVar, new zzdzb() { // from class: com.google.android.gms.internal.ads.zzdyw
            @Override // com.google.android.gms.internal.ads.zzdzb
            public final m zza(zzbvb zzbvbVar2) {
                return zzdygVar.zza(zzbvbVar2);
            }
        }, new zzdzb() { // from class: com.google.android.gms.internal.ads.zzdyx
            @Override // com.google.android.gms.internal.ads.zzdzb
            public final m zza(zzbvb zzbvbVar2) {
                return this.zza.zzd(zzbvbVar2);
            }
        }, zzgbqVar);
    }

    public final m zzb(JSONObject jSONObject) {
        return zzgcj.zzn(zzgca.zzu(zzgcj.zzh(jSONObject)), com.google.android.gms.ads.internal.zzu.zzf().zza(this.zze, this.zzf, this.zzd).zza("AFMA_getAdDictionary", zzbnl.zza, new zzbng() { // from class: com.google.android.gms.internal.ads.zzdyr
            @Override // com.google.android.gms.internal.ads.zzbng
            public final Object zza(JSONObject jSONObject2) {
                return new zzbvd(jSONObject2);
            }
        }), this.zza);
    }

    final /* synthetic */ m zzc(zzdzb zzdzbVar, zzbvb zzbvbVar, zzgbq zzgbqVar, zzdyp zzdypVar) throws Exception {
        return zzgcj.zzn(zzdzbVar.zza(zzbvbVar), zzgbqVar, this.zza);
    }

    final /* synthetic */ m zzd(zzbvb zzbvbVar) {
        return ((zzeay) this.zzc.zzb()).zzb(zzbvbVar, Binder.getCallingUid());
    }

    final /* synthetic */ m zze(zzbvb zzbvbVar) {
        return this.zzb.zzd(zzbvbVar.zzh);
    }

    final /* synthetic */ m zzf(zzbvb zzbvbVar) {
        return ((zzeay) this.zzc.zzb()).zzi(zzbvbVar.zzh);
    }

    public final m zzg(zzbvb zzbvbVar) {
        return zzh(zzbvbVar, new zzdzb() { // from class: com.google.android.gms.internal.ads.zzdyt
            @Override // com.google.android.gms.internal.ads.zzdzb
            public final m zza(zzbvb zzbvbVar2) {
                return this.zza.zze(zzbvbVar2);
            }
        }, new zzdzb() { // from class: com.google.android.gms.internal.ads.zzdyu
            @Override // com.google.android.gms.internal.ads.zzdzb
            public final m zza(zzbvb zzbvbVar2) {
                return this.zza.zzf(zzbvbVar2);
            }
        }, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdys
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return zzgcj.zzh(null);
            }
        });
    }
}
