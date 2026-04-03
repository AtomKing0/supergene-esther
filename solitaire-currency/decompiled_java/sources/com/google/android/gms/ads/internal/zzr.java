package com.google.android.gms.ads.internal;

import android.os.AsyncTask;
import com.google.android.gms.internal.ads.zzauo;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzr extends AsyncTask {
    final /* synthetic */ zzt zza;

    /* synthetic */ zzr(zzt zztVar, zzq zzqVar) {
        this.zza = zztVar;
    }

    @Override // android.os.AsyncTask
    protected final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        zzt zztVar = this.zza;
        String str = (String) obj;
        if (zztVar.zzf == null || str == null) {
            return;
        }
        zztVar.zzf.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final String doInBackground(Void... voidArr) {
        try {
            zzt zztVar = this.zza;
            zztVar.zzh = (zzauo) zztVar.zzc.get(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            e = e10;
            com.google.android.gms.ads.internal.util.client.zzm.zzk("", e);
        } catch (ExecutionException e11) {
            e = e11;
            com.google.android.gms.ads.internal.util.client.zzm.zzk("", e);
        } catch (TimeoutException e12) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("", e12);
        }
        return this.zza.zzp();
    }
}
