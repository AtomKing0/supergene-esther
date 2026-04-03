package bo.app;

import com.braze.models.cards.Card;

/* JADX INFO: loaded from: classes2.dex */
public final class nl extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Card f3496a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nl(Card card) {
        super(0);
        this.f3496a = card;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to log card as clicked for id: " + this.f3496a.getId();
    }
}
