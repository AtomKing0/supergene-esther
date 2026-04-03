package kotlin.jvm.internal;

import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* JADX INFO: compiled from: PropertyReference1Impl.java */
/* JADX INFO: loaded from: classes5.dex */
public class g0 extends f0 {
    public g0(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(f.NO_RECEIVER, ((h) kDeclarationContainer).a(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    public Object get(Object obj) {
        return getGetter().call(obj);
    }

    public g0(Class cls, String str, String str2, int i10) {
        super(f.NO_RECEIVER, cls, str, str2, i10);
    }

    public g0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
