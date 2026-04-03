package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzkm extends zzil {
    zzkm(zzho zzhoVar) {
        super(zzhoVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final boolean zzc() {
        NetworkInfo activeNetworkInfo;
        zzac();
        ConnectivityManager connectivityManager = (ConnectivityManager) zza().getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
                activeNetworkInfo = null;
            }
        } else {
            activeNetworkInfo = null;
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    protected final boolean zzo() {
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public static byte[] zza(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 > 0) {
                    byteArrayOutputStream.write(bArr, 0, i10);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    return byteArray;
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }
}
