package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbpn extends zzboo {
    private final Object zza;
    private zzbpp zzb;
    private zzbvy zzc;
    private IObjectWrapper zzd;
    private View zze;
    private MediationInterstitialAd zzf;
    private UnifiedNativeAdMapper zzg;
    private NativeAdMapper zzh;
    private MediationRewardedAd zzi;
    private MediationInterscrollerAd zzj;
    private MediationAppOpenAd zzk;
    private final String zzl = "";

    public zzbpn(@NonNull Adapter adapter) {
        this.zza = adapter;
    }

    private final Bundle zzV(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        Bundle bundle;
        Bundle bundle2 = zzlVar.zzm;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    private final Bundle zzW(String str, com.google.android.gms.ads.internal.client.zzl zzlVar, String str2) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzm.zze("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.zza instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzlVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzlVar.zzg);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            throw new RemoteException();
        }
    }

    private static final boolean zzX(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        if (zzlVar.zzf) {
            return true;
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        return com.google.android.gms.ads.internal.util.client.zzf.zzs();
    }

    @Nullable
    private static final String zzY(String str, com.google.android.gms.ads.internal.client.zzl zzlVar) {
        String str2 = zzlVar.zzu;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzA(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbos zzbosVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting rewarded ad from adapter.");
        try {
            ((Adapter) this.zza).loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str, zzlVar, null), zzV(zzlVar), zzX(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzY(str, zzlVar), ""), new zzbpl(this, zzbosVar));
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
            zzboj.zza(iObjectWrapper, e10, "adapter.loadRewardedAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzB(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            zzA(this.zzd, zzlVar, str, new zzbpq((Adapter) obj, this.zzc));
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzC(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbos zzbosVar) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting rewarded interstitial ad from adapter.");
            try {
                ((Adapter) this.zza).loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str, zzlVar, null), zzV(zzlVar), zzX(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzY(str, zzlVar), ""), new zzbpl(this, zzbosVar));
                return;
            } catch (Exception e10) {
                zzboj.zza(iObjectWrapper, e10, "adapter.loadRewardedInterstitialAd");
                throw new RemoteException();
            }
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zza;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzE() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzF() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzG(boolean z10) throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z10);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                return;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze(OnImmersiveModeUpdatedListener.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze("Show app open ad from adapter.");
        MediationAppOpenAd mediationAppOpenAd = this.zzk;
        if (mediationAppOpenAd == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Can not show null mediation app open ad.");
            throw new RemoteException();
        }
        try {
            mediationAppOpenAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
        } catch (RuntimeException e10) {
            zzboj.zza(iObjectWrapper, e10, "adapter.appOpen.showAd");
            throw e10;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzI() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationInterstitialAdapter) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zza).showInterstitial();
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                throw new RemoteException();
            }
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzj(MediationInterstitialAdapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter) && !(obj instanceof MediationInterstitialAdapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj(MediationInterstitialAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        if (obj instanceof MediationInterstitialAdapter) {
            zzI();
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze("Show interstitial ad from adapter.");
        MediationInterstitialAd mediationInterstitialAd = this.zzf;
        if (mediationInterstitialAd == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Can not show null mediation interstitial ad.");
            throw new RemoteException();
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
        } catch (RuntimeException e10) {
            zzboj.zza(iObjectWrapper, e10, "adapter.interstitial.showAd");
            throw e10;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze("Show rewarded ad from adapter.");
        MediationRewardedAd mediationRewardedAd = this.zzi;
        if (mediationRewardedAd == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Can not show null mediation rewarded ad.");
            throw new RemoteException();
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
        } catch (RuntimeException e10) {
            zzboj.zza(iObjectWrapper, e10, "adapter.rewarded.showAd");
            throw e10;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzL() throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        MediationRewardedAd mediationRewardedAd = this.zzi;
        if (mediationRewardedAd == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Can not show null mediated rewarded ad.");
            throw new RemoteException();
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzd));
        } catch (RuntimeException e10) {
            zzboj.zza(this.zzd, e10, "adapter.showVideo");
            throw e10;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final boolean zzM() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final boolean zzN() throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof Adapter) || Objects.equals(obj.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            return this.zzc != null;
        }
        Object obj2 = this.zza;
        com.google.android.gms.ads.internal.util.client.zzm.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj2.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    @Nullable
    public final zzbox zzO() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    @Nullable
    public final zzboy zzP() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final Bundle zze() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final Bundle zzf() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final Bundle zzg() {
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzdq zzh() {
        Object obj = this.zza;
        if (obj instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) obj).getVideoController();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    @Nullable
    public final zzbfx zzi() {
        zzbpp zzbppVar = this.zzb;
        if (zzbppVar == null) {
            return null;
        }
        zzbfy zzbfyVarZzc = zzbppVar.zzc();
        if (zzbfyVarZzc instanceof zzbfy) {
            return zzbfyVarZzc.zza();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    @Nullable
    public final zzbov zzj() {
        MediationInterscrollerAd mediationInterscrollerAd = this.zzj;
        if (mediationInterscrollerAd != null) {
            return new zzbpo(mediationInterscrollerAd);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    @Nullable
    public final zzbpb zzk() {
        UnifiedNativeAdMapper unifiedNativeAdMapperZza;
        Object obj = this.zza;
        if (obj instanceof MediationNativeAdapter) {
            zzbpp zzbppVar = this.zzb;
            if (zzbppVar == null || (unifiedNativeAdMapperZza = zzbppVar.zza()) == null) {
                return null;
            }
            return new zzbpt(unifiedNativeAdMapperZza);
        }
        if (!(obj instanceof Adapter)) {
            return null;
        }
        NativeAdMapper nativeAdMapper = this.zzh;
        if (nativeAdMapper != null) {
            return new zzbpr(nativeAdMapper);
        }
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzg;
        if (unifiedNativeAdMapper != null) {
            return new zzbpt(unifiedNativeAdMapper);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    @Nullable
    public final zzbra zzl() {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            return zzbra.zza(((Adapter) obj).getVersionInfo());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    @Nullable
    public final zzbra zzm() {
        Object obj = this.zza;
        if (obj instanceof Adapter) {
            return zzbra.zza(((Adapter) obj).getSDKVersionInfo());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final IObjectWrapper zzn() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                throw new RemoteException();
            }
        }
        if (obj instanceof Adapter) {
            return ObjectWrapper.wrap(this.zze);
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzj(MediationBannerAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzo() throws RemoteException {
        Object obj = this.zza;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzp(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbvy zzbvyVar, String str2) throws RemoteException {
        Object obj = this.zza;
        if ((obj instanceof Adapter) || Objects.equals(obj.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            this.zzd = iObjectWrapper;
            this.zzc = zzbvyVar;
            zzbvyVar.zzl(ObjectWrapper.wrap(this.zza));
            return;
        }
        Object obj2 = this.zza;
        com.google.android.gms.ads.internal.util.client.zzm.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj2.getClass().getCanonicalName());
        throw new RemoteException();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    @Override // com.google.android.gms.internal.ads.zzbop
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzq(com.google.android.gms.dynamic.IObjectWrapper r6, com.google.android.gms.internal.ads.zzbkz r7, java.util.List r8) throws android.os.RemoteException {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbpn.zzq(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzbkz, java.util.List):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzr(IObjectWrapper iObjectWrapper, zzbvy zzbvyVar, List list) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not initialize rewarded video adapter.");
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzs(com.google.android.gms.ads.internal.client.zzl zzlVar, String str) throws RemoteException {
        zzB(zzlVar, str, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzt(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbos zzbosVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting app open ad from adapter.");
        try {
            ((Adapter) this.zza).loadAppOpenAd(new MediationAppOpenAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str, zzlVar, null), zzV(zzlVar), zzX(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzY(str, zzlVar), ""), new zzbpm(this, zzbosVar));
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
            zzboj.zza(iObjectWrapper, e10, "adapter.loadAppOpenAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzu(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbos zzbosVar) throws RemoteException {
        zzv(iObjectWrapper, zzqVar, zzlVar, str, null, zzbosVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzv(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbos zzbosVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof MediationBannerAdapter) && !(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj(MediationBannerAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting banner ad from adapter.");
        AdSize adSizeZzd = zzqVar.zzn ? com.google.android.gms.ads.zzb.zzd(zzqVar.zze, zzqVar.zzb) : com.google.android.gms.ads.zzb.zzc(zzqVar.zze, zzqVar.zzb, zzqVar.zza);
        Object obj2 = this.zza;
        if (!(obj2 instanceof MediationBannerAdapter)) {
            if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str, zzlVar, str2), zzV(zzlVar), zzX(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzY(str, zzlVar), adSizeZzd, this.zzl), new zzbph(this, zzbosVar));
                    return;
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                    zzboj.zza(iObjectWrapper, th, "adapter.loadBannerAd");
                    throw new RemoteException();
                }
            }
            return;
        }
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) obj2;
            List list = zzlVar.zze;
            HashSet hashSet = list != null ? new HashSet(list) : null;
            long j10 = zzlVar.zzb;
            zzbpe zzbpeVar = new zzbpe(j10 == -1 ? null : new Date(j10), zzlVar.zzd, hashSet, zzlVar.zzk, zzX(zzlVar), zzlVar.zzg, zzlVar.zzr, zzlVar.zzt, zzY(str, zzlVar));
            Bundle bundle = zzlVar.zzm;
            mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzbpp(zzbosVar), zzW(str, zzlVar, str2), adSizeZzd, zzbpeVar, bundle != null ? bundle.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th2) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", th2);
            zzboj.zza(iObjectWrapper, th2, "adapter.requestBannerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzw(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbos zzbosVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj(Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting interscroller ad from adapter.");
        try {
            Adapter adapter = (Adapter) this.zza;
            adapter.loadInterscrollerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str, zzlVar, str2), zzV(zzlVar), zzX(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzY(str, zzlVar), com.google.android.gms.ads.zzb.zze(zzqVar.zze, zzqVar.zzb), ""), new zzbpf(this, zzbosVar, adapter));
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
            zzboj.zza(iObjectWrapper, e10, "adapter.loadInterscrollerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzx(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbos zzbosVar) throws RemoteException {
        zzy(iObjectWrapper, zzlVar, str, null, zzbosVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzy(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbos zzbosVar) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof MediationInterstitialAdapter) && !(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj(MediationInterstitialAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting interstitial ad from adapter.");
        Object obj2 = this.zza;
        if (!(obj2 instanceof MediationInterstitialAdapter)) {
            if (obj2 instanceof Adapter) {
                try {
                    ((Adapter) obj2).loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str, zzlVar, str2), zzV(zzlVar), zzX(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzY(str, zzlVar), this.zzl), new zzbpi(this, zzbosVar));
                    return;
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                    zzboj.zza(iObjectWrapper, th, "adapter.loadInterstitialAd");
                    throw new RemoteException();
                }
            }
            return;
        }
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) obj2;
            List list = zzlVar.zze;
            HashSet hashSet = list != null ? new HashSet(list) : null;
            long j10 = zzlVar.zzb;
            zzbpe zzbpeVar = new zzbpe(j10 == -1 ? null : new Date(j10), zzlVar.zzd, hashSet, zzlVar.zzk, zzX(zzlVar), zzlVar.zzg, zzlVar.zzr, zzlVar.zzt, zzY(str, zzlVar));
            Bundle bundle = zzlVar.zzm;
            mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzbpp(zzbosVar), zzW(str, zzlVar, str2), zzbpeVar, bundle != null ? bundle.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th2) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", th2);
            zzboj.zza(iObjectWrapper, th2, "adapter.requestInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzz(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbos zzbosVar, zzbes zzbesVar, List list) throws RemoteException {
        Object obj = this.zza;
        if (!(obj instanceof MediationNativeAdapter) && !(obj instanceof Adapter)) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj(MediationNativeAdapter.class.getCanonicalName() + " or " + Adapter.class.getCanonicalName() + " #009 Class mismatch: " + obj.getClass().getCanonicalName());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze("Requesting native ad from adapter.");
        Object obj2 = this.zza;
        if (obj2 instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj2;
                List list2 = zzlVar.zze;
                HashSet hashSet = list2 != null ? new HashSet(list2) : null;
                long j10 = zzlVar.zzb;
                zzbps zzbpsVar = new zzbps(j10 == -1 ? null : new Date(j10), zzlVar.zzd, hashSet, zzlVar.zzk, zzX(zzlVar), zzlVar.zzg, zzbesVar, list, zzlVar.zzr, zzlVar.zzt, zzY(str, zzlVar));
                Bundle bundle = zzlVar.zzm;
                Bundle bundle2 = bundle != null ? bundle.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.zzb = new zzbpp(zzbosVar);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzb, zzW(str, zzlVar, str2), zzbpsVar, bundle2);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
                zzboj.zza(iObjectWrapper, th, "adapter.requestNativeAd");
                throw new RemoteException();
            }
        }
        if (obj2 instanceof Adapter) {
            try {
                ((Adapter) obj2).loadNativeAdMapper(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str, zzlVar, str2), zzV(zzlVar), zzX(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzY(str, zzlVar), this.zzl, zzbesVar), new zzbpk(this, zzbosVar));
            } catch (Throwable th2) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th2);
                zzboj.zza(iObjectWrapper, th2, "adapter.loadNativeAdMapper");
                String message = th2.getMessage();
                if (TextUtils.isEmpty(message) || !message.equals("Method is not found")) {
                    throw new RemoteException();
                }
                try {
                    ((Adapter) this.zza).loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zzW(str, zzlVar, str2), zzV(zzlVar), zzX(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzY(str, zzlVar), this.zzl, zzbesVar), new zzbpj(this, zzbosVar));
                } catch (Throwable th3) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("", th3);
                    zzboj.zza(iObjectWrapper, th3, "adapter.loadNativeAd");
                    throw new RemoteException();
                }
            }
        }
    }

    public zzbpn(@NonNull MediationAdapter mediationAdapter) {
        this.zza = mediationAdapter;
    }
}
