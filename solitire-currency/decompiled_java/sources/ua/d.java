package ua;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BufferedSink.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface d extends x0, WritableByteChannel {
    @NotNull
    d E(@NotNull String str) throws IOException;

    @NotNull
    d I(@NotNull f fVar) throws IOException;

    @NotNull
    d b0(long j10) throws IOException;

    @Override // ua.x0, java.io.Flushable
    void flush() throws IOException;

    @NotNull
    c g();

    @NotNull
    d o() throws IOException;

    long s(@NotNull z0 z0Var) throws IOException;

    @NotNull
    d v0(long j10) throws IOException;

    @NotNull
    d w() throws IOException;

    @NotNull
    d write(@NotNull byte[] bArr) throws IOException;

    @NotNull
    d write(@NotNull byte[] bArr, int i10, int i11) throws IOException;

    @NotNull
    d writeByte(int i10) throws IOException;

    @NotNull
    d writeInt(int i10) throws IOException;

    @NotNull
    d writeShort(int i10) throws IOException;
}
