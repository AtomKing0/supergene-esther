package l3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IcyDataSource.java */
/* JADX INFO: loaded from: classes2.dex */
final class s implements z3.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z3.k f30688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f30689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f30690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f30691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f30692e;

    /* JADX INFO: compiled from: IcyDataSource.java */
    public interface a {
        void a(a4.c0 c0Var);
    }

    public s(z3.k kVar, int i10, a aVar) {
        a4.a.a(i10 > 0);
        this.f30688a = kVar;
        this.f30689b = i10;
        this.f30690c = aVar;
        this.f30691d = new byte[1];
        this.f30692e = i10;
    }

    private boolean c() throws IOException {
        if (this.f30688a.read(this.f30691d, 0, 1) == -1) {
            return false;
        }
        int i10 = (this.f30691d[0] & 255) << 4;
        if (i10 == 0) {
            return true;
        }
        byte[] bArr = new byte[i10];
        int i11 = i10;
        int i12 = 0;
        while (i11 > 0) {
            int i13 = this.f30688a.read(bArr, i12, i11);
            if (i13 == -1) {
                return false;
            }
            i12 += i13;
            i11 -= i13;
        }
        while (i10 > 0 && bArr[i10 - 1] == 0) {
            i10--;
        }
        if (i10 > 0) {
            this.f30690c.a(new a4.c0(bArr, i10));
        }
        return true;
    }

    @Override // z3.k
    public long a(z3.o oVar) {
        throw new UnsupportedOperationException();
    }

    @Override // z3.k
    public void b(z3.m0 m0Var) {
        a4.a.e(m0Var);
        this.f30688a.b(m0Var);
    }

    @Override // z3.k
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // z3.k
    public Map<String, List<String>> getResponseHeaders() {
        return this.f30688a.getResponseHeaders();
    }

    @Override // z3.k
    @Nullable
    public Uri getUri() {
        return this.f30688a.getUri();
    }

    @Override // z3.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f30692e == 0) {
            if (!c()) {
                return -1;
            }
            this.f30692e = this.f30689b;
        }
        int i12 = this.f30688a.read(bArr, i10, Math.min(this.f30692e, i11));
        if (i12 != -1) {
            this.f30692e -= i12;
        }
        return i12;
    }
}
