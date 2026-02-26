package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzayy implements Comparator {
    zzayy(zzaza zzazaVar) {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzaze zzazeVar = (zzaze) obj;
        zzaze zzazeVar2 = (zzaze) obj2;
        int i10 = zzazeVar.zzc - zzazeVar2.zzc;
        return i10 != 0 ? i10 : Long.compare(zzazeVar.zza, zzazeVar2.zza);
    }
}
