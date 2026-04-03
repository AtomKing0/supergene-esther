package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.BitmapTeleporter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface SnapshotMetadataChange {

    @NonNull
    public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    public static final class Builder {
        private String zza;
        private Long zzb;
        private Long zzc;
        private BitmapTeleporter zzd;
        private Uri zze;

        @NonNull
        public SnapshotMetadataChange build() {
            return new SnapshotMetadataChangeEntity(this.zza, this.zzb, this.zzd, this.zze, this.zzc);
        }

        @NonNull
        public Builder fromMetadata(@NonNull SnapshotMetadata snapshotMetadata) {
            this.zza = snapshotMetadata.getDescription();
            this.zzb = Long.valueOf(snapshotMetadata.getPlayedTime());
            this.zzc = Long.valueOf(snapshotMetadata.getProgressValue());
            if (this.zzb.longValue() == -1) {
                this.zzb = null;
            }
            Uri coverImageUri = snapshotMetadata.getCoverImageUri();
            this.zze = coverImageUri;
            if (coverImageUri != null) {
                this.zzd = null;
            }
            return this;
        }

        @NonNull
        public Builder setCoverImage(@NonNull Bitmap bitmap) {
            this.zzd = new BitmapTeleporter(bitmap);
            this.zze = null;
            return this;
        }

        @NonNull
        public Builder setDescription(@NonNull String str) {
            this.zza = str;
            return this;
        }

        @NonNull
        public Builder setPlayedTimeMillis(long j10) {
            this.zzb = Long.valueOf(j10);
            return this;
        }

        @NonNull
        public Builder setProgressValue(long j10) {
            this.zzc = Long.valueOf(j10);
            return this;
        }
    }

    @Nullable
    Bitmap getCoverImage();

    @Nullable
    String getDescription();

    @Nullable
    Long getPlayedTimeMillis();

    @Nullable
    Long getProgressValue();

    @Nullable
    BitmapTeleporter zza();
}
