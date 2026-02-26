package bo.app;

import com.braze.Braze;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class r4 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Braze f3745a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r4(Braze braze) {
        super(0);
        this.f3745a = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        if (((ci0) this.f3745a.getUdm$android_sdk_base_release()).f2556h.z()) {
            gy gyVar = ((ci0) this.f3745a.getUdm$android_sdk_base_release()).f2574z;
            if (gyVar.f2938j.get() > 0) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) gyVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new ay(gyVar), 7, (Object) null);
            } else {
                long jNowInSeconds = DateTimeUtils.nowInSeconds();
                if (jNowInSeconds - gyVar.f2935g.getLong("last_refresh", 0L) < gyVar.f2931c.h()) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) gyVar, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new cy(gyVar, jNowInSeconds), 6, (Object) null);
                    ((vw) gyVar.f2929a).b(iy.class, new iy());
                } else {
                    tf tfVar = (tf) gyVar.f2932d;
                    tfVar.getClass();
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) tfVar, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) lf.f3331a, 7, (Object) null);
                    tfVar.a(new ny(tfVar.f3924f, tfVar.f3923e.getBaseUrlForRequests(), tfVar.f3920b));
                }
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f3745a, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) q4.f3684a, 6, (Object) null);
            ((ci0) this.f3745a.getUdm$android_sdk_base_release()).f2559k.b(iy.class, new iy());
        }
        return v8.k0.f35197a;
    }
}
