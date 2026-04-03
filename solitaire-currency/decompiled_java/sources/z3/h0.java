package z3;

import a4.o0;
import android.content.Context;
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

/* JADX INFO: compiled from: RawResourceDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Resources f37420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f37421f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Uri f37422g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private AssetFileDescriptor f37423h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private InputStream f37424i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f37425j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f37426k;

    /* JADX INFO: compiled from: RawResourceDataSource.java */
    public static class a extends l {
        public a(@Nullable String str, @Nullable Throwable th, int i10) {
            super(str, th, i10);
        }
    }

    public h0(Context context) {
        super(false);
        this.f37420e = context.getResources();
        this.f37421f = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i10) {
        return Uri.parse("rawresource:///" + i10);
    }

    @Override // z3.k
    public long a(o oVar) throws a {
        int identifier;
        String str;
        Uri uri = oVar.f37463a;
        this.f37422g = uri;
        if (TextUtils.equals(RawResourceDataSource.RAW_RESOURCE_SCHEME, uri.getScheme()) || (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) a4.a.e(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                identifier = Integer.parseInt((String) a4.a.e(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new a("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", uri.getScheme())) {
                throw new a("URI must either use scheme rawresource or android.resource", null, 1004);
            }
            String strSubstring = (String) a4.a.e(uri.getPath());
            if (strSubstring.startsWith(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH)) {
                strSubstring = strSubstring.substring(1);
            }
            String host = uri.getHost();
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(host)) {
                str = "";
            } else {
                str = host + ":";
            }
            sb.append(str);
            sb.append(strSubstring);
            identifier = this.f37420e.getIdentifier(sb.toString(), "raw", this.f37421f);
            if (identifier == 0) {
                throw new a("Resource not found.", null, 2005);
            }
        }
        e(oVar);
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = this.f37420e.openRawResourceFd(identifier);
            this.f37423h = assetFileDescriptorOpenRawResourceFd;
            if (assetFileDescriptorOpenRawResourceFd == null) {
                throw new a("Resource is compressed: " + uri, null, 2000);
            }
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenRawResourceFd.getFileDescriptor());
            this.f37424i = fileInputStream;
            if (length != -1) {
                try {
                    if (oVar.f37469g > length) {
                        throw new a(null, null, 2008);
                    }
                } catch (a e10) {
                    throw e10;
                } catch (IOException e11) {
                    throw new a(null, e11, 2000);
                }
            }
            long startOffset = assetFileDescriptorOpenRawResourceFd.getStartOffset();
            long jSkip = fileInputStream.skip(oVar.f37469g + startOffset) - startOffset;
            if (jSkip != oVar.f37469g) {
                throw new a(null, null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.f37425j = -1L;
                } else {
                    long size = channel.size() - channel.position();
                    this.f37425j = size;
                    if (size < 0) {
                        throw new a(null, null, 2008);
                    }
                }
            } else {
                long j10 = length - jSkip;
                this.f37425j = j10;
                if (j10 < 0) {
                    throw new l(2008);
                }
            }
            long jMin = oVar.f37470h;
            if (jMin != -1) {
                long j11 = this.f37425j;
                if (j11 != -1) {
                    jMin = Math.min(j11, jMin);
                }
                this.f37425j = jMin;
            }
            this.f37426k = true;
            f(oVar);
            long j12 = oVar.f37470h;
            return j12 != -1 ? j12 : this.f37425j;
        } catch (Resources.NotFoundException e12) {
            throw new a(null, e12, 2005);
        }
    }

    @Override // z3.k
    public void close() throws a {
        this.f37422g = null;
        try {
            try {
                InputStream inputStream = this.f37424i;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f37424i = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f37423h;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.f37423h = null;
                        if (this.f37426k) {
                            this.f37426k = false;
                            d();
                        }
                    }
                } catch (IOException e10) {
                    throw new a(null, e10, 2000);
                }
            } catch (IOException e11) {
                throw new a(null, e11, 2000);
            }
        } catch (Throwable th) {
            this.f37424i = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f37423h;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f37423h = null;
                    if (this.f37426k) {
                        this.f37426k = false;
                        d();
                    }
                    throw th;
                } catch (IOException e12) {
                    throw new a(null, e12, 2000);
                }
            } finally {
                this.f37423h = null;
                if (this.f37426k) {
                    this.f37426k = false;
                    d();
                }
            }
        }
    }

    @Override // z3.k
    @Nullable
    public Uri getUri() {
        return this.f37422g;
    }

    @Override // z3.h
    public int read(byte[] bArr, int i10, int i11) throws a {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f37425j;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, i11);
            } catch (IOException e10) {
                throw new a(null, e10, 2000);
            }
        }
        int i12 = ((InputStream) o0.j(this.f37424i)).read(bArr, i10, i11);
        if (i12 == -1) {
            if (this.f37425j == -1) {
                return -1;
            }
            throw new a("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j11 = this.f37425j;
        if (j11 != -1) {
            this.f37425j = j11 - ((long) i12);
        }
        c(i12);
        return i12;
    }
}
