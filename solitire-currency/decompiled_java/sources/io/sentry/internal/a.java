package io.sentry.internal;

import io.sentry.k1;
import io.sentry.protocol.SentryPackage;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ManifestVersionReader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private static volatile a f27906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final io.sentry.util.a f27907e = new io.sentry.util.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f27908a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private volatile C0584a f27909b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private io.sentry.util.a f27910c = new io.sentry.util.a();

    /* JADX INFO: renamed from: io.sentry.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ManifestVersionReader.java */
    public static final class C0584a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private String f27911a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private String f27912b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<SentryPackage> f27913c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<String> f27914d = new ArrayList();
    }

    private a() {
    }

    @NotNull
    public static a a() {
        if (f27906d == null) {
            k1 k1VarA = f27907e.a();
            try {
                if (f27906d == null) {
                    f27906d = new a();
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
        return f27906d;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.internal.a.b():void");
    }
}
