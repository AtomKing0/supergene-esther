package io.sentry;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FullyDisplayedReporter.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final k0 f27960b = new k0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<a> f27961a = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: FullyDisplayedReporter.java */
    @ApiStatus.Internal
    public interface a {
        void a();
    }

    private k0() {
    }

    @NotNull
    public static k0 a() {
        return f27960b;
    }

    public void b(@NotNull a aVar) {
        this.f27961a.add(aVar);
    }

    public void c() {
        Iterator<a> it = this.f27961a.iterator();
        this.f27961a.clear();
        while (it.hasNext()) {
            it.next().a();
        }
    }
}
