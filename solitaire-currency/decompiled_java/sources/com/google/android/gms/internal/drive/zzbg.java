package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.CreateFileActivityOptions;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes3.dex */
final class zzbg extends TaskApiCall<zzaw, IntentSender> {
    private final /* synthetic */ CreateFileActivityOptions zzer;

    zzbg(zzbb zzbbVar, CreateFileActivityOptions createFileActivityOptions) {
        this.zzer = createFileActivityOptions;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<IntentSender> taskCompletionSource) throws RemoteException {
        zzaw zzawVar = (zzaw) anyClient;
        zzeo zzeoVar = (zzeo) zzawVar.getService();
        this.zzer.zzde.zza(zzawVar.getContext());
        CreateFileActivityOptions createFileActivityOptions = this.zzer;
        MetadataBundle metadataBundle = createFileActivityOptions.zzde;
        int iIntValue = createFileActivityOptions.zzdk.intValue();
        CreateFileActivityOptions createFileActivityOptions2 = this.zzer;
        taskCompletionSource.setResult(zzeoVar.zza(new zzu(metadataBundle, iIntValue, createFileActivityOptions2.zzba, createFileActivityOptions2.zzbd, Integer.valueOf(createFileActivityOptions2.zzdl))));
    }
}
