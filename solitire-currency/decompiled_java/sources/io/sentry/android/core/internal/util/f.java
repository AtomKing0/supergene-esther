package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import io.sentry.android.core.w0;
import io.sentry.s2;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentProviderSecurityChecker.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final w0 f27301a;

    public f() {
        this(new w0(s2.e()));
    }

    @SuppressLint({"NewApi"})
    public void a(@NotNull ContentProvider contentProvider) {
        int iD = this.f27301a.d();
        if (iD < 26 || iD > 28) {
            return;
        }
        String callingPackage = contentProvider.getCallingPackage();
        String packageName = contentProvider.getContext().getPackageName();
        if (callingPackage == null || !callingPackage.equals(packageName)) {
            throw new SecurityException("Provider does not allow for granting of Uri permissions");
        }
    }

    public f(@NotNull w0 w0Var) {
        this.f27301a = w0Var;
    }
}
