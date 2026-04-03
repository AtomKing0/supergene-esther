package androidx.media3.datasource;

import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public interface TransferListener {
    void onBytesTransferred(DataSource dataSource, DataSpec dataSpec, boolean z10, int i10);

    void onTransferEnd(DataSource dataSource, DataSpec dataSpec, boolean z10);

    void onTransferInitializing(DataSource dataSource, DataSpec dataSpec, boolean z10);

    void onTransferStart(DataSource dataSource, DataSpec dataSpec, boolean z10);
}
