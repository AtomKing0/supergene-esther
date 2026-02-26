package bo.app;

import com.braze.events.ContentCardsUpdatedEvent;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class yg extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih f4362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ dm f4363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4364c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yg(ih ihVar, dm dmVar, String str) {
        super(0);
        this.f4362a = ihVar;
        this.f4363b = dmVar;
        this.f4364c = str;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        ContentCardsUpdatedEvent contentCardsUpdatedEventA = this.f4362a.f3059e.a(this.f4363b, this.f4364c);
        if (contentCardsUpdatedEventA != null) {
            ((vw) this.f4362a.f3056b).b(ContentCardsUpdatedEvent.class, contentCardsUpdatedEventA);
        }
        return v8.k0.f35197a;
    }
}
