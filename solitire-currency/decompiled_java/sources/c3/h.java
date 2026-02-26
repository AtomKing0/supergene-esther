package c3;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SimpleMetadataDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class h implements c {
    @Override // c3.c
    @Nullable
    public final a a(e eVar) {
        ByteBuffer byteBuffer = (ByteBuffer) a4.a.e(eVar.f31586c);
        a4.a.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (eVar.g()) {
            return null;
        }
        return b(eVar, byteBuffer);
    }

    @Nullable
    protected abstract a b(e eVar, ByteBuffer byteBuffer);
}
