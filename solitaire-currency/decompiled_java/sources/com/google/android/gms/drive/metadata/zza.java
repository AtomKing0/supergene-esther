package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zza<T> implements MetadataField<T> {
    private final String fieldName;
    private final Set<String> zziw;
    private final Set<String> zzix;
    private final int zziy;

    protected zza(String str, int i10) {
        this.fieldName = (String) Preconditions.checkNotNull(str, "fieldName");
        this.zziw = Collections.singleton(str);
        this.zzix = Collections.emptySet();
        this.zziy = i10;
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final String getName() {
        return this.fieldName;
    }

    public String toString() {
        return this.fieldName;
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final T zza(Bundle bundle) {
        Preconditions.checkNotNull(bundle, "bundle");
        if (bundle.get(this.fieldName) != null) {
            return zzb(bundle);
        }
        return null;
    }

    protected abstract void zza(Bundle bundle, T t10);

    public final Collection<String> zzaz() {
        return this.zziw;
    }

    protected abstract T zzb(Bundle bundle);

    protected boolean zzb(DataHolder dataHolder, int i10, int i11) {
        for (String str : this.zziw) {
            if (dataHolder.isClosed() || !dataHolder.hasColumn(str) || dataHolder.hasNull(str, i10, i11)) {
                return false;
            }
        }
        return true;
    }

    protected abstract T zzc(DataHolder dataHolder, int i10, int i11);

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final void zza(T t10, Bundle bundle) {
        Preconditions.checkNotNull(bundle, "bundle");
        if (t10 == null) {
            bundle.putString(this.fieldName, null);
        } else {
            zza(bundle, t10);
        }
    }

    protected zza(String str, Collection<String> collection, Collection<String> collection2, int i10) {
        this.fieldName = (String) Preconditions.checkNotNull(str, "fieldName");
        this.zziw = Collections.unmodifiableSet(new HashSet(collection));
        this.zzix = Collections.unmodifiableSet(new HashSet(collection2));
        this.zziy = i10;
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final void zza(DataHolder dataHolder, MetadataBundle metadataBundle, int i10, int i11) {
        Preconditions.checkNotNull(dataHolder, "dataHolder");
        Preconditions.checkNotNull(metadataBundle, "bundle");
        if (zzb(dataHolder, i10, i11)) {
            metadataBundle.zzb(this, zzc(dataHolder, i10, i11));
        }
    }

    @Override // com.google.android.gms.drive.metadata.MetadataField
    public final T zza(DataHolder dataHolder, int i10, int i11) {
        if (zzb(dataHolder, i10, i11)) {
            return zzc(dataHolder, i10, i11);
        }
        return null;
    }
}
