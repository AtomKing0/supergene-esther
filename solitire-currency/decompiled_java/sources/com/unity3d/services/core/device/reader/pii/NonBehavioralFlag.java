package com.unity3d.services.core.device.reader.pii;

import java.util.Locale;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.t;
import v8.u;

/* JADX INFO: compiled from: NonBehavioralFlag.kt */
/* JADX INFO: loaded from: classes4.dex */
public enum NonBehavioralFlag {
    UNKNOWN,
    TRUE,
    FALSE;


    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: NonBehavioralFlag.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final NonBehavioralFlag fromString(@NotNull String value) {
            Object objB;
            t.i(value, "value");
            try {
                t.a aVar = v8.t.f35208b;
                String upperCase = value.toUpperCase(Locale.ROOT);
                kotlin.jvm.internal.t.h(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                objB = v8.t.b(NonBehavioralFlag.valueOf(upperCase));
            } catch (Throwable th) {
                t.a aVar2 = v8.t.f35208b;
                objB = v8.t.b(u.a(th));
            }
            NonBehavioralFlag nonBehavioralFlag = NonBehavioralFlag.UNKNOWN;
            if (v8.t.g(objB)) {
                objB = nonBehavioralFlag;
            }
            return (NonBehavioralFlag) objB;
        }
    }
}
