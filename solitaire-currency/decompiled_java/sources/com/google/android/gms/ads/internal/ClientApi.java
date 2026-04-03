package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzew;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzad;
import com.google.android.gms.ads.internal.overlay.zzaf;
import com.google.android.gms.ads.internal.overlay.zzag;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzbjz;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbvq;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzbym;
import com.google.android.gms.internal.ads.zzcgj;
import com.google.android.gms.internal.ads.zzdjv;
import com.google.android.gms.internal.ads.zzdjx;
import com.google.android.gms.internal.ads.zzdtt;
import com.google.android.gms.internal.ads.zzeln;
import com.google.android.gms.internal.ads.zzezl;
import com.google.android.gms.internal.ads.zzfaz;
import com.google.android.gms.internal.ads.zzfcq;
import com.google.android.gms.internal.ads.zzfee;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class ClientApi extends zzcd {
    @KeepForSdk
    public ClientApi() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbom zzbomVar, int i10) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzeln(zzcgj.zzb(context, zzbomVar, i10), context, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzc(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzbom zzbomVar, int i10) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzezl zzezlVarZzt = zzcgj.zzb(context, zzbomVar, i10).zzt();
        zzezlVarZzt.zza(str);
        zzezlVarZzt.zzb(context);
        return i10 >= ((Integer) zzba.zzc().zza(zzbbw.zzeK)).intValue() ? zzezlVarZzt.zzc().zza() : new zzew();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzd(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzbom zzbomVar, int i10) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfaz zzfazVarZzu = zzcgj.zzb(context, zzbomVar, i10).zzu();
        zzfazVarZzu.zzc(context);
        zzfazVarZzu.zza(zzqVar);
        zzfazVarZzu.zzb(str);
        return zzfazVarZzu.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zze(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzbom zzbomVar, int i10) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfcq zzfcqVarZzv = zzcgj.zzb(context, zzbomVar, i10).zzv();
        zzfcqVarZzv.zzc(context);
        zzfcqVarZzv.zza(zzqVar);
        zzfcqVarZzv.zzb(str);
        return zzfcqVarZzv.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzf(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, int i10) {
        return new zzt((Context) ObjectWrapper.unwrap(iObjectWrapper), zzqVar, str, new VersionInfoParcel(242402000, i10, true, false));
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzco zzg(IObjectWrapper iObjectWrapper, int i10) {
        return zzcgj.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), null, i10).zzc();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzdj zzh(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10) {
        return zzcgj.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbomVar, i10).zzm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbfh zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdjx((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 242402000);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbfn zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdjv((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbjz zzk(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10, zzbjw zzbjwVar) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdtt zzdttVarZzk = zzcgj.zzb(context, zzbomVar, i10).zzk();
        zzdttVarZzk.zzb(context);
        zzdttVarZzk.zza(zzbjwVar);
        return zzdttVarZzk.zzc().zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbsg zzl(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10) {
        return zzcgj.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbomVar, i10).zzn();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbsn zzm(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel adOverlayInfoParcelZza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (adOverlayInfoParcelZza == null) {
            return new com.google.android.gms.ads.internal.overlay.zzu(activity);
        }
        int i10 = adOverlayInfoParcelZza.zzk;
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? new com.google.android.gms.ads.internal.overlay.zzu(activity) : new zzad(activity) : new zzz(activity, adOverlayInfoParcelZza) : new zzag(activity) : new zzaf(activity) : new com.google.android.gms.ads.internal.overlay.zzt(activity);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbvq zzn(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfee zzfeeVarZzw = zzcgj.zzb(context, zzbomVar, i10).zzw();
        zzfeeVarZzw.zzb(context);
        return zzfeeVarZzw.zzc().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbwg zzo(IObjectWrapper iObjectWrapper, String str, zzbom zzbomVar, int i10) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzfee zzfeeVarZzw = zzcgj.zzb(context, zzbomVar, i10).zzw();
        zzfeeVarZzw.zzb(context);
        zzfeeVarZzw.zza(str);
        return zzfeeVarZzw.zzc().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbym zzp(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10) {
        return zzcgj.zzb((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbomVar, i10).zzq();
    }
}
