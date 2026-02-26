package ua;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BufferedSource.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface e extends z0, ReadableByteChannel {
    long E0() throws IOException;

    @NotNull
    InputStream F0();

    boolean K(long j10) throws IOException;

    @NotNull
    String N() throws IOException;

    @NotNull
    byte[] P(long j10) throws IOException;

    short T() throws IOException;

    long U() throws IOException;

    long V(@NotNull x0 x0Var) throws IOException;

    int X(@NotNull n0 n0Var) throws IOException;

    void a0(long j10) throws IOException;

    @NotNull
    String d0(long j10) throws IOException;

    @NotNull
    f f0(long j10) throws IOException;

    @NotNull
    c g();

    @NotNull
    byte[] l0() throws IOException;

    boolean m0() throws IOException;

    long p0() throws IOException;

    @NotNull
    e peek();

    byte readByte() throws IOException;

    int readInt() throws IOException;

    short readShort() throws IOException;

    @NotNull
    String s0(@NotNull Charset charset) throws IOException;

    void skip(long j10) throws IOException;

    @NotNull
    f w0() throws IOException;

    @NotNull
    String y(long j10) throws IOException;

    int y0() throws IOException;
}
