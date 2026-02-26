package bo.app;

import com.braze.support.ValidationUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class ji0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ji0 f3162a = new ji0();

    public ji0() {
        super(0);
    }

    @Override // h9.a
    public final Object invoke() {
        return "The currencyCode is empty. Expected one of " + ValidationUtils.INSTANCE.getVALID_CURRENCY_CODES();
    }
}
