package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.m;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzege implements zzeez {
    private final Context zza;
    private final zzcql zzb;
    private View zzc;
    private zzbov zzd;

    public zzege(Context context, zzcql zzcqlVar) {
        this.zza = context;
        this.zzb = zzcqlVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzeez
    public final /* bridge */ /* synthetic */ Object zza(zzfex zzfexVar, final zzfel zzfelVar, final zzeew zzeewVar) throws zzffn, zzeir {
        final View view;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgZ)).booleanValue() && zzfelVar.zzag) {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zZzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzffn(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                }
                if (zZzf) {
                    try {
                        view = (View) zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzegb
                            @Override // com.google.android.gms.internal.ads.zzgbq
                            public final m zza(Object obj) {
                                return this.zza.zzc(view, zzfelVar, obj);
                            }
                        }, zzbzo.zze).get();
                    } catch (InterruptedException | ExecutionException e10) {
                        throw new zzffn(e10);
                    }
                }
            } catch (RemoteException e11) {
                throw new zzffn(e11);
            }
        } else {
            view = this.zzc;
        }
        zzcpl zzcplVarZza = this.zzb.zza(new zzcsk(zzfexVar, zzfelVar, zzeewVar.zza), new zzcpr(view, null, new zzcrs() { // from class: com.google.android.gms.internal.ads.zzega
            @Override // com.google.android.gms.internal.ads.zzcrs
            public final com.google.android.gms.ads.internal.client.zzdq zza() throws zzffn {
                try {
                    return ((zzbql) zzeewVar.zzb).zze();
                } catch (RemoteException e12) {
                    throw new zzffn(e12);
                }
            }
        }, (zzfem) zzfelVar.zzu.get(0)));
        zzcplVarZza.zzg().zza(view);
        ((zzegp) zzeewVar.zzc).zzc(zzcplVarZza.zzj());
        return zzcplVarZza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzeez
    public final void zzb(zzfex zzfexVar, zzfel zzfelVar, zzeew zzeewVar) throws zzffn {
        try {
            ((zzbql) zzeewVar.zzb).zzq(zzfelVar.zzZ);
            zzegc zzegcVar = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgZ)).booleanValue() && zzfelVar.zzag) {
                ((zzbql) zzeewVar.zzb).zzk(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzegd(this, zzeewVar, zzegcVar), (zzbos) zzeewVar.zzc, zzfexVar.zza.zza.zze);
            } else {
                ((zzbql) zzeewVar.zzb).zzj(zzfelVar.zzU, zzfelVar.zzv.toString(), zzfexVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzegd(this, zzeewVar, zzegcVar), (zzbos) zzeewVar.zzc, zzfexVar.zza.zza.zze);
            }
        } catch (RemoteException e10) {
            throw new zzffn(e10);
        }
    }

    final /* synthetic */ m zzc(View view, zzfel zzfelVar, Object obj) throws Exception {
        return zzgcj.zzh(zzcrg.zza(this.zza, view, zzfelVar));
    }
}
