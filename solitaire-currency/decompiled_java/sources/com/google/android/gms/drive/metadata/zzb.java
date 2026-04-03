package com.google.android.gms.drive.metadata;

import com.google.android.gms.common.data.DataHolder;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzb<T> extends zza<Collection<T>> {
    protected zzb(String str, Collection<String> collection, Collection<String> collection2, int i10) {
        super(str, collection, collection2, i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zza
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public Collection<T> zzc(DataHolder dataHolder, int i10, int i11) {
        throw new UnsupportedOperationException("Cannot read collections from a dataHolder.");
    }
}
