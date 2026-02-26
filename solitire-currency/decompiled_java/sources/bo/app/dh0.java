package bo.app;

import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dh0 extends bh0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HashMap f2657f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dh0(JSONObject json) {
        super(json);
        kotlin.jvm.internal.t.i(json, "json");
        this.f2657f = new LinkedHashMap();
    }
}
