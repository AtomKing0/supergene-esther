package bo.app;

import android.content.Context;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.location.BrazeInternalLocationApi;
import com.braze.location.IBrazeLocationApi;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes2.dex */
public final class sd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBrazeLocationApi f3849a;

    public sd(Context context, EnumSet allowedProviders, BrazeConfigurationProvider appConfigurationProvider) {
        IBrazeLocationApi iBrazeLocationApi;
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(allowedProviders, "allowedProviders");
        kotlin.jvm.internal.t.i(appConfigurationProvider, "appConfigurationProvider");
        try {
            BrazeInternalLocationApi.Companion companion = BrazeInternalLocationApi.Companion;
            Object objNewInstance = BrazeInternalLocationApi.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            kotlin.jvm.internal.t.g(objNewInstance, "null cannot be cast to non-null type com.braze.location.IBrazeLocationApi");
            iBrazeLocationApi = (IBrazeLocationApi) objNewInstance;
        } catch (Exception unused) {
            iBrazeLocationApi = null;
        }
        this.f3849a = iBrazeLocationApi;
        if (iBrazeLocationApi != null) {
            iBrazeLocationApi.initWithContext(context, allowedProviders, appConfigurationProvider);
        }
    }

    public final boolean a() {
        return this.f3849a != null;
    }
}
