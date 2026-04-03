package com.unity3d.ads.core.domain.events;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.work.BackgroundWorker;
import com.unity3d.ads.core.domain.work.DiagnosticEventJob;
import com.unity3d.ads.core.domain.work.UniversalRequestWorkerData;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.UniversalRequestKt;
import gatewayprotocol.v1.UniversalRequestOuterClass;
import h9.p;
import java.util.List;
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

/* JADX INFO: compiled from: DiagnosticEventObserver.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DiagnosticEventObserver {

    @NotNull
    private final BackgroundWorker backgroundWorker;

    @NotNull
    private final k0 defaultDispatcher;

    @NotNull
    private final DiagnosticEventRepository diagnosticEventRepository;

    @NotNull
    private final GetDiagnosticEventBatchRequest getDiagnosticEventBatchRequest;

    @NotNull
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    @NotNull
    private final y<Boolean> isRunning;

    @NotNull
    private final UniversalRequestDataSource universalRequestDataSource;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.DiagnosticEventObserver$invoke$2, reason: invalid class name */
    /* JADX INFO: compiled from: DiagnosticEventObserver.kt */
    @f(c = "com.unity3d.ads.core.domain.events.DiagnosticEventObserver$invoke$2", f = "DiagnosticEventObserver.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, d<? super v8.k0>, Object> {
        int label;

        /* JADX INFO: renamed from: com.unity3d.ads.core.domain.events.DiagnosticEventObserver$invoke$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DiagnosticEventObserver.kt */
        @f(c = "com.unity3d.ads.core.domain.events.DiagnosticEventObserver$invoke$2$2", f = "DiagnosticEventObserver.kt", l = {42, 45}, m = "invokeSuspend")
        static final class C04912 extends l implements p<List<? extends DiagnosticEventRequestOuterClass.DiagnosticEvent>, d<? super v8.k0>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DiagnosticEventObserver this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C04912(DiagnosticEventObserver diagnosticEventObserver, d<? super C04912> dVar) {
                super(2, dVar);
                this.this$0 = diagnosticEventObserver;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                C04912 c04912 = new C04912(this.this$0, dVar);
                c04912.L$0 = obj;
                return c04912;
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(List<? extends DiagnosticEventRequestOuterClass.DiagnosticEvent> list, d<? super v8.k0> dVar) {
                return invoke2((List<DiagnosticEventRequestOuterClass.DiagnosticEvent>) list, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                String str;
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    List<DiagnosticEventRequestOuterClass.DiagnosticEvent> list = (List) this.L$0;
                    UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
                    DiagnosticEventObserver diagnosticEventObserver = this.this$0;
                    UniversalRequestKt.PayloadKt.Dsl.Companion companion = UniversalRequestKt.PayloadKt.Dsl.Companion;
                    UniversalRequestOuterClass.UniversalRequest.Payload.Builder builderNewBuilder = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
                    t.h(builderNewBuilder, "newBuilder()");
                    UniversalRequestKt.PayloadKt.Dsl dsl_create = companion._create(builderNewBuilder);
                    dsl_create.setDiagnosticEventRequest(diagnosticEventObserver.getDiagnosticEventBatchRequest.invoke(list));
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
                        OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(DiagnosticEventJob.class).setConstraints(constraintsBuild).setInputData(universalRequestWorkerData.invoke()).build();
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
                OneTimeWorkRequest oneTimeWorkRequestBuild2 = new OneTimeWorkRequest.Builder(DiagnosticEventJob.class).setConstraints(constraintsBuild2).setInputData(universalRequestWorkerData2.invoke()).build();
                t.h(oneTimeWorkRequestBuild2, "OneTimeWorkRequestBuilde…a())\n            .build()");
                backgroundWorker2.getWorkManager().enqueue(oneTimeWorkRequestBuild2);
                return v8.k0.f35197a;
            }

            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(@NotNull List<DiagnosticEventRequestOuterClass.DiagnosticEvent> list, @Nullable d<? super v8.k0> dVar) {
                return ((C04912) create(list, dVar)).invokeSuspend(v8.k0.f35197a);
            }
        }

        AnonymousClass2(d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<v8.k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return DiagnosticEventObserver.this.new AnonymousClass2(dVar);
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
            y yVar = DiagnosticEventObserver.this.isRunning;
            do {
                value = yVar.getValue();
                bool = (Boolean) value;
                bool.booleanValue();
            } while (!yVar.d(value, b.a(true)));
            if (bool.booleanValue()) {
                return v8.k0.f35197a;
            }
            j.D(j.G(DiagnosticEventObserver.this.diagnosticEventRepository.getDiagnosticEvents(), new C04912(DiagnosticEventObserver.this, null)), p0.a(DiagnosticEventObserver.this.defaultDispatcher));
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super v8.k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public DiagnosticEventObserver(@NotNull GetUniversalRequestForPayLoad getUniversalRequestForPayLoad, @NotNull GetDiagnosticEventBatchRequest getDiagnosticEventBatchRequest, @NotNull k0 defaultDispatcher, @NotNull DiagnosticEventRepository diagnosticEventRepository, @NotNull UniversalRequestDataSource universalRequestDataSource, @NotNull BackgroundWorker backgroundWorker) {
        t.i(getUniversalRequestForPayLoad, "getUniversalRequestForPayLoad");
        t.i(getDiagnosticEventBatchRequest, "getDiagnosticEventBatchRequest");
        t.i(defaultDispatcher, "defaultDispatcher");
        t.i(diagnosticEventRepository, "diagnosticEventRepository");
        t.i(universalRequestDataSource, "universalRequestDataSource");
        t.i(backgroundWorker, "backgroundWorker");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad;
        this.getDiagnosticEventBatchRequest = getDiagnosticEventBatchRequest;
        this.defaultDispatcher = defaultDispatcher;
        this.diagnosticEventRepository = diagnosticEventRepository;
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
