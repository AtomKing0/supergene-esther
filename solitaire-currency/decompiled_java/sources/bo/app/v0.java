package bo.app;

import com.braze.configuration.BrazeConfig;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeConfig f4065a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(BrazeConfig brazeConfig) {
        super(0);
        this.f4065a = brazeConfig;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Setting pending config object: " + this.f4065a;
    }
}
