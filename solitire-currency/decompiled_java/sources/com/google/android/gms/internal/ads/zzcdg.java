package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcdg extends zzfl implements zzgp {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzb = new AtomicReference();
    private final SSLSocketFactory zzc;
    private final int zzd;
    private final int zze;
    private final String zzf;
    private final zzgo zzg;
    private zzfy zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private int zzq;
    private final Set zzr;

    zzcdg(String str, zzgu zzguVar, int i10, int i11, int i12) {
        super(true);
        this.zzc = new zzcdf(this);
        this.zzr = new HashSet();
        zzdi.zzc(str);
        this.zzf = str;
        this.zzg = new zzgo();
        this.zzd = i10;
        this.zze = i11;
        this.zzq = i12;
        if (zzguVar != null) {
            zzf(zzguVar);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Unexpected error while disconnecting", e10);
            }
            this.zzi = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0077 A[Catch: IOException -> 0x008e, TryCatch #0 {IOException -> 0x008e, blocks: (B:2:0x0000, B:21:0x0056, B:23:0x005e, B:26:0x0069, B:27:0x006f, B:29:0x0077, B:32:0x007e, B:33:0x0083, B:34:0x0084, B:5:0x000b, B:7:0x0016, B:8:0x001a, B:10:0x0022, B:13:0x0038, B:14:0x0042, B:15:0x0047, B:16:0x0048, B:17:0x004d, B:18:0x004e), top: B:39:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0084 A[Catch: IOException -> 0x008e, TRY_LEAVE, TryCatch #0 {IOException -> 0x008e, blocks: (B:2:0x0000, B:21:0x0056, B:23:0x005e, B:26:0x0069, B:27:0x006f, B:29:0x0077, B:32:0x007e, B:33:0x0083, B:34:0x0084, B:5:0x000b, B:7:0x0016, B:8:0x001a, B:10:0x0022, B:13:0x0038, B:14:0x0042, B:15:0x0047, B:16:0x0048, B:17:0x004d, B:18:0x004e), top: B:39:0x0000 }] */
    @Override // com.google.android.gms.internal.ads.zzp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(byte[] r9, int r10, int r11) throws com.google.android.gms.internal.ads.zzgl {
        /*
            r8 = this;
            long r0 = r8.zzo     // Catch: java.io.IOException -> L8e
            long r2 = r8.zzm     // Catch: java.io.IOException -> L8e
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = -1
            if (r0 != 0) goto Lb
            goto L53
        Lb:
            java.util.concurrent.atomic.AtomicReference r0 = com.google.android.gms.internal.ads.zzcdg.zzb     // Catch: java.io.IOException -> L8e
            r3 = 0
            java.lang.Object r0 = r0.getAndSet(r3)     // Catch: java.io.IOException -> L8e
            byte[] r0 = (byte[]) r0     // Catch: java.io.IOException -> L8e
            if (r0 != 0) goto L1a
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch: java.io.IOException -> L8e
        L1a:
            long r3 = r8.zzo     // Catch: java.io.IOException -> L8e
            long r5 = r8.zzm     // Catch: java.io.IOException -> L8e
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L4e
            int r7 = r0.length     // Catch: java.io.IOException -> L8e
            long r5 = r5 - r3
            long r3 = (long) r7     // Catch: java.io.IOException -> L8e
            long r3 = java.lang.Math.min(r5, r3)     // Catch: java.io.IOException -> L8e
            int r3 = (int) r3     // Catch: java.io.IOException -> L8e
            java.io.InputStream r4 = r8.zzj     // Catch: java.io.IOException -> L8e
            int r3 = r4.read(r0, r1, r3)     // Catch: java.io.IOException -> L8e
            boolean r4 = java.lang.Thread.interrupted()     // Catch: java.io.IOException -> L8e
            if (r4 != 0) goto L48
            if (r3 == r2) goto L42
            long r4 = r8.zzo     // Catch: java.io.IOException -> L8e
            long r6 = (long) r3     // Catch: java.io.IOException -> L8e
            long r4 = r4 + r6
            r8.zzo = r4     // Catch: java.io.IOException -> L8e
            r8.zzg(r3)     // Catch: java.io.IOException -> L8e
            goto L1a
        L42:
            java.io.EOFException r9 = new java.io.EOFException     // Catch: java.io.IOException -> L8e
            r9.<init>()     // Catch: java.io.IOException -> L8e
            throw r9     // Catch: java.io.IOException -> L8e
        L48:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.io.IOException -> L8e
            r9.<init>()     // Catch: java.io.IOException -> L8e
            throw r9     // Catch: java.io.IOException -> L8e
        L4e:
            java.util.concurrent.atomic.AtomicReference r3 = com.google.android.gms.internal.ads.zzcdg.zzb     // Catch: java.io.IOException -> L8e
            r3.set(r0)     // Catch: java.io.IOException -> L8e
        L53:
            if (r11 != 0) goto L56
            goto L8d
        L56:
            long r0 = r8.zzn     // Catch: java.io.IOException -> L8e
            r3 = -1
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 == 0) goto L6f
            long r5 = r8.zzp     // Catch: java.io.IOException -> L8e
            long r0 = r0 - r5
            r5 = 0
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 != 0) goto L69
        L67:
            r1 = r2
            goto L8d
        L69:
            long r5 = (long) r11     // Catch: java.io.IOException -> L8e
            long r0 = java.lang.Math.min(r5, r0)     // Catch: java.io.IOException -> L8e
            int r11 = (int) r0     // Catch: java.io.IOException -> L8e
        L6f:
            java.io.InputStream r0 = r8.zzj     // Catch: java.io.IOException -> L8e
            int r1 = r0.read(r9, r10, r11)     // Catch: java.io.IOException -> L8e
            if (r1 != r2) goto L84
            long r9 = r8.zzn     // Catch: java.io.IOException -> L8e
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 != 0) goto L7e
            goto L67
        L7e:
            java.io.EOFException r9 = new java.io.EOFException     // Catch: java.io.IOException -> L8e
            r9.<init>()     // Catch: java.io.IOException -> L8e
            throw r9     // Catch: java.io.IOException -> L8e
        L84:
            long r9 = r8.zzp     // Catch: java.io.IOException -> L8e
            long r2 = (long) r1     // Catch: java.io.IOException -> L8e
            long r9 = r9 + r2
            r8.zzp = r9     // Catch: java.io.IOException -> L8e
            r8.zzg(r1)     // Catch: java.io.IOException -> L8e
        L8d:
            return r1
        L8e:
            r9 = move-exception
            com.google.android.gms.internal.ads.zzgl r10 = new com.google.android.gms.internal.ads.zzgl
            com.google.android.gms.internal.ads.zzfy r11 = r8.zzh
            r0 = 2000(0x7d0, float:2.803E-42)
            r1 = 2
            r10.<init>(r9, r11, r0, r1)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdg.zza(byte[], int, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0271 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b7 A[Catch: IOException -> 0x0290, TryCatch #2 {IOException -> 0x0290, blocks: (B:3:0x000e, B:4:0x0023, B:6:0x0029, B:8:0x0033, B:9:0x003b, B:10:0x0053, B:12:0x0059, B:19:0x007d, B:21:0x0097, B:22:0x00a9, B:23:0x00ae, B:25:0x00b7, B:26:0x00be, B:39:0x00e6, B:93:0x0235, B:95:0x0240, B:97:0x0251, B:100:0x025a, B:101:0x0269, B:103:0x0271, B:104:0x0278, B:105:0x0279, B:106:0x028f), top: B:114:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0240 A[Catch: IOException -> 0x0290, TryCatch #2 {IOException -> 0x0290, blocks: (B:3:0x000e, B:4:0x0023, B:6:0x0029, B:8:0x0033, B:9:0x003b, B:10:0x0053, B:12:0x0059, B:19:0x007d, B:21:0x0097, B:22:0x00a9, B:23:0x00ae, B:25:0x00b7, B:26:0x00be, B:39:0x00e6, B:93:0x0235, B:95:0x0240, B:97:0x0251, B:100:0x025a, B:101:0x0269, B:103:0x0271, B:104:0x0278, B:105:0x0279, B:106:0x028f), top: B:114:0x000e }] */
    @Override // com.google.android.gms.internal.ads.zzfs
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long zzb(com.google.android.gms.internal.ads.zzfy r21) throws com.google.android.gms.internal.ads.zzgl {
        /*
            Method dump skipped, instruction units count: 685
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcdg.zzb(com.google.android.gms.internal.ads.zzfy):long");
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    @Nullable
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() throws zzgl {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                int i10 = zzet.zza;
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    throw new zzgl(e10, this.zzh, 2000, 3);
                }
            }
        } finally {
            this.zzj = null;
            zzn();
            if (this.zzk) {
                this.zzk = false;
                zzh();
            }
            this.zzr.clear();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfl, com.google.android.gms.internal.ads.zzfs
    @Nullable
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    final void zzm(int i10) {
        this.zzq = i10;
        for (Socket socket : this.zzr) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzq);
                } catch (SocketException e10) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to update receive buffer size.", e10);
                }
            }
        }
    }
}
