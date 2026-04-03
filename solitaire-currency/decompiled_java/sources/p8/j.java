package p8;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.a;

/* JADX INFO: compiled from: ByteReadPacket.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends m {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f32928i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final j f32929j;

    /* JADX INFO: compiled from: ByteReadPacket.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final j a() {
            return j.f32929j;
        }
    }

    static {
        a.d dVar = q8.a.f33167j;
        f32929j = new j(dVar.a(), 0L, dVar.b());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull q8.a head, long j10, @NotNull s8.g<q8.a> pool) {
        super(head, j10, pool);
        t.i(head, "head");
        t.i(pool, "pool");
        Q0();
    }

    @Override // p8.m
    @Nullable
    protected final q8.a W() {
        return null;
    }

    @Override // p8.m
    protected final int h0(@NotNull ByteBuffer destination, int i10, int i11) {
        t.i(destination, "destination");
        return 0;
    }

    @NotNull
    public String toString() {
        return "ByteReadPacket[" + hashCode() + ']';
    }

    @Override // p8.m
    protected final void x() {
    }
}
