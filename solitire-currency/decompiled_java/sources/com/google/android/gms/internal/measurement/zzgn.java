package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzgn {
    @Nullable
    String zza(ContentResolver contentResolver, String str) throws zzgq;

    <T extends Map<String, String>> T zza(ContentResolver contentResolver, String[] strArr, zzgo<T> zzgoVar) throws zzgq;
}
