package bo.app;

import com.braze.enums.DeviceKey;

/* JADX INFO: loaded from: classes2.dex */
public final class kq extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeviceKey f3278a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kq(DeviceKey deviceKey) {
        super(0);
        this.f3278a = deviceKey;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Not adding device key <" + this.f3278a + "> to export due to allowlist restrictions.";
    }
}
