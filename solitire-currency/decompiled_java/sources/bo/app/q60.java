package bo.app;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
public final class q60 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o60 f3686a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q60(o60 o60Var) {
        super(0);
        this.f3686a = o60Var;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        StringBuilder sb = new StringBuilder("Clearing PDE from storage with uid ");
        String string = this.f3686a.f2432b.getString(CmcdConfiguration.KEY_CONTENT_ID);
        kotlin.jvm.internal.t.h(string, "data.getString(IBrazeEvent.DATA_CAMPAIGN_ID)");
        sb.append(string);
        return sb.toString();
    }
}
