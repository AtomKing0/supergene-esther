package za;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;

/* JADX INFO: compiled from: SubstituteLogger.java */
/* JADX INFO: loaded from: classes5.dex */
public class e implements xa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f37632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile xa.a f37633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f37634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Method f37635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ya.a f37636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Queue<ya.d> f37637f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f37638g;

    public e(String str, Queue<ya.d> queue, boolean z10) {
        this.f37632a = str;
        this.f37637f = queue;
        this.f37638g = z10;
    }

    private xa.a d() {
        if (this.f37636e == null) {
            this.f37636e = new ya.a(this, this.f37637f);
        }
        return this.f37636e;
    }

    @Override // xa.a
    public void a(String str) {
        c().a(str);
    }

    @Override // xa.a
    public void b(String str) {
        c().b(str);
    }

    xa.a c() {
        return this.f37633b != null ? this.f37633b : this.f37638g ? b.f37631a : d();
    }

    public boolean e() {
        Boolean bool = this.f37634c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.f37635d = this.f37633b.getClass().getMethod("log", ya.c.class);
            this.f37634c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.f37634c = Boolean.FALSE;
        }
        return this.f37634c.booleanValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.f37632a.equals(((e) obj).f37632a);
    }

    public boolean f() {
        return this.f37633b instanceof b;
    }

    public boolean g() {
        return this.f37633b == null;
    }

    @Override // xa.a
    public String getName() {
        return this.f37632a;
    }

    public void h(ya.c cVar) {
        if (e()) {
            try {
                this.f37635d.invoke(this.f37633b, cVar);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public int hashCode() {
        return this.f37632a.hashCode();
    }

    public void i(xa.a aVar) {
        this.f37633b = aVar;
    }
}
