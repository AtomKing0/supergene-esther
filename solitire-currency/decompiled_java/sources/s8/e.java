package s8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ByteBufferPools.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends d<ByteBuffer> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f33640h;

    public e(int i10, int i11) {
        super(i10);
        this.f33640h = i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s8.d
    @NotNull
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public ByteBuffer i(@NotNull ByteBuffer instance) {
        t.i(instance, "instance");
        instance.clear();
        instance.order(ByteOrder.BIG_ENDIAN);
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s8.d
    @NotNull
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public ByteBuffer x() {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.f33640h);
        t.f(byteBufferAllocateDirect);
        return byteBufferAllocateDirect;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s8.d
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public void L(@NotNull ByteBuffer instance) {
        t.i(instance, "instance");
        if (!(instance.capacity() == this.f33640h)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!instance.isDirect()) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }
}
