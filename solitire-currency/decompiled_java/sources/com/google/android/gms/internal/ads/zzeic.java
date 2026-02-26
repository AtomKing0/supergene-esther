package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventParameters;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.common.util.concurrent.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzeic implements zzeet {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final m zza(zzfex zzfexVar, zzfel zzfelVar) {
        String strOptString = zzfelVar.zzv.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzffg zzffgVar = zzfexVar.zza.zza;
        zzffe zzffeVar = new zzffe();
        zzffeVar.zzq(zzffgVar);
        zzffeVar.zzt(strOptString);
        Bundle bundleZzd = zzd(zzffgVar.zzd.zzm);
        Bundle bundleZzd2 = zzd(bundleZzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        bundleZzd2.putInt("gw", 1);
        String strOptString2 = zzfelVar.zzv.optString("mad_hac", null);
        if (strOptString2 != null) {
            bundleZzd2.putString("mad_hac", strOptString2);
        }
        String strOptString3 = zzfelVar.zzv.optString("adJson", null);
        if (strOptString3 != null) {
            bundleZzd2.putString("_ad", strOptString3);
        }
        bundleZzd2.putBoolean("_noRefresh", true);
        Iterator<String> itKeys = zzfelVar.zzD.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString4 = zzfelVar.zzD.optString(next, null);
            if (next != null) {
                bundleZzd2.putString(next, strOptString4);
            }
        }
        bundleZzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundleZzd2);
        com.google.android.gms.ads.internal.client.zzl zzlVar = zzffgVar.zzd;
        Bundle bundle = zzlVar.zzn;
        List list = zzlVar.zzo;
        String str = zzlVar.zzp;
        String str2 = zzlVar.zzq;
        int i10 = zzlVar.zzd;
        boolean z10 = zzlVar.zzr;
        List list2 = zzlVar.zze;
        com.google.android.gms.ads.internal.client.zzc zzcVar = zzlVar.zzs;
        boolean z11 = zzlVar.zzf;
        int i11 = zzlVar.zzt;
        int i12 = zzlVar.zzg;
        String str3 = zzlVar.zzu;
        boolean z12 = zzlVar.zzh;
        List list3 = zzlVar.zzv;
        String str4 = zzlVar.zzi;
        int i13 = zzlVar.zzw;
        zzffeVar.zzH(new com.google.android.gms.ads.internal.client.zzl(zzlVar.zza, zzlVar.zzb, bundleZzd2, i10, list2, z11, i12, z12, str4, zzlVar.zzj, zzlVar.zzk, zzlVar.zzl, bundleZzd, bundle, list, str, str2, z10, zzcVar, i11, str3, list3, i13, zzlVar.zzx, zzlVar.zzy, zzlVar.zzz));
        zzffg zzffgVarZzJ = zzffeVar.zzJ();
        Bundle bundle2 = new Bundle();
        zzfeo zzfeoVar = zzfexVar.zzb.zzb;
        Bundle bundle3 = new Bundle();
        bundle3.putStringArrayList("nofill_urls", new ArrayList<>(zzfeoVar.zza));
        bundle3.putInt("refresh_interval", zzfeoVar.zzc);
        bundle3.putString("gws_query_id", zzfeoVar.zzb);
        bundle2.putBundle("parent_common_config", bundle3);
        zzffg zzffgVar2 = zzfexVar.zza.zza;
        Bundle bundle4 = new Bundle();
        bundle4.putString("initial_ad_unit_id", zzffgVar2.zzf);
        bundle4.putString("allocation_id", zzfelVar.zzw);
        bundle4.putString("ad_source_name", zzfelVar.zzF);
        bundle4.putStringArrayList("click_urls", new ArrayList<>(zzfelVar.zzc));
        bundle4.putStringArrayList("imp_urls", new ArrayList<>(zzfelVar.zzd));
        bundle4.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzfelVar.zzp));
        bundle4.putStringArrayList("fill_urls", new ArrayList<>(zzfelVar.zzm));
        bundle4.putStringArrayList("video_start_urls", new ArrayList<>(zzfelVar.zzg));
        bundle4.putStringArrayList("video_reward_urls", new ArrayList<>(zzfelVar.zzh));
        bundle4.putStringArrayList("video_complete_urls", new ArrayList<>(zzfelVar.zzi));
        bundle4.putString(AppLovinEventParameters.CHECKOUT_TRANSACTION_IDENTIFIER, zzfelVar.zzj);
        bundle4.putString("valid_from_timestamp", zzfelVar.zzk);
        bundle4.putBoolean("is_closable_area_disabled", zzfelVar.zzP);
        bundle4.putString("recursive_server_response_data", zzfelVar.zzao);
        if (zzfelVar.zzl != null) {
            Bundle bundle5 = new Bundle();
            bundle5.putInt("rb_amount", zzfelVar.zzl.zzb);
            bundle5.putString("rb_type", zzfelVar.zzl.zza);
            bundle4.putParcelableArray("rewards", new Bundle[]{bundle5});
        }
        bundle2.putBundle("parent_ad_config", bundle4);
        return zzc(zzffgVarZzJ, bundle2, zzfelVar, zzfexVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeet
    public final boolean zzb(zzfex zzfexVar, zzfel zzfelVar) {
        return !TextUtils.isEmpty(zzfelVar.zzv.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    protected abstract m zzc(zzffg zzffgVar, Bundle bundle, zzfel zzfelVar, zzfex zzfexVar);
}
