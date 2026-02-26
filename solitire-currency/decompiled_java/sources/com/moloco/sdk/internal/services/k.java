package com.moloco.sdk.internal.services;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.moloco.sdk.internal.services.f;
import org.jetbrains.annotations.NotNull;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f18796a;

    public k(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f18796a = context;
    }

    @Override // com.moloco.sdk.internal.services.i
    @NotNull
    public f a() {
        Object objB;
        try {
            t.a aVar = v8.t.f35208b;
            objB = v8.t.b(AdvertisingIdClient.getAdvertisingIdInfo(this.f18796a));
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(v8.u.a(th));
        }
        f aVar3 = null;
        if (v8.t.g(objB)) {
            objB = null;
        }
        AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) objB;
        if (info != null) {
            if (info.isLimitAdTrackingEnabled()) {
                aVar3 = f.b.f18674a;
            } else {
                String id = info.getId();
                if (id != null) {
                    kotlin.jvm.internal.t.h(id, "this");
                    aVar3 = new f.a(id);
                }
            }
            if (aVar3 != null) {
                return aVar3;
            }
        }
        return f.b.f18674a;
    }
}
