package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.datasource.RawResourceDataSource;
import com.unity3d.services.UnityAdsConstants;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgs extends zzfl {
    private final Context zza;

    @Nullable
    private zzfy zzb;

    @Nullable
    private AssetFileDescriptor zzc;

    @Nullable
    private InputStream zzd;
    private long zze;
    private boolean zzf;

    public zzgs(Context context) {
        super(false);
        this.zza = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i10) {
        return Uri.parse("rawresource:///" + i10);
    }

    private static int zzk(String str) throws zzgr {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new zzgr("Resource identifier must be an integer.", null, 1004);
        }
    }

    private static AssetFileDescriptor zzl(Context context, zzfy zzfyVar) throws zzgr {
        Resources resourcesForApplication;
        int identifier;
        Uri uriNormalizeScheme = zzfyVar.zza.normalizeScheme();
        if (TextUtils.equals(RawResourceDataSource.RAW_RESOURCE_SCHEME, uriNormalizeScheme.getScheme())) {
            resourcesForApplication = context.getResources();
            List<String> pathSegments = uriNormalizeScheme.getPathSegments();
            if (pathSegments.size() != 1) {
                throw new zzgr("rawresource:// URI must have exactly one path element, found " + pathSegments.size());
            }
            identifier = zzk(pathSegments.get(0));
        } else {
            if (!TextUtils.equals("android.resource", uriNormalizeScheme.getScheme())) {
                throw new zzgr("Unsupported URI scheme (" + uriNormalizeScheme.getScheme() + "). Only android.resource is supported.", null, 1004);
            }
            String path = uriNormalizeScheme.getPath();
            path.getClass();
            if (path.startsWith(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH)) {
                path = path.substring(1);
            }
            String packageName = TextUtils.isEmpty(uriNormalizeScheme.getHost()) ? context.getPackageName() : uriNormalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resourcesForApplication = context.getResources();
            } else {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e10) {
                    throw new zzgr("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e10, 2005);
                }
            }
            if (path.matches("\\d+")) {
                identifier = zzk(path);
            } else {
                identifier = resourcesForApplication.getIdentifier(packageName + ":" + path, "raw", null);
                if (identifier == 0) {
                    throw new zzgr("Resource not found.", null, 2005);
                }
            }
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resourcesForApplication.openRawResourceFd(identifier);
            if (assetFileDescriptorOpenRawResourceFd != null) {
                return assetFileDescriptorOpenRawResourceFd;
            }
            throw new zzgr("Resource is compressed: ".concat(String.valueOf(uriNormalizeScheme)), null, 2000);
        } catch (Resources.NotFoundException e11) {
            throw new zzgr(null, e11, 2005);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzp
    public final int zza(byte[] bArr, int i10, int i11) throws zzgr {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.zze;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, i11);
            } catch (IOException e10) {
                throw new zzgr(null, e10, 2000);
            }
        }
        InputStream inputStream = this.zzd;
        int i12 = zzet.zza;
        int i13 = inputStream.read(bArr, i10, i11);
        if (i13 == -1) {
            if (this.zze == -1) {
                return -1;
            }
            throw new zzgr("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j11 = this.zze;
        if (j11 != -1) {
            this.zze = j11 - ((long) i13);
        }
        zzg(i13);
        return i13;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final long zzb(zzfy zzfyVar) throws zzgr {
        long size;
        this.zzb = zzfyVar;
        zzi(zzfyVar);
        AssetFileDescriptor assetFileDescriptorZzl = zzl(this.zza, zzfyVar);
        this.zzc = assetFileDescriptorZzl;
        long length = assetFileDescriptorZzl.getLength();
        FileInputStream fileInputStream = new FileInputStream(this.zzc.getFileDescriptor());
        this.zzd = fileInputStream;
        if (length != -1) {
            try {
                if (zzfyVar.zze > length) {
                    throw new zzgr(null, null, 2008);
                }
            } catch (zzgr e10) {
                throw e10;
            } catch (IOException e11) {
                throw new zzgr(null, e11, 2000);
            }
        }
        long startOffset = this.zzc.getStartOffset();
        long jSkip = fileInputStream.skip(zzfyVar.zze + startOffset) - startOffset;
        if (jSkip != zzfyVar.zze) {
            throw new zzgr(null, null, 2008);
        }
        if (length == -1) {
            FileChannel channel = fileInputStream.getChannel();
            if (channel.size() == 0) {
                this.zze = -1L;
                size = -1;
            } else {
                size = channel.size() - channel.position();
                this.zze = size;
                if (size < 0) {
                    throw new zzgr(null, null, 2008);
                }
            }
        } else {
            size = length - jSkip;
            this.zze = size;
            if (size < 0) {
                throw new zzft(2008);
            }
        }
        long jMin = zzfyVar.zzf;
        if (jMin != -1) {
            if (size != -1) {
                jMin = Math.min(size, jMin);
            }
            this.zze = jMin;
        }
        this.zzf = true;
        zzj(zzfyVar);
        long j10 = zzfyVar.zzf;
        return j10 != -1 ? j10 : this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    @Nullable
    public final Uri zzc() {
        zzfy zzfyVar = this.zzb;
        if (zzfyVar != null) {
            return zzfyVar.zza;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzfs
    public final void zzd() throws zzgr {
        this.zzb = null;
        try {
            try {
                try {
                    InputStream inputStream = this.zzd;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    this.zzd = null;
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.zzc;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                        this.zzc = null;
                        if (this.zzf) {
                            this.zzf = false;
                            zzh();
                        }
                    } catch (IOException e10) {
                        throw new zzgr(null, e10, 2000);
                    }
                } catch (IOException e11) {
                    throw new zzgr(null, e11, 2000);
                }
            } catch (Throwable th) {
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzh();
                }
                throw th;
            }
        } catch (Throwable th2) {
            this.zzd = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.zzc;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzh();
                }
                throw th2;
            } catch (IOException e12) {
                throw new zzgr(null, e12, 2000);
            }
        }
    }
}
