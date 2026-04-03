package bo.app;

import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.z0;

/* JADX INFO: loaded from: classes2.dex */
public final class ex implements f00 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f00 f2755a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v00 f2756b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2757c;

    public ex(pc0 storage, vw eventPublisher) {
        kotlin.jvm.internal.t.i(storage, "storage");
        kotlin.jvm.internal.t.i(eventPublisher, "eventPublisher");
        this.f2755a = storage;
        this.f2756b = eventPublisher;
    }

    @Override // bo.app.f00
    public final void a(e00 event) {
        kotlin.jvm.internal.t.i(event, "event");
        String str = "add event " + event;
        ww wwVar = new ww(this, event);
        if (this.f2757c) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new ax(str), 6, (Object) null);
        } else {
            kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new cx(wwVar, this, str, null), 3, null);
        }
    }

    @Override // bo.app.f00
    public final void a(Set events) {
        kotlin.jvm.internal.t.i(events, "events");
        String str = "delete events " + events;
        zw zwVar = new zw(this, events);
        if (!this.f2757c) {
            kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new cx(zwVar, this, str, null), 3, null);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new ax(str), 6, (Object) null);
        }
    }

    @Override // bo.app.f00
    public final Collection a() {
        if (this.f2757c) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) xw.f4305a, 6, (Object) null);
            return z0.e();
        }
        try {
            return this.f2755a.a();
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) yw.f4385a, 4, (Object) null);
            a(e10);
            return z0.e();
        }
    }

    public final void a(Exception exc) {
        try {
            ((vw) this.f2756b).b(uc0.class, new uc0("A storage exception has occurred!", exc));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) dx.f2690a, 4, (Object) null);
        }
    }
}
