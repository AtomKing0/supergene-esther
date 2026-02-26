package bo.app;

import com.braze.support.ValidationUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class ki0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3255a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ki0(String str) {
        super(0);
        this.f3255a = str;
    }

    @Override // h9.a
    public final Object invoke() {
        return "The currencyCode " + this.f3255a + " is invalid. Expected one of " + ValidationUtils.INSTANCE.getVALID_CURRENCY_CODES();
    }
}
