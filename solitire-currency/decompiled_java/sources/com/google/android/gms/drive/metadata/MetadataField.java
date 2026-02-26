package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* JADX INFO: loaded from: classes3.dex */
public interface MetadataField<T> {
    String getName();

    T zza(Bundle bundle);

    T zza(DataHolder dataHolder, int i10, int i11);

    void zza(DataHolder dataHolder, MetadataBundle metadataBundle, int i10, int i11);

    void zza(T t10, Bundle bundle);
}
