package bo.app;

import com.braze.enums.Gender;

/* JADX INFO: loaded from: classes2.dex */
public final class vj extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Gender f4122a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vj(Gender gender) {
        super(0);
        this.f4122a = gender;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to set gender to: " + this.f4122a;
    }
}
