package com.applovin.impl.sdk.network;

import androidx.core.app.NotificationCompat;
import com.applovin.impl.e5;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.EventServiceImpl;
import com.applovin.impl.sdk.j;
import com.applovin.impl.w4;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PostbackServiceImpl implements AppLovinPostbackService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f7230a;

    public PostbackServiceImpl(j jVar) {
        this.f7230a = jVar;
    }

    private boolean a(e eVar) {
        Map mapI = eVar.i();
        if (mapI == null) {
            return false;
        }
        Object obj = mapI.get(NotificationCompat.CATEGORY_EVENT);
        if ("postinstall".equals(obj)) {
            obj = mapI.get("sub_event");
        }
        return EventServiceImpl.ALLOW_PRE_INIT_EVENT_TYPES.contains(obj);
    }

    @Override // com.applovin.sdk.AppLovinPostbackService
    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(e.b(this.f7230a).b(str).a(false).a(), appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(e eVar, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(eVar, r5.b.OTHER, appLovinPostbackListener);
    }

    public String toString() {
        return "PostbackService{}";
    }

    public void dispatchPostbackRequest(e eVar, r5.b bVar, AppLovinPostbackListener appLovinPostbackListener) {
        e5 e5Var = new e5(eVar, bVar, this.f7230a, appLovinPostbackListener);
        e5Var.a(a(eVar));
        this.f7230a.j0().a((w4) e5Var, bVar);
    }
}
