package io.sentry.android.ndk;

import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.c1;
import io.sentry.g4;
import io.sentry.j8;
import io.sentry.n;
import io.sentry.ndk.NativeScope;
import io.sentry.protocol.User;
import io.sentry.util.w;
import java.util.Locale;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NdkScopeObserver.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class i extends g4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f27578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final io.sentry.ndk.a f27579b;

    public i(@NotNull SentryOptions sentryOptions) {
        this(sentryOptions, new NativeScope());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(Breadcrumb breadcrumb) throws Exception {
        String strF = null;
        String lowerCase = breadcrumb.getLevel() != null ? breadcrumb.getLevel().name().toLowerCase(Locale.ROOT) : null;
        String strH = n.h(breadcrumb.getTimestamp());
        try {
            Map<String, Object> data = breadcrumb.getData();
            if (!data.isEmpty()) {
                strF = this.f27578a.getSerializer().f(data);
            }
        } catch (Throwable th) {
            this.f27578a.getLogger().a(SentryLevel.ERROR, th, "Breadcrumb data is not serializable.", new Object[0]);
        }
        this.f27579b.a(lowerCase, breadcrumb.getMessage(), breadcrumb.getCategory(), breadcrumb.getType(), strH, strF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(String str) {
        this.f27579b.removeExtra(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(String str) {
        this.f27579b.removeTag(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(String str, String str2) {
        this.f27579b.setExtra(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(String str, String str2) {
        this.f27579b.setTag(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(j8 j8Var) {
        this.f27579b.d(j8Var.n().toString(), j8Var.k().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(User user) {
        if (user == null) {
            this.f27579b.b();
        } else {
            this.f27579b.c(user.getId(), user.getEmail(), user.getIpAddress(), user.getUsername());
        }
    }

    @Override // io.sentry.d1
    public void c(@NotNull final Breadcrumb breadcrumb) {
        try {
            this.f27578a.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.g
                @Override // java.lang.Runnable
                public final void run() throws Exception {
                    this.f27574a.q(breadcrumb);
                }
            });
        } catch (Throwable th) {
            this.f27578a.getLogger().a(SentryLevel.ERROR, th, "Scope sync addBreadcrumb has an error.", new Object[0]);
        }
    }

    @Override // io.sentry.d1
    public void f(@Nullable final j8 j8Var, @NotNull c1 c1Var) {
        if (j8Var == null) {
            return;
        }
        try {
            this.f27578a.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27576a.v(j8Var);
                }
            });
        } catch (Throwable th) {
            this.f27578a.getLogger().a(SentryLevel.ERROR, th, "Scope sync setTrace failed.", new Object[0]);
        }
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void removeExtra(@NotNull final String str) {
        try {
            this.f27578a.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.b
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27562a.r(str);
                }
            });
        } catch (Throwable th) {
            this.f27578a.getLogger().a(SentryLevel.ERROR, th, "Scope sync removeExtra(%s) has an error.", str);
        }
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void removeTag(@NotNull final String str) {
        try {
            this.f27578a.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27564a.s(str);
                }
            });
        } catch (Throwable th) {
            this.f27578a.getLogger().a(SentryLevel.ERROR, th, "Scope sync removeTag(%s) has an error.", str);
        }
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void setExtra(@NotNull final String str, @NotNull final String str2) {
        try {
            this.f27578a.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27568a.t(str, str2);
                }
            });
        } catch (Throwable th) {
            this.f27578a.getLogger().a(SentryLevel.ERROR, th, "Scope sync setExtra(%s) has an error.", str);
        }
    }

    @Override // io.sentry.g4, io.sentry.d1
    public void setTag(@NotNull final String str, @NotNull final String str2) {
        try {
            this.f27578a.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27571a.u(str, str2);
                }
            });
        } catch (Throwable th) {
            this.f27578a.getLogger().a(SentryLevel.ERROR, th, "Scope sync setTag(%s) has an error.", str);
        }
    }

    @Override // io.sentry.d1
    public void setUser(@Nullable final User user) {
        try {
            this.f27578a.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.ndk.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27566a.w(user);
                }
            });
        } catch (Throwable th) {
            this.f27578a.getLogger().a(SentryLevel.ERROR, th, "Scope sync setUser has an error.", new Object[0]);
        }
    }

    i(@NotNull SentryOptions sentryOptions, @NotNull io.sentry.ndk.a aVar) {
        this.f27578a = (SentryOptions) w.c(sentryOptions, "The SentryOptions object is required.");
        this.f27579b = (io.sentry.ndk.a) w.c(aVar, "The NativeScope object is required.");
    }
}
