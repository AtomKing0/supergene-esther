package com.google.android.gms.games;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface SnapshotsClient {
    public static final int DISPLAY_LIMIT_NONE = -1;

    @NonNull
    public static final String EXTRA_SNAPSHOT_METADATA = "com.google.android.gms.games.SNAPSHOT_METADATA";

    @NonNull
    public static final String EXTRA_SNAPSHOT_NEW = "com.google.android.gms.games.SNAPSHOT_NEW";
    public static final int RESOLUTION_POLICY_HIGHEST_PROGRESS = 4;
    public static final int RESOLUTION_POLICY_LAST_KNOWN_GOOD = 2;
    public static final int RESOLUTION_POLICY_LONGEST_PLAYTIME = 1;
    public static final int RESOLUTION_POLICY_MANUAL = -1;
    public static final int RESOLUTION_POLICY_MOST_RECENTLY_MODIFIED = 3;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    public static final class DataOrConflict<T> {
        private final Object zza;
        private final SnapshotConflict zzb;

        public DataOrConflict(@Nullable Object obj, @Nullable SnapshotConflict snapshotConflict) {
            this.zza = obj;
            this.zzb = snapshotConflict;
        }

        @Nullable
        public SnapshotConflict getConflict() {
            if (isConflict()) {
                return this.zzb;
            }
            throw new IllegalStateException("getConflict called when there is no conflict.");
        }

        @Nullable
        public T getData() {
            if (isConflict()) {
                throw new IllegalStateException("getData called when there is a conflict.");
            }
            return (T) this.zza;
        }

        public boolean isConflict() {
            return this.zzb != null;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResolutionPolicy {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    public static final class SnapshotConflict {
        private final Snapshot zza;
        private final String zzb;
        private final Snapshot zzc;
        private final SnapshotContents zzd;

        public SnapshotConflict(@NonNull Snapshot snapshot, @NonNull String str, @NonNull Snapshot snapshot2, @NonNull SnapshotContents snapshotContents) {
            this.zza = snapshot;
            this.zzb = str;
            this.zzc = snapshot2;
            this.zzd = snapshotContents;
        }

        @NonNull
        public String getConflictId() {
            return this.zzb;
        }

        @NonNull
        public Snapshot getConflictingSnapshot() {
            return this.zzc;
        }

        @NonNull
        public SnapshotContents getResolutionSnapshotContents() {
            return this.zzd;
        }

        @NonNull
        public Snapshot getSnapshot() {
            return this.zza;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    public static final class SnapshotContentUnavailableApiException extends ApiException {

        @NonNull
        protected final SnapshotMetadata metadata;

        public SnapshotContentUnavailableApiException(@NonNull Status status, @NonNull SnapshotMetadata snapshotMetadata) {
            super(status);
            this.metadata = snapshotMetadata;
        }

        @NonNull
        public SnapshotMetadata getSnapshotMetadata() {
            return this.metadata;
        }
    }

    @NonNull
    Task<SnapshotMetadata> commitAndClose(@NonNull Snapshot snapshot, @NonNull SnapshotMetadataChange snapshotMetadataChange);

    @NonNull
    Task<String> delete(@NonNull SnapshotMetadata snapshotMetadata);

    @NonNull
    Task<Void> discardAndClose(@NonNull Snapshot snapshot);

    @NonNull
    Task<Integer> getMaxCoverImageSize();

    @NonNull
    Task<Integer> getMaxDataSize();

    @NonNull
    Task<Intent> getSelectSnapshotIntent(@NonNull String str, boolean z10, boolean z11, int i10);

    @NonNull
    Task<AnnotatedData<SnapshotMetadataBuffer>> load(boolean z10);

    @NonNull
    Task<DataOrConflict<Snapshot>> open(@NonNull SnapshotMetadata snapshotMetadata);

    @NonNull
    Task<DataOrConflict<Snapshot>> open(@NonNull SnapshotMetadata snapshotMetadata, int i10);

    @NonNull
    Task<DataOrConflict<Snapshot>> open(@NonNull String str, boolean z10);

    @NonNull
    Task<DataOrConflict<Snapshot>> open(@NonNull String str, boolean z10, int i10);

    @NonNull
    Task<DataOrConflict<Snapshot>> resolveConflict(@NonNull String str, @NonNull Snapshot snapshot);

    @NonNull
    Task<DataOrConflict<Snapshot>> resolveConflict(@NonNull String str, @NonNull String str2, @NonNull SnapshotMetadataChange snapshotMetadataChange, @NonNull SnapshotContents snapshotContents);
}
