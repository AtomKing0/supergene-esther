package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import androidx.annotation.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
final class zzayz {

    @VisibleForTesting
    ByteArrayOutputStream zza = new ByteArrayOutputStream(4096);

    @VisibleForTesting
    Base64OutputStream zzb = new Base64OutputStream(this.zza, 10);

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        String string;
        try {
            this.zzb.close();
        } catch (IOException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("HashManager: Unable to convert to Base64.", e10);
        }
        try {
            try {
                this.zza.close();
                string = this.zza.toString();
            } catch (IOException e11) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("HashManager: Unable to convert to Base64.", e11);
                string = "";
            }
            return string;
        } finally {
            this.zza = null;
            this.zzb = null;
        }
    }
}
