package z3;

import a4.o0;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: ContentDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ContentResolver f37394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Uri f37395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private AssetFileDescriptor f37396g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private FileInputStream f37397h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f37398i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f37399j;

    /* JADX INFO: compiled from: ContentDataSource.java */
    public static class a extends l {
        public a(@Nullable IOException iOException, int i10) {
            super(iOException, i10);
        }
    }

    public g(Context context) {
        super(false);
        this.f37394e = context.getContentResolver();
    }

    @Override // z3.k
    public long a(o oVar) throws a {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        try {
            Uri uri = oVar.f37463a;
            this.f37395f = uri;
            e(oVar);
            if ("content".equals(oVar.f37463a.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptorOpenAssetFileDescriptor = this.f37394e.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                assetFileDescriptorOpenAssetFileDescriptor = this.f37394e.openAssetFileDescriptor(uri, AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
            }
            this.f37396g = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new a(new IOException("Could not open file descriptor for: " + uri), 2000);
            }
            long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
            this.f37397h = fileInputStream;
            if (length != -1 && oVar.f37469g > length) {
                throw new a(null, 2008);
            }
            long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
            long jSkip = fileInputStream.skip(oVar.f37469g + startOffset) - startOffset;
            if (jSkip != oVar.f37469g) {
                throw new a(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f37398i = -1L;
                } else {
                    long jPosition = size - channel.position();
                    this.f37398i = jPosition;
                    if (jPosition < 0) {
                        throw new a(null, 2008);
                    }
                }
            } else {
                long j10 = length - jSkip;
                this.f37398i = j10;
                if (j10 < 0) {
                    throw new a(null, 2008);
                }
            }
            long jMin = oVar.f37470h;
            if (jMin != -1) {
                long j11 = this.f37398i;
                if (j11 != -1) {
                    jMin = Math.min(j11, jMin);
                }
                this.f37398i = jMin;
            }
            this.f37399j = true;
            f(oVar);
            long j12 = oVar.f37470h;
            return j12 != -1 ? j12 : this.f37398i;
        } catch (a e10) {
            throw e10;
        } catch (IOException e11) {
            throw new a(e11, e11 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // z3.k
    public void close() throws a {
        this.f37395f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f37397h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f37397h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f37396g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.f37396g = null;
                        if (this.f37399j) {
                            this.f37399j = false;
                            d();
                        }
                    }
                } catch (IOException e10) {
                    throw new a(e10, 2000);
                }
            } catch (IOException e11) {
                throw new a(e11, 2000);
            }
        } catch (Throwable th) {
            this.f37397h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f37396g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f37396g = null;
                    if (this.f37399j) {
                        this.f37399j = false;
                        d();
                    }
                    throw th;
                } catch (IOException e12) {
                    throw new a(e12, 2000);
                }
            } finally {
                this.f37396g = null;
                if (this.f37399j) {
                    this.f37399j = false;
                    d();
                }
            }
        }
    }

    @Override // z3.k
    @Nullable
    public Uri getUri() {
        return this.f37395f;
    }

    @Override // z3.h
    public int read(byte[] bArr, int i10, int i11) throws a {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f37398i;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, i11);
            } catch (IOException e10) {
                throw new a(e10, 2000);
            }
        }
        int i12 = ((FileInputStream) o0.j(this.f37397h)).read(bArr, i10, i11);
        if (i12 == -1) {
            return -1;
        }
        long j11 = this.f37398i;
        if (j11 != -1) {
            this.f37398i = j11 - ((long) i12);
        }
        c(i12);
        return i12;
    }
}
