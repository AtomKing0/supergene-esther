package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgj extends zzfl {

    @Nullable
    private RandomAccessFile zza;

    @Nullable
    private Uri zzb;
    private long zzc;
    private boolean zzd;

    public zzgj() {
        super(false);
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i10, int i11) throws zzgi {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.zzc;
        if (j10 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.zza;
            int i12 = zzet.zza;
            int i13 = randomAccessFile.read(bArr, i10, (int) Math.min(j10, i11));
            if (i13 > 0) {
                this.zzc -= (long) i13;
                zzg(i13);
            }
            return i13;
        } catch (IOException e10) {
            throw new zzgi(e10, 2000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws zzgi {
        Uri uri = zzfyVar.zza;
        this.zzb = uri;
        zzi(zzfyVar);
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            this.zza = randomAccessFile;
            try {
                randomAccessFile.seek(zzfyVar.zze);
                long length = zzfyVar.zzf;
                if (length == -1) {
                    length = this.zza.length() - zzfyVar.zze;
                }
                this.zzc = length;
                if (length < 0) {
                    throw new zzgi(null, null, 2008);
                }
                this.zzd = true;
                zzj(zzfyVar);
                return this.zzc;
            } catch (IOException e10) {
                throw new zzgi(e10, 2000);
            }
        } catch (FileNotFoundException e11) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new zzgi(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e11, 1004);
            }
            int i10 = zzet.zza;
            throw new zzgi(e11, true != zzgh.zzb(e11.getCause()) ? 2005 : 2006);
        } catch (SecurityException e12) {
            throw new zzgi(e12, 2006);
        } catch (RuntimeException e13) {
            throw new zzgi(e13, 2000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    @Nullable
    public final Uri zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() throws zzgi {
        this.zzb = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.zza;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.zza = null;
                if (this.zzd) {
                    this.zzd = false;
                    zzh();
                }
            } catch (IOException e10) {
                throw new zzgi(e10, 2000);
            }
        } catch (Throwable th) {
            this.zza = null;
            if (this.zzd) {
                this.zzd = false;
                zzh();
            }
            throw th;
        }
    }
}
