package io.ktor.utils.io.internal;

import io.ktor.utils.io.internal.g;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ObjectPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f26836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f26837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f26838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final s8.g<ByteBuffer> f26839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final s8.g<g.c> f26840e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final s8.g<g.c> f26841f;

    /* JADX INFO: compiled from: ObjectPool.kt */
    public static final class a extends s8.f<g.c> {
        a() {
        }

        @Override // s8.g
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g.c k0() {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(e.a());
            t.h(byteBufferAllocateDirect, "allocateDirect(BUFFER_SIZE)");
            return new g.c(byteBufferAllocateDirect, 0, 2, null);
        }
    }

    /* JADX INFO: compiled from: ObjectPool.kt */
    public static final class b extends s8.d<g.c> {
        b(int i10) {
            super(i10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // s8.d
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public void n(@NotNull g.c instance) {
            t.i(instance, "instance");
            e.d().C0(instance.f26844a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // s8.d
        @NotNull
        /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
        public g.c x() {
            return new g.c(e.d().k0(), 0, 2, null);
        }
    }

    static {
        int iA = k.a("BufferSize", 4096);
        f26836a = iA;
        int iA2 = k.a("BufferPoolSize", 2048);
        f26837b = iA2;
        int iA3 = k.a("BufferObjectPoolSize", 1024);
        f26838c = iA3;
        f26839d = new s8.e(iA2, iA);
        f26840e = new b(iA3);
        f26841f = new a();
    }

    public static final int a() {
        return f26836a;
    }

    @NotNull
    public static final s8.g<g.c> b() {
        return f26841f;
    }

    @NotNull
    public static final s8.g<g.c> c() {
        return f26840e;
    }

    @NotNull
    public static final s8.g<ByteBuffer> d() {
        return f26839d;
    }
}
