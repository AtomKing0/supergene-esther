package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbqy extends zzbqk {
    private final RtbAdapter zza;
    private MediationInterstitialAd zzb;
    private MediationRewardedAd zzc;
    private MediationAppOpenAd zzd;
    private String zze = "";

    public zzbqy(RtbAdapter rtbAdapter) {
        this.zza = rtbAdapter;
    }

    private final Bundle zzv(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        Bundle bundle;
        Bundle bundle2 = zzlVar.zzm;
        return (bundle2 == null || (bundle = bundle2.getBundle(this.zza.getClass().getName())) == null) ? new Bundle() : bundle;
    }

    private static final Bundle zzw(String str) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzm.zzj("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", e10);
            throw new RemoteException();
        }
    }

    private static final boolean zzx(com.google.android.gms.ads.internal.client.zzl zzlVar) {
        if (zzlVar.zzf) {
            return true;
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        return com.google.android.gms.ads.internal.util.client.zzf.zzs();
    }

    @Nullable
    private static final String zzy(String str, com.google.android.gms.ads.internal.client.zzl zzlVar) {
        String str2 = zzlVar.zzu;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzdq zze() {
        MediationExtrasReceiver mediationExtrasReceiver = this.zza;
        if (mediationExtrasReceiver instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) mediationExtrasReceiver).getVideoController();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final zzbra zzf() throws RemoteException {
        return zzbra.zza(this.zza.getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final zzbra zzg() throws RemoteException {
        return zzbra.zza(this.zza.getSDKVersionInfo());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    @Override // com.google.android.gms.internal.ads.zzbql
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(com.google.android.gms.dynamic.IObjectWrapper r5, java.lang.String r6, android.os.Bundle r7, android.os.Bundle r8, com.google.android.gms.ads.internal.client.zzq r9, com.google.android.gms.internal.ads.zzbqo r10) throws android.os.RemoteException {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbqy.zzh(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, android.os.Bundle, android.os.Bundle, com.google.android.gms.ads.internal.client.zzq, com.google.android.gms.internal.ads.zzbqo):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpw zzbpwVar, zzbos zzbosVar) throws RemoteException {
        try {
            this.zza.loadRtbAppOpenAd(new MediationAppOpenAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzlVar), zzx(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzy(str2, zzlVar), this.zze), new zzbqv(this, zzbpwVar, zzbosVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render app open ad.", th);
            zzboj.zza(iObjectWrapper, th, "adapter.loadRtbAppOpenAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpz zzbpzVar, zzbos zzbosVar, com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        try {
            this.zza.loadRtbBannerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzlVar), zzx(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzy(str2, zzlVar), com.google.android.gms.ads.zzb.zzc(zzqVar.zze, zzqVar.zzb, zzqVar.zza), this.zze), new zzbqq(this, zzbpzVar, zzbosVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render banner ad.", th);
            zzboj.zza(iObjectWrapper, th, "adapter.loadRtbBannerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzk(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpz zzbpzVar, zzbos zzbosVar, com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        try {
            this.zza.loadRtbInterscrollerAd(new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzlVar), zzx(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzy(str2, zzlVar), com.google.android.gms.ads.zzb.zzc(zzqVar.zze, zzqVar.zzb, zzqVar.zza), this.zze), new zzbqr(this, zzbpzVar, zzbosVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render interscroller ad.", th);
            zzboj.zza(iObjectWrapper, th, "adapter.loadRtbInterscrollerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqc zzbqcVar, zzbos zzbosVar) throws RemoteException {
        try {
            this.zza.loadRtbInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzlVar), zzx(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzy(str2, zzlVar), this.zze), new zzbqs(this, zzbqcVar, zzbosVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render interstitial ad.", th);
            zzboj.zza(iObjectWrapper, th, "adapter.loadRtbInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzm(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqf zzbqfVar, zzbos zzbosVar) throws RemoteException {
        zzn(str, str2, zzlVar, iObjectWrapper, zzbqfVar, zzbosVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqf zzbqfVar, zzbos zzbosVar, zzbes zzbesVar) throws RemoteException {
        try {
            this.zza.loadRtbNativeAdMapper(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzlVar), zzx(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzy(str2, zzlVar), this.zze, zzbesVar), new zzbqt(this, zzbqfVar, zzbosVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render native ad.", th);
            zzboj.zza(iObjectWrapper, th, "adapter.loadRtbNativeAdMapper");
            String message = th.getMessage();
            if (TextUtils.isEmpty(message) || !message.equals("Method is not found")) {
                throw new RemoteException();
            }
            try {
                this.zza.loadRtbNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzlVar), zzx(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzy(str2, zzlVar), this.zze, zzbesVar), new zzbqu(this, zzbqfVar, zzbosVar));
            } catch (Throwable th2) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render native ad.", th2);
                zzboj.zza(iObjectWrapper, th2, "adapter.loadRtbNativeAd");
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzo(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqi zzbqiVar, zzbos zzbosVar) throws RemoteException {
        try {
            this.zza.loadRtbRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzlVar), zzx(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzy(str2, zzlVar), this.zze), new zzbqx(this, zzbqiVar, zzbosVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render rewarded interstitial ad.", th);
            zzboj.zza(iObjectWrapper, th, "adapter.loadRtbRewardedInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqi zzbqiVar, zzbos zzbosVar) throws RemoteException {
        try {
            this.zza.loadRtbRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzw(str2), zzv(zzlVar), zzx(zzlVar), zzlVar.zzk, zzlVar.zzg, zzlVar.zzt, zzy(str2, zzlVar), this.zze), new zzbqx(this, zzbqiVar, zzbosVar));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Adapter failed to render rewarded ad.", th);
            zzboj.zza(iObjectWrapper, th, "adapter.loadRtbRewardedAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzq(String str) {
        this.zze = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationAppOpenAd mediationAppOpenAd = this.zzd;
        if (mediationAppOpenAd == null) {
            return false;
        }
        try {
            mediationAppOpenAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            zzboj.zza(iObjectWrapper, th, "adapter.showRtbAppOpenAd");
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzb;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            zzboj.zza(iObjectWrapper, th, "adapter.showRtbInterstitialAd");
            return true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzc;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("", th);
            zzboj.zza(iObjectWrapper, th, "adapter.showRtbRewardedAd");
            return true;
        }
    }
}
