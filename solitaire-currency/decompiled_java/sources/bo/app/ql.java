package bo.app;

import com.braze.models.cards.Card;

/* JADX INFO: loaded from: classes2.dex */
public final class ql extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Card f3716a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ql(Card card) {
        super(0);
        this.f3716a = card;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to log card impression for card id: " + this.f3716a.getId();
    }
}
