package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjl;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzji<T extends zzjl<T>> {
    zzji() {
    }

    abstract int zza(Map.Entry<?, ?> entry);

    abstract zzjj<T> zza(Object obj);

    abstract Object zza(zzjg zzjgVar, zzlg zzlgVar, int i10);

    abstract <UT, UB> UB zza(Object obj, zzlv zzlvVar, Object obj2, zzjg zzjgVar, zzjj<T> zzjjVar, UB ub, zzmt<UT, UB> zzmtVar) throws IOException;

    abstract void zza(zzij zzijVar, Object obj, zzjg zzjgVar, zzjj<T> zzjjVar) throws IOException;

    abstract void zza(zzlv zzlvVar, Object obj, zzjg zzjgVar, zzjj<T> zzjjVar) throws IOException;

    abstract void zza(zznt zzntVar, Map.Entry<?, ?> entry) throws IOException;

    abstract boolean zza(zzlg zzlgVar);

    abstract zzjj<T> zzb(Object obj);

    abstract void zzc(Object obj);
}
