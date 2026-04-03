package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;

/* JADX INFO: loaded from: classes3.dex */
final class zzgl extends zzl {
    private final BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> zzdx;
    private final DriveFile.DownloadProgressListener zziq;

    zzgl(BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> resultHolder, DriveFile.DownloadProgressListener downloadProgressListener) {
        this.zzdx = resultHolder;
        this.zziq = downloadProgressListener;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfh zzfhVar) throws RemoteException {
        this.zzdx.setResult(new zzal(zzfhVar.zzhv ? new Status(-1) : Status.RESULT_SUCCESS, new zzbi(zzfhVar.zzes)));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfl zzflVar) throws RemoteException {
        DriveFile.DownloadProgressListener downloadProgressListener = this.zziq;
        if (downloadProgressListener != null) {
            downloadProgressListener.onProgress(zzflVar.zzhy, zzflVar.zzhz);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzal(status, null));
    }
}
