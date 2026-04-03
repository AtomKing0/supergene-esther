package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.drive.DriveFile;

/* JADX INFO: loaded from: classes3.dex */
final class zzbq implements ListenerHolder.Notifier<DriveFile.DownloadProgressListener> {
    private final /* synthetic */ long zzfb;
    private final /* synthetic */ long zzfc;

    zzbq(zzbp zzbpVar, long j10, long j11) {
        this.zzfb = j10;
        this.zzfc = j11;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(DriveFile.DownloadProgressListener downloadProgressListener) {
        downloadProgressListener.onProgress(this.zzfb, this.zzfc);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
