package bo.app;

import com.braze.enums.CardKey;
import com.braze.storage.ICardStorageProvider;
import com.braze.support.BrazeLogger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class wl extends kotlin.jvm.internal.v implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardKey.Provider f4215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h00 f4216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ICardStorageProvider f4217c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m00 f4218d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ JSONArray f4219e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wl(m00 m00Var, CardKey.Provider provider, h00 h00Var, ICardStorageProvider iCardStorageProvider, JSONArray jSONArray) {
        super(1);
        this.f4215a = provider;
        this.f4216b = h00Var;
        this.f4217c = iCardStorageProvider;
        this.f4218d = m00Var;
        this.f4219e = jSONArray;
    }

    @Override // h9.l
    public final Object invoke(Object it) {
        kotlin.jvm.internal.t.i(it, "it");
        try {
            String string = it.toString();
            return xl.a(new JSONObject(string), this.f4215a, this.f4216b, this.f4217c, this.f4218d);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) xl.f4289a, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new vl(it, this.f4219e), 4, (Object) null);
            return null;
        }
    }
}
