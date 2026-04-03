package bo.app;

import com.braze.Braze;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.support.ValidationUtils;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public final class k3 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BigDecimal f3207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3208d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Braze f3209e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ BrazeProperties f3210f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k3(String str, String str2, BigDecimal bigDecimal, int i10, Braze braze, BrazeProperties brazeProperties) {
        super(0);
        this.f3205a = str;
        this.f3206b = str2;
        this.f3207c = bigDecimal;
        this.f3208d = i10;
        this.f3209e = braze;
        this.f3210f = brazeProperties;
    }

    @Override // h9.a
    public final Object invoke() {
        String str = this.f3205a;
        if (ValidationUtils.isValidLogPurchaseInput(str, this.f3206b, this.f3207c, this.f3208d, ((ci0) this.f3209e.getUdm$android_sdk_base_release()).f2556h)) {
            BrazeProperties brazeProperties = this.f3210f;
            if (brazeProperties == null || !brazeProperties.isInvalid()) {
                String productId = ValidationUtils.ensureBrazeFieldLength(str);
                z9 z9Var = ba.f2429g;
                String currencyCode = this.f3206b;
                kotlin.jvm.internal.t.f(currencyCode);
                BigDecimal price = this.f3207c;
                kotlin.jvm.internal.t.f(price);
                int i10 = this.f3208d;
                BrazeProperties brazeProperties2 = this.f3210f;
                z9Var.getClass();
                kotlin.jvm.internal.t.i(productId, "productId");
                kotlin.jvm.internal.t.i(currencyCode, "currencyCode");
                kotlin.jvm.internal.t.i(price, "price");
                e00 e00VarA = z9Var.a(new p9(productId, currencyCode, price, i10, brazeProperties2));
                if (e00VarA != null && ((ci0) this.f3209e.getUdm$android_sdk_base_release()).f2570v.a(e00VarA)) {
                    ((ci0) this.f3209e.getUdm$android_sdk_base_release()).f2571w.b(new i60(productId, this.f3210f, e00VarA));
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f3209e, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) j3.f3113a, 6, (Object) null);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f3209e, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) i3.f3016a, 6, (Object) null);
        }
        return v8.k0.f35197a;
    }
}
