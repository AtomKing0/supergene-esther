package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaln {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzall
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((zzaln) obj).zzb.zzb, ((zzaln) obj2).zzb.zzb);
        }
    };
    private final zzalo zzb;
    private final int zzc;

    /* synthetic */ zzaln(zzalo zzaloVar, int i10, zzalm zzalmVar) {
        this.zzb = zzaloVar;
        this.zzc = i10;
    }
}
