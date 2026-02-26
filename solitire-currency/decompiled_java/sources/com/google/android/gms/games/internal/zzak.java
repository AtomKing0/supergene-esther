package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.FriendsResolutionRequiredException;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.GamesClientStatusCodes;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.google.android.gms.internal.games_v2.zzez;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzak extends GmsClient {
    public static final /* synthetic */ int zze = 0;
    private final com.google.android.gms.internal.games_v2.zzak zzf;
    private final String zzg;
    private PlayerEntity zzh;
    private GameEntity zzi;
    private final zzaq zzj;
    private boolean zzk;
    private final long zzl;
    private final com.google.android.gms.games.zzn zzm;
    private final zzar zzn;

    public zzak(Context context, Looper looper, ClientSettings clientSettings, com.google.android.gms.games.zzn zznVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzar zzarVar) {
        super(context, looper, 1, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzf = new zzm(this);
        this.zzk = false;
        this.zzg = clientSettings.getRealClientPackageName();
        this.zzn = (zzar) Preconditions.checkNotNull(zzarVar);
        zzaq zzaqVarZzd = zzaq.zzd(this, clientSettings.getGravityForPopups());
        this.zzj = zzaqVarZzd;
        this.zzl = hashCode();
        this.zzm = zznVar;
        boolean z10 = zznVar.zzh;
        if (clientSettings.getViewForPopups() != null || (context instanceof Activity)) {
            zzaqVarZzd.zzf(clientSettings.getViewForPopups());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzU(RemoteException remoteException) {
        zzez.zzh("GamesGmsClientImpl", "service died", remoteException);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* bridge */ /* synthetic */ void zzq(zzak zzakVar, TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setException(FriendsResolutionRequiredException.zza(GamesClientStatusCodes.zzb(GamesClientStatusCodes.CONSENT_REQUIRED, ((zzap) zzakVar.getService()).zzf())));
        } catch (RemoteException e10) {
            taskCompletionSource.setException(e10);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzh = null;
        this.zzi = null;
        super.connect(connectionProgressReportCallbacks);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
        return iInterfaceQueryLocalInterface instanceof zzap ? (zzap) iInterfaceQueryLocalInterface : new zzap(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        this.zzk = false;
        if (isConnected()) {
            try {
                this.zzf.zzb();
                ((zzap) getService()).zzq(this.zzl);
            } catch (RemoteException unused) {
                zzez.zzg("GamesGmsClientImpl", "Failed to notify client disconnect.");
            }
        }
        super.disconnect();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return com.google.android.gms.games.zzd.zzb;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    @Nullable
    public final Bundle getConnectionHint() {
        return null;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final Bundle getGetServiceRequestExtraArgs() {
        String string = getContext().getResources().getConfiguration().locale.toString();
        Bundle bundleZza = this.zzm.zza();
        bundleZza.putString(ServiceSpecificExtraArgs.GamesExtraArgs.GAME_PACKAGE_NAME, this.zzg);
        bundleZza.putString(ServiceSpecificExtraArgs.GamesExtraArgs.DESIRED_LOCALE, string);
        bundleZza.putParcelable(ServiceSpecificExtraArgs.GamesExtraArgs.WINDOW_TOKEN, new BinderWrapper(this.zzj.zzc()));
        if (!bundleZza.containsKey("com.google.android.gms.games.key.API_VERSION")) {
            bundleZza.putInt("com.google.android.gms.games.key.API_VERSION", 9);
        }
        bundleZza.putBundle(ServiceSpecificExtraArgs.GamesExtraArgs.SIGNIN_OPTIONS, SignInClientImpl.createBundleFromClientSettings(getClientSettings()));
        return bundleZza;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.GmsClient, com.google.android.gms.common.api.Api.Client
    public final Set getScopesForConnectionlessNonSignIn() {
        return getScopes();
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getServiceDescriptor() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.games.service.START";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* bridge */ /* synthetic */ void onConnectedLocked(@NonNull IInterface iInterface) {
        zzap zzapVar = (zzap) iInterface;
        super.onConnectedLocked(zzapVar);
        if (this.zzk) {
            this.zzj.zzg();
            this.zzk = false;
        }
        boolean z10 = this.zzm.zza;
        try {
            zzapVar.zzK(new zzn(new com.google.android.gms.internal.games_v2.zzan(this.zzj.zze())), this.zzl);
        } catch (RemoteException e10) {
            zzU(e10);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        this.zzk = false;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final void onPostInitHandler(int i10, IBinder iBinder, Bundle bundle, int i11) {
        if (i10 == 0) {
            i10 = 0;
            if (bundle != null) {
                bundle.setClassLoader(zzak.class.getClassLoader());
                this.zzk = bundle.getBoolean("show_welcome_popup");
                this.zzh = (PlayerEntity) bundle.getParcelable("com.google.android.gms.games.current_player");
                this.zzi = (GameEntity) bundle.getParcelable("com.google.android.gms.games.current_game");
            }
        }
        super.onPostInitHandler(i10, iBinder, bundle, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final void onUserSignOut(@NonNull BaseGmsClient.SignOutCallbacks signOutCallbacks) {
        try {
            zzo zzoVar = new zzo(signOutCallbacks);
            this.zzf.zzb();
            try {
                ((zzap) getService()).zzQ(new zzp(zzoVar));
            } catch (SecurityException unused) {
                zzoVar.setFailedResult(GamesClientStatusCodes.zza(4));
            }
        } catch (RemoteException unused2) {
            signOutCallbacks.onSignOutComplete();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresAccount() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        if (this.zzm.zzo.zzb()) {
            return false;
        }
        String str = this.zzm.zzl;
        return true;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzA(TaskCompletionSource taskCompletionSource, boolean z10) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzap) getService()).zzy(new zzv(taskCompletionSource), z10);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzB(TaskCompletionSource taskCompletionSource, boolean z10, String... strArr) throws RemoteException {
        this.zzf.zzb();
        try {
            ((zzap) getService()).zzz(new zzv(taskCompletionSource), z10, strArr);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzC(TaskCompletionSource taskCompletionSource, String str, boolean z10) throws RemoteException {
        try {
            ((zzap) getService()).zzA(new zzy(taskCompletionSource), str, z10);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzD(TaskCompletionSource taskCompletionSource, boolean z10) throws RemoteException {
        try {
            ((zzap) getService()).zzB(new zzab(taskCompletionSource), z10);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzE(TaskCompletionSource taskCompletionSource, LeaderboardScoreBuffer leaderboardScoreBuffer, int i10, int i11) throws RemoteException {
        try {
            ((zzap) getService()).zzC(new zzaa(this, taskCompletionSource), leaderboardScoreBuffer.zza().zza(), i10, i11);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzF(TaskCompletionSource taskCompletionSource, String str, boolean z10) throws RemoteException {
        try {
            ((zzap) getService()).zzF(new zzaf(taskCompletionSource), str, z10);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzG(TaskCompletionSource taskCompletionSource, String str, int i10, int i11, int i12, boolean z10) throws RemoteException {
        try {
            ((zzap) getService()).zzD(new zzaa(this, taskCompletionSource), str, i10, i11, i12, z10);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzH(TaskCompletionSource taskCompletionSource, boolean z10) throws RemoteException {
        try {
            ((zzap) getService()).zzE(new zzad(taskCompletionSource), z10);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzI(TaskCompletionSource taskCompletionSource, String str, int i10, boolean z10, boolean z11) throws RemoteException {
        if (!str.equals("played_with") && !str.equals("friends_all")) {
            throw new IllegalArgumentException(str.length() != 0 ? "Invalid player collection: ".concat(str) : new String("Invalid player collection: "));
        }
        try {
            ((zzap) getService()).zzG(new zzae(this, taskCompletionSource), str, i10, z10, z11);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzJ(TaskCompletionSource taskCompletionSource, boolean z10) throws RemoteException {
        try {
            ((zzap) getService()).zzH(new zzac(taskCompletionSource), z10);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzK(TaskCompletionSource taskCompletionSource, String str, int i10, int i11, int i12, boolean z10) throws RemoteException {
        try {
            ((zzap) getService()).zzI(new zzaa(this, taskCompletionSource), str, i10, i11, i12, z10);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzL(TaskCompletionSource taskCompletionSource, String str, boolean z10, int i10) throws RemoteException {
        try {
            ((zzap) getService()).zzJ(new zzaj(taskCompletionSource), str, z10, i10);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzM(TaskCompletionSource taskCompletionSource, String str, boolean z10) throws RemoteException {
        ((zzap) getService()).zzL(new zzx(taskCompletionSource), str, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzN(TaskCompletionSource taskCompletionSource, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) throws RemoteException {
        Preconditions.checkState(!snapshotContents.isClosed(), "SnapshotContents already closed");
        BitmapTeleporter bitmapTeleporterZza = snapshotMetadataChange.zza();
        if (bitmapTeleporterZza != null) {
            bitmapTeleporterZza.setTempDir(getContext().getCacheDir());
        }
        Contents contentsZza = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzap) getService()).zzM(new zzaj(taskCompletionSource), str, str2, (SnapshotMetadataChangeEntity) snapshotMetadataChange, contentsZza);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzO(@Nullable TaskCompletionSource taskCompletionSource, String str) throws RemoteException {
        try {
            ((zzap) getService()).zzN(taskCompletionSource == null ? null : new zzr(taskCompletionSource), str, this.zzj.zzc(), this.zzj.zzb());
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzP(@Nullable TaskCompletionSource taskCompletionSource, String str, int i10) throws RemoteException {
        try {
            ((zzap) getService()).zzO(taskCompletionSource == null ? null : new zzq(taskCompletionSource), str, i10, this.zzj.zzc(), this.zzj.zzb());
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzQ(IBinder iBinder, Bundle bundle) {
        if (isConnected()) {
            if (this.zzm.zzo.zzd() && this.zzn.zzc()) {
                return;
            }
            try {
                ((zzap) getService()).zzP(iBinder, bundle);
                this.zzn.zzb();
            } catch (RemoteException e10) {
                zzU(e10);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzR(TaskCompletionSource taskCompletionSource, String str, long j10, @Nullable String str2) throws RemoteException {
        try {
            ((zzap) getService()).zzR(new zzah(taskCompletionSource), str, j10, str2);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    public final void zzS(zzg zzgVar) {
        zzgVar.zzf(this.zzj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzT(@Nullable TaskCompletionSource taskCompletionSource, String str) throws RemoteException {
        try {
            ((zzap) getService()).zzS(taskCompletionSource == null ? null : new zzr(taskCompletionSource), str, this.zzj.zzc(), this.zzj.zzb());
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Player zzp() throws RemoteException {
        checkConnected();
        synchronized (this) {
            if (this.zzh == null) {
                PlayerBuffer playerBuffer = new PlayerBuffer(((zzap) getService()).zzn());
                try {
                    if (playerBuffer.getCount() > 0) {
                        this.zzh = new PlayerEntity(playerBuffer.get(0));
                    }
                    playerBuffer.release();
                } catch (Throwable th) {
                    playerBuffer.release();
                    throw th;
                }
            }
        }
        return this.zzh;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final void zzs() {
        if (isConnected()) {
            try {
                ((zzap) getService()).zzp();
            } catch (RemoteException e10) {
                zzU(e10);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzt(TaskCompletionSource taskCompletionSource, Snapshot snapshot, SnapshotMetadataChange snapshotMetadataChange) throws RemoteException {
        SnapshotContents snapshotContents = snapshot.getSnapshotContents();
        Preconditions.checkState(!snapshotContents.isClosed(), "Snapshot already closed");
        BitmapTeleporter bitmapTeleporterZza = snapshotMetadataChange.zza();
        if (bitmapTeleporterZza != null) {
            bitmapTeleporterZza.setTempDir(getContext().getCacheDir());
        }
        Contents contentsZza = snapshotContents.zza();
        snapshotContents.zzb();
        try {
            ((zzap) getService()).zzr(new zzt(taskCompletionSource), snapshot.getMetadata().getSnapshotId(), (SnapshotMetadataChangeEntity) snapshotMetadataChange, contentsZza);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzu(TaskCompletionSource taskCompletionSource, String str) throws RemoteException {
        try {
            ((zzap) getService()).zzs(new zzu(taskCompletionSource), str);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzv(TaskCompletionSource taskCompletionSource, boolean z10) throws RemoteException {
        try {
            ((zzap) getService()).zzF(new zzaf(taskCompletionSource), null, z10);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzw(@Nullable TaskCompletionSource taskCompletionSource, String str, int i10) throws RemoteException {
        try {
            ((zzap) getService()).zzv(taskCompletionSource == null ? null : new zzq(taskCompletionSource), str, i10, this.zzj.zzc(), this.zzj.zzb());
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    public final void zzx(String str, int i10) {
        this.zzf.zzc(str, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzy(TaskCompletionSource taskCompletionSource, boolean z10) throws RemoteException {
        try {
            ((zzap) getService()).zzx(new zzs(taskCompletionSource), z10);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void zzz(TaskCompletionSource taskCompletionSource, String str, int i10, int i11) throws RemoteException {
        try {
            ((zzap) getService()).zzu(new zzz(this, taskCompletionSource), null, str, i10, i11);
        } catch (SecurityException e10) {
            GamesStatusUtils.zzb(taskCompletionSource, e10);
        }
    }
}
