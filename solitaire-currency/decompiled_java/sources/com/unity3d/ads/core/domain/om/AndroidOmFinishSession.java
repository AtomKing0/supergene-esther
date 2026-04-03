package com.unity3d.ads.core.domain.om;

import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidOmFinishSession.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidOmFinishSession implements OmFinishSession {

    @NotNull
    private final OpenMeasurementRepository openMeasurementRepository;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.om.AndroidOmFinishSession$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidOmFinishSession.kt */
    @f(c = "com.unity3d.ads.core.domain.om.AndroidOmFinishSession", f = "AndroidOmFinishSession.kt", l = {17}, m = "invoke")
    static final class AnonymousClass1 extends d {
        Object L$0;
        Object L$1;
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
            return AndroidOmFinishSession.this.invoke(null, this);
        }
    }

    public AndroidOmFinishSession(@NotNull OpenMeasurementRepository openMeasurementRepository, @NotNull SendDiagnosticEvent sendDiagnosticEvent) {
        t.i(openMeasurementRepository, "openMeasurementRepository");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.openMeasurementRepository = openMeasurementRepository;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.om.OmFinishSession
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.unity3d.ads.core.data.model.AdObject r11, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.unity3d.ads.core.domain.om.AndroidOmFinishSession.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r12
            com.unity3d.ads.core.domain.om.AndroidOmFinishSession$invoke$1 r0 = (com.unity3d.ads.core.domain.om.AndroidOmFinishSession.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.ads.core.domain.om.AndroidOmFinishSession$invoke$1 r0 = new com.unity3d.ads.core.domain.om.AndroidOmFinishSession$invoke$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r11 = r0.L$1
            com.unity3d.ads.core.data.model.AdObject r11 = (com.unity3d.ads.core.data.model.AdObject) r11
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.core.domain.om.AndroidOmFinishSession r0 = (com.unity3d.ads.core.domain.om.AndroidOmFinishSession) r0
            v8.u.b(r12)
            goto L50
        L31:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L39:
            v8.u.b(r12)
            com.unity3d.ads.core.data.repository.OpenMeasurementRepository r12 = r10.openMeasurementRepository
            com.google.protobuf.ByteString r2 = r11.getOpportunityId()
            r0.L$0 = r10
            r0.L$1 = r11
            r0.label = r3
            java.lang.Object r12 = r12.finishSession(r2, r0)
            if (r12 != r1) goto L4f
            return r1
        L4f:
            r0 = r10
        L50:
            r7 = r11
            com.unity3d.ads.core.data.model.OMResult r12 = (com.unity3d.ads.core.data.model.OMResult) r12
            boolean r11 = r12 instanceof com.unity3d.ads.core.data.model.OMResult.Success
            if (r11 == 0) goto L65
            com.unity3d.ads.core.domain.SendDiagnosticEvent r2 = r0.sendDiagnosticEvent
            java.lang.String r3 = "om_session_finish_success"
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 14
            r9 = 0
            com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L99
        L65:
            boolean r11 = r12 instanceof com.unity3d.ads.core.data.model.OMResult.Failure
            if (r11 == 0) goto L99
            com.unity3d.ads.core.domain.SendDiagnosticEvent r2 = r0.sendDiagnosticEvent
            java.lang.String r3 = "om_session_finish_failure"
            r4 = 0
            java.util.Map r11 = kotlin.collections.o0.c()
            com.unity3d.ads.core.data.model.OMResult$Failure r12 = (com.unity3d.ads.core.data.model.OMResult.Failure) r12
            java.lang.String r0 = r12.getReason()
            java.lang.String r1 = "reason"
            r11.put(r1, r0)
            java.lang.String r0 = r12.getReasonDebug()
            if (r0 == 0) goto L8c
            java.lang.String r0 = "reason_debug"
            java.lang.String r12 = r12.getReasonDebug()
            r11.put(r0, r12)
        L8c:
            v8.k0 r12 = v8.k0.f35197a
            java.util.Map r5 = kotlin.collections.o0.b(r11)
            r6 = 0
            r8 = 10
            r9 = 0
            com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r2, r3, r4, r5, r6, r7, r8, r9)
        L99:
            v8.k0 r11 = v8.k0.f35197a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.om.AndroidOmFinishSession.invoke(com.unity3d.ads.core.data.model.AdObject, z8.d):java.lang.Object");
    }
}
