package bo.app;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class se0 implements f10 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3852b = BrazeLogger.getBrazeLogTag((Class<?>) se0.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f3853a;

    public se0(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("property_filters");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i10);
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                arrayList2.add(new f60(jSONArray2.getJSONObject(i11)));
            }
            arrayList.add(new h50(arrayList2));
        }
        this.f3853a = new m(arrayList);
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("property_filters", this.f3853a.forJsonPut());
            jSONObject.put("data", jSONObject2);
        } catch (JSONException e10) {
            BrazeLogger.e(f3852b, "Caught exception creating Json.", e10);
        }
        return jSONObject;
    }
}
