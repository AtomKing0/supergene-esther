package bo.app;

import com.braze.events.FeedUpdatedEvent;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class ah extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ih f2381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONArray f2382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2383c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ih ihVar, JSONArray jSONArray, String str) {
        super(0);
        this.f2381a = ihVar;
        this.f2382b = jSONArray;
        this.f2383c = str;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        FeedUpdatedEvent feedUpdatedEventA = this.f2381a.f3057c.a(this.f2383c, this.f2382b);
        if (feedUpdatedEventA != null) {
            ((vw) this.f2381a.f3056b).b(FeedUpdatedEvent.class, feedUpdatedEventA);
        }
        return v8.k0.f35197a;
    }
}
