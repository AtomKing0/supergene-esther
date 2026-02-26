package com.google.android.gms.internal.ads;

import android.net.Network;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfrp extends zzfrd {
    private zzfvk<Integer> zza;
    private zzfvk<Integer> zzb;

    @Nullable
    private zzfro zzc;

    @Nullable
    private HttpURLConnection zzd;

    zzfrp(zzfvk<Integer> zzfvkVar, zzfvk<Integer> zzfvkVar2, @Nullable zzfro zzfroVar) {
        this.zza = zzfvkVar;
        this.zzb = zzfvkVar2;
        this.zzc = zzfroVar;
    }

    static /* synthetic */ Integer zzf() {
        return -1;
    }

    static /* synthetic */ Integer zzg() {
        return -1;
    }

    public static void zzs(@Nullable HttpURLConnection httpURLConnection) {
        zzfre.zza();
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        zzs(this.zzd);
    }

    public HttpURLConnection zzm() throws IOException {
        zzfre.zzb(((Integer) this.zza.zza()).intValue(), ((Integer) this.zzb.zza()).intValue());
        zzfro zzfroVar = this.zzc;
        zzfroVar.getClass();
        HttpURLConnection httpURLConnection = (HttpURLConnection) zzfroVar.zza();
        this.zzd = httpURLConnection;
        return httpURLConnection;
    }

    public HttpURLConnection zzn(zzfro zzfroVar, final int i10, final int i11) throws IOException {
        this.zza = new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrh
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return Integer.valueOf(i10);
            }
        };
        this.zzb = new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfri
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return Integer.valueOf(i11);
            }
        };
        this.zzc = zzfroVar;
        return zzm();
    }

    @RequiresApi(21)
    public HttpURLConnection zzo(@NonNull final Network network, @NonNull final URL url, final int i10, final int i11) throws IOException {
        this.zza = new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrj
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return Integer.valueOf(i10);
            }
        };
        this.zzb = new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrk
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return Integer.valueOf(i11);
            }
        };
        this.zzc = new zzfro() { // from class: com.google.android.gms.internal.ads.zzfrl
            @Override // com.google.android.gms.internal.ads.zzfro
            public final URLConnection zza() {
                return network.openConnection(url);
            }
        };
        return zzm();
    }

    public URLConnection zzr(@NonNull final URL url, final int i10) throws IOException {
        this.zza = new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrm
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return Integer.valueOf(i10);
            }
        };
        this.zzc = new zzfro() { // from class: com.google.android.gms.internal.ads.zzfrn
            @Override // com.google.android.gms.internal.ads.zzfro
            public final URLConnection zza() {
                return url.openConnection();
            }
        };
        return zzm();
    }

    zzfrp() {
        this(new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrf
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return zzfrp.zzf();
            }
        }, new zzfvk() { // from class: com.google.android.gms.internal.ads.zzfrg
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                return zzfrp.zzg();
            }
        }, null);
    }
}
