package com.unity3d.ads.core.domain.events;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.data.repository.OperativeEventRepository;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.work.BackgroundWorker;
import com.unity3d.ads.core.domain.work.OperativeEventJob;
import com.unity3d.ads.core.domain.work.UniversalRequestWorkerData;
import gatewayprotocol.v1.OperativeEventRequestOuterClass;
import gatewayprotocol.v1.UniversalRequestKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import h9.p;
import java.util.UUID;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.i;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.j;
import s9.y;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: OperativeEventObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OperativeEventObserver {

    @NotNull
    private final BackgroundWorker backgroundWorker;

    @NotNull
    private final k0 defaultDispatcher;

    @NotNull
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    @NotNull
    private final y<Boolean> isRunning;

    @NotNull
    private final OperativeEventRepository operativeEventRepository;

    @NotNull
    private final UniversalRequestDataSource universalRequestDataSource;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: OperativeEventObserver.kt */
    @f(c = "com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2", f = "OperativeEventObserver.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, d<? super v8.k0>, Object> {
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: OperativeEventObserver.kt */
        @f(c = "com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2$2", f = "OperativeEventObserver.kt", l = {40, 43}, m = "invokeSuspend")
        static final class C04922 extends l implements p<OperativeEventRequestOuterClass.OperativeEventRequest, d<? super v8.k0>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ OperativeEventObserver this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C04922(OperativeEventObserver operativeEventObserver, d<? super C04922> dVar) {
                super(2, dVar);
                this.this$0 = operativeEventObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                C04922 c04922 = new C04922(this.this$0, dVar);
                c04922.L$0 = obj;
                return c04922;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest, @Nullable d<? super v8.k0> dVar) {
                return ((C04922) create(operativeEventRequest, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                String str;
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest = (OperativeEventRequestOuterClass.OperativeEventRequest) this.L$0;
                    UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
                    UniversalRequestKt.PayloadKt.Dsl.Companion companion = UniversalRequestKt.PayloadKt.Dsl.Companion;
                    UniversalRequestOuterClass.UniversalRequest.Payload.Builder builderNewBuilder = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
                    t.h(builderNewBuilder, "newBuilder()");
                    UniversalRequestKt.PayloadKt.Dsl dsl_create = companion._create(builderNewBuilder);
                    dsl_create.setOperativeEvent(operativeEventRequest);
                    UniversalRequestOuterClass.UniversalRequest.Payload payload_build = dsl_create._build();
                    GetUniversalRequestForPayLoad getUniversalRequestForPayLoad = this.this$0.getUniversalRequestForPayLoad;
                    this.label = 1;
                    obj = getUniversalRequestForPayLoad.invoke(payload_build, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        str = (String) this.L$0;
                        u.b(obj);
                        UniversalRequestWorkerData universalRequestWorkerData = new UniversalRequestWorkerData(str);
                        BackgroundWorker backgroundWorker = this.this$0.backgroundWorker;
                        Constraints constraintsBuild = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
                        t.h(constraintsBuild, "Builder()\n            .s…TED)\n            .build()");
                        OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(OperativeEventJob.class).setConstraints(constraintsBuild).setInputData(universalRequestWorkerData.invoke()).build();
                        t.h(oneTimeWorkRequestBuild, "OneTimeWorkRequestBuilde…a())\n            .build()");
                        backgroundWorker.getWorkManager().enqueue(oneTimeWorkRequestBuild);
                        return v8.k0.f35197a;
                    }
                    u.b(obj);
                }
                String string = UUID.randomUUID().toString();
                t.h(string, "randomUUID().toString()");
                UniversalRequestDataSource universalRequestDataSource = this.this$0.universalRequestDataSource;
                byte[] byteArray = ((UniversalRequestOuterClass.UniversalRequest) obj).toByteArray();
                t.h(byteArray, "fullRequest.toByteArray()");
                ByteString byteString = ByteStringsKt.toByteString(byteArray);
                this.L$0 = string;
                this.label = 2;
                if (universalRequestDataSource.set(string, byteString, this) == objE) {
                    return objE;
                }
                str = string;
                UniversalRequestWorkerData universalRequestWorkerData2 = new UniversalRequestWorkerData(str);
                BackgroundWorker backgroundWorker2 = this.this$0.backgroundWorker;
                Constraints constraintsBuild2 = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
                t.h(constraintsBuild2, "Builder()\n            .s…TED)\n            .build()");
                OneTimeWorkRequest oneTimeWorkRequestBuild2 = new OneTimeWorkRequest.Builder(OperativeEventJob.class).setConstraints(constraintsBuild2).setInputData(universalRequestWorkerData2.invoke()).build();
                t.h(oneTimeWorkRequestBuild2, "OneTimeWorkRequestBuilde…a())\n            .build()");
                backgroundWorker2.getWorkManager().enqueue(oneTimeWorkRequestBuild2);
                return v8.k0.f35197a;
            }
        }

        AnonymousClass2(d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return OperativeEventObserver.this.new AnonymousClass2(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object value;
            Boolean bool;
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            y yVar = OperativeEventObserver.this.isRunning;
            do {
                value = yVar.getValue();
                bool = (Boolean) value;
                bool.booleanValue();
            } while (!yVar.d(value, b.a(true)));
            if (bool.booleanValue()) {
                return v8.k0.f35197a;
            }
            j.D(j.G(OperativeEventObserver.this.operativeEventRepository.getOperativeEvents(), new C04922(OperativeEventObserver.this, null)), p0.a(OperativeEventObserver.this.defaultDispatcher));
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super v8.k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public OperativeEventObserver(@NotNull GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, @NotNull k0 defaultDispatcher, @NotNull OperativeEventRepository operativeEventRepository, @NotNull UniversalRequestDataSource universalRequestDataSource, @NotNull BackgroundWorker backgroundWorker) {
        t.i(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        t.i(defaultDispatcher, "defaultDispatcher");
        t.i(operativeEventRepository, "operativeEventRepository");
        t.i(universalRequestDataSource, "universalRequestDataSource");
        t.i(backgroundWorker, "backgroundWorker");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
        this.defaultDispatcher = defaultDispatcher;
        this.operativeEventRepository = operativeEventRepository;
        this.universalRequestDataSource = universalRequestDataSource;
        this.backgroundWorker = backgroundWorker;
        this.isRunning = s9.o0.a(Boolean.FALSE);
    }

    @Nullable
    public final Object invoke(@NotNull d<? super v8.k0> dVar) {
        Object objG = i.g(this.defaultDispatcher, new AnonymousClass2(null), dVar);
        return objG == a9.d.e() ? objG : v8.k0.f35197a;
    }
}
