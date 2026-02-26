package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.MetadataField;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface zzj<F> {
    <T> F zza(com.google.android.gms.drive.metadata.zzb<T> zzbVar, T t10);

    <T> F zza(zzx zzxVar, MetadataField<T> metadataField, T t10);

    F zza(zzx zzxVar, List<F> list);

    F zza(F f10);

    F zzbj();

    F zzbk();

    <T> F zzc(MetadataField<T> metadataField, T t10);

    F zze(MetadataField<?> metadataField);

    F zzi(String str);
}
