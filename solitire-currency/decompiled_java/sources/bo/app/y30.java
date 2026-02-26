package bo.app;

import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class y30 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONArray f4319b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y30(int i10, JSONArray jSONArray) {
        super(0);
        this.f4318a = i10;
        this.f4319b = jSONArray;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to get string for item at index: " + this.f4318a + " and array: " + this.f4319b;
    }
}
