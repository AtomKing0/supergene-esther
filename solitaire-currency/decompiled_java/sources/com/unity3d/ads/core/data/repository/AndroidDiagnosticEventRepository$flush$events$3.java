package com.unity3d.ads.core.data.repository;

import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidDiagnosticEventRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
final class AndroidDiagnosticEventRepository$flush$events$3 extends v implements l<DiagnosticEventRequestOuterClass.DiagnosticEvent, Boolean> {
    final /* synthetic */ AndroidDiagnosticEventRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidDiagnosticEventRepository$flush$events$3(AndroidDiagnosticEventRepository androidDiagnosticEventRepository) {
        super(1);
        this.this$0 = androidDiagnosticEventRepository;
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull DiagnosticEventRequestOuterClass.DiagnosticEvent it) {
        t.i(it, "it");
        return Boolean.valueOf(!this.this$0.blockedEvents.contains(it.getEventType()));
    }
}
