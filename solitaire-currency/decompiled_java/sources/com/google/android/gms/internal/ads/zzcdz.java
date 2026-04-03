package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ironsource.v8;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcdz extends zzfl implements zzgp {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final zzgo zze;
    private zzfy zzf;
    private HttpURLConnection zzg;
    private final Queue zzh;
    private InputStream zzi;
    private boolean zzj;
    private int zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private final long zzq;
    private final long zzr;

    zzcdz(String str, zzgu zzguVar, int i10, int i11, long j10, long j11) {
        super(true);
        zzdi.zzc(str);
        this.zzd = str;
        this.zze = new zzgo();
        this.zzb = i10;
        this.zzc = i11;
        this.zzh = new ArrayDeque();
        this.zzq = j10;
        this.zzr = j11;
        if (zzguVar != null) {
            zzf(zzguVar);
        }
    }

    private final void zzl() {
        while (!this.zzh.isEmpty()) {
            try {
                ((HttpURLConnection) this.zzh.remove()).disconnect();
            } catch (Exception e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Unexpected error while disconnecting", e10);
            }
        }
        this.zzg = null;
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i10, int i11) throws zzgl {
        if (i11 == 0) {
            return 0;
        }
        try {
            long j10 = this.zzl;
            long j11 = this.zzm;
            if (j10 - j11 == 0) {
                return -1;
            }
            long j12 = this.zzn + j11;
            long j13 = i11;
            long j14 = j12 + j13 + this.zzr;
            long j15 = this.zzp;
            long j16 = j15 + 1;
            if (j14 > j16) {
                long j17 = this.zzo;
                if (j15 < j17) {
                    long jMin = Math.min(j17, Math.max(((this.zzq + j16) - r3) - 1, (-1) + j16 + j13));
                    zzk(j16, jMin, 2);
                    this.zzp = jMin;
                    j15 = jMin;
                }
            }
            int i12 = this.zzi.read(bArr, i10, (int) Math.min(j13, ((j15 + 1) - this.zzn) - this.zzm));
            if (i12 == -1) {
                throw new EOFException();
            }
            this.zzm += (long) i12;
            zzg(i12);
            return i12;
        } catch (IOException e10) {
            throw new zzgl(e10, this.zzf, 2000, 2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws zzgl {
        this.zzf = zzfyVar;
        this.zzm = 0L;
        long j10 = zzfyVar.zze;
        long j11 = zzfyVar.zzf;
        long jMin = j11 == -1 ? this.zzq : Math.min(this.zzq, j11);
        this.zzn = j10;
        HttpURLConnection httpURLConnectionZzk = zzk(j10, (jMin + j10) - 1, 1);
        this.zzg = httpURLConnectionZzk;
        String headerField = httpURLConnectionZzk.getHeaderField("Content-Range");
        if (!TextUtils.isEmpty(headerField)) {
            Matcher matcher = zza.matcher(headerField);
            if (matcher.find()) {
                try {
                    Long.parseLong(matcher.group(1));
                    long j12 = Long.parseLong(matcher.group(2));
                    long j13 = Long.parseLong(matcher.group(3));
                    long j14 = zzfyVar.zzf;
                    if (j14 != -1) {
                        this.zzl = j14;
                        this.zzo = Math.max(j12, (this.zzn + j14) - 1);
                    } else {
                        this.zzl = j13 - this.zzn;
                        this.zzo = j13 - 1;
                    }
                    this.zzp = j12;
                    this.zzj = true;
                    zzj(zzfyVar);
                    return this.zzl;
                } catch (NumberFormatException unused) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzg("Unexpected Content-Range [" + headerField + v8.i.f15839e);
                }
            }
        }
        throw new zzcdx(headerField, zzfyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    @Nullable
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzg;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() throws zzgl {
        try {
            InputStream inputStream = this.zzi;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    throw new zzgl(e10, this.zzf, 2000, 3);
                }
            }
        } finally {
            this.zzi = null;
            zzl();
            if (this.zzj) {
                this.zzj = false;
                zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfl, com.google.android.gms.internal.ads.zzfs
    @Nullable
    public final Map zze() {
        HttpURLConnection httpURLConnection = this.zzg;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    @VisibleForTesting
    final HttpURLConnection zzk(long j10, long j11, int i10) throws zzgl {
        String string = this.zzf.zza.toString();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(string).openConnection();
            httpURLConnection.setConnectTimeout(this.zzb);
            httpURLConnection.setReadTimeout(this.zzc);
            for (Map.Entry entry : this.zze.zza().entrySet()) {
                httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setRequestProperty("Range", "bytes=" + j10 + "-" + j11);
            httpURLConnection.setRequestProperty("User-Agent", this.zzd);
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            this.zzh.add(httpURLConnection);
            String string2 = this.zzf.zza.toString();
            try {
                int responseCode = httpURLConnection.getResponseCode();
                this.zzk = responseCode;
                if (responseCode < 200 || responseCode > 299) {
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    zzl();
                    throw new zzcdy(this.zzk, headerFields, this.zzf, i10);
                }
                try {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    if (this.zzi != null) {
                        inputStream = new SequenceInputStream(this.zzi, inputStream);
                    }
                    this.zzi = inputStream;
                    return httpURLConnection;
                } catch (IOException e10) {
                    zzl();
                    throw new zzgl(e10, this.zzf, 2000, i10);
                }
            } catch (IOException e11) {
                zzl();
                throw new zzgl("Unable to connect to ".concat(String.valueOf(string2)), e11, this.zzf, 2000, i10);
            }
        } catch (IOException e12) {
            throw new zzgl("Unable to connect to ".concat(String.valueOf(string)), e12, this.zzf, 2000, i10);
        }
    }
}
