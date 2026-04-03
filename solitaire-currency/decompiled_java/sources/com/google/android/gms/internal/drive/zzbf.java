package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.OpenFileActivityOptions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes3.dex */
final class zzbf extends TaskApiCall<zzaw, IntentSender> {
    private final /* synthetic */ OpenFileActivityOptions zzeq;

    zzbf(zzbb zzbbVar, OpenFileActivityOptions openFileActivityOptions) {
        this.zzeq = openFileActivityOptions;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<IntentSender> taskCompletionSource) throws RemoteException {
        zzeo zzeoVar = (zzeo) ((zzaw) anyClient).getService();
        OpenFileActivityOptions openFileActivityOptions = this.zzeq;
        taskCompletionSource.setResult(zzeoVar.zza(new zzgm(openFileActivityOptions.zzba, openFileActivityOptions.zzbb, openFileActivityOptions.zzbd, openFileActivityOptions.zzbe)));
    }
}
