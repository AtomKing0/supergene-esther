package y0;

import androidx.annotation.NonNull;
import s0.d;
import y0.n;

/* JADX INFO: compiled from: UnitModelLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class v<Model> implements n<Model, Model> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final v<?> f36336a = new v<>();

    /* JADX INFO: compiled from: UnitModelLoader.java */
    public static class a<Model> implements o<Model, Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a<?> f36337a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> a() {
            return (a<T>) f36337a;
        }

        @Override // y0.o
        @NonNull
        public n<Model, Model> b(r rVar) {
            return v.c();
        }
    }

    @Deprecated
    public v() {
    }

    public static <T> v<T> c() {
        return (v<T>) f36336a;
    }

    @Override // y0.n
    public boolean a(@NonNull Model model) {
        return true;
    }

    @Override // y0.n
    public n.a<Model> b(@NonNull Model model, int i10, int i11, @NonNull r0.h hVar) {
        return new n.a<>(new n1.b(model), new b(model));
    }

    /* JADX INFO: compiled from: UnitModelLoader.java */
    private static class b<Model> implements s0.d<Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Model f36338a;

        b(Model model) {
            this.f36338a = model;
        }

        @Override // s0.d
        @NonNull
        public Class<Model> a() {
            return (Class<Model>) this.f36338a.getClass();
        }

        @Override // s0.d
        @NonNull
        public r0.a d() {
            return r0.a.LOCAL;
        }

        @Override // s0.d
        public void e(@NonNull com.bumptech.glide.f fVar, @NonNull d.a<? super Model> aVar) {
            aVar.f(this.f36338a);
        }

        @Override // s0.d
        public void b() {
        }

        @Override // s0.d
        public void cancel() {
        }
    }
}
