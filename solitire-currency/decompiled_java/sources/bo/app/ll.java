package bo.app;

import com.braze.models.cards.Card;

/* JADX INFO: loaded from: classes2.dex */
public final class ll extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Card f3341a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ll(Card card) {
        super(0);
        this.f3341a = card;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Logged click for card with id: " + this.f3341a.getId();
    }
}
