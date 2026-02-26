package io.sentry.internal.modules;

import io.sentry.SentryLevel;
import io.sentry.k1;
import io.sentry.w0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ModulesLoader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public abstract class d implements b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Charset f27931d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    protected final w0 f27932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27933b = new io.sentry.util.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private volatile Map<String, String> f27934c = null;

    public d(@NotNull w0 w0Var) {
        this.f27932a = w0Var;
    }

    @Override // io.sentry.internal.modules.b
    @Nullable
    public Map<String, String> a() {
        if (this.f27934c == null) {
            k1 k1VarA = this.f27933b.a();
            try {
                if (this.f27934c == null) {
                    this.f27934c = b();
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
        return this.f27934c;
    }

    protected abstract Map<String, String> b();

    protected Map<String, String> c(@NotNull InputStream inputStream) {
        TreeMap treeMap = new TreeMap();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, f27931d));
            try {
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    int iLastIndexOf = line.lastIndexOf(58);
                    treeMap.put(line.substring(0, iLastIndexOf), line.substring(iLastIndexOf + 1));
                }
                this.f27932a.c(SentryLevel.DEBUG, "Extracted %d modules from resources.", Integer.valueOf(treeMap.size()));
                bufferedReader.close();
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e10) {
            this.f27932a.b(SentryLevel.ERROR, "Error extracting modules.", e10);
        } catch (RuntimeException e11) {
            this.f27932a.a(SentryLevel.ERROR, e11, "%s file is malformed.", "sentry-external-modules.txt");
        }
        return treeMap;
    }
}
