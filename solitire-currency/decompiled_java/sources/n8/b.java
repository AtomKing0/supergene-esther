package n8;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MemoryFactoryJvm.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f31706a = new b();

    private b() {
    }

    @Override // n8.a
    public void a(@NotNull ByteBuffer instance) {
        t.i(instance, "instance");
    }

    @Override // n8.a
    @NotNull
    public ByteBuffer b(int i10) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i10);
        t.h(byteBufferAllocate, "allocate(size)");
        return c.b(byteBufferAllocate);
    }
}
