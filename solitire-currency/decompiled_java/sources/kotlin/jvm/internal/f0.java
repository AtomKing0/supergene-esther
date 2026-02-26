package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;

/* JADX INFO: compiled from: PropertyReference1.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class f0 extends h0 implements KProperty1 {
    public f0() {
    }

    @Override // kotlin.jvm.internal.f
    protected KCallable computeReflected() {
        return o0.g(this);
    }

    @Override // kotlin.reflect.KProperty1
    public Object getDelegate(Object obj) {
        return ((KProperty1) getReflected()).getDelegate(obj);
    }

    @Override // kotlin.reflect.KProperty1, h9.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public f0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.KProperty
    public KProperty1.Getter getGetter() {
        return ((KProperty1) getReflected()).getGetter();
    }

    public f0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
