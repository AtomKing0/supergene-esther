package oa;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ua.f;

/* JADX INFO: compiled from: Header.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f32103d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final ua.f f32104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final ua.f f32105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final ua.f f32106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final ua.f f32107h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public static final ua.f f32108i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public static final ua.f f32109j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final ua.f f32110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final ua.f f32111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f32112c;

    /* JADX INFO: compiled from: Header.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    static {
        f.a aVar = ua.f.f34755d;
        f32104e = aVar.d(":");
        f32105f = aVar.d(":status");
        f32106g = aVar.d(":method");
        f32107h = aVar.d(":path");
        f32108i = aVar.d(":scheme");
        f32109j = aVar.d(":authority");
    }

    public c(@NotNull ua.f name, @NotNull ua.f value) {
        t.i(name, "name");
        t.i(value, "value");
        this.f32110a = name;
        this.f32111b = value;
        this.f32112c = name.B() + 32 + value.B();
    }

    @NotNull
    public final ua.f a() {
        return this.f32110a;
    }

    @NotNull
    public final ua.f b() {
        return this.f32111b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return t.d(this.f32110a, cVar.f32110a) && t.d(this.f32111b, cVar.f32111b);
    }

    public int hashCode() {
        return (this.f32110a.hashCode() * 31) + this.f32111b.hashCode();
    }

    @NotNull
    public String toString() {
        return this.f32110a.G() + ": " + this.f32111b.G();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(@NotNull String name, @NotNull String value) {
        t.i(name, "name");
        t.i(value, "value");
        f.a aVar = ua.f.f34755d;
        this(aVar.d(name), aVar.d(value));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(@NotNull ua.f name, @NotNull String value) {
        this(name, ua.f.f34755d.d(value));
        t.i(name, "name");
        t.i(value, "value");
    }
}
