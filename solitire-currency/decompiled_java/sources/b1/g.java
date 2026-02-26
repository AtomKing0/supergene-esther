package b1;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferBitmapDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements r0.j<ByteBuffer, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q f1839a;

    public g(q qVar) {
        this.f1839a = qVar;
    }

    @Override // r0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public u0.v<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i10, int i11, @NonNull r0.h hVar) throws IOException {
        return this.f1839a.d(o1.a.f(byteBuffer), i10, i11, hVar);
    }

    @Override // r0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull r0.h hVar) {
        return this.f1839a.n(byteBuffer);
    }
}
