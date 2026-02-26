package bo.app;

import com.braze.models.inappmessage.MessageButton;

/* JADX INFO: loaded from: classes2.dex */
public final class f9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f2785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MessageButton f2786b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f9(String str, MessageButton messageButton) {
        super(0);
        this.f2785a = str;
        this.f2786b = messageButton;
    }

    @Override // h9.a
    public final Object invoke() {
        return new ba(lx.INAPP_MESSAGE_BUTTON_CLICK, z9.a(ba.f2429g, this.f2785a, this.f2786b.getStringId(), 4), 0.0d, 12);
    }
}
