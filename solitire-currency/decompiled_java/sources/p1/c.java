package p1;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: StateVerifier.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: compiled from: StateVerifier.java */
    private static class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile boolean f32419a;

        b() {
            super();
        }

        @Override // p1.c
        public void b(boolean z10) {
            this.f32419a = z10;
        }

        @Override // p1.c
        public void c() {
            if (this.f32419a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private c() {
    }

    @NonNull
    public static c a() {
        return new b();
    }

    abstract void b(boolean z10);

    public abstract void c();
}
