package v8;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: KotlinVersion.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j implements Comparable<j> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f35190e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final j f35191f = k.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f35192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f35193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f35194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f35195d;

    /* JADX INFO: compiled from: KotlinVersion.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public j(int i10, int i11, int i12) {
        this.f35192a = i10;
        this.f35193b = i11;
        this.f35194c = i12;
        this.f35195d = c(i10, i11, i12);
    }

    private final int c(int i10, int i11, int i12) {
        boolean z10 = false;
        if (new n9.i(0, 255).i(i10) && new n9.i(0, 255).i(i11) && new n9.i(0, 255).i(i12)) {
            z10 = true;
        }
        if (z10) {
            return (i10 << 16) + (i11 << 8) + i12;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i10 + '.' + i11 + '.' + i12).toString());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NotNull j other) {
        kotlin.jvm.internal.t.i(other, "other");
        return this.f35195d - other.f35195d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        j jVar = obj instanceof j ? (j) obj : null;
        return jVar != null && this.f35195d == jVar.f35195d;
    }

    public int hashCode() {
        return this.f35195d;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f35192a);
        sb.append('.');
        sb.append(this.f35193b);
        sb.append('.');
        sb.append(this.f35194c);
        return sb.toString();
    }
}
