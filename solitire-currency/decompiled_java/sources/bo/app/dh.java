package bo.app;

import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageBase;

/* JADX INFO: loaded from: classes2.dex */
public final class dh extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih f2654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IInAppMessage f2655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2656c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh(ih ihVar, InAppMessageBase inAppMessageBase, String str) {
        super(0);
        this.f2654a = ihVar;
        this.f2655b = inAppMessageBase;
        this.f2656c = str;
    }

    @Override // h9.a
    public final Object invoke() {
        l00 l00Var = this.f2654a.f3061g;
        if (l00Var instanceof gd0) {
            this.f2655b.setExpirationTimestamp(((gd0) l00Var).f2903o);
            ih ihVar = this.f2654a;
            v00 v00Var = ihVar.f3055a;
            gd0 gd0Var = (gd0) ihVar.f3061g;
            ((vw) v00Var).b(d30.class, new d30(gd0Var.f2899k, gd0Var.f2904p, this.f2655b, this.f2656c));
        }
        return v8.k0.f35197a;
    }
}
