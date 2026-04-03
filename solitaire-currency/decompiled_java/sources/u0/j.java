package u0;

/* JADX INFO: compiled from: DiskCacheStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f34321a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f34322b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f34323c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f34324d = new d();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final j f34325e = new e();

    /* JADX INFO: compiled from: DiskCacheStrategy.java */
    class a extends j {
        a() {
        }

        @Override // u0.j
        public boolean a() {
            return true;
        }

        @Override // u0.j
        public boolean b() {
            return true;
        }

        @Override // u0.j
        public boolean c(r0.a aVar) {
            return aVar == r0.a.REMOTE;
        }

        @Override // u0.j
        public boolean d(boolean z10, r0.a aVar, r0.c cVar) {
            return (aVar == r0.a.RESOURCE_DISK_CACHE || aVar == r0.a.MEMORY_CACHE) ? false : true;
        }
    }

    /* JADX INFO: compiled from: DiskCacheStrategy.java */
    class b extends j {
        b() {
        }

        @Override // u0.j
        public boolean a() {
            return false;
        }

        @Override // u0.j
        public boolean b() {
            return false;
        }

        @Override // u0.j
        public boolean c(r0.a aVar) {
            return false;
        }

        @Override // u0.j
        public boolean d(boolean z10, r0.a aVar, r0.c cVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: DiskCacheStrategy.java */
    class c extends j {
        c() {
        }

        @Override // u0.j
        public boolean a() {
            return true;
        }

        @Override // u0.j
        public boolean b() {
            return false;
        }

        @Override // u0.j
        public boolean c(r0.a aVar) {
            return (aVar == r0.a.DATA_DISK_CACHE || aVar == r0.a.MEMORY_CACHE) ? false : true;
        }

        @Override // u0.j
        public boolean d(boolean z10, r0.a aVar, r0.c cVar) {
            return false;
        }
    }

    /* JADX INFO: compiled from: DiskCacheStrategy.java */
    class d extends j {
        d() {
        }

        @Override // u0.j
        public boolean a() {
            return false;
        }

        @Override // u0.j
        public boolean b() {
            return true;
        }

        @Override // u0.j
        public boolean c(r0.a aVar) {
            return false;
        }

        @Override // u0.j
        public boolean d(boolean z10, r0.a aVar, r0.c cVar) {
            return (aVar == r0.a.RESOURCE_DISK_CACHE || aVar == r0.a.MEMORY_CACHE) ? false : true;
        }
    }

    /* JADX INFO: compiled from: DiskCacheStrategy.java */
    class e extends j {
        e() {
        }

        @Override // u0.j
        public boolean a() {
            return true;
        }

        @Override // u0.j
        public boolean b() {
            return true;
        }

        @Override // u0.j
        public boolean c(r0.a aVar) {
            return aVar == r0.a.REMOTE;
        }

        @Override // u0.j
        public boolean d(boolean z10, r0.a aVar, r0.c cVar) {
            return ((z10 && aVar == r0.a.DATA_DISK_CACHE) || aVar == r0.a.LOCAL) && cVar == r0.c.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(r0.a aVar);

    public abstract boolean d(boolean z10, r0.a aVar, r0.c cVar);
}
