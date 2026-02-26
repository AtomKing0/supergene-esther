package bo.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class l80 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v80 f3313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3314b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l80(v80 v80Var, long j10) {
        super(0);
        this.f3313a = v80Var;
        this.f3314b = j10;
    }

    @Override // h9.a
    public final Object invoke() {
        v80 v80Var = this.f3313a;
        long j10 = this.f3314b;
        LinkedHashMap linkedHashMap = v80Var.f4086e;
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((uu) ((Map.Entry) it.next()).getValue());
        }
        return p9.j.h("RequestFramework->\n            |mockAllNetworkRequests=" + v80Var.f4084c + "\n            |lastSdkAuthFailureError=" + v80Var.f4089h + "\n            |lastSdkAuthFailureAt=" + (v80Var.f4090i - j10) + "\n            |sdkAuthFailureBackoffUntil=" + (v80Var.f4091j - j10) + "\n            |invalidApiKeyErrorCounter=" + v80Var.f4092k.get() + "\n            |globalRequestRateLimiter=" + v80Var.f4093l + "\n            |lastNetworkLevel=" + v80Var.f4094m + "\n            |endpointQueues=\n            | \n            |" + kotlin.collections.d0.r0(arrayList, "\n\n", null, null, 0, null, new u80(j10), 30, null) + "\n            |  \n            |\n        ", null, 1, null);
    }
}
