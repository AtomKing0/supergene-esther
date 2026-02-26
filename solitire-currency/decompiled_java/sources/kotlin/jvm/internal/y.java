package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: MutablePropertyReference0Impl.java */
/* JADX INFO: loaded from: classes5.dex */
public class y extends x {
    public y(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(f.NO_RECEIVER, ((h) kDeclarationContainer).a(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    public Object get() {
        return getGetter().call(new Object[0]);
    }

    public void set(Object obj) {
        getSetter().call(obj);
    }

    public y(Class cls, String str, String str2, int i10) {
        super(f.NO_RECEIVER, cls, str, str2, i10);
    }

    public y(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
