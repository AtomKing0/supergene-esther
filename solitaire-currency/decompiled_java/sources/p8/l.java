package p8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BufferFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends s8.d<q8.a> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f32932h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final n8.a f32933i;

    public /* synthetic */ l(int i10, int i11, n8.a aVar, int i12, kotlin.jvm.internal.k kVar) {
        this((i12 & 1) != 0 ? 4096 : i10, (i12 & 2) != 0 ? 1000 : i11, (i12 & 4) != 0 ? n8.b.f31706a : aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s8.d
    @NotNull
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public q8.a i(@NotNull q8.a instance) {
        t.i(instance, "instance");
        q8.a aVar = (q8.a) super.i(instance);
        aVar.E();
        aVar.q();
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s8.d
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull q8.a instance) {
        t.i(instance, "instance");
        this.f32933i.a(instance.g());
        super.n(instance);
        instance.D();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s8.d
    @NotNull
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public q8.a x() {
        return new q8.a(this.f32933i.b(this.f32932h), null, this, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s8.d
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public void L(@NotNull q8.a instance) {
        t.i(instance, "instance");
        super.L(instance);
        if (!(((long) instance.g().limit()) == ((long) this.f32932h))) {
            StringBuilder sb = new StringBuilder();
            sb.append("Buffer size mismatch. Expected: ");
            sb.append(this.f32932h);
            sb.append(", actual: ");
            sb.append(instance.g().limit());
            throw new IllegalStateException(sb.toString().toString());
        }
        if (!(instance != q8.a.f33167j.a())) {
            throw new IllegalStateException("ChunkBuffer.Empty couldn't be recycled".toString());
        }
        if (!(instance != a.f32920g.a())) {
            throw new IllegalStateException("Empty instance couldn't be recycled".toString());
        }
        if (!(instance.z() == 0)) {
            throw new IllegalStateException("Unable to clear buffer: it is still in use.".toString());
        }
        if (!(instance.x() == null)) {
            throw new IllegalStateException("Recycled instance shouldn't be a part of a chain.".toString());
        }
        if (!(instance.y() == null)) {
            throw new IllegalStateException("Recycled instance shouldn't be a view or another buffer.".toString());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(int i10, int i11, @NotNull n8.a allocator) {
        super(i11);
        t.i(allocator, "allocator");
        this.f32932h = i10;
        this.f32933i = allocator;
    }
}
