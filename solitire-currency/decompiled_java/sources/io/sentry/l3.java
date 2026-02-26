package io.sentry;

import java.io.Closeable;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ObjectReader.java */
/* JADX INFO: loaded from: classes5.dex */
public interface l3 extends Closeable {
    @Nullable
    Double A() throws IOException;

    @Nullable
    Object A0() throws IOException;

    @NotNull
    String C() throws IOException;

    @Nullable
    <T> List<T> D0(@NotNull w0 w0Var, @NotNull x1<T> x1Var) throws IOException;

    @Nullable
    Date F(w0 w0Var) throws IOException;

    @Nullable
    Boolean H() throws IOException;

    @Nullable
    <T> T M(@NotNull w0 w0Var, @NotNull x1<T> x1Var) throws Exception;

    String e0() throws IOException;

    @Nullable
    Integer g0() throws IOException;

    void h() throws IOException;

    void j(boolean z10);

    @Nullable
    Long j0() throws IOException;

    void k() throws IOException;

    double nextDouble() throws IOException;

    float nextFloat() throws IOException;

    int nextInt() throws IOException;

    long nextLong() throws IOException;

    @Nullable
    String o0() throws IOException;

    void p() throws IOException;

    @NotNull
    io.sentry.vendor.gson.stream.b peek() throws IOException;

    @Nullable
    <T> Map<String, T> q0(@NotNull w0 w0Var, @NotNull x1<T> x1Var) throws IOException;

    void r0(w0 w0Var, Map<String, Object> map, String str);

    @Nullable
    TimeZone t(w0 w0Var) throws IOException;

    @Nullable
    Float x0() throws IOException;
}
