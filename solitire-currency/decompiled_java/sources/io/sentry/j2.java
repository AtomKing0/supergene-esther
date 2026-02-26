package io.sentry;

import io.sentry.protocol.DebugMeta;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MainEventProcessor.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class j2 implements g0, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryOptions f27939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final t7 f27940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final s6 f27941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private volatile o0 f27942d = null;

    public j2(@NotNull SentryOptions sentryOptions) {
        SentryOptions sentryOptions2 = (SentryOptions) io.sentry.util.w.c(sentryOptions, "The SentryOptions is required.");
        this.f27939a = sentryOptions2;
        s7 s7Var = new s7(sentryOptions2);
        this.f27941c = new s6(s7Var);
        this.f27940b = new t7(s7Var, sentryOptions2);
    }

    private void B(@NotNull i5 i5Var) {
        DebugMeta debugMetaBuildDebugMeta = DebugMeta.buildDebugMeta(i5Var.getDebugMeta(), this.f27939a);
        if (debugMetaBuildDebugMeta != null) {
            i5Var.setDebugMeta(debugMetaBuildDebugMeta);
        }
    }

    private void G0(@NotNull i5 i5Var) {
        if (i5Var.getTags() == null) {
            i5Var.setTags(new HashMap(this.f27939a.getTags()));
            return;
        }
        for (Map.Entry<String, String> entry : this.f27939a.getTags().entrySet()) {
            if (!i5Var.getTags().containsKey(entry.getKey())) {
                i5Var.setTag(entry.getKey(), entry.getValue());
            }
        }
    }

    private void I0(@NotNull r6 r6Var, @NotNull l0 l0Var) {
        if (r6Var.o() == null) {
            List<SentryException> listJ = r6Var.j();
            ArrayList arrayList = null;
            if (listJ != null && !listJ.isEmpty()) {
                for (SentryException sentryException : listJ) {
                    if (sentryException.getMechanism() != null && sentryException.getThreadId() != null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(sentryException.getThreadId());
                    }
                }
            }
            if (this.f27939a.isAttachThreads() || io.sentry.util.m.h(l0Var, io.sentry.hints.a.class)) {
                Object objG = io.sentry.util.m.g(l0Var);
                r6Var.y(this.f27940b.b(arrayList, objG instanceof io.sentry.hints.a ? ((io.sentry.hints.a) objG).f() : false));
            } else if (this.f27939a.isAttachStacktrace()) {
                if ((listJ == null || listJ.isEmpty()) && !n(l0Var)) {
                    r6Var.y(this.f27940b.a());
                }
            }
        }
    }

    private void J(@NotNull i5 i5Var) {
        if (i5Var.getDist() == null) {
            i5Var.setDist(this.f27939a.getDist());
        }
    }

    private boolean J0(@NotNull i5 i5Var, @NotNull l0 l0Var) {
        if (io.sentry.util.m.u(l0Var)) {
            return true;
        }
        this.f27939a.getLogger().c(SentryLevel.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", i5Var.getEventId());
        return false;
    }

    private void L(@NotNull i5 i5Var) {
        if (i5Var.getEnvironment() == null) {
            i5Var.setEnvironment(this.f27939a.getEnvironment());
        }
    }

    private void O(@NotNull r6 r6Var) {
        Throwable throwableMechanism = r6Var.getThrowableMechanism();
        if (throwableMechanism != null) {
            r6Var.t(this.f27941c.d(throwableMechanism));
        }
    }

    private void R(@NotNull r6 r6Var) {
        Map<String, String> mapA = this.f27939a.getModulesLoader().a();
        if (mapA == null) {
            return;
        }
        Map<String, String> mapN = r6Var.n();
        if (mapN == null) {
            r6Var.x(mapA);
        } else {
            mapN.putAll(mapA);
        }
    }

    private void S(@NotNull i5 i5Var) {
        if (i5Var.getPlatform() == null) {
            i5Var.setPlatform(i5.DEFAULT_PLATFORM);
        }
    }

    private void W(@NotNull i5 i5Var) {
        if (i5Var.getRelease() == null) {
            i5Var.setRelease(this.f27939a.getRelease());
        }
    }

    private void h0(@NotNull i5 i5Var) {
        if (i5Var.getSdk() == null) {
            i5Var.setSdk(this.f27939a.getSdkVersion());
        }
    }

    private void i() {
        if (this.f27942d == null) {
            this.f27942d = o0.e();
        }
    }

    private void i0(@NotNull i5 i5Var) {
        if (i5Var.getServerName() == null) {
            i5Var.setServerName(this.f27939a.getServerName());
        }
        if (this.f27939a.isAttachServerName() && i5Var.getServerName() == null) {
            i();
            if (this.f27942d != null) {
                i5Var.setServerName(this.f27942d.d());
            }
        }
    }

    private boolean n(@NotNull l0 l0Var) {
        return io.sentry.util.m.h(l0Var, io.sentry.hints.e.class);
    }

    private void q(@NotNull i5 i5Var) {
        User user = i5Var.getUser();
        if (user == null) {
            user = new User();
            i5Var.setUser(user);
        }
        if (user.getIpAddress() == null && this.f27939a.isSendDefaultPii()) {
            user.setIpAddress("{{auto}}");
        }
    }

    private void x(@NotNull i5 i5Var) {
        W(i5Var);
        L(i5Var);
        i0(i5Var);
        J(i5Var);
        h0(i5Var);
        G0(i5Var);
        q(i5Var);
    }

    private void z(@NotNull i5 i5Var) {
        S(i5Var);
    }

    @Override // io.sentry.g0
    @NotNull
    public r6 a(@NotNull r6 r6Var, @NotNull l0 l0Var) {
        z(r6Var);
        O(r6Var);
        B(r6Var);
        R(r6Var);
        if (J0(r6Var, l0Var)) {
            x(r6Var);
            I0(r6Var, l0Var);
        }
        return r6Var;
    }

    @Override // io.sentry.g0
    @NotNull
    public SentryTransaction c(@NotNull SentryTransaction sentryTransaction, @NotNull l0 l0Var) {
        z(sentryTransaction);
        B(sentryTransaction);
        if (J0(sentryTransaction, l0Var)) {
            x(sentryTransaction);
        }
        return sentryTransaction;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f27942d != null) {
            this.f27942d.c();
        }
    }

    @Override // io.sentry.g0
    @Nullable
    public Long getOrder() {
        return 0L;
    }
}
