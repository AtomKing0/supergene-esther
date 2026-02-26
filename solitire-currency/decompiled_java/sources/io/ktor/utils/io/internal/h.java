package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ReadWriteBufferState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final ByteBuffer f26858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final i f26859b;

    static {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        t.h(byteBufferAllocate, "allocate(0)");
        f26858a = byteBufferAllocate;
        f26859b = new i(0);
    }

    @NotNull
    public static final ByteBuffer a() {
        return f26858a;
    }

    @NotNull
    public static final i b() {
        return f26859b;
    }
}
