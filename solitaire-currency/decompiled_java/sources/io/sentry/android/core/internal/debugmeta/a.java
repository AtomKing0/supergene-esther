package io.sentry.android.core.internal.debugmeta;

import android.content.Context;
import io.sentry.SentryLevel;
import io.sentry.android.core.e1;
import io.sentry.util.d;
import io.sentry.w0;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AssetsDebugMetaLoader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class a implements io.sentry.internal.debugmeta.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f27236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final w0 f27237b;

    public a(@NotNull Context context, @NotNull w0 w0Var) {
        this.f27236a = e1.h(context);
        this.f27237b = w0Var;
    }

    @Override // io.sentry.internal.debugmeta.a
    @Nullable
    public List<Properties> a() {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f27236a.getAssets().open(d.f28341a));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                List<Properties> listSingletonList = Collections.singletonList(properties);
                bufferedInputStream.close();
                return listSingletonList;
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (FileNotFoundException unused) {
            this.f27237b.c(SentryLevel.INFO, "%s file was not found.", d.f28341a);
            return null;
        } catch (IOException e10) {
            this.f27237b.b(SentryLevel.ERROR, "Error getting Proguard UUIDs.", e10);
            return null;
        } catch (RuntimeException e11) {
            this.f27237b.a(SentryLevel.ERROR, e11, "%s file is malformed.", d.f28341a);
            return null;
        }
    }
}
