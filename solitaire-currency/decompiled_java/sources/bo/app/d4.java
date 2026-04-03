package bo.app;

import com.braze.Braze;
import com.braze.support.BrazeLogger;
import com.braze.support.ValidationUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class d4 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Braze f2623c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d4(Braze braze, String str, String str2) {
        super(0);
        this.f2621a = str;
        this.f2622b = str2;
        this.f2623c = braze;
    }

    @Override // h9.a
    public final Object invoke() {
        if (ValidationUtils.isValidPushStoryClickInput(this.f2621a, this.f2622b)) {
            z9 z9Var = ba.f2429g;
            String campaignId = this.f2621a;
            kotlin.jvm.internal.t.f(campaignId);
            String pageId = this.f2622b;
            kotlin.jvm.internal.t.f(pageId);
            z9Var.getClass();
            kotlin.jvm.internal.t.i(campaignId, "campaignId");
            kotlin.jvm.internal.t.i(pageId, "pageId");
            e00 e00VarA = z9Var.a(new q9(campaignId, pageId));
            if (e00VarA != null) {
                ((ci0) this.f2623c.getUdm$android_sdk_base_release()).f2570v.a(e00VarA);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f2623c, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) c4.f2482a, 6, (Object) null);
        }
        return v8.k0.f35197a;
    }
}
