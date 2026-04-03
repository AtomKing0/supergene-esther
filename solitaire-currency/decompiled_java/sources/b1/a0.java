package b1;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import b1.q;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: StreamBitmapDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class a0 implements r0.j<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f1813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v0.b f1814b;

    /* JADX INFO: compiled from: StreamBitmapDecoder.java */
    static class a implements q.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final y f1815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final o1.d f1816b;

        a(y yVar, o1.d dVar) {
            this.f1815a = yVar;
            this.f1816b = dVar;
        }

        @Override // b1.q.b
        public void a(v0.d dVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionA = this.f1816b.a();
            if (iOExceptionA != null) {
                if (bitmap == null) {
                    throw iOExceptionA;
                }
                dVar.c(bitmap);
                throw iOExceptionA;
            }
        }

        @Override // b1.q.b
        public void b() {
            this.f1815a.c();
        }
    }

    public a0(q qVar, v0.b bVar) {
        this.f1813a = qVar;
        this.f1814b = bVar;
    }

    @Override // r0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public u0.v<Bitmap> b(@NonNull InputStream inputStream, int i10, int i11, @NonNull r0.h hVar) throws IOException {
        boolean z10;
        y yVar;
        if (inputStream instanceof y) {
            yVar = (y) inputStream;
            z10 = false;
        } else {
            z10 = true;
            yVar = new y(inputStream, this.f1814b);
        }
        o1.d dVarC = o1.d.c(yVar);
        try {
            return this.f1813a.e(new o1.h(dVarC), i10, i11, hVar, new a(yVar, dVarC));
        } finally {
            dVarC.release();
            if (z10) {
                yVar.release();
            }
        }
    }

    @Override // r0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull r0.h hVar) {
        return this.f1813a.m(inputStream);
    }
}
