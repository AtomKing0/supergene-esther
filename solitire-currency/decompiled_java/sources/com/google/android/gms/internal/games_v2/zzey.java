package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.SnapshotsClient;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzey implements SnapshotsClient {
    private final zzar zza;

    public zzey(zzar zzarVar) {
        this.zza = zzarVar;
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotMetadata> commitAndClose(@NonNull final Snapshot snapshot, @NonNull final SnapshotMetadataChange snapshotMetadataChange) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzeh
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final Snapshot snapshot2 = snapshot;
                final SnapshotMetadataChange snapshotMetadataChange2 = snapshotMetadataChange;
                return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzep
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) throws RemoteException {
                        ((com.google.android.gms.games.internal.zzak) obj).zzt((TaskCompletionSource) obj2, snapshot2, snapshotMetadataChange2);
                    }
                }).setMethodKey(6722).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<String> delete(@NonNull final SnapshotMetadata snapshotMetadata) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzei
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final SnapshotMetadata snapshotMetadata2 = snapshotMetadata;
                return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzeq
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) throws RemoteException {
                        ((com.google.android.gms.games.internal.zzak) obj).zzu((TaskCompletionSource) obj2, snapshotMetadata2.getSnapshotId());
                    }
                }).setMethodKey(6724).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<Void> discardAndClose(@NonNull final Snapshot snapshot) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzex
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final Snapshot snapshot2 = snapshot;
                return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzeg
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) throws RemoteException {
                        SnapshotContents snapshotContents = snapshot2.getSnapshotContents();
                        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
                        Contents contentsZza = snapshotContents.zza();
                        snapshotContents.zzb();
                        ((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzt(contentsZza);
                        ((TaskCompletionSource) obj2).setResult(null);
                    }
                }).setMethodKey(6723).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<Integer> getMaxCoverImageSize() {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzen
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzev
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(Integer.valueOf(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzd()));
                    }
                }).setMethodKey(6718).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<Integer> getMaxDataSize() {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzeo
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzew
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(Integer.valueOf(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zze()));
                    }
                }).setMethodKey(6717).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<Intent> getSelectSnapshotIntent(@NonNull final String str, final boolean z10, final boolean z11, final int i10) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzel
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final String str2 = str;
                final boolean z12 = z10;
                final boolean z13 = z11;
                final int i11 = i10;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzet
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzm(str2, z12, z13, i11));
                    }
                }).setMethodKey(6719).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<AnnotatedData<SnapshotMetadataBuffer>> load(final boolean z10) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzem
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final boolean z11 = z10;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzeu
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) throws RemoteException {
                        ((com.google.android.gms.games.internal.zzak) obj).zzJ((TaskCompletionSource) obj2, z11);
                    }
                }).setMethodKey(6720).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(@NonNull SnapshotMetadata snapshotMetadata) {
        return open(snapshotMetadata.getUniqueName(), false, -1);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> resolveConflict(@NonNull String str, @NonNull Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange.Builder builder = new SnapshotMetadataChange.Builder();
        builder.fromMetadata(metadata);
        SnapshotMetadataChange snapshotMetadataChangeBuild = builder.build();
        return this.zza.zzb(new zzej(str, metadata.getSnapshotId(), snapshotMetadataChangeBuild, snapshot.getSnapshotContents()));
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(@NonNull SnapshotMetadata snapshotMetadata, int i10) {
        return open(snapshotMetadata.getUniqueName(), false, i10);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(@NonNull String str, boolean z10) {
        return open(str, z10, -1);
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> open(@NonNull final String str, final boolean z10, final int i10) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzek
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final String str2 = str;
                final boolean z11 = z10;
                final int i11 = i10;
                return googleApi.doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzes
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) throws RemoteException {
                        ((com.google.android.gms.games.internal.zzak) obj).zzL((TaskCompletionSource) obj2, str2, z11, i11);
                    }
                }).setMethodKey(6721).build());
            }
        });
    }

    @Override // com.google.android.gms.games.SnapshotsClient
    public final Task<SnapshotsClient.DataOrConflict<Snapshot>> resolveConflict(@NonNull String str, @NonNull String str2, @NonNull SnapshotMetadataChange snapshotMetadataChange, @NonNull SnapshotContents snapshotContents) {
        return this.zza.zzb(new zzej(str, str2, snapshotMetadataChange, snapshotContents));
    }
}
