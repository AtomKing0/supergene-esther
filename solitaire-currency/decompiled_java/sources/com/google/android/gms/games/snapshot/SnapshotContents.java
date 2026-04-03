package com.google.android.gms.games.snapshot;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.drive.Contents;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface SnapshotContents extends Parcelable {
    @NonNull
    ParcelFileDescriptor getParcelFileDescriptor();

    boolean isClosed();

    boolean modifyBytes(int i10, @NonNull byte[] bArr, int i11, int i12);

    @NonNull
    byte[] readFully() throws IOException;

    boolean writeBytes(@NonNull byte[] bArr);

    @NonNull
    Contents zza();

    void zzb();
}
