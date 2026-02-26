package io.sentry;

import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryCrashLastRunState.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class m5 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final m5 f28002d = new m5();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f28003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Boolean f28004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f28005c = new io.sentry.util.a();

    private m5() {
    }

    public static m5 a() {
        return f28002d;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004c  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Boolean b(@org.jetbrains.annotations.Nullable java.lang.String r6, boolean r7) {
        /*
            r5 = this;
            io.sentry.util.a r0 = r5.f28005c
            io.sentry.k1 r0 = r0.a()
            boolean r1 = r5.f28003a     // Catch: java.lang.Throwable -> L52
            if (r1 == 0) goto L12
            java.lang.Boolean r6 = r5.f28004b     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto L11
            r0.close()
        L11:
            return r6
        L12:
            if (r6 != 0) goto L1b
            if (r0 == 0) goto L19
            r0.close()
        L19:
            r6 = 0
            return r6
        L1b:
            r1 = 1
            r5.f28003a = r1     // Catch: java.lang.Throwable -> L52
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L52
            java.lang.String r3 = "last_crash"
            r2.<init>(r6, r3)     // Catch: java.lang.Throwable -> L52
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L52
            java.lang.String r4 = ".sentry-native/last_crash"
            r3.<init>(r6, r4)     // Catch: java.lang.Throwable -> L52
            r6 = 0
            boolean r4 = r2.exists()     // Catch: java.lang.Throwable -> L43
            if (r4 == 0) goto L37
            r2.delete()     // Catch: java.lang.Throwable -> L44
            goto L44
        L37:
            boolean r2 = r3.exists()     // Catch: java.lang.Throwable -> L43
            if (r2 == 0) goto L43
            if (r7 == 0) goto L44
            r3.delete()     // Catch: java.lang.Throwable -> L44
            goto L44
        L43:
            r1 = r6
        L44:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> L52
            r5.f28004b = r6     // Catch: java.lang.Throwable -> L52
            if (r0 == 0) goto L4f
            r0.close()
        L4f:
            java.lang.Boolean r6 = r5.f28004b
            return r6
        L52:
            r6 = move-exception
            if (r0 == 0) goto L5d
            r0.close()     // Catch: java.lang.Throwable -> L59
            goto L5d
        L59:
            r7 = move-exception
            r6.addSuppressed(r7)
        L5d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.m5.b(java.lang.String, boolean):java.lang.Boolean");
    }

    public void c(boolean z10) {
        k1 k1VarA = this.f28005c.a();
        try {
            if (!this.f28003a) {
                this.f28004b = Boolean.valueOf(z10);
                this.f28003a = true;
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
