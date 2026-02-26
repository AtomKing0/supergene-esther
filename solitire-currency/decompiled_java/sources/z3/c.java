package z3;

import a4.o0;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.unity3d.services.UnityAdsConstants;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: AssetDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AssetManager f37369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Uri f37370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private InputStream f37371g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f37372h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f37373i;

    /* JADX INFO: compiled from: AssetDataSource.java */
    public static final class a extends l {
        public a(@Nullable Throwable th, int i10) {
            super(th, i10);
        }
    }

    public c(Context context) {
        super(false);
        this.f37369e = context.getAssets();
    }

    @Override // z3.k
    public long a(o oVar) throws a {
        try {
            Uri uri = oVar.f37463a;
            this.f37370f = uri;
            String strSubstring = (String) a4.a.e(uri.getPath());
            if (strSubstring.startsWith("/android_asset/")) {
                strSubstring = strSubstring.substring(15);
            } else if (strSubstring.startsWith(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH)) {
                strSubstring = strSubstring.substring(1);
            }
            e(oVar);
            InputStream inputStreamOpen = this.f37369e.open(strSubstring, 1);
            this.f37371g = inputStreamOpen;
            if (inputStreamOpen.skip(oVar.f37469g) < oVar.f37469g) {
                throw new a(null, 2008);
            }
            long j10 = oVar.f37470h;
            if (j10 != -1) {
                this.f37372h = j10;
            } else {
                long jAvailable = this.f37371g.available();
                this.f37372h = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.f37372h = -1L;
                }
            }
            this.f37373i = true;
            f(oVar);
            return this.f37372h;
        } catch (a e10) {
            throw e10;
        } catch (IOException e11) {
            throw new a(e11, e11 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // z3.k
    public void close() throws a {
        this.f37370f = null;
        try {
            try {
                InputStream inputStream = this.f37371g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e10) {
                throw new a(e10, 2000);
            }
        } finally {
            this.f37371g = null;
            if (this.f37373i) {
                this.f37373i = false;
                d();
            }
        }
    }

    @Override // z3.k
    @Nullable
    public Uri getUri() {
        return this.f37370f;
    }

    @Override // z3.h
    public int read(byte[] bArr, int i10, int i11) throws a {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f37372h;
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
        int i12 = ((InputStream) o0.j(this.f37371g)).read(bArr, i10, i11);
        if (i12 == -1) {
            return -1;
        }
        long j11 = this.f37372h;
        if (j11 != -1) {
            this.f37372h = j11 - ((long) i12);
        }
        c(i12);
        return i12;
    }
}
