package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KProperty0;

/* JADX INFO: compiled from: MutablePropertyReference0.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class x extends b0 implements KMutableProperty0 {
    public x() {
    }

    @Override // kotlin.jvm.internal.f
    protected KCallable computeReflected() {
        return o0.d(this);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return ((KMutableProperty0) getReflected()).getDelegate();
    }

    @Override // kotlin.reflect.KMutableProperty0, kotlin.reflect.KProperty0, h9.a
    public Object invoke() {
        return get();
    }

    public x(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty
    public KProperty0.Getter getGetter() {
        return ((KMutableProperty0) getReflected()).getGetter();
    }

    @Override // kotlin.reflect.KMutableProperty
    public KMutableProperty0.Setter getSetter() {
        return ((KMutableProperty0) getReflected()).getSetter();
    }

    public x(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
