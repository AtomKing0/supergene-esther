package bo.app;

import com.braze.enums.CardKey;

/* JADX INFO: loaded from: classes2.dex */
public final class bn extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f2465a = Boolean.TRUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CardKey f2466b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bn(CardKey cardKey) {
        super(0);
        this.f2466b = cardKey;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to update card json field to " + this.f2465a + " with key: " + this.f2466b;
    }
}
