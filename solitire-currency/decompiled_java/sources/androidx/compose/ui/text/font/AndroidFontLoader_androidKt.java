package androidx.compose.ui.text.font;

import android.content.Context;
import android.os.Build;
import androidx.core.content.res.ResourcesCompat;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.i;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: AndroidFontLoader.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidFontLoader_androidKt {

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AndroidFontLoader_androidKt$loadAsync$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidFontLoader.android.kt */
    @f(c = "androidx.compose.ui.text.font.AndroidFontLoader_androidKt$loadAsync$2", f = "AndroidFontLoader.android.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, z8.d<? super android.graphics.Typeface>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ ResourceFont $this_loadAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ResourceFont resourceFont, Context context, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$this_loadAsync = resourceFont;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new AnonymousClass2(this.$this_loadAsync, this.$context, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            return AndroidFontLoader_androidKt.load(this.$this_loadAsync, this.$context);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super android.graphics.Typeface> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final android.graphics.Typeface load(ResourceFont resourceFont, Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ResourceFontHelper.INSTANCE.load(context, resourceFont);
        }
        android.graphics.Typeface font = ResourcesCompat.getFont(context, resourceFont.getResId());
        t.f(font);
        t.h(font, "{\n        ResourcesCompa…t(context, resId)!!\n    }");
        return font;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object loadAsync(ResourceFont resourceFont, Context context, z8.d<? super android.graphics.Typeface> dVar) {
        return i.g(e1.b(), new AnonymousClass2(resourceFont, context, null), dVar);
    }
}
