package b2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import y1.l;

/* JADX INFO: compiled from: ClientMetrics.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a f1896e = new C0147a().b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f1897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f1898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f1899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f1900d;

    /* JADX INFO: renamed from: b2.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ClientMetrics.java */
    public static final class C0147a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f f1901a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<d> f1902b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private b f1903c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f1904d = "";

        C0147a() {
        }

        public C0147a a(d dVar) {
            this.f1902b.add(dVar);
            return this;
        }

        public a b() {
            return new a(this.f1901a, Collections.unmodifiableList(this.f1902b), this.f1903c, this.f1904d);
        }

        public C0147a c(String str) {
            this.f1904d = str;
            return this;
        }

        public C0147a d(b bVar) {
            this.f1903c = bVar;
            return this;
        }

        public C0147a e(f fVar) {
            this.f1901a = fVar;
            return this;
        }
    }

    a(f fVar, List<d> list, b bVar, String str) {
        this.f1897a = fVar;
        this.f1898b = list;
        this.f1899c = bVar;
        this.f1900d = str;
    }

    public static C0147a e() {
        return new C0147a();
    }

    @s5.d(tag = 4)
    public String a() {
        return this.f1900d;
    }

    @s5.d(tag = 3)
    public b b() {
        return this.f1899c;
    }

    @s5.d(tag = 2)
    public List<d> c() {
        return this.f1898b;
    }

    @s5.d(tag = 1)
    public f d() {
        return this.f1897a;
    }

    public byte[] f() {
        return l.a(this);
    }
}
