package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdwf extends com.google.android.gms.ads.internal.client.zzdi {

    @VisibleForTesting
    final Map zza = new HashMap();
    private final Context zzb;
    private final WeakReference zzc;
    private final zzdvt zzd;
    private final zzgcu zze;
    private zzdvi zzf;

    zzdwf(Context context, WeakReference weakReference, zzdvt zzdvtVar, zzdwg zzdwgVar, zzgcu zzgcuVar) {
        this.zzb = context;
        this.zzc = weakReference;
        this.zzd = zzdvtVar;
        this.zze = zzgcuVar;
    }

    private final Context zzj() {
        Context context = (Context) this.zzc.get();
        return context == null ? this.zzb : context;
    }

    private static AdRequest zzk() {
        Bundle bundle = new Bundle();
        bundle.putString("request_origin", "inspector_ooct");
        return new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzl(Object obj) {
        ResponseInfo responseInfo;
        com.google.android.gms.ads.internal.client.zzdn zzdnVarZzc;
        if (obj instanceof LoadAdError) {
            responseInfo = ((LoadAdError) obj).getResponseInfo();
        } else if (obj instanceof AppOpenAd) {
            responseInfo = ((AppOpenAd) obj).getResponseInfo();
        } else if (obj instanceof InterstitialAd) {
            responseInfo = ((InterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedAd) {
            responseInfo = ((RewardedAd) obj).getResponseInfo();
        } else if (obj instanceof RewardedInterstitialAd) {
            responseInfo = ((RewardedInterstitialAd) obj).getResponseInfo();
        } else if (obj instanceof AdView) {
            responseInfo = ((AdView) obj).getResponseInfo();
        } else {
            if (!(obj instanceof NativeAd)) {
                return "";
            }
            responseInfo = ((NativeAd) obj).getResponseInfo();
        }
        if (responseInfo == null || (zzdnVarZzc = responseInfo.zzc()) == null) {
            return "";
        }
        try {
            return zzdnVarZzc.zzh();
        } catch (RemoteException unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzm(String str, String str2) {
        try {
            zzgcj.zzr(this.zzf.zzb(str), new zzdwd(this, str2), this.zze);
        } catch (NullPointerException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "OutOfContextTester.setAdAsOutOfContext");
            this.zzd.zzk(str2);
        }
    }

    private final synchronized void zzn(String str, String str2) {
        try {
            zzgcj.zzr(this.zzf.zzb(str), new zzdwe(this, str2), this.zze);
        } catch (NullPointerException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "OutOfContextTester.setAdAsShown");
            this.zzd.zzk(str2);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdj
    public final void zze(String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        ViewGroup viewGroup = (ViewGroup) ObjectWrapper.unwrap(iObjectWrapper2);
        if (context == null || viewGroup == null) {
            return;
        }
        Object obj = this.zza.get(str);
        if (obj != null) {
            this.zza.remove(str);
        }
        if (obj instanceof AdView) {
            zzdwg.zza(context, viewGroup, (AdView) obj);
        } else if (obj instanceof NativeAd) {
            zzdwg.zzb(context, viewGroup, (NativeAd) obj);
        }
    }

    public final void zzf(zzdvi zzdviVar) {
        this.zzf = zzdviVar;
    }

    protected final synchronized void zzg(String str, Object obj, String str2) {
        this.zza.put(str, obj);
        zzm(zzl(obj), str2);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzh(final java.lang.String r7, java.lang.String r8, final java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdwf.zzh(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final synchronized void zzi(String str, String str2) {
        Object obj;
        Activity activityZzg = this.zzd.zzg();
        if (activityZzg != null && (obj = this.zza.get(str)) != null) {
            zzbbn zzbbnVar = zzbbw.zziz;
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue() || (obj instanceof AppOpenAd) || (obj instanceof InterstitialAd) || (obj instanceof RewardedAd) || (obj instanceof RewardedInterstitialAd)) {
                this.zza.remove(str);
            }
            zzn(zzl(obj), str2);
            if (obj instanceof AppOpenAd) {
                ((AppOpenAd) obj).show(activityZzg);
                return;
            }
            if (obj instanceof InterstitialAd) {
                ((InterstitialAd) obj).show(activityZzg);
                return;
            }
            if (obj instanceof RewardedAd) {
                ((RewardedAd) obj).show(activityZzg, new OnUserEarnedRewardListener() { // from class: com.google.android.gms.internal.ads.zzdvv
                    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                    public final void onUserEarnedReward(RewardItem rewardItem) {
                    }
                });
                return;
            }
            if (obj instanceof RewardedInterstitialAd) {
                ((RewardedInterstitialAd) obj).show(activityZzg, new OnUserEarnedRewardListener() { // from class: com.google.android.gms.internal.ads.zzdvw
                    @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
                    public final void onUserEarnedReward(RewardItem rewardItem) {
                    }
                });
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue() && ((obj instanceof AdView) || (obj instanceof NativeAd))) {
                Intent intent = new Intent();
                Context contextZzj = zzj();
                intent.setClassName(contextZzj, OutOfContextTestingActivity.CLASS_NAME);
                intent.putExtra("adUnit", str);
                com.google.android.gms.ads.internal.zzu.zzp();
                com.google.android.gms.ads.internal.util.zzt.zzT(contextZzj, intent);
            }
        }
    }
}
