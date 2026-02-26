package bo.app;

import com.braze.configuration.BrazeConfig;

/* JADX INFO: loaded from: classes2.dex */
public final class e90 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeConfig f2717a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e90(BrazeConfig brazeConfig) {
        super(0);
        this.f2717a = brazeConfig;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Setting Braze Override configuration with config: " + this.f2717a;
    }
}
