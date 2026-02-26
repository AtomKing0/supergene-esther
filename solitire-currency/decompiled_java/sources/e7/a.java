package e7;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

/* JADX INFO: compiled from: QueryInfoCallback.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends QueryInfoGenerationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f25180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b7.a f25181b;

    public a(String str, b7.a aVar) {
        this.f25180a = str;
        this.f25181b = aVar;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public void onFailure(String str) {
        this.f25181b.onFailure(str);
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public void onSuccess(QueryInfo queryInfo) {
        this.f25181b.a(this.f25180a, queryInfo.getQuery(), queryInfo);
    }
}
