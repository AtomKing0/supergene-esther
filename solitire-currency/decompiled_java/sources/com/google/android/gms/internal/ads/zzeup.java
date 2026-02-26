package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeup implements zzevo {
    final String zza;
    private final zzgcu zzb;
    private final ScheduledExecutorService zzc;
    private final zzelg zzd;
    private final Context zze;
    private final zzffg zzf;
    private final zzelc zzg;
    private final zzdqb zzh;
    private final zzdup zzi;

    zzeup(zzgcu zzgcuVar, ScheduledExecutorService scheduledExecutorService, String str, zzelg zzelgVar, Context context, zzffg zzffgVar, zzelc zzelcVar, zzdqb zzdqbVar, zzdup zzdupVar) {
        this.zzb = zzgcuVar;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzelgVar;
        this.zze = context;
        this.zzf = zzffgVar;
        this.zzg = zzelcVar;
        this.zzh = zzdqbVar;
        this.zzi = zzdupVar;
    }

    public static /* synthetic */ m zzc(zzeup zzeupVar) {
        String lowerCase = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjW)).booleanValue() ? zzeupVar.zzf.zzf.toLowerCase(Locale.ROOT) : zzeupVar.zzf.zzf;
        final Bundle bundleZzg = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbt)).booleanValue() ? zzeupVar.zzi.zzg() : new Bundle();
        final ArrayList arrayList = new ArrayList();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbC)).booleanValue()) {
            zzeupVar.zzi(arrayList, zzeupVar.zzd.zza(zzeupVar.zza, lowerCase));
        } else {
            for (Map.Entry entry : ((zzfxu) zzeupVar.zzd.zzb(zzeupVar.zza, lowerCase)).entrySet()) {
                String str = (String) entry.getKey();
                arrayList.add(zzeupVar.zzg(str, (List) entry.getValue(), zzeupVar.zzf(str), true, true));
            }
            zzeupVar.zzi(arrayList, zzeupVar.zzd.zzc());
        }
        return zzgcj.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzeuk
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                JSONArray jSONArray = new JSONArray();
                for (m mVar : arrayList) {
                    if (((JSONObject) mVar.get()) != null) {
                        jSONArray.put(mVar.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzeuq(jSONArray.toString(), bundleZzg);
            }
        }, zzeupVar.zzb);
    }

    @Nullable
    private final Bundle zzf(String str) {
        Bundle bundle = this.zzf.zzd.zzm;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzgca zzg(final String str, final List list, final Bundle bundle, final boolean z10, final boolean z11) {
        zzgca zzgcaVarZzu = zzgca.zzu(zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.internal.ads.zzeum
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final m zza() {
                return this.zza.zzd(str, list, bundle, z10, z11);
            }
        }, this.zzb));
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbp)).booleanValue()) {
            zzgcaVarZzu = (zzgca) zzgcj.zzo(zzgcaVarZzu, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbi)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return (zzgca) zzgcj.zze(zzgcaVarZzu, Throwable.class, new zzful() { // from class: com.google.android.gms.internal.ads.zzeun
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                String str2 = str;
                com.google.android.gms.ads.internal.util.client.zzm.zzg("Error calling adapter: ".concat(String.valueOf(str2)));
                String strConcat = "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2));
                com.google.android.gms.ads.internal.zzu.zzo().zzw((Throwable) obj, strConcat);
                return null;
            }
        }, this.zzb);
    }

    private final void zzh(zzbql zzbqlVar, Bundle bundle, @NonNull List list, zzelj zzeljVar) throws RemoteException {
        zzbqlVar.zzh(ObjectWrapper.wrap(this.zze), this.zza, bundle, (Bundle) list.get(0), this.zzf.zze, zzeljVar);
    }

    private final void zzi(List list, Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            zzelk zzelkVar = (zzelk) ((Map.Entry) it.next()).getValue();
            String str = zzelkVar.zza;
            list.add(zzg(str, Collections.singletonList(zzelkVar.zze), zzf(str), zzelkVar.zzb, zzelkVar.zzc));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        zzffg zzffgVar = this.zzf;
        if (zzffgVar.zzr) {
            if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbv)).split(",")).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzq.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzq.zzc(zzffgVar.zzd)))) {
                return zzgcj.zzh(new zzeuq(new JSONArray().toString(), new Bundle()));
            }
        }
        return zzgcj.zzk(new zzgbp() { // from class: com.google.android.gms.internal.ads.zzeuj
            @Override // com.google.android.gms.internal.ads.zzgbp
            public final m zza() {
                return zzeup.zzc(this.zza);
            }
        }, this.zzb);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0026 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ com.google.common.util.concurrent.m zzd(java.lang.String r9, final java.util.List r10, final android.os.Bundle r11, boolean r12, boolean r13) throws java.lang.Exception {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzbzt r7 = new com.google.android.gms.internal.ads.zzbzt
            r7.<init>()
            r0 = 0
            if (r13 == 0) goto L26
            com.google.android.gms.internal.ads.zzbbn r13 = com.google.android.gms.internal.ads.zzbbw.zzbu
            com.google.android.gms.internal.ads.zzbbu r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r13 = r1.zza(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L26
            com.google.android.gms.internal.ads.zzelc r13 = r8.zzg
            r13.zzb(r9)
            com.google.android.gms.internal.ads.zzelc r13 = r8.zzg
            com.google.android.gms.internal.ads.zzbql r13 = r13.zza(r9)
            goto L34
        L26:
            com.google.android.gms.internal.ads.zzdqb r13 = r8.zzh     // Catch: android.os.RemoteException -> L2d
            com.google.android.gms.internal.ads.zzbql r13 = r13.zzb(r9)     // Catch: android.os.RemoteException -> L2d
            goto L34
        L2d:
            r13 = move-exception
            java.lang.String r1 = "Couldn't create RTB adapter : "
            com.google.android.gms.ads.internal.util.zze.zzb(r1, r13)
            r13 = r0
        L34:
            if (r13 != 0) goto L4e
            com.google.android.gms.internal.ads.zzbbn r10 = com.google.android.gms.internal.ads.zzbbw.zzbk
            com.google.android.gms.internal.ads.zzbbu r11 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r10 = r11.zza(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L4d
            com.google.android.gms.internal.ads.zzelj.zzb(r9, r7)
            goto Lba
        L4d:
            throw r0
        L4e:
            com.google.android.gms.internal.ads.zzelj r6 = new com.google.android.gms.internal.ads.zzelj
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()
            long r4 = r0.elapsedRealtime()
            r0 = r6
            r1 = r9
            r2 = r13
            r3 = r7
            r0.<init>(r1, r2, r3, r4)
            com.google.android.gms.internal.ads.zzbbn r9 = com.google.android.gms.internal.ads.zzbbw.zzbp
            com.google.android.gms.internal.ads.zzbbu r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r9 = r0.zza(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L8d
            java.util.concurrent.ScheduledExecutorService r9 = r8.zzc
            com.google.android.gms.internal.ads.zzeuo r0 = new com.google.android.gms.internal.ads.zzeuo
            r0.<init>()
            com.google.android.gms.internal.ads.zzbbn r1 = com.google.android.gms.internal.ads.zzbbw.zzbi
            com.google.android.gms.internal.ads.zzbbu r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            r9.schedule(r0, r1, r3)
        L8d:
            if (r12 == 0) goto Lb7
            com.google.android.gms.internal.ads.zzbbn r9 = com.google.android.gms.internal.ads.zzbbw.zzbw
            com.google.android.gms.internal.ads.zzbbu r12 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r9 = r12.zza(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lb3
            com.google.android.gms.internal.ads.zzgcu r9 = r8.zzb
            com.google.android.gms.internal.ads.zzeul r12 = new com.google.android.gms.internal.ads.zzeul
            r0 = r12
            r1 = r8
            r2 = r13
            r3 = r11
            r4 = r10
            r5 = r6
            r6 = r7
            r0.<init>()
            r9.zza(r12)
            goto Lba
        Lb3:
            r8.zzh(r13, r11, r10, r6)
            goto Lba
        Lb7:
            r6.zzd()
        Lba:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeup.zzd(java.lang.String, java.util.List, android.os.Bundle, boolean, boolean):com.google.common.util.concurrent.m");
    }

    final /* synthetic */ void zze(zzbql zzbqlVar, Bundle bundle, List list, zzelj zzeljVar, zzbzt zzbztVar) {
        try {
            zzh(zzbqlVar, bundle, list, zzeljVar);
        } catch (RemoteException e10) {
            zzbztVar.zzd(e10);
        }
    }
}
