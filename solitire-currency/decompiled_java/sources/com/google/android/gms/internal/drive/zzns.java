package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
interface zzns {
    void zza(int i10, double d10) throws IOException;

    void zza(int i10, float f10) throws IOException;

    void zza(int i10, long j10) throws IOException;

    void zza(int i10, zzjc zzjcVar) throws IOException;

    <K, V> void zza(int i10, zzlj<K, V> zzljVar, Map<K, V> map) throws IOException;

    void zza(int i10, Object obj) throws IOException;

    void zza(int i10, Object obj, zzmf zzmfVar) throws IOException;

    void zza(int i10, String str) throws IOException;

    void zza(int i10, List<String> list) throws IOException;

    void zza(int i10, List<?> list, zzmf zzmfVar) throws IOException;

    void zza(int i10, List<Integer> list, boolean z10) throws IOException;

    @Deprecated
    void zzak(int i10) throws IOException;

    @Deprecated
    void zzal(int i10) throws IOException;

    void zzb(int i10, long j10) throws IOException;

    @Deprecated
    void zzb(int i10, Object obj, zzmf zzmfVar) throws IOException;

    void zzb(int i10, List<zzjc> list) throws IOException;

    @Deprecated
    void zzb(int i10, List<?> list, zzmf zzmfVar) throws IOException;

    void zzb(int i10, List<Integer> list, boolean z10) throws IOException;

    void zzb(int i10, boolean z10) throws IOException;

    void zzc(int i10, int i11) throws IOException;

    void zzc(int i10, long j10) throws IOException;

    void zzc(int i10, List<Long> list, boolean z10) throws IOException;

    int zzcd();

    void zzd(int i10, int i11) throws IOException;

    void zzd(int i10, List<Long> list, boolean z10) throws IOException;

    void zze(int i10, int i11) throws IOException;

    void zze(int i10, List<Long> list, boolean z10) throws IOException;

    void zzf(int i10, int i11) throws IOException;

    void zzf(int i10, List<Float> list, boolean z10) throws IOException;

    void zzg(int i10, List<Double> list, boolean z10) throws IOException;

    void zzh(int i10, List<Integer> list, boolean z10) throws IOException;

    void zzi(int i10, long j10) throws IOException;

    void zzi(int i10, List<Boolean> list, boolean z10) throws IOException;

    void zzj(int i10, long j10) throws IOException;

    void zzj(int i10, List<Integer> list, boolean z10) throws IOException;

    void zzk(int i10, List<Integer> list, boolean z10) throws IOException;

    void zzl(int i10, List<Long> list, boolean z10) throws IOException;

    void zzm(int i10, int i11) throws IOException;

    void zzm(int i10, List<Integer> list, boolean z10) throws IOException;

    void zzn(int i10, int i11) throws IOException;

    void zzn(int i10, List<Long> list, boolean z10) throws IOException;
}
