package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty1;

/* JADX INFO: compiled from: MutablePropertyReference1.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class z extends b0 implements KMutableProperty1 {
    public z() {
    }

    @Override // kotlin.jvm.internal.f
    protected KCallable computeReflected() {
        return o0.e(this);
    }

    @Override // kotlin.reflect.KProperty1
    public Object getDelegate(Object obj) {
        return ((KMutableProperty1) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.reflect.KMutableProperty1, kotlin.reflect.KProperty1, h9.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public z(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty
    public KProperty1.Getter getGetter() {
        return ((KMutableProperty1) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty
    public KMutableProperty1.Setter getSetter() {
        return ((KMutableProperty1) getReflected()).getSetter();
    }

    public z(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
