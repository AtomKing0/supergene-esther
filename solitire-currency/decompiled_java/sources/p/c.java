package p;

import java.nio.ByteBuffer;
import m.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.i;
import v.n;

/* JADX INFO: compiled from: ByteBufferFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ByteBuffer f32339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final n f32340b;

    /* JADX INFO: compiled from: ByteBufferFetcher.kt */
    public static final class a implements i.a<ByteBuffer> {
        @Override // p.i.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(@NotNull ByteBuffer byteBuffer, @NotNull n nVar, @NotNull j.e eVar) {
            return new c(byteBuffer, nVar);
        }
    }

    public c(@NotNull ByteBuffer byteBuffer, @NotNull n nVar) {
        this.f32339a = byteBuffer;
        this.f32340b = nVar;
    }

    @Override // p.i
    @Nullable
    public Object a(@NotNull z8.d<? super h> dVar) {
        try {
            ua.c cVar = new ua.c();
            cVar.write(this.f32339a);
            this.f32339a.position(0);
            return new m(q.a(cVar, this.f32340b.g()), null, m.f.MEMORY);
        } catch (Throwable th) {
            this.f32339a.position(0);
            throw th;
        }
    }
}
