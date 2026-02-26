package io.sentry;

import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ObjectWriter.java */
/* JADX INFO: loaded from: classes5.dex */
public interface m3 {
    m3 a(long j10) throws IOException;

    m3 b(double d10) throws IOException;

    m3 c(boolean z10) throws IOException;

    m3 d() throws IOException;

    m3 e(@NotNull String str) throws IOException;

    m3 f() throws IOException;

    m3 g(@Nullable String str) throws IOException;

    m3 h() throws IOException;

    @Nullable
    String i();

    void j(boolean z10);

    m3 k() throws IOException;

    m3 l(@Nullable String str) throws IOException;

    void m(@Nullable String str);

    m3 n(@Nullable Number number) throws IOException;

    m3 o(@NotNull w0 w0Var, @Nullable Object obj) throws IOException;

    m3 p(@Nullable Boolean bool) throws IOException;

    m3 q() throws IOException;
}
