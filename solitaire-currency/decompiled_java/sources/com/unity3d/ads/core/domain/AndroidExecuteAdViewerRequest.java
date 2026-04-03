package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.extensions.JSONArrayExtensionsKt;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import h9.p;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.i;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import v8.q;
import v8.u;

/* JADX INFO: compiled from: AndroidExecuteAdViewerRequest.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidExecuteAdViewerRequest implements ExecuteAdViewerRequest {

    @NotNull
    private final HttpClient httpClient;

    @NotNull
    private final k0 ioDispatcher;

    /* JADX INFO: compiled from: AndroidExecuteAdViewerRequest.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RequestType.values().length];
            try {
                iArr[RequestType.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RequestType.HEAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RequestType.POST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.AndroidExecuteAdViewerRequest$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidExecuteAdViewerRequest.kt */
    @f(c = "com.unity3d.ads.core.domain.AndroidExecuteAdViewerRequest$invoke$2", f = "AndroidExecuteAdViewerRequest.kt", l = {24}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, z8.d<? super HttpResponse>, Object> {
        final /* synthetic */ Object[] $parameters;
        final /* synthetic */ RequestType $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(RequestType requestType, Object[] objArr, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$type = requestType;
            this.$parameters = objArr;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return AndroidExecuteAdViewerRequest.this.new AnonymousClass2(this.$type, this.$parameters, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                HttpRequest httpRequestCreateRequest = AndroidExecuteAdViewerRequest.this.createRequest(this.$type, this.$parameters);
                HttpClient httpClient = AndroidExecuteAdViewerRequest.this.httpClient;
                this.label = 1;
                obj = httpClient.execute(httpRequestCreateRequest, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return obj;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super HttpResponse> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public AndroidExecuteAdViewerRequest(@NotNull k0 ioDispatcher, @NotNull HttpClient httpClient) {
        t.i(ioDispatcher, "ioDispatcher");
        t.i(httpClient, "httpClient");
        this.ioDispatcher = ioDispatcher;
        this.httpClient = httpClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HttpRequest createRequest(RequestType requestType, Object[] objArr) {
        Map<String, List<String>> mapG;
        Map<String, List<String>> mapG2;
        String str = (String) kotlin.collections.p.T(objArr, 1);
        if (!(!(str == null || str.length() == 0))) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i10 = WhenMappings.$EnumSwitchMapping$0[requestType.ordinal()];
        if (i10 == 1 || i10 == 2) {
            JSONArray jSONArray = (JSONArray) kotlin.collections.p.T(objArr, 2);
            Integer num = (Integer) kotlin.collections.p.T(objArr, 3);
            Integer num2 = (Integer) kotlin.collections.p.T(objArr, 4);
            if (jSONArray == null || (mapG = JSONArrayExtensionsKt.getHeadersMap(jSONArray)) == null) {
                mapG = r0.g();
            }
            return new HttpRequest(str, null, requestType, null, mapG, null, null, null, null, num != null ? num.intValue() : 30000, num2 != null ? num2.intValue() : 30000, 0, 0, false, null, null, 0, 129514, null);
        }
        if (i10 != 3) {
            throw new q();
        }
        String str2 = (String) kotlin.collections.p.T(objArr, 2);
        JSONArray jSONArray2 = (JSONArray) kotlin.collections.p.T(objArr, 3);
        Integer num3 = (Integer) kotlin.collections.p.T(objArr, 4);
        Integer num4 = (Integer) kotlin.collections.p.T(objArr, 5);
        if (jSONArray2 == null || (mapG2 = JSONArrayExtensionsKt.getHeadersMap(jSONArray2)) == null) {
            mapG2 = r0.g();
        }
        return new HttpRequest(str, null, requestType, str2, mapG2, null, null, null, null, num3 != null ? num3.intValue() : 30000, num4 != null ? num4.intValue() : 30000, 0, 0, false, null, null, 0, 129506, null);
    }

    @Override // com.unity3d.ads.core.domain.ExecuteAdViewerRequest
    @Nullable
    public Object invoke(@NotNull RequestType requestType, @NotNull Object[] objArr, @NotNull z8.d<? super HttpResponse> dVar) {
        return i.g(this.ioDispatcher, new AnonymousClass2(requestType, objArr, null), dVar);
    }
}
