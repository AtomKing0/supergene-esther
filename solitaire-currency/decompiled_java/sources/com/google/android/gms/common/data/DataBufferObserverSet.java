package com.google.android.gms.common.data;

import androidx.annotation.NonNull;
import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {
    private final HashSet zaa = new HashSet();

    @Override // com.google.android.gms.common.data.DataBufferObserver.Observable
    public void addObserver(@NonNull DataBufferObserver dataBufferObserver) {
        this.zaa.add(dataBufferObserver);
    }

    public void clear() {
        this.zaa.clear();
    }

    public boolean hasObservers() {
        return !this.zaa.isEmpty();
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataChanged() {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataChanged();
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataRangeChanged(int i10, int i11) {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeChanged(i10, i11);
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataRangeInserted(int i10, int i11) {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeInserted(i10, i11);
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataRangeMoved(int i10, int i11, int i12) {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeMoved(i10, i11, i12);
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver
    public void onDataRangeRemoved(int i10, int i11) {
        Iterator it = this.zaa.iterator();
        while (it.hasNext()) {
            ((DataBufferObserver) it.next()).onDataRangeRemoved(i10, i11);
        }
    }

    @Override // com.google.android.gms.common.data.DataBufferObserver.Observable
    public void removeObserver(@NonNull DataBufferObserver dataBufferObserver) {
        this.zaa.remove(dataBufferObserver);
    }
}
