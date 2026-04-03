package bo.app;

import androidx.media3.exoplayer.upstream.CmcdData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class w9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4174b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w9(String str, String str2) {
        super(0);
        this.f4173a = str;
        this.f4174b = str2;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject eventData = new JSONObject().put(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, this.f4173a).put(CmcdData.Factory.STREAM_TYPE_LIVE, this.f4174b);
        lx lxVar = lx.USER_ALIAS;
        kotlin.jvm.internal.t.h(eventData, "eventData");
        return new ba(lxVar, eventData, 0.0d, 12);
    }
}
