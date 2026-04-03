package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzlx implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzla zza;
    private volatile boolean zzb;
    private volatile zzfy zzc;

    protected zzlx(zzla zzlaVar) {
        this.zza = zzlaVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    public final void onConnected(Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                Preconditions.checkNotNull(this.zzc);
                this.zza.zzl().zzb(new zzly(this, this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzgb zzgbVarZzm = this.zza.zzu.zzm();
        if (zzgbVarZzm != null) {
            zzgbVarZzm.zzu().zza("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzl().zzb(new zzma(this));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    @MainThread
    public final void onConnectionSuspended(int i10) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zza.zzj().zzc().zza("Service connection suspended");
        this.zza.zzl().zzb(new zzmb(this));
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.zzb = false;
                this.zza.zzj().zzg().zza("Service connected with null binder");
                return;
            }
            zzfq zzfsVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    zzfsVar = iInterfaceQueryLocalInterface instanceof zzfq ? (zzfq) iInterfaceQueryLocalInterface : new zzfs(iBinder);
                    this.zza.zzj().zzp().zza("Bound to IMeasurementService interface");
                } else {
                    this.zza.zzj().zzg().zza("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.zza.zzj().zzg().zza("Service connect failed to get IMeasurementService");
            }
            if (zzfsVar == null) {
                this.zzb = false;
                try {
                    ConnectionTracker.getInstance().unbindService(this.zza.zza(), this.zza.zza);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.zza.zzl().zzb(new zzlw(this, zzfsVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zza.zzj().zzc().zza("Service disconnected");
        this.zza.zzl().zzb(new zzlz(this, componentName));
    }

    @WorkerThread
    public final void zzb() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }

    @WorkerThread
    public final void zza(Intent intent) {
        this.zza.zzt();
        Context contextZza = this.zza.zza();
        ConnectionTracker connectionTracker = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzj().zzp().zza("Connection attempt already in progress");
                return;
            }
            this.zza.zzj().zzp().zza("Using local app measurement service");
            this.zzb = true;
            connectionTracker.bindService(contextZza, intent, this.zza.zza, 129);
        }
    }

    @WorkerThread
    public final void zza() {
        this.zza.zzt();
        Context contextZza = this.zza.zza();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzj().zzp().zza("Connection attempt already in progress");
                return;
            }
            if (this.zzc != null && (this.zzc.isConnecting() || this.zzc.isConnected())) {
                this.zza.zzj().zzp().zza("Already awaiting connection attempt");
                return;
            }
            this.zzc = new zzfy(contextZza, Looper.getMainLooper(), this, this);
            this.zza.zzj().zzp().zza("Connecting to remote service");
            this.zzb = true;
            Preconditions.checkNotNull(this.zzc);
            this.zzc.checkAvailabilityAndConnect();
        }
    }
}
