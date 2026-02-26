package t;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t.c;

/* JADX INFO: compiled from: RealMemoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h f33996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final i f33997b;

    public e(@NotNull h hVar, @NotNull i iVar) {
        this.f33996a = hVar;
        this.f33997b = iVar;
    }

    @Override // t.c
    public void a(int i10) {
        this.f33996a.a(i10);
        this.f33997b.a(i10);
    }

    @Override // t.c
    @Nullable
    public c.C0690c b(@NotNull c.b bVar) {
        c.C0690c c0690cB = this.f33996a.b(bVar);
        return c0690cB == null ? this.f33997b.b(bVar) : c0690cB;
    }

    @Override // t.c
    public void c(@NotNull c.b bVar, @NotNull c.C0690c c0690c) {
        this.f33996a.c(c.b.b(bVar, null, a0.c.b(bVar.c()), 1, null), c0690c.a(), a0.c.b(c0690c.b()));
    }
}
