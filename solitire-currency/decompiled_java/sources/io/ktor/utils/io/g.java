package io.ktor.utils.io;

import java.nio.ByteBuffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ByteReadChannelJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f26800a = a.f26801a;

    /* JADX INFO: compiled from: ByteReadChannelJVM.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f26801a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private static final v8.l<c> f26802b = v8.n.a(C0575a.f26803g);

        /* JADX INFO: renamed from: io.ktor.utils.io.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ByteReadChannelJVM.kt */
        static final class C0575a extends kotlin.jvm.internal.v implements h9.a<c> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0575a f26803g = new C0575a();

            C0575a() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final c invoke() {
                c cVarC = e.c(false, 1, null);
                k.a(cVarC);
                return cVarC;
            }
        }

        private a() {
        }

        @NotNull
        public final g a() {
            return f26802b.getValue();
        }
    }

    /* JADX INFO: compiled from: ByteReadChannelJVM.kt */
    public static final class b {
        public static /* synthetic */ Object a(g gVar, long j10, z8.d dVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readRemaining");
            }
            if ((i10 & 1) != 0) {
                j10 = Long.MAX_VALUE;
            }
            return gVar.i(j10, dVar);
        }
    }

    boolean b(@Nullable Throwable th);

    @Nullable
    Throwable c();

    int f();

    @Nullable
    Object g(@NotNull byte[] bArr, int i10, int i11, @NotNull z8.d<? super Integer> dVar);

    @Nullable
    Object h(int i10, @NotNull h9.l<? super ByteBuffer, k0> lVar, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object i(long j10, @NotNull z8.d<? super p8.j> dVar);

    @Nullable
    Object k(@NotNull q8.a aVar, @NotNull z8.d<? super Integer> dVar);

    boolean m();
}
