package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import f6.h;
import java.util.List;
import kotlin.collections.u;
import l5.c;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public final class FirebaseCommonLegacyRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @NotNull
    public List<c<?>> getComponents() {
        return u.e(h.b("fire-core-ktx", "20.4.3"));
    }
}
