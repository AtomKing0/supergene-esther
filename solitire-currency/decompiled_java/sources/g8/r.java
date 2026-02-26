package g8;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f25911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f25912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f25913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f25914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final boolean f25915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f25916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final boolean f25917g;

    static {
        r rVar = new r();
        f25911a = rVar;
        f25912b = s.a(rVar) == q.Browser;
        f25913c = s.a(rVar) == q.Node;
        f25914d = s.a(rVar) == q.Jvm;
        f25915e = s.a(rVar) == q.Native;
        f25916f = s.b(rVar);
        f25917g = s.c(rVar);
    }

    private r() {
    }

    public final boolean a() {
        return f25912b;
    }

    public final boolean b() {
        return f25916f;
    }

    public final boolean c() {
        return f25915e;
    }
}
