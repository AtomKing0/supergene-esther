package androidx.media3.datasource;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public abstract class BaseDataSource implements DataSource {

    @Nullable
    private DataSpec dataSpec;
    private final boolean isNetwork;
    private int listenerCount;
    private final ArrayList<TransferListener> listeners = new ArrayList<>(1);

    protected BaseDataSource(boolean z10) {
        this.isNetwork = z10;
    }

    @Override // androidx.media3.datasource.DataSource
    @UnstableApi
    public final void addTransferListener(TransferListener transferListener) {
        Assertions.checkNotNull(transferListener);
        if (this.listeners.contains(transferListener)) {
            return;
        }
        this.listeners.add(transferListener);
        this.listenerCount++;
    }

    protected final void bytesTransferred(int i10) {
        DataSpec dataSpec = (DataSpec) Util.castNonNull(this.dataSpec);
        for (int i11 = 0; i11 < this.listenerCount; i11++) {
            this.listeners.get(i11).onBytesTransferred(this, dataSpec, this.isNetwork, i10);
        }
    }

    @Override // androidx.media3.datasource.DataSource
    public /* synthetic */ Map getResponseHeaders() {
        return a.a(this);
    }

    protected final void transferEnded() {
        DataSpec dataSpec = (DataSpec) Util.castNonNull(this.dataSpec);
        for (int i10 = 0; i10 < this.listenerCount; i10++) {
            this.listeners.get(i10).onTransferEnd(this, dataSpec, this.isNetwork);
        }
        this.dataSpec = null;
    }

    protected final void transferInitializing(DataSpec dataSpec) {
        for (int i10 = 0; i10 < this.listenerCount; i10++) {
            this.listeners.get(i10).onTransferInitializing(this, dataSpec, this.isNetwork);
        }
    }

    protected final void transferStarted(DataSpec dataSpec) {
        this.dataSpec = dataSpec;
        for (int i10 = 0; i10 < this.listenerCount; i10++) {
            this.listeners.get(i10).onTransferStart(this, dataSpec, this.isNetwork);
        }
    }
}
