package bo.app;

import android.content.Context;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.IBrazeLocation;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class zd implements y00 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final vd f4429c = new vd();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h00 f4430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final sd f4431b;

    public zd(Context context, h00 brazeManager, BrazeConfigurationProvider appConfigurationProvider) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        kotlin.jvm.internal.t.i(appConfigurationProvider, "appConfigurationProvider");
        this.f4430a = brazeManager;
        sd sdVar = new sd(context, f4429c.a(appConfigurationProvider), appConfigurationProvider);
        this.f4431b = sdVar;
        if (sdVar.a()) {
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) td.f3914a, 6, (Object) null);
    }

    public final boolean a(IBrazeLocation location) {
        kotlin.jvm.internal.t.i(location, "location");
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new wd(location), 6, (Object) null);
            e00 e00VarA = ba.f2429g.a(location);
            if (e00VarA != null) {
                ((tf) this.f4430a).a(e00VarA);
            }
            return true;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) xd.f4263a, 4, (Object) null);
            return false;
        }
    }
}
