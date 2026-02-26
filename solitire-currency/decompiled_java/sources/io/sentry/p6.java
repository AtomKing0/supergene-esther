package io.sentry;

import com.ironsource.nb;
import io.sentry.protocol.SentryTransaction;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryEnvelopeItem.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class p6 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Charset f28045d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q6 f28046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Callable<byte[]> f28047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private byte[] f28048c;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SentryEnvelopeItem.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private byte[] f28049a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final Callable<byte[]> f28050b;

        public a(@Nullable Callable<byte[]> callable) {
            this.f28050b = callable;
        }

        @NotNull
        private static byte[] b(@Nullable byte[] bArr) {
            return bArr != null ? bArr : new byte[0];
        }

        @NotNull
        public byte[] a() throws Exception {
            Callable<byte[]> callable;
            if (this.f28049a == null && (callable = this.f28050b) != null) {
                this.f28049a = callable.call();
            }
            return b(this.f28049a);
        }
    }

    p6(@NotNull q6 q6Var, byte[] bArr) {
        this.f28046a = (q6) io.sentry.util.w.c(q6Var, "SentryEnvelopeItemHeader is required.");
        this.f28048c = bArr;
        this.f28047b = null;
    }

    @NotNull
    public static p6 A(@NotNull final l1 l1Var, @NotNull final io.sentry.clientreport.c cVar) throws IOException {
        io.sentry.util.w.c(l1Var, "ISerializer is required.");
        io.sentry.util.w.c(cVar, "ClientReport is required.");
        final a aVar = new a(new Callable() { // from class: io.sentry.a6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.P(l1Var, cVar);
            }
        });
        return new p6(new q6(b7.resolve(cVar), new Callable() { // from class: io.sentry.b6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.Q(aVar);
            }
        }, nb.L, null), (Callable<byte[]>) new Callable() { // from class: io.sentry.d6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    @NotNull
    public static p6 B(@NotNull final l1 l1Var, @NotNull final i5 i5Var) {
        io.sentry.util.w.c(l1Var, "ISerializer is required.");
        io.sentry.util.w.c(i5Var, "SentryEvent is required.");
        final a aVar = new a(new Callable() { // from class: io.sentry.i6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.S(l1Var, i5Var);
            }
        });
        return new p6(new q6(b7.resolve(i5Var), new Callable() { // from class: io.sentry.j6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.T(aVar);
            }
        }, nb.L, null), (Callable<byte[]>) new Callable() { // from class: io.sentry.k6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public static p6 C(@NotNull final l1 l1Var, @NotNull final f7 f7Var) {
        io.sentry.util.w.c(l1Var, "ISerializer is required.");
        io.sentry.util.w.c(f7Var, "SentryLogEvents is required.");
        final a aVar = new a(new Callable() { // from class: io.sentry.e6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.V(l1Var, f7Var);
            }
        });
        return new p6(new q6(b7.Log, (Callable<Integer>) new Callable() { // from class: io.sentry.f6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.W(aVar);
            }
        }, "application/vnd.sentry.items.log+json", (String) null, (String) null, (String) null, Integer.valueOf(f7Var.a().size())), (Callable<byte[]>) new Callable() { // from class: io.sentry.g6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    @NotNull
    public static p6 D(@NotNull final t3 t3Var, @NotNull final l1 l1Var) throws io.sentry.exception.c {
        final File fileO = t3Var.o();
        final a aVar = new a(new Callable() { // from class: io.sentry.o6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.Y(fileO, t3Var, l1Var);
            }
        });
        return new p6(new q6(b7.ProfileChunk, (Callable<Integer>) new Callable() { // from class: io.sentry.s5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.Z(aVar);
            }
        }, "application-json", fileO.getName(), (String) null, t3Var.n(), (Integer) null), (Callable<byte[]>) new Callable() { // from class: io.sentry.t5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    @NotNull
    public static p6 E(@NotNull final x3 x3Var, final long j10, @NotNull final l1 l1Var) throws io.sentry.exception.c {
        final File fileC = x3Var.C();
        final a aVar = new a(new Callable() { // from class: io.sentry.x5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.b0(fileC, j10, x3Var, l1Var);
            }
        });
        return new p6(new q6(b7.Profile, new Callable() { // from class: io.sentry.y5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.c0(aVar);
            }
        }, "application-json", fileC.getName()), (Callable<byte[]>) new Callable() { // from class: io.sentry.z5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    @NotNull
    public static p6 F(@NotNull final l1 l1Var, @NotNull final e8 e8Var) throws IOException {
        io.sentry.util.w.c(l1Var, "ISerializer is required.");
        io.sentry.util.w.c(e8Var, "Session is required.");
        final a aVar = new a(new Callable() { // from class: io.sentry.r5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.e0(l1Var, e8Var);
            }
        });
        return new p6(new q6(b7.Session, new Callable() { // from class: io.sentry.c6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.f0(aVar);
            }
        }, nb.L, null), (Callable<byte[]>) new Callable() { // from class: io.sentry.h6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    public static p6 G(@NotNull final l1 l1Var, @NotNull final c9 c9Var) {
        io.sentry.util.w.c(l1Var, "ISerializer is required.");
        io.sentry.util.w.c(c9Var, "UserFeedback is required.");
        final a aVar = new a(new Callable() { // from class: io.sentry.l6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.h0(l1Var, c9Var);
            }
        });
        return new p6(new q6(b7.UserFeedback, new Callable() { // from class: io.sentry.m6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.i0(aVar);
            }
        }, nb.L, null), (Callable<byte[]>) new Callable() { // from class: io.sentry.n6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] M(b bVar, long j10, l1 l1Var, w0 w0Var) throws Exception {
        byte[] bArrCall;
        if (bVar.f() != null) {
            byte[] bArrF = bVar.f();
            y(bArrF.length, j10, bVar.h());
            return bArrF;
        }
        if (bVar.j() != null) {
            byte[] bArrB = io.sentry.util.q.b(l1Var, w0Var, bVar.j());
            if (bArrB != null) {
                y(bArrB.length, j10, bVar.h());
                return bArrB;
            }
        } else {
            if (bVar.i() != null) {
                return io.sentry.util.h.b(bVar.i(), j10);
            }
            if (bVar.e() != null && (bArrCall = bVar.e().call()) != null) {
                y(bArrCall.length, j10, bVar.h());
                return bArrCall;
            }
        }
        throw new io.sentry.exception.c(String.format("Couldn't attach the attachment %s.\nPlease check that either bytes, serializable, path or provider is set.", bVar.h()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer N(a aVar) throws Exception {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] P(l1 l1Var, io.sentry.clientreport.c cVar) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, f28045d));
            try {
                l1Var.a(cVar, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer Q(a aVar) throws Exception {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] S(l1 l1Var, i5 i5Var) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, f28045d));
            try {
                l1Var.a(i5Var, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer T(a aVar) throws Exception {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] V(l1 l1Var, f7 f7Var) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, f28045d));
            try {
                l1Var.a(f7Var, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer W(a aVar) throws Exception {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] Y(File file, t3 t3Var, l1 l1Var) throws Exception {
        if (!file.exists()) {
            throw new io.sentry.exception.c(String.format("Dropping profile chunk, because the file '%s' doesn't exists", file.getName()));
        }
        String strC = io.sentry.vendor.a.c(io.sentry.util.h.b(file.getPath(), 52428800L), 3);
        if (strC.isEmpty()) {
            throw new io.sentry.exception.c("Profiling trace file is empty");
        }
        t3Var.q(strC);
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, f28045d));
                    try {
                        l1Var.a(t3Var, bufferedWriter);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream.close();
                        return byteArray;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e10) {
                throw new io.sentry.exception.c(String.format("Failed to serialize profile chunk\n%s", e10.getMessage()));
            }
        } finally {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer Z(a aVar) throws Exception {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] b0(File file, long j10, x3 x3Var, l1 l1Var) throws Exception {
        if (!file.exists()) {
            throw new io.sentry.exception.c(String.format("Dropping profiling trace data, because the file '%s' doesn't exists", file.getName()));
        }
        String strC = io.sentry.vendor.a.c(io.sentry.util.h.b(file.getPath(), j10), 3);
        if (strC.isEmpty()) {
            throw new io.sentry.exception.c("Profiling trace file is empty");
        }
        x3Var.G(strC);
        x3Var.F();
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, f28045d));
                    try {
                        l1Var.a(x3Var, bufferedWriter);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        bufferedWriter.close();
                        byteArrayOutputStream.close();
                        return byteArray;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e10) {
                throw new io.sentry.exception.c(String.format("Failed to serialize profiling trace data\n%s", e10.getMessage()));
            }
        } finally {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer c0(a aVar) throws Exception {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] e0(l1 l1Var, e8 e8Var) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, f28045d));
            try {
                l1Var.a(e8Var, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer f0(a aVar) throws Exception {
        return Integer.valueOf(aVar.a().length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] h0(l1 l1Var, c9 c9Var) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, f28045d));
            try {
                l1Var.a(c9Var, bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } finally {
            }
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer i0(a aVar) throws Exception {
        return Integer.valueOf(aVar.a().length);
    }

    private static void y(long j10, long j11, @NotNull String str) throws io.sentry.exception.c {
        if (j10 > j11) {
            throw new io.sentry.exception.c(String.format("Dropping attachment with filename '%s', because the size of the passed bytes with %d bytes is bigger than the maximum allowed attachment size of %d bytes.", str, Long.valueOf(j10), Long.valueOf(j11)));
        }
    }

    public static p6 z(@NotNull final l1 l1Var, @NotNull final w0 w0Var, @NotNull final b bVar, final long j10) {
        final a aVar = new a(new Callable() { // from class: io.sentry.u5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.M(bVar, j10, l1Var, w0Var);
            }
        });
        return new p6(new q6(b7.Attachment, new Callable() { // from class: io.sentry.v5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return p6.N(aVar);
            }
        }, bVar.g(), bVar.h(), bVar.d()), (Callable<byte[]>) new Callable() { // from class: io.sentry.w5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return aVar.a();
            }
        });
    }

    @Nullable
    public io.sentry.clientreport.c H(@NotNull l1 l1Var) throws Exception {
        q6 q6Var = this.f28046a;
        if (q6Var == null || q6Var.b() != b7.ClientReport) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(I()), f28045d));
        try {
            io.sentry.clientreport.c cVar = (io.sentry.clientreport.c) l1Var.c(bufferedReader, io.sentry.clientreport.c.class);
            bufferedReader.close();
            return cVar;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @NotNull
    public byte[] I() throws Exception {
        Callable<byte[]> callable;
        if (this.f28048c == null && (callable = this.f28047b) != null) {
            this.f28048c = callable.call();
        }
        return this.f28048c;
    }

    @Nullable
    public r6 J(@NotNull l1 l1Var) throws Exception {
        q6 q6Var = this.f28046a;
        if (q6Var == null || q6Var.b() != b7.Event) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(I()), f28045d));
        try {
            r6 r6Var = (r6) l1Var.c(bufferedReader, r6.class);
            bufferedReader.close();
            return r6Var;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @NotNull
    public q6 K() {
        return this.f28046a;
    }

    @Nullable
    public SentryTransaction L(@NotNull l1 l1Var) throws Exception {
        q6 q6Var = this.f28046a;
        if (q6Var == null || q6Var.b() != b7.Transaction) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(I()), f28045d));
        try {
            SentryTransaction sentryTransaction = (SentryTransaction) l1Var.c(bufferedReader, SentryTransaction.class);
            bufferedReader.close();
            return sentryTransaction;
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    p6(@NotNull q6 q6Var, @Nullable Callable<byte[]> callable) {
        this.f28046a = (q6) io.sentry.util.w.c(q6Var, "SentryEnvelopeItemHeader is required.");
        this.f28047b = (Callable) io.sentry.util.w.c(callable, "DataFactory is required.");
        this.f28048c = null;
    }
}
