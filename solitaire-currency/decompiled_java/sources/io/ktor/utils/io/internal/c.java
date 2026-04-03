package io.ktor.utils.io.internal;

import io.ktor.utils.io.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ByteBufferChannelInternals.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f26830b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final c f26831c = new c(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Throwable f26832a;

    /* JADX INFO: compiled from: ByteBufferChannelInternals.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final c a() {
            return c.f26831c;
        }
    }

    public c(@Nullable Throwable th) {
        this.f26832a = th;
    }

    @Nullable
    public final Throwable b() {
        return this.f26832a;
    }

    @NotNull
    public final Throwable c() {
        Throwable th = this.f26832a;
        return th == null ? new p("The channel was closed") : th;
    }

    @NotNull
    public String toString() {
        return "Closed[" + c() + ']';
    }
}
