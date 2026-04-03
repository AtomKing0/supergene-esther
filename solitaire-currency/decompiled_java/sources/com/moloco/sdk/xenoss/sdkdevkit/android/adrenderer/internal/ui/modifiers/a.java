package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.modifiers;

import android.annotation.SuppressLint;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.c;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.modifiers.a$a, reason: collision with other inner class name */
    public static final class C0406a extends v implements l<LayoutCoordinates, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ a.AbstractC0481a.c f19900g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ l<a.AbstractC0481a.c, k0> f19901h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0406a(a.AbstractC0481a.c cVar, l<? super a.AbstractC0481a.c, k0> lVar) {
            super(1);
            this.f19900g = cVar;
            this.f19901h = lVar;
        }

        public final void a(@NotNull LayoutCoordinates it) {
            t.i(it, "it");
            c cVar = c.f20066a;
            a.AbstractC0481a.c cVarB = cVar.b(it, this.f19900g.c());
            if (!cVar.e(cVarB) || t.d(cVarB, this.f19900g)) {
                return;
            }
            this.f19901h.invoke(cVarB);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(LayoutCoordinates layoutCoordinates) {
            a(layoutCoordinates);
            return k0.f35197a;
        }
    }

    @SuppressLint({"ModifierFactoryExtensionFunction"})
    @NotNull
    public static final Modifier a(@NotNull Modifier modifier, @NotNull a.AbstractC0481a.c savedStateButton, @NotNull l<? super a.AbstractC0481a.c, k0> updateButtonState) {
        t.i(modifier, "modifier");
        t.i(savedStateButton, "savedStateButton");
        t.i(updateButtonState, "updateButtonState");
        return OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, new C0406a(savedStateButton, updateButtonState));
    }
}
