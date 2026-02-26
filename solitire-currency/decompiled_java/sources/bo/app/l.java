package bo.app;

import android.content.Context;
import com.amazon.device.messaging.ADM;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f3290c = new i();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z00 f3292b;

    public l(Context context, z00 admRegistrationDataProvider) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(admRegistrationDataProvider, "admRegistrationDataProvider");
        this.f3291a = context;
        this.f3292b = admRegistrationDataProvider;
    }

    public final void a() {
        if (((i70) this.f3292b).a() != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new j(this), 6, (Object) null);
            i70 i70Var = (i70) this.f3292b;
            i70Var.a(i70Var.a());
        } else {
            ADM adm = new ADM(this.f3291a);
            if (adm.isSupported()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) k.f3186a, 6, (Object) null);
                adm.startRegister();
            }
        }
    }
}
