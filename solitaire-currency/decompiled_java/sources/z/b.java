package z;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v.f;
import v.j;
import v.r;
import z.c;

/* JADX INFO: compiled from: NoneTransition.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final d f36957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final j f36958b;

    /* JADX INFO: compiled from: NoneTransition.kt */
    public static final class a implements c.a {
        @Override // z.c.a
        @NotNull
        public c a(@NotNull d dVar, @NotNull j jVar) {
            return new b(dVar, jVar);
        }

        public boolean equals(@Nullable Object obj) {
            return obj instanceof a;
        }

        public int hashCode() {
            return a.class.hashCode();
        }
    }

    public b(@NotNull d dVar, @NotNull j jVar) {
        this.f36957a = dVar;
        this.f36958b = jVar;
    }

    @Override // z.c
    public void a() {
        j jVar = this.f36958b;
        if (jVar instanceof r) {
            this.f36957a.a(((r) jVar).a());
        } else if (jVar instanceof f) {
            this.f36957a.c(jVar.a());
        }
    }
}
