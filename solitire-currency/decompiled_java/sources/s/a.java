package s;

import java.nio.ByteBuffer;
import org.jetbrains.annotations.NotNull;
import v.n;

/* JADX INFO: compiled from: ByteArrayMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements d<byte[], ByteBuffer> {
    @Override // s.d
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a(@NotNull byte[] bArr, @NotNull n nVar) {
        return ByteBuffer.wrap(bArr);
    }
}
