package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
@WorkerThread
final class zzko implements Runnable {
    private final URL zza;
    private final byte[] zzb;
    private final zzkp zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzkm zzf;

    public zzko(zzkm zzkmVar, String str, URL url, byte[] bArr, Map<String, String> map, zzkp zzkpVar) {
        this.zzf = zzkmVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzkpVar);
        this.zza = url;
        this.zzb = null;
        this.zzc = zzkpVar;
        this.zzd = str;
        this.zze = null;
    }

    private final void zzb(final int i10, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.zzf.zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkr
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza(i10, exc, bArr, map);
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> headerFields;
        this.zzf.zzr();
        int responseCode = 0;
        try {
            URLConnection uRLConnectionZza = com.google.android.gms.internal.measurement.zzcq.zza().zza(this.zza, "client-measurement");
            if (!(uRLConnectionZza instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionZza;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                responseCode = httpURLConnection.getResponseCode();
                headerFields = httpURLConnection.getHeaderFields();
                try {
                    zzkm zzkmVar = this.zzf;
                    byte[] bArrZza = zzkm.zza(httpURLConnection);
                    httpURLConnection.disconnect();
                    zzb(responseCode, null, bArrZza, headerFields);
                } catch (IOException e10) {
                    e = e10;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(responseCode, e, null, headerFields);
                } catch (Throwable th) {
                    th = th;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    zzb(responseCode, null, null, headerFields);
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
                headerFields = null;
            } catch (Throwable th2) {
                th = th2;
                headerFields = null;
            }
        } catch (IOException e12) {
            e = e12;
            httpURLConnection = null;
            headerFields = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            headerFields = null;
        }
    }

    final /* synthetic */ void zza(int i10, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i10, exc, bArr, map);
    }
}
