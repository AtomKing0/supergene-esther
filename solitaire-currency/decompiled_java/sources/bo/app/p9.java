package bo.app;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.braze.models.outgoing.BrazeProperties;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class p9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrazeProperties f3610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BigDecimal f3613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f3614e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p9(String str, String str2, BigDecimal bigDecimal, int i10, BrazeProperties brazeProperties) {
        super(0);
        this.f3610a = brazeProperties;
        this.f3611b = str;
        this.f3612c = str2;
        this.f3613d = bigDecimal;
        this.f3614e = i10;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.f3611b;
        String str2 = this.f3612c;
        BigDecimal bigDecimal = this.f3613d;
        int i10 = this.f3614e;
        jSONObject.put("pid", str);
        jSONObject.put("c", str2);
        kotlin.jvm.internal.t.i(bigDecimal, "<this>");
        BigDecimal scale = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        kotlin.jvm.internal.t.h(scale, "this.setScale(2, RoundingMode.HALF_UP)");
        jSONObject.put(TtmlNode.TAG_P, scale.doubleValue());
        jSONObject.put("q", i10);
        BrazeProperties brazeProperties = this.f3610a;
        if (brazeProperties != null && brazeProperties.getSize() > 0) {
            jSONObject.put(CmcdConfiguration.KEY_PLAYBACK_RATE, this.f3610a.forJsonPut());
        }
        return new ba(lx.PURCHASE, jSONObject, 0.0d, 12);
    }
}
