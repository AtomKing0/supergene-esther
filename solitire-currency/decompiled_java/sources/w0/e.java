package w0;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import p0.b;
import w0.a;

/* JADX INFO: compiled from: DiskLruCacheWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f35292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f35293c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p0.b f35295e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f35294d = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f35291a = new j();

    @Deprecated
    protected e(File file, long j10) {
        this.f35292b = file;
        this.f35293c = j10;
    }

    public static a c(File file, long j10) {
        return new e(file, j10);
    }

    private synchronized p0.b d() throws IOException {
        if (this.f35295e == null) {
            this.f35295e = p0.b.J0(this.f35292b, 1, 1, this.f35293c);
        }
        return this.f35295e;
    }

    @Override // w0.a
    public File a(r0.f fVar) {
        String strB = this.f35291a.b(fVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strB + " for for Key: " + fVar);
        }
        try {
            b.e eVarG0 = d().G0(strB);
            if (eVarG0 != null) {
                return eVarG0.a(0);
            }
            return null;
        } catch (IOException e10) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e10);
            return null;
        }
    }

    @Override // w0.a
    public void b(r0.f fVar, a.b bVar) {
        p0.b bVarD;
        String strB = this.f35291a.b(fVar);
        this.f35294d.a(strB);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strB + " for for Key: " + fVar);
            }
            try {
                bVarD = d();
            } catch (IOException e10) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e10);
                }
            }
            if (bVarD.G0(strB) != null) {
                return;
            }
            b.c cVarW = bVarD.W(strB);
            if (cVarW == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + strB);
            }
            try {
                if (bVar.a(cVarW.f(0))) {
                    cVarW.e();
                }
                cVarW.b();
            } catch (Throwable th) {
                cVarW.b();
                throw th;
            }
        } finally {
            this.f35294d.b(strB);
        }
    }
}
