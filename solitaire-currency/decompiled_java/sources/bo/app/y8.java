package bo.app;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.braze.models.outgoing.BrazeProperties;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class y8 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BrazeProperties f4342b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y8(String str, BrazeProperties brazeProperties) {
        super(0);
        this.f4341a = str;
        this.f4342b = brazeProperties;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject eventData = new JSONObject().put(com.ironsource.nb.f14119q, this.f4341a);
        BrazeProperties brazeProperties = this.f4342b;
        if (brazeProperties != null && brazeProperties.getSize() > 0) {
            eventData.put(TtmlNode.TAG_P, this.f4342b.forJsonPut());
        }
        lx lxVar = lx.CUSTOM_EVENT;
        kotlin.jvm.internal.t.h(eventData, "eventData");
        return new ba(lxVar, eventData, 0.0d, 12);
    }
}
