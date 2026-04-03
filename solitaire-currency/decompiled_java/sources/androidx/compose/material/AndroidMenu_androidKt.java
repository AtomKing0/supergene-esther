package androidx.compose.material;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import h9.a;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidMenu.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidMenu_androidKt {

    /* JADX INFO: renamed from: androidx.compose.material.AndroidMenu_androidKt$DropdownMenuItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidMenu.android.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ a<k0> $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(a<k0> aVar, Modifier modifier, boolean z10, PaddingValues paddingValues, MutableInteractionSource mutableInteractionSource, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
            super(2);
            this.$onClick = aVar;
            this.$modifier = modifier;
            this.$enabled = z10;
            this.$contentPadding = paddingValues;
            this.$interactionSource = mutableInteractionSource;
            this.$content = qVar;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            AndroidMenu_androidKt.DropdownMenuItem(this.$onClick, this.$modifier, this.$enabled, this.$contentPadding, this.$interactionSource, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0174  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* JADX INFO: renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m856DropdownMenuILWXrKs(boolean r24, @org.jetbrains.annotations.NotNull h9.a<v8.k0> r25, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, long r27, @org.jetbrains.annotations.Nullable androidx.compose.ui.window.PopupProperties r29, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r30, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidMenu_androidKt.m856DropdownMenuILWXrKs(boolean, h9.a, androidx.compose.ui.Modifier, long, androidx.compose.ui.window.PopupProperties, h9.q, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DropdownMenuItem(@org.jetbrains.annotations.NotNull h9.a<v8.k0> r17, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r18, boolean r19, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r20, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r21, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r22, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AndroidMenu_androidKt.DropdownMenuItem(h9.a, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, h9.q, androidx.compose.runtime.Composer, int, int):void");
    }
}
