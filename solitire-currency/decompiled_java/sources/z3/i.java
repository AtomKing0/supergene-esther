package z3;

import a4.o0;
import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.URLDecoder;
import k2.j2;

/* JADX INFO: compiled from: DataSchemeDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private o f37427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private byte[] f37428f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f37429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f37430h;

    public i() {
        super(false);
    }

    @Override // z3.k
    public long a(o oVar) throws IOException {
        e(oVar);
        this.f37427e = oVar;
        Uri uri = oVar.f37463a;
        String scheme = uri.getScheme();
        a4.a.b("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] strArrH0 = o0.H0(uri.getSchemeSpecificPart(), ",");
        if (strArrH0.length != 2) {
            throw j2.b("Unexpected URI format: " + uri, null);
        }
        String str = strArrH0[1];
        if (strArrH0[0].contains(";base64")) {
            try {
                this.f37428f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e10) {
                throw j2.b("Error while parsing Base64 encoded string: " + str, e10);
            }
        } else {
            this.f37428f = o0.h0(URLDecoder.decode(str, e5.e.f25138a.name()));
        }
        long j10 = oVar.f37469g;
        byte[] bArr = this.f37428f;
        if (j10 > bArr.length) {
            this.f37428f = null;
            throw new l(2008);
        }
        int i10 = (int) j10;
        this.f37429g = i10;
        int length = bArr.length - i10;
        this.f37430h = length;
        long j11 = oVar.f37470h;
        if (j11 != -1) {
            this.f37430h = (int) Math.min(length, j11);
        }
        f(oVar);
        long j12 = oVar.f37470h;
        return j12 != -1 ? j12 : this.f37430h;
    }

    @Override // z3.k
    public void close() {
        if (this.f37428f != null) {
            this.f37428f = null;
            d();
        }
        this.f37427e = null;
    }

    @Override // z3.k
    @Nullable
    public Uri getUri() {
        o oVar = this.f37427e;
        if (oVar != null) {
            return oVar.f37463a;
        }
        return null;
    }

    @Override // z3.h
    public int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        int i12 = this.f37430h;
        if (i12 == 0) {
            return -1;
        }
        int iMin = Math.min(i11, i12);
        System.arraycopy(o0.j(this.f37428f), this.f37429g, bArr, i10, iMin);
        this.f37429g += iMin;
        this.f37430h -= iMin;
        c(iMin);
        return iMin;
    }
}
