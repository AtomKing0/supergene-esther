package bo.app;

import com.braze.models.IBrazeLocation;

/* JADX INFO: loaded from: classes2.dex */
public final class n9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBrazeLocation f3475a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n9(IBrazeLocation iBrazeLocation) {
        super(0);
        this.f3475a = iBrazeLocation;
    }

    @Override // h9.a
    public final Object invoke() {
        return new ba(lx.LOCATION_RECORDED, this.f3475a.forJsonPut(), 0.0d, 12);
    }
}
