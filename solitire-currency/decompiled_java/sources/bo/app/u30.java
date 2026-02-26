package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes2.dex */
public final class u30 implements k9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f3985a;

    public final void setValue(Object thisRef, KProperty property, Object obj) {
        kotlin.jvm.internal.t.i(thisRef, "thisRef");
        kotlin.jvm.internal.t.i(property, "property");
        Object obj2 = this.f3985a;
        if (obj2 == null) {
            this.f3985a = obj;
        } else {
            if (kotlin.jvm.internal.t.d(obj2, obj)) {
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new t30(obj, property), 7, (Object) null);
        }
    }
}
