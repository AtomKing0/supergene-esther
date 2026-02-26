package com.google.android.gms.internal.drive;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbn extends zzdp implements DriveFile {
    public zzbn(DriveId driveId) {
        super(driveId);
    }

    @Override // com.google.android.gms.drive.DriveFile
    public final PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient googleApiClient, int i10, @Nullable DriveFile.DownloadProgressListener downloadProgressListener) {
        if (i10 == 268435456 || i10 == 536870912 || i10 == 805306368) {
            return googleApiClient.enqueue(new zzbo(this, googleApiClient, i10, downloadProgressListener == null ? null : new zzbp(googleApiClient.registerListener(downloadProgressListener))));
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
