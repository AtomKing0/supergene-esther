package bo.app;

import com.braze.Braze;
import com.braze.models.IBrazeLocation;

/* JADX INFO: loaded from: classes2.dex */
public final class g3 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBrazeLocation f2856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Braze f2857b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g3(IBrazeLocation iBrazeLocation, Braze braze) {
        super(0);
        this.f2856a = iBrazeLocation;
        this.f2857b = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        e00 e00VarA = ba.f2429g.a(this.f2856a);
        if (e00VarA != null) {
            ((ci0) this.f2857b.getUdm$android_sdk_base_release()).f2570v.a(e00VarA);
        }
        return v8.k0.f35197a;
    }
}
