package l4;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: CircularRevealWidget.java */
/* JADX INFO: loaded from: classes3.dex */
public interface d {

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class b implements TypeEvaluator<e> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f30820b = new b();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e f30821a = new e();

        @Override // android.animation.TypeEvaluator
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f10, @NonNull e eVar, @NonNull e eVar2) {
            this.f30821a.a(r4.a.c(eVar.f30824a, eVar2.f30824a, f10), r4.a.c(eVar.f30825b, eVar2.f30825b, f10), r4.a.c(eVar.f30826c, eVar2.f30826c, f10));
            return this.f30821a;
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class c extends Property<d, e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<d, e> f30822a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        @Nullable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(@NonNull d dVar) {
            return dVar.getRevealInfo();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull d dVar, @Nullable e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* JADX INFO: renamed from: l4.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class C0621d extends Property<d, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Property<d, Integer> f30823a = new C0621d("circularRevealScrimColor");

        private C0621d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(@NonNull d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull d dVar, @NonNull Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* JADX INFO: compiled from: CircularRevealWidget.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f30824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f30825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f30826c;

        private e() {
        }

        public void a(float f10, float f11, float f12) {
            this.f30824a = f10;
            this.f30825b = f11;
            this.f30826c = f12;
        }

        public e(float f10, float f11, float f12) {
            this.f30824a = f10;
            this.f30825b = f11;
            this.f30826c = f12;
        }
    }

    void a();

    void b();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    e getRevealInfo();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(@ColorInt int i10);

    void setRevealInfo(@Nullable e eVar);
}
