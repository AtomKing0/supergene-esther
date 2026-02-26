package bo.app;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: classes2.dex */
public final class wt extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4225a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wt(String str, z8.d dVar) {
        super(2, dVar);
        this.f4225a = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new wt(this.f4225a, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return new wt(this.f4225a, (z8.d) obj2).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) throws IOException {
        a9.d.e();
        v8.u.b(obj);
        URLConnection uRLConnectionOpenConnection = new URL(this.f4225a).openConnection();
        uRLConnectionOpenConnection.setRequestProperty("Accept", "text/event-stream");
        uRLConnectionOpenConnection.setDoInput(true);
        uRLConnectionOpenConnection.connect();
        return uRLConnectionOpenConnection;
    }
}
