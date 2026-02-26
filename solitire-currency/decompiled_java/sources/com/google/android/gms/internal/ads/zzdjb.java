package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.m;
import com.ironsource.v8;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdjb {
    private int zza;
    private com.google.android.gms.ads.internal.client.zzdq zzb;
    private zzbew zzc;
    private View zzd;
    private List zze;
    private com.google.android.gms.ads.internal.client.zzel zzg;
    private Bundle zzh;
    private zzcej zzi;
    private zzcej zzj;

    @Nullable
    private zzcej zzk;

    @Nullable
    private zzeeo zzl;

    @Nullable
    private m zzm;

    @Nullable
    private zzbzt zzn;
    private View zzo;
    private View zzp;
    private IObjectWrapper zzq;
    private double zzr;
    private zzbfd zzs;
    private zzbfd zzt;
    private String zzu;
    private float zzx;

    @Nullable
    private String zzy;
    private final SimpleArrayMap zzv = new SimpleArrayMap();
    private final SimpleArrayMap zzw = new SimpleArrayMap();
    private List zzf = Collections.emptyList();

    @Nullable
    public static zzdjb zzag(zzbox zzboxVar) {
        try {
            zzdja zzdjaVarZzak = zzak(zzboxVar.zzg(), null);
            zzbew zzbewVarZzh = zzboxVar.zzh();
            View view = (View) zzam(zzboxVar.zzj());
            String strZzo = zzboxVar.zzo();
            List listZzr = zzboxVar.zzr();
            String strZzm = zzboxVar.zzm();
            Bundle bundleZzf = zzboxVar.zzf();
            String strZzn = zzboxVar.zzn();
            View view2 = (View) zzam(zzboxVar.zzk());
            IObjectWrapper iObjectWrapperZzl = zzboxVar.zzl();
            String strZzq = zzboxVar.zzq();
            String strZzp = zzboxVar.zzp();
            double dZze = zzboxVar.zze();
            zzbfd zzbfdVarZzi = zzboxVar.zzi();
            zzdjb zzdjbVar = new zzdjb();
            zzdjbVar.zza = 2;
            zzdjbVar.zzb = zzdjaVarZzak;
            zzdjbVar.zzc = zzbewVarZzh;
            zzdjbVar.zzd = view;
            zzdjbVar.zzZ("headline", strZzo);
            zzdjbVar.zze = listZzr;
            zzdjbVar.zzZ("body", strZzm);
            zzdjbVar.zzh = bundleZzf;
            zzdjbVar.zzZ("call_to_action", strZzn);
            zzdjbVar.zzo = view2;
            zzdjbVar.zzq = iObjectWrapperZzl;
            zzdjbVar.zzZ(v8.h.U, strZzq);
            zzdjbVar.zzZ("price", strZzp);
            zzdjbVar.zzr = dZze;
            zzdjbVar.zzs = zzbfdVarZzi;
            return zzdjbVar;
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to get native ad from app install ad mapper", e10);
            return null;
        }
    }

    @Nullable
    public static zzdjb zzah(zzboy zzboyVar) {
        try {
            zzdja zzdjaVarZzak = zzak(zzboyVar.zzf(), null);
            zzbew zzbewVarZzg = zzboyVar.zzg();
            View view = (View) zzam(zzboyVar.zzi());
            String strZzo = zzboyVar.zzo();
            List listZzp = zzboyVar.zzp();
            String strZzm = zzboyVar.zzm();
            Bundle bundleZze = zzboyVar.zze();
            String strZzn = zzboyVar.zzn();
            View view2 = (View) zzam(zzboyVar.zzj());
            IObjectWrapper iObjectWrapperZzk = zzboyVar.zzk();
            String strZzl = zzboyVar.zzl();
            zzbfd zzbfdVarZzh = zzboyVar.zzh();
            zzdjb zzdjbVar = new zzdjb();
            zzdjbVar.zza = 1;
            zzdjbVar.zzb = zzdjaVarZzak;
            zzdjbVar.zzc = zzbewVarZzg;
            zzdjbVar.zzd = view;
            zzdjbVar.zzZ("headline", strZzo);
            zzdjbVar.zze = listZzp;
            zzdjbVar.zzZ("body", strZzm);
            zzdjbVar.zzh = bundleZze;
            zzdjbVar.zzZ("call_to_action", strZzn);
            zzdjbVar.zzo = view2;
            zzdjbVar.zzq = iObjectWrapperZzk;
            zzdjbVar.zzZ(v8.h.F0, strZzl);
            zzdjbVar.zzt = zzbfdVarZzh;
            return zzdjbVar;
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to get native ad from content ad mapper", e10);
            return null;
        }
    }

    @Nullable
    public static zzdjb zzai(zzbox zzboxVar) {
        try {
            return zzal(zzak(zzboxVar.zzg(), null), zzboxVar.zzh(), (View) zzam(zzboxVar.zzj()), zzboxVar.zzo(), zzboxVar.zzr(), zzboxVar.zzm(), zzboxVar.zzf(), zzboxVar.zzn(), (View) zzam(zzboxVar.zzk()), zzboxVar.zzl(), zzboxVar.zzq(), zzboxVar.zzp(), zzboxVar.zze(), zzboxVar.zzi(), null, 0.0f);
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to get native ad assets from app install ad mapper", e10);
            return null;
        }
    }

    @Nullable
    public static zzdjb zzaj(zzboy zzboyVar) {
        try {
            return zzal(zzak(zzboyVar.zzf(), null), zzboyVar.zzg(), (View) zzam(zzboyVar.zzi()), zzboyVar.zzo(), zzboyVar.zzp(), zzboyVar.zzm(), zzboyVar.zze(), zzboyVar.zzn(), (View) zzam(zzboyVar.zzj()), zzboyVar.zzk(), null, null, -1.0d, zzboyVar.zzh(), zzboyVar.zzl(), 0.0f);
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to get native ad assets from content ad mapper", e10);
            return null;
        }
    }

    @Nullable
    private static zzdja zzak(com.google.android.gms.ads.internal.client.zzdq zzdqVar, @Nullable zzbpb zzbpbVar) {
        if (zzdqVar == null) {
            return null;
        }
        return new zzdja(zzdqVar, zzbpbVar);
    }

    private static zzdjb zzal(com.google.android.gms.ads.internal.client.zzdq zzdqVar, zzbew zzbewVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d10, zzbfd zzbfdVar, String str6, float f10) {
        zzdjb zzdjbVar = new zzdjb();
        zzdjbVar.zza = 6;
        zzdjbVar.zzb = zzdqVar;
        zzdjbVar.zzc = zzbewVar;
        zzdjbVar.zzd = view;
        zzdjbVar.zzZ("headline", str);
        zzdjbVar.zze = list;
        zzdjbVar.zzZ("body", str2);
        zzdjbVar.zzh = bundle;
        zzdjbVar.zzZ("call_to_action", str3);
        zzdjbVar.zzo = view2;
        zzdjbVar.zzq = iObjectWrapper;
        zzdjbVar.zzZ(v8.h.U, str4);
        zzdjbVar.zzZ("price", str5);
        zzdjbVar.zzr = d10;
        zzdjbVar.zzs = zzbfdVar;
        zzdjbVar.zzZ(v8.h.F0, str6);
        zzdjbVar.zzR(f10);
        return zzdjbVar;
    }

    private static Object zzam(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    @Nullable
    public static zzdjb zzt(zzbpb zzbpbVar) {
        try {
            return zzal(zzak(zzbpbVar.zzj(), zzbpbVar), zzbpbVar.zzk(), (View) zzam(zzbpbVar.zzm()), zzbpbVar.zzs(), zzbpbVar.zzv(), zzbpbVar.zzq(), zzbpbVar.zzi(), zzbpbVar.zzr(), (View) zzam(zzbpbVar.zzn()), zzbpbVar.zzo(), zzbpbVar.zzu(), zzbpbVar.zzt(), zzbpbVar.zze(), zzbpbVar.zzl(), zzbpbVar.zzp(), zzbpbVar.zzf());
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to get native ad assets from unified ad mapper", e10);
            return null;
        }
    }

    public final synchronized String zzA() {
        return this.zzu;
    }

    public final synchronized String zzB() {
        return zzF("headline");
    }

    @Nullable
    public final synchronized String zzC() {
        return this.zzy;
    }

    public final synchronized String zzD() {
        return zzF("price");
    }

    public final synchronized String zzE() {
        return zzF(v8.h.U);
    }

    public final synchronized String zzF(String str) {
        return (String) this.zzw.get(str);
    }

    public final synchronized List zzG() {
        return this.zze;
    }

    public final synchronized List zzH() {
        return this.zzf;
    }

    public final synchronized void zzI() {
        zzcej zzcejVar = this.zzi;
        if (zzcejVar != null) {
            zzcejVar.destroy();
            this.zzi = null;
        }
        zzcej zzcejVar2 = this.zzj;
        if (zzcejVar2 != null) {
            zzcejVar2.destroy();
            this.zzj = null;
        }
        zzcej zzcejVar3 = this.zzk;
        if (zzcejVar3 != null) {
            zzcejVar3.destroy();
            this.zzk = null;
        }
        m mVar = this.zzm;
        if (mVar != null) {
            mVar.cancel(false);
            this.zzm = null;
        }
        zzbzt zzbztVar = this.zzn;
        if (zzbztVar != null) {
            zzbztVar.cancel(false);
            this.zzn = null;
        }
        this.zzl = null;
        this.zzv.clear();
        this.zzw.clear();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzh = null;
        this.zzo = null;
        this.zzp = null;
        this.zzq = null;
        this.zzs = null;
        this.zzt = null;
        this.zzu = null;
    }

    public final synchronized void zzJ(zzbew zzbewVar) {
        this.zzc = zzbewVar;
    }

    public final synchronized void zzK(String str) {
        this.zzu = str;
    }

    public final synchronized void zzL(@Nullable com.google.android.gms.ads.internal.client.zzel zzelVar) {
        this.zzg = zzelVar;
    }

    public final synchronized void zzM(zzbfd zzbfdVar) {
        this.zzs = zzbfdVar;
    }

    public final synchronized void zzN(String str, zzbeq zzbeqVar) {
        if (zzbeqVar == null) {
            this.zzv.remove(str);
        } else {
            this.zzv.put(str, zzbeqVar);
        }
    }

    public final synchronized void zzO(zzcej zzcejVar) {
        this.zzj = zzcejVar;
    }

    public final synchronized void zzP(List list) {
        this.zze = list;
    }

    public final synchronized void zzQ(zzbfd zzbfdVar) {
        this.zzt = zzbfdVar;
    }

    public final synchronized void zzR(float f10) {
        this.zzx = f10;
    }

    public final synchronized void zzS(List list) {
        this.zzf = list;
    }

    public final synchronized void zzT(zzcej zzcejVar) {
        this.zzk = zzcejVar;
    }

    public final synchronized void zzU(m mVar) {
        this.zzm = mVar;
    }

    public final synchronized void zzV(@Nullable String str) {
        this.zzy = str;
    }

    public final synchronized void zzW(zzeeo zzeeoVar) {
        this.zzl = zzeeoVar;
    }

    public final synchronized void zzX(zzbzt zzbztVar) {
        this.zzn = zzbztVar;
    }

    public final synchronized void zzY(double d10) {
        this.zzr = d10;
    }

    public final synchronized void zzZ(String str, String str2) {
        if (str2 == null) {
            this.zzw.remove(str);
        } else {
            this.zzw.put(str, str2);
        }
    }

    public final synchronized double zza() {
        return this.zzr;
    }

    public final synchronized void zzaa(int i10) {
        this.zza = i10;
    }

    public final synchronized void zzab(com.google.android.gms.ads.internal.client.zzdq zzdqVar) {
        this.zzb = zzdqVar;
    }

    public final synchronized void zzac(View view) {
        this.zzo = view;
    }

    public final synchronized void zzad(zzcej zzcejVar) {
        this.zzi = zzcejVar;
    }

    public final synchronized void zzae(View view) {
        this.zzp = view;
    }

    public final synchronized boolean zzaf() {
        return this.zzj != null;
    }

    public final synchronized float zzb() {
        return this.zzx;
    }

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized Bundle zzd() {
        if (this.zzh == null) {
            this.zzh = new Bundle();
        }
        return this.zzh;
    }

    public final synchronized View zze() {
        return this.zzd;
    }

    public final synchronized View zzf() {
        return this.zzo;
    }

    public final synchronized View zzg() {
        return this.zzp;
    }

    public final synchronized SimpleArrayMap zzh() {
        return this.zzv;
    }

    public final synchronized SimpleArrayMap zzi() {
        return this.zzw;
    }

    public final synchronized com.google.android.gms.ads.internal.client.zzdq zzj() {
        return this.zzb;
    }

    @Nullable
    public final synchronized com.google.android.gms.ads.internal.client.zzel zzk() {
        return this.zzg;
    }

    public final synchronized zzbew zzl() {
        return this.zzc;
    }

    @Nullable
    public final zzbfd zzm() {
        List list = this.zze;
        if (list == null || list.isEmpty()) {
            return null;
        }
        Object obj = this.zze.get(0);
        if (obj instanceof IBinder) {
            return zzbfc.zzg((IBinder) obj);
        }
        return null;
    }

    public final synchronized zzbfd zzn() {
        return this.zzs;
    }

    public final synchronized zzbfd zzo() {
        return this.zzt;
    }

    @Nullable
    public final synchronized zzbzt zzp() {
        return this.zzn;
    }

    public final synchronized zzcej zzq() {
        return this.zzj;
    }

    @Nullable
    public final synchronized zzcej zzr() {
        return this.zzk;
    }

    public final synchronized zzcej zzs() {
        return this.zzi;
    }

    @Nullable
    public final synchronized zzeeo zzu() {
        return this.zzl;
    }

    public final synchronized IObjectWrapper zzv() {
        return this.zzq;
    }

    @Nullable
    public final synchronized m zzw() {
        return this.zzm;
    }

    public final synchronized String zzx() {
        return zzF(v8.h.F0);
    }

    public final synchronized String zzy() {
        return zzF("body");
    }

    public final synchronized String zzz() {
        return zzF("call_to_action");
    }
}
