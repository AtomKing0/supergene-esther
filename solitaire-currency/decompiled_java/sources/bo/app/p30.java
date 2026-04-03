package bo.app;

import com.braze.models.inappmessage.InAppMessageBase;

/* JADX INFO: loaded from: classes2.dex */
public final class p30 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q30 f3601a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p30(q30 q30Var) {
        super(0);
        this.f3601a = q30Var;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Failed to return remote paths to assets for type: ");
        InAppMessageBase inAppMessageBase = this.f3601a.f3681g;
        sb.append(inAppMessageBase != null ? inAppMessageBase.getMessageType() : null);
        return sb.toString();
    }
}
