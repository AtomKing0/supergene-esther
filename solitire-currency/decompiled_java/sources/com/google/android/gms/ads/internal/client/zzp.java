package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzp {
    public static final zzp zza = new zzp();

    @VisibleForTesting
    protected zzp() {
    }

    public final zzl zza(Context context, zzdx zzdxVar) {
        Context context2;
        List listUnmodifiableList;
        String strZzr;
        String strZzk = zzdxVar.zzk();
        Set setZzp = zzdxVar.zzp();
        if (setZzp.isEmpty()) {
            context2 = context;
            listUnmodifiableList = null;
        } else {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(setZzp));
            context2 = context;
        }
        boolean zZzs = zzdxVar.zzs(context2);
        Bundle bundleZzf = zzdxVar.zzf(AdMobAdapter.class);
        String strZzl = zzdxVar.zzl();
        SearchAdRequest searchAdRequestZzi = zzdxVar.zzi();
        zzfh zzfhVar = searchAdRequestZzi != null ? new zzfh(searchAdRequestZzi) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzay.zzb();
            strZzr = com.google.android.gms.ads.internal.util.client.zzf.zzr(Thread.currentThread().getStackTrace(), packageName);
        } else {
            strZzr = null;
        }
        boolean zZzr = zzdxVar.zzr();
        RequestConfiguration requestConfigurationZzc = zzej.zzf().zzc();
        return new zzl(8, -1L, bundleZzf, -1, listUnmodifiableList, zZzs, Math.max(zzdxVar.zzb(), requestConfigurationZzc.getTagForChildDirectedTreatment()), false, strZzl, zzfhVar, null, strZzk, zzdxVar.zzg(), zzdxVar.zze(), Collections.unmodifiableList(new ArrayList(zzdxVar.zzo())), zzdxVar.zzm(), strZzr, zZzr, null, requestConfigurationZzc.getTagForUnderAgeOfConsent(), (String) Collections.max(Arrays.asList(null, requestConfigurationZzc.getMaxAdContentRating()), new Comparator() { // from class: com.google.android.gms.ads.internal.client.zzo
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                List list = RequestConfiguration.zza;
                return list.indexOf((String) obj) - list.indexOf((String) obj2);
            }
        }), zzdxVar.zzn(), zzdxVar.zza(), zzdxVar.zzj(), requestConfigurationZzc.getPublisherPrivacyPersonalizationState().getValue(), zzdxVar.zzc());
    }
}
