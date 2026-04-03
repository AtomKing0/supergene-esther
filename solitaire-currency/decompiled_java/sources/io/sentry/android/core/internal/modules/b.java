package io.sentry.android.core.internal.modules;

import android.content.Context;
import io.sentry.SentryLevel;
import io.sentry.android.core.e1;
import io.sentry.internal.modules.d;
import io.sentry.w0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AssetsModulesLoader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class b extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final Context f27267e;

    public b(@NotNull Context context, @NotNull w0 w0Var) {
        super(w0Var);
        this.f27267e = e1.h(context);
        new Thread(new Runnable() { // from class: io.sentry.android.core.internal.modules.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f27266a.e();
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        a();
    }

    @Override // io.sentry.internal.modules.d
    protected Map<String, String> b() {
        TreeMap treeMap = new TreeMap();
        try {
            InputStream inputStreamOpen = this.f27267e.getAssets().open("sentry-external-modules.txt");
            try {
                Map<String, String> mapC = c(inputStreamOpen);
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                return mapC;
            } finally {
            }
        } catch (FileNotFoundException unused) {
            this.f27932a.c(SentryLevel.INFO, "%s file was not found.", "sentry-external-modules.txt");
            return treeMap;
        } catch (IOException e10) {
            this.f27932a.b(SentryLevel.ERROR, "Error extracting modules.", e10);
            return treeMap;
        }
    }
}
