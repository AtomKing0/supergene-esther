package bo.app;

import com.braze.models.IBrazeLocation;

/* JADX INFO: loaded from: classes2.dex */
public final class wd extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IBrazeLocation f4197a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wd(IBrazeLocation iBrazeLocation) {
        super(0);
        this.f4197a = iBrazeLocation;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Invoked manualSetUserLocation for " + this.f4197a;
    }
}
