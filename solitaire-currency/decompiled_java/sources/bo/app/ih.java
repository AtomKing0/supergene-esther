package bo.app;

import com.braze.events.NoMatchingTriggerEvent;
import com.braze.support.BrazeLogger;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class ih {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v00 f3055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v00 f3056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xy f3057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vb0 f3058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kn f3059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap f3060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l00 f3061g;

    public ih(z80 requestInfo, x00 httpConnector, v00 internalPublisher, v00 externalPublisher, xy feedStorageProvider, h00 brazeManager, vb0 serverConfigStorage, kn contentCardsStorage, ju endpointMetadataProvider, a80 requestDispatchCallback) {
        kotlin.jvm.internal.t.i(requestInfo, "requestInfo");
        kotlin.jvm.internal.t.i(httpConnector, "httpConnector");
        kotlin.jvm.internal.t.i(internalPublisher, "internalPublisher");
        kotlin.jvm.internal.t.i(externalPublisher, "externalPublisher");
        kotlin.jvm.internal.t.i(feedStorageProvider, "feedStorageProvider");
        kotlin.jvm.internal.t.i(brazeManager, "brazeManager");
        kotlin.jvm.internal.t.i(serverConfigStorage, "serverConfigStorage");
        kotlin.jvm.internal.t.i(contentCardsStorage, "contentCardsStorage");
        kotlin.jvm.internal.t.i(endpointMetadataProvider, "endpointMetadataProvider");
        kotlin.jvm.internal.t.i(requestDispatchCallback, "requestDispatchCallback");
        this.f3055a = internalPublisher;
        this.f3056b = externalPublisher;
        this.f3057c = feedStorageProvider;
        this.f3058d = serverConfigStorage;
        this.f3059e = contentCardsStorage;
        HashMap mapA = w80.a();
        this.f3060f = mapA;
        l00 l00VarA = requestInfo.a();
        this.f3061g = l00VarA;
        l00VarA.a(mapA);
    }

    public final void a(d10 responseError) {
        kotlin.jvm.internal.t.i(responseError, "responseError");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new gh(responseError), 6, (Object) null);
        ((vw) this.f3055a).b(wb0.class, new wb0(responseError));
        l00 l00Var = this.f3061g;
        if (l00Var instanceof gd0) {
            v00 v00Var = this.f3056b;
            String strA = ((gd0) l00Var).f2899k.a();
            kotlin.jvm.internal.t.h(strA, "request.triggerEvent.triggerEventType");
            ((vw) v00Var).b(NoMatchingTriggerEvent.class, new NoMatchingTriggerEvent(strA));
        }
    }
}
