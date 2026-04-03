package io.ktor.utils.io;

import java.nio.ByteBuffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ByteChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: compiled from: ByteChannel.kt */
    public static final class a extends io.ktor.utils.io.a {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final /* synthetic */ h9.l<Throwable, Throwable> f26739q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(boolean z10, h9.l<? super Throwable, ? extends Throwable> lVar) {
            super(z10, null, 0, 6, null);
            this.f26739q = lVar;
        }

        @Override // io.ktor.utils.io.a, io.ktor.utils.io.j
        public boolean d(@Nullable Throwable th) {
            return super.d(this.f26739q.invoke(th));
        }
    }

    @NotNull
    public static final c a(boolean z10) {
        return new io.ktor.utils.io.a(z10, null, 0, 6, null);
    }

    @NotNull
    public static final c b(boolean z10, @NotNull h9.l<? super Throwable, ? extends Throwable> exceptionMapper) {
        kotlin.jvm.internal.t.i(exceptionMapper, "exceptionMapper");
        return new a(z10, exceptionMapper);
    }

    public static /* synthetic */ c c(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return a(z10);
    }

    public static /* synthetic */ c d(boolean z10, h9.l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return b(z10, lVar);
    }

    @NotNull
    public static final g e(@NotNull byte[] content, int i10, int i11) {
        kotlin.jvm.internal.t.i(content, "content");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(content, i10, i11);
        kotlin.jvm.internal.t.h(byteBufferWrap, "wrap(content, offset, length)");
        return new io.ktor.utils.io.a(byteBufferWrap);
    }
}
