package androidx.privacysandbox.ads.adservices.topics;

import a9.c;
import android.adservices.topics.GetTopicsRequest;
import android.annotation.SuppressLint;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.annotation.RestrictTo;
import androidx.core.os.OutcomeReceiverKt;
import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.dash.offline.a;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TopicsManagerImplCommon.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresExtension(extension = PlaybackException.CUSTOM_ERROR_CODE_BASE, version = 4)
@SuppressLint({"NewApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class TopicsManagerImplCommon extends TopicsManager {

    @NotNull
    private final android.adservices.topics.TopicsManager mTopicsManager;

    /* JADX INFO: renamed from: androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1, reason: invalid class name */
    /* JADX INFO: compiled from: TopicsManagerImplCommon.kt */
    @f(c = "androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon", f = "TopicsManagerImplCommon.kt", l = {22}, m = "getTopics$suspendImpl")
    static final class AnonymousClass1 extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TopicsManagerImplCommon.getTopics$suspendImpl(TopicsManagerImplCommon.this, null, this);
        }
    }

    public TopicsManagerImplCommon(@NotNull android.adservices.topics.TopicsManager mTopicsManager) {
        t.i(mTopicsManager, "mTopicsManager");
        this.mTopicsManager = mTopicsManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @androidx.annotation.RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    @androidx.annotation.DoNotInline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ java.lang.Object getTopics$suspendImpl(androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon r4, androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest r5, z8.d<? super androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1 r0 = (androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1 r0 = new androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon$getTopics$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon r4 = (androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon) r4
            v8.u.b(r6)
            goto L47
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            v8.u.b(r6)
            android.adservices.topics.GetTopicsRequest r5 = r4.convertRequest$ads_adservices_release(r5)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r4.getTopicsAsyncInternal(r5, r0)
            if (r6 != r1) goto L47
            return r1
        L47:
            android.adservices.topics.GetTopicsResponse r6 = (android.adservices.topics.GetTopicsResponse) r6
            androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse r4 = r4.convertResponse$ads_adservices_release(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon.getTopics$suspendImpl(androidx.privacysandbox.ads.adservices.topics.TopicsManagerImplCommon, androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    public final Object getTopicsAsyncInternal(android.adservices.topics.GetTopicsRequest getTopicsRequest, z8.d<? super android.adservices.topics.GetTopicsResponse> dVar) throws Throwable {
        p pVar = new p(c.c(dVar), 1);
        pVar.C();
        this.mTopicsManager.getTopics(getTopicsRequest, new a(), OutcomeReceiverKt.asOutcomeReceiver(pVar));
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            h.c(dVar);
        }
        return objZ;
    }

    @NotNull
    public android.adservices.topics.GetTopicsRequest convertRequest$ads_adservices_release(@NotNull GetTopicsRequest request) {
        t.i(request, "request");
        android.adservices.topics.GetTopicsRequest getTopicsRequestBuild = new GetTopicsRequest.Builder().setAdsSdkName(request.getAdsSdkName()).build();
        t.h(getTopicsRequestBuild, "Builder()\n            .s…ame)\n            .build()");
        return getTopicsRequestBuild;
    }

    @NotNull
    public final GetTopicsResponse convertResponse$ads_adservices_release(@NotNull android.adservices.topics.GetTopicsResponse response) {
        t.i(response, "response");
        ArrayList arrayList = new ArrayList();
        for (android.adservices.topics.Topic topic : response.getTopics()) {
            arrayList.add(new Topic(topic.getTaxonomyVersion(), topic.getModelVersion(), topic.getTopicId()));
        }
        return new GetTopicsResponse(arrayList);
    }

    @Override // androidx.privacysandbox.ads.adservices.topics.TopicsManager
    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    @DoNotInline
    @Nullable
    public Object getTopics(@NotNull GetTopicsRequest getTopicsRequest, @NotNull z8.d<? super GetTopicsResponse> dVar) {
        return getTopics$suspendImpl(this, getTopicsRequest, dVar);
    }
}
