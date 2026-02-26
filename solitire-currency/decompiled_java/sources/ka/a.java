package ka;

import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Task.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f29716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f29717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private d f29718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f29719d;

    public a(@NotNull String name, boolean z10) {
        t.i(name, "name");
        this.f29716a = name;
        this.f29717b = z10;
        this.f29719d = -1L;
    }

    public final boolean a() {
        return this.f29717b;
    }

    @NotNull
    public final String b() {
        return this.f29716a;
    }

    public final long c() {
        return this.f29719d;
    }

    @Nullable
    public final d d() {
        return this.f29718c;
    }

    public final void e(@NotNull d queue) {
        t.i(queue, "queue");
        d dVar = this.f29718c;
        if (dVar == queue) {
            return;
        }
        if (!(dVar == null)) {
            throw new IllegalStateException("task is in multiple queues".toString());
        }
        this.f29718c = queue;
    }

    public abstract long f();

    public final void g(long j10) {
        this.f29719d = j10;
    }

    @NotNull
    public String toString() {
        return this.f29716a;
    }

    public /* synthetic */ a(String str, boolean z10, int i10, k kVar) {
        this(str, (i10 & 2) != 0 ? true : z10);
    }
}
