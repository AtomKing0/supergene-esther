package la;

import ga.f0;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RouteDatabase.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Set<f0> f31066a = new LinkedHashSet();

    public final synchronized void a(@NotNull f0 route) {
        t.i(route, "route");
        this.f31066a.remove(route);
    }

    public final synchronized void b(@NotNull f0 failedRoute) {
        t.i(failedRoute, "failedRoute");
        this.f31066a.add(failedRoute);
    }

    public final synchronized boolean c(@NotNull f0 route) {
        t.i(route, "route");
        return this.f31066a.contains(route);
    }
}
