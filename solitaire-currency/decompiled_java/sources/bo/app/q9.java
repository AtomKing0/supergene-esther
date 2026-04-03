package bo.app;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.CmcdData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q9 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3694b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q9(String str, String str2) {
        super(0);
        this.f3693a = str;
        this.f3694b = str2;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        JSONObject eventData = new JSONObject().put(CmcdConfiguration.KEY_CONTENT_ID, this.f3693a).put(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, this.f3694b);
        lx lxVar = lx.PUSH_STORY_PAGE_CLICK;
        kotlin.jvm.internal.t.h(eventData, "eventData");
        return new ba(lxVar, eventData, 0.0d, 12);
    }
}
