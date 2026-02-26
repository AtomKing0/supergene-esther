package io.sentry;

import java.io.StringReader;
import java.nio.charset.Charset;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EnvelopeReader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class a0 implements t0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Charset f26973b = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final l1 f26974a;

    public a0(@NotNull l1 l1Var) {
        this.f26974a = l1Var;
    }

    @Nullable
    private q5 b(@NotNull byte[] bArr, int i10, int i11) {
        StringReader stringReader = new StringReader(new String(bArr, i10, i11, f26973b));
        try {
            q5 q5Var = (q5) this.f26974a.c(stringReader, q5.class);
            stringReader.close();
            return q5Var;
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Nullable
    private q6 c(@NotNull byte[] bArr, int i10, int i11) {
        StringReader stringReader = new StringReader(new String(bArr, i10, i11, f26973b));
        try {
            q6 q6Var = (q6) this.f26974a.c(stringReader, q6.class);
            stringReader.close();
            return q6Var;
        } catch (Throwable th) {
            try {
                stringReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0081, code lost:
    
        r11 = new io.sentry.p5(r0, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0086, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0089, code lost:
    
        return r11;
     */
    @Override // io.sentry.t0
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.sentry.p5 a(@org.jetbrains.annotations.NotNull java.io.InputStream r11) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.a0.a(java.io.InputStream):io.sentry.p5");
    }
}
