package n8;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MemoryJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f31707a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final ByteBuffer f31708b;

    /* JADX INFO: compiled from: MemoryJvm.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }

        @NotNull
        public final ByteBuffer a() {
            return c.f31708b;
        }
    }

    static {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(0).order(ByteOrder.BIG_ENDIAN);
        t.h(byteBufferOrder, "allocate(0).order(ByteOrder.BIG_ENDIAN)");
        f31708b = b(byteBufferOrder);
    }

    @NotNull
    public static ByteBuffer b(@NotNull ByteBuffer buffer) {
        t.i(buffer, "buffer");
        return buffer;
    }

    public static final void c(ByteBuffer byteBuffer, @NotNull ByteBuffer destination, int i10, int i11, int i12) {
        t.i(destination, "destination");
        if (byteBuffer.hasArray() && destination.hasArray() && !byteBuffer.isReadOnly() && !destination.isReadOnly()) {
            System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + i10, destination.array(), destination.arrayOffset() + i12, i11);
            return;
        }
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position(i10);
        byteBufferDuplicate.limit(i10 + i11);
        ByteBuffer byteBufferDuplicate2 = destination.duplicate();
        byteBufferDuplicate2.position(i12);
        byteBufferDuplicate2.put(byteBufferDuplicate);
    }

    @NotNull
    public static final ByteBuffer d(ByteBuffer byteBuffer, int i10, int i11) {
        return b(d.d(byteBuffer, i10, i11));
    }
}
