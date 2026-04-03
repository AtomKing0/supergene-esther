package com.ironsource;

/* JADX INFO: loaded from: classes4.dex */
public class co {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private go f11601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f11602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f11603f;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f11604a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f11605b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f11606c = false;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private go f11607d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f11608e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f11609f = 0;

        public b a(boolean z10) {
            this.f11604a = z10;
            return this;
        }

        public b a(boolean z10, int i10) {
            this.f11606c = z10;
            this.f11609f = i10;
            return this;
        }

        public b a(boolean z10, go goVar, int i10) {
            this.f11605b = z10;
            if (goVar == null) {
                goVar = go.PER_DAY;
            }
            this.f11607d = goVar;
            this.f11608e = i10;
            return this;
        }

        public co a() {
            return new co(this.f11604a, this.f11605b, this.f11606c, this.f11607d, this.f11608e, this.f11609f);
        }
    }

    private co(boolean z10, boolean z11, boolean z12, go goVar, int i10, int i11) {
        this.f11598a = z10;
        this.f11599b = z11;
        this.f11600c = z12;
        this.f11601d = goVar;
        this.f11602e = i10;
        this.f11603f = i11;
    }

    public go a() {
        return this.f11601d;
    }

    public int b() {
        return this.f11602e;
    }

    public int c() {
        return this.f11603f;
    }

    public boolean d() {
        return this.f11599b;
    }

    public boolean e() {
        return this.f11598a;
    }

    public boolean f() {
        return this.f11600c;
    }
}
