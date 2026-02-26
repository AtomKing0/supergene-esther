package i7;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

/* JADX INFO: compiled from: QueryInfoCallback.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends QueryInfoGenerationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b7.a f26629b;

    public a(String str, b7.a aVar) {
        this.f26628a = str;
        this.f26629b = aVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public void onFailure(String str) {
        this.f26629b.onFailure(str);
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public void onSuccess(QueryInfo queryInfo) {
        this.f26629b.a(this.f26628a, queryInfo.getQuery(), queryInfo);
    }
}
