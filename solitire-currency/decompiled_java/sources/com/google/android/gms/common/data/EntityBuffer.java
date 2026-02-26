package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public abstract class EntityBuffer<T> extends AbstractDataBuffer<T> {
    private boolean zaa;
    private ArrayList zab;

    @KeepForSdk
    protected EntityBuffer(@NonNull DataHolder dataHolder) {
        super(dataHolder);
        this.zaa = false;
    }

    private final void zab() {
        synchronized (this) {
            if (!this.zaa) {
                int count = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                ArrayList arrayList = new ArrayList();
                this.zab = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String primaryDataMarkerColumn = getPrimaryDataMarkerColumn();
                    String string = this.mDataHolder.getString(primaryDataMarkerColumn, 0, this.mDataHolder.getWindowIndex(0));
                    for (int i10 = 1; i10 < count; i10++) {
                        int windowIndex = this.mDataHolder.getWindowIndex(i10);
                        String string2 = this.mDataHolder.getString(primaryDataMarkerColumn, i10, windowIndex);
                        if (string2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + primaryDataMarkerColumn + ", at row: " + i10 + ", for window: " + windowIndex);
                        }
                        if (!string2.equals(string)) {
                            this.zab.add(Integer.valueOf(i10));
                            string = string2;
                        }
                    }
                }
                this.zaa = true;
            }
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @NonNull
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public final T get(int i10) {
        int iIntValue;
        int iIntValue2;
        zab();
        int iZaa = zaa(i10);
        int i11 = 0;
        if (i10 >= 0 && i10 != this.zab.size()) {
            if (i10 == this.zab.size() - 1) {
                iIntValue = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getCount();
                iIntValue2 = ((Integer) this.zab.get(i10)).intValue();
            } else {
                iIntValue = ((Integer) this.zab.get(i10 + 1)).intValue();
                iIntValue2 = ((Integer) this.zab.get(i10)).intValue();
            }
            int i12 = iIntValue - iIntValue2;
            if (i12 == 1) {
                int iZaa2 = zaa(i10);
                int windowIndex = ((DataHolder) Preconditions.checkNotNull(this.mDataHolder)).getWindowIndex(iZaa2);
                String childDataMarkerColumn = getChildDataMarkerColumn();
                if (childDataMarkerColumn == null || this.mDataHolder.getString(childDataMarkerColumn, iZaa2, windowIndex) != null) {
                    i11 = 1;
                }
            } else {
                i11 = i12;
            }
        }
        return getEntry(iZaa, i11);
    }

    @Nullable
    @KeepForSdk
    protected String getChildDataMarkerColumn() {
        return null;
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    public int getCount() {
        zab();
        return this.zab.size();
    }

    @NonNull
    @KeepForSdk
    protected abstract T getEntry(int i10, int i11);

    @NonNull
    @KeepForSdk
    protected abstract String getPrimaryDataMarkerColumn();

    final int zaa(int i10) {
        if (i10 >= 0 && i10 < this.zab.size()) {
            return ((Integer) this.zab.get(i10)).intValue();
        }
        throw new IllegalArgumentException("Position " + i10 + " is out of bounds for this buffer");
    }
}
