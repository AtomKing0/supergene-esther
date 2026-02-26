package bo.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.TrafficStats;
import android.widget.ImageView;
import com.braze.R$string;
import com.braze.enums.BrazeViewBounds;
import com.braze.images.DefaultBrazeImageLoader;
import com.braze.support.BrazeLogger;
import kotlinx.coroutines.n2;

/* JADX INFO: loaded from: classes2.dex */
public final class dq extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Bitmap f2671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ DefaultBrazeImageLoader f2673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f2674d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f2675e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ BrazeViewBounds f2676f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ImageView f2677g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dq(DefaultBrazeImageLoader defaultBrazeImageLoader, Context context, String str, BrazeViewBounds brazeViewBounds, ImageView imageView, z8.d dVar) {
        super(2, dVar);
        this.f2673c = defaultBrazeImageLoader;
        this.f2674d = context;
        this.f2675e = str;
        this.f2676f = brazeViewBounds;
        this.f2677g = imageView;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        return new dq(this.f2673c, this.f2674d, this.f2675e, this.f2676f, this.f2677g, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((dq) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final Object invokeSuspend(Object obj) {
        Bitmap bitmap;
        Object objE = a9.d.e();
        int i10 = this.f2672b;
        if (i10 == 0) {
            v8.u.b(obj);
            TrafficStats.setThreadStatsTag(1337);
            Bitmap bitmapFromUrl = this.f2673c.getBitmapFromUrl(this.f2674d, this.f2675e, this.f2676f);
            if (bitmapFromUrl == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, DefaultBrazeImageLoader.TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new aq(this.f2675e), 14, (Object) null);
            } else {
                String str = this.f2675e;
                Object tag = this.f2677g.getTag(R$string.com_braze_image_lru_cache_image_url_key);
                kotlin.jvm.internal.t.g(tag, "null cannot be cast to non-null type kotlin.String");
                if (kotlin.jvm.internal.t.d(str, (String) tag)) {
                    n2 n2VarC = kotlinx.coroutines.e1.c();
                    bq bqVar = new bq(this.f2677g, bitmapFromUrl, null);
                    this.f2671a = bitmapFromUrl;
                    this.f2672b = 1;
                    if (kotlinx.coroutines.i.g(n2VarC, bqVar, this) == objE) {
                        return objE;
                    }
                    bitmap = bitmapFromUrl;
                }
            }
            return v8.k0.f35197a;
        }
        if (i10 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        bitmap = this.f2671a;
        v8.u.b(obj);
        BrazeViewBounds brazeViewBounds = this.f2676f;
        ImageView imageView = this.f2677g;
        imageView.addOnLayoutChangeListener(new cq(brazeViewBounds, imageView, bitmap));
        return v8.k0.f35197a;
    }
}
