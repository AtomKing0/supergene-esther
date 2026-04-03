package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.zzh;
import com.google.android.gms.internal.games_v2.zzez;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@UsedByReflection("GamesGmsClientImpl.java")
@SafeParcelable.Class(creator = "SnapshotContentsEntityCreator")
@SafeParcelable.Reserved({1000})
public final class SnapshotContentsEntity extends zzh implements SnapshotContents {

    @SafeParcelable.Field(getter = "getContents", id = 1)
    private Contents zzb;
    private static final Object zza = new Object();

    @NonNull
    public static final Parcelable.Creator<SnapshotContentsEntity> CREATOR = new zza();

    @SafeParcelable.Constructor
    public SnapshotContentsEntity(@NonNull @SafeParcelable.Param(id = 1) Contents contents) {
        this.zzb = contents;
    }

    private final boolean zzc(int i10, byte[] bArr, int i11, int i12, boolean z10) {
        Preconditions.checkState(!isClosed(), "Must provide a previously opened SnapshotContents");
        synchronized (zza) {
            FileOutputStream fileOutputStream = new FileOutputStream(this.zzb.getParcelFileDescriptor().getFileDescriptor());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            try {
                FileChannel channel = fileOutputStream.getChannel();
                channel.position(i10);
                bufferedOutputStream.write(bArr, i11, i12);
                if (z10) {
                    channel.truncate(bArr.length);
                }
                bufferedOutputStream.flush();
            } catch (IOException e10) {
                zzez.zze("SnapshotContentsEntity", "Failed to write snapshot data", e10);
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    @NonNull
    public final ParcelFileDescriptor getParcelFileDescriptor() {
        Preconditions.checkState(!isClosed(), "Cannot mutate closed contents!");
        return this.zzb.getParcelFileDescriptor();
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public final boolean isClosed() {
        return this.zzb == null;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public final boolean modifyBytes(int i10, @NonNull byte[] bArr, int i11, int i12) {
        return zzc(i10, bArr, i11, bArr.length, false);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    @NonNull
    public final byte[] readFully() throws IOException {
        byte[] inputStreamFully;
        Preconditions.checkState(!isClosed(), "Must provide a previously opened Snapshot");
        synchronized (zza) {
            FileInputStream fileInputStream = new FileInputStream(this.zzb.getParcelFileDescriptor().getFileDescriptor());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                fileInputStream.getChannel().position(0L);
                inputStreamFully = IOUtils.readInputStreamFully(bufferedInputStream, false);
                fileInputStream.getChannel().position(0L);
            } catch (IOException e10) {
                zzez.zzh("SnapshotContentsEntity", "Failed to read snapshot data", e10);
                throw e10;
            }
        }
        return inputStreamFully;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public final boolean writeBytes(@NonNull byte[] bArr) {
        return zzc(0, bArr, 0, bArr.length, true);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i10) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzb, i10, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    @NonNull
    public final Contents zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.games.snapshot.SnapshotContents
    public final void zzb() {
        this.zzb = null;
    }
}
