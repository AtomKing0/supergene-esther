package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzetl implements zzevo {
    private final zzgcu zza;
    private final zzffg zzb;

    @Nullable
    private final PackageInfo zzc;
    private final com.google.android.gms.ads.internal.util.zzg zzd;

    public zzetl(zzgcu zzgcuVar, zzffg zzffgVar, @Nullable PackageInfo packageInfo, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzgcuVar;
        this.zzb = zzffgVar;
        this.zzc = packageInfo;
        this.zzd = zzgVar;
    }

    public static /* synthetic */ zzetm zzc(final zzetl zzetlVar) {
        final ArrayList arrayList = zzetlVar.zzb.zzg;
        return arrayList == null ? new zzetm() { // from class: com.google.android.gms.internal.ads.zzeti
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
            }
        } : arrayList.isEmpty() ? new zzetm() { // from class: com.google.android.gms.internal.ads.zzetj
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                ((Bundle) obj).putInt("native_version", 0);
            }
        } : new zzetm() { // from class: com.google.android.gms.internal.ads.zzetk
            @Override // com.google.android.gms.internal.ads.zzevn
            public final void zzj(Object obj) {
                this.zza.zzd(arrayList, (Bundle) obj);
            }
        };
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 26;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeth
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzetl.zzc(this.zza);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final /* synthetic */ void zzd(java.util.ArrayList r9, android.os.Bundle r10) {
        /*
            Method dump skipped, instruction units count: 416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzetl.zzd(java.util.ArrayList, android.os.Bundle):void");
    }
}
