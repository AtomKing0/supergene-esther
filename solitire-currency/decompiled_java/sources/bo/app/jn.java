package bo.app;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class jn extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kn f3168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3170c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jn(kn knVar, JSONObject jSONObject, String str, z8.d dVar) {
        super(2, dVar);
        this.f3168a = knVar;
        this.f3169b = jSONObject;
        this.f3170c = str;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new jn(this.f3168a, this.f3169b, this.f3170c, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((jn) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        a9.d.e();
        v8.u.b(obj);
        SharedPreferences.Editor editorEdit = this.f3168a.f3272i.edit();
        JSONObject jSONObject = this.f3169b;
        if (jSONObject != null) {
            editorEdit.putString(this.f3170c, jSONObject.toString());
        } else {
            editorEdit.remove(this.f3170c);
        }
        editorEdit.apply();
        return v8.k0.f35197a;
    }
}
