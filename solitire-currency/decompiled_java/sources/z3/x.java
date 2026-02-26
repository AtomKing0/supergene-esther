package z3;

import a4.o0;
import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: compiled from: FileDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private RandomAccessFile f37558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Uri f37559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f37560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f37561h;

    /* JADX INFO: compiled from: FileDataSource.java */
    @RequiresApi(21)
    private static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        @DoNotInline
        public static boolean b(@Nullable Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }

    /* JADX INFO: compiled from: FileDataSource.java */
    public static class b extends l {
        public b(Throwable th, int i10) {
            super(th, i10);
        }

        public b(@Nullable String str, @Nullable Throwable th, int i10) {
            super(str, th, i10);
        }
    }

    public x() {
        super(false);
    }

    private static RandomAccessFile g(Uri uri) throws b {
        try {
            return new RandomAccessFile((String) a4.a.e(uri.getPath()), AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ);
        } catch (FileNotFoundException e10) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new b(e10, (o0.f214a < 21 || !a.b(e10.getCause())) ? 2005 : 2006);
            }
            throw new b(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e10, 1004);
        } catch (SecurityException e11) {
            throw new b(e11, 2006);
        } catch (RuntimeException e12) {
            throw new b(e12, 2000);
        }
    }

    @Override // z3.k
    public long a(o oVar) throws b {
        Uri uri = oVar.f37463a;
        this.f37559f = uri;
        e(oVar);
        RandomAccessFile randomAccessFileG = g(uri);
        this.f37558e = randomAccessFileG;
        try {
            randomAccessFileG.seek(oVar.f37469g);
            long length = oVar.f37470h;
            if (length == -1) {
                length = this.f37558e.length() - oVar.f37469g;
            }
            this.f37560g = length;
            if (length < 0) {
                throw new b(null, null, 2008);
            }
            this.f37561h = true;
            f(oVar);
            return this.f37560g;
        } catch (IOException e10) {
            throw new b(e10, 2000);
        }
    }

    @Override // z3.k
    public void close() throws b {
        this.f37559f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f37558e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e10) {
                throw new b(e10, 2000);
            }
        } finally {
            this.f37558e = null;
            if (this.f37561h) {
                this.f37561h = false;
                d();
            }
        }
    }

    @Override // z3.k
    @Nullable
    public Uri getUri() {
        return this.f37559f;
    }

    @Override // z3.h
    public int read(byte[] bArr, int i10, int i11) throws b {
        if (i11 == 0) {
            return 0;
        }
        if (this.f37560g == 0) {
            return -1;
        }
        try {
            int i12 = ((RandomAccessFile) o0.j(this.f37558e)).read(bArr, i10, (int) Math.min(this.f37560g, i11));
            if (i12 > 0) {
                this.f37560g -= (long) i12;
                c(i12);
            }
            return i12;
        } catch (IOException e10) {
            throw new b(e10, 2000);
        }
    }
}
