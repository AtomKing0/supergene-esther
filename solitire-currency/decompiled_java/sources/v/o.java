package v;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.y;

/* JADX INFO: compiled from: Parameters.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements Iterable<v8.s<? extends String, ? extends c>>, i9.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final b f34954b = new b(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final o f34955c = new o();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<String, c> f34956a;

    /* JADX INFO: compiled from: Parameters.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Map<String, c> f34957a;

        public a(@NotNull o oVar) {
            this.f34957a = r0.z(oVar.f34956a);
        }

        @NotNull
        public final o a() {
            return new o(a0.c.b(this.f34957a), null);
        }
    }

    /* JADX INFO: compiled from: Parameters.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: Parameters.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Object f34958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final String f34959b;

        @Nullable
        public final String a() {
            return this.f34959b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (kotlin.jvm.internal.t.d(this.f34958a, cVar.f34958a) && kotlin.jvm.internal.t.d(this.f34959b, cVar.f34959b)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.f34958a;
            int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
            String str = this.f34959b;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        @NotNull
        public String toString() {
            return "Entry(value=" + this.f34958a + ", memoryCacheKey=" + this.f34959b + ')';
        }
    }

    public /* synthetic */ o(Map map, kotlin.jvm.internal.k kVar) {
        this(map);
    }

    @NotNull
    public final Map<String, String> b() {
        if (isEmpty()) {
            return r0.g();
        }
        Map<String, c> map = this.f34956a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, c> entry : map.entrySet()) {
            String strA = entry.getValue().a();
            if (strA != null) {
                linkedHashMap.put(entry.getKey(), strA);
            }
        }
        return linkedHashMap;
    }

    @NotNull
    public final a e() {
        return new a(this);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o) && kotlin.jvm.internal.t.d(this.f34956a, ((o) obj).f34956a);
    }

    public int hashCode() {
        return this.f34956a.hashCode();
    }

    public final boolean isEmpty() {
        return this.f34956a.isEmpty();
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<v8.s<? extends String, ? extends c>> iterator() {
        Map<String, c> map = this.f34956a;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, c> entry : map.entrySet()) {
            arrayList.add(y.a(entry.getKey(), entry.getValue()));
        }
        return arrayList.iterator();
    }

    @NotNull
    public String toString() {
        return "Parameters(entries=" + this.f34956a + ')';
    }

    private o(Map<String, c> map) {
        this.f34956a = map;
    }

    public o() {
        this(r0.g());
    }
}
