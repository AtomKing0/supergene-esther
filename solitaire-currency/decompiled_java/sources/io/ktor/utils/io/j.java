package io.ktor.utils.io;

import java.nio.ByteBuffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ByteWriteChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface j {
    boolean d(@Nullable Throwable th);

    @Nullable
    Object e(@NotNull p8.a aVar, @NotNull z8.d<? super k0> dVar);

    void flush();

    @Nullable
    Object j(@NotNull ByteBuffer byteBuffer, @NotNull z8.d<? super k0> dVar);

    @Nullable
    Object l(@NotNull byte[] bArr, int i10, int i11, @NotNull z8.d<? super k0> dVar);

    boolean n();
}
