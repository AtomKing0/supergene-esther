package com.unity3d.ads.core.domain.om;

import android.content.Context;
import com.unity3d.ads.core.data.repository.OpenMeasurementRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InitializeOMAndroidSDK.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitializeOMAndroidSDK implements InitializeOMSDK {

    @NotNull
    private final Context context;

    @NotNull
    private final OpenMeasurementRepository omRepository;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    @NotNull
    private final SessionRepository sessionRepository;

    /* JADX INFO: renamed from: com.unity3d.ads.core.domain.om.InitializeOMAndroidSDK$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: InitializeOMAndroidSDK.kt */
    @f(c = "com.unity3d.ads.core.domain.om.InitializeOMAndroidSDK", f = "InitializeOMAndroidSDK.kt", l = {28}, m = "invoke")
    static final class AnonymousClass1 extends d {
        long J$0;
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
            return InitializeOMAndroidSDK.this.invoke(this);
        }
    }

    public InitializeOMAndroidSDK(@NotNull Context context, @NotNull SendDiagnosticEvent sendDiagnosticEvent, @NotNull SessionRepository sessionRepository, @NotNull OpenMeasurementRepository omRepository) {
        t.i(context, "context");
        t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        t.i(sessionRepository, "sessionRepository");
        t.i(omRepository, "omRepository");
        this.context = context;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
        this.sessionRepository = sessionRepository;
        this.omRepository = omRepository;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.ads.core.domain.om.InitializeOMSDK
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object invoke(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r15) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.om.InitializeOMAndroidSDK.invoke(z8.d):java.lang.Object");
    }
}
