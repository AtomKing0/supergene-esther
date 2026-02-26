package bo.app;

import com.braze.models.FeatureFlag;

/* JADX INFO: loaded from: classes2.dex */
public final class dy extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FeatureFlag f2691a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dy(FeatureFlag featureFlag) {
        super(0);
        this.f2691a = featureFlag;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Error storing Feature Flag: " + this.f2691a + '.';
    }
}
