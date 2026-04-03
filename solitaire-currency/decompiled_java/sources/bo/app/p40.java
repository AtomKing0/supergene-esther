package bo.app;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p40 implements n00 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3603b = BrazeLogger.getBrazeLogTag((Class<?>) p40.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f3604a;

    public p40(ArrayList arrayList) {
        this.f3604a = arrayList;
    }

    @Override // com.braze.models.IPutIntoJson
    public final JSONArray forJsonPut() {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = this.f3604a.iterator();
            while (it.hasNext()) {
                jSONArray.put(((n00) it.next()).forJsonPut());
            }
        } catch (Exception e10) {
            BrazeLogger.e(f3603b, "Caught exception creating Json.", e10);
        }
        return jSONArray;
    }
}
