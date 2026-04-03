package kotlin.jvm.internal;

/* JADX INFO: compiled from: PropertyReference0Impl.java */
/* JADX INFO: loaded from: classes5.dex */
public class e0 extends d0 {
    public e0(Class cls, String str, String str2, int i10) {
        super(f.NO_RECEIVER, cls, str, str2, i10);
    }

    @Override // kotlin.reflect.KProperty0
    public Object get() {
        return getGetter().call(new Object[0]);
    }

    public e0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
