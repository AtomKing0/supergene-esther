package w;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w.c;

/* JADX INFO: compiled from: Size.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f35273c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final i f35274d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final c f35275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final c f35276b;

    /* JADX INFO: compiled from: Size.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    static {
        c.b bVar = c.b.f35261a;
        f35274d = new i(bVar, bVar);
    }

    public i(@NotNull c cVar, @NotNull c cVar2) {
        this.f35275a = cVar;
        this.f35276b = cVar2;
    }

    @NotNull
    public final c a() {
        return this.f35276b;
    }

    @NotNull
    public final c b() {
        return this.f35275a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return t.d(this.f35275a, iVar.f35275a) && t.d(this.f35276b, iVar.f35276b);
    }

    public int hashCode() {
        return (this.f35275a.hashCode() * 31) + this.f35276b.hashCode();
    }

    @NotNull
    public String toString() {
        return "Size(width=" + this.f35275a + ", height=" + this.f35276b + ')';
    }
}
