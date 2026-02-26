package ab;

import java.lang.annotation.Annotation;

/* JADX INFO: compiled from: SkipCallbackExecutorImpl.java */
/* JADX INFO: loaded from: classes5.dex */
final class c0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b0 f394a = new c0();

    c0() {
    }

    static Annotation[] a(Annotation[] annotationArr) {
        if (d0.l(annotationArr, b0.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[annotationArr.length + 1];
        annotationArr2[0] = f394a;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return b0.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof b0;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + b0.class.getName() + "()";
    }
}
