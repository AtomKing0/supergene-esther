package androidx.compose.ui.text.font;

import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2", f = "FontListFontFamilyTypefaceAdapter.kt", l = {305}, m = "invokeSuspend")
final class AsyncFontListLoader$loadWithTimeoutOrNull$2 extends l implements p<o0, z8.d<? super Object>, Object> {
    final /* synthetic */ Font $this_loadWithTimeoutOrNull;
    int label;
    final /* synthetic */ AsyncFontListLoader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncFontListLoader$loadWithTimeoutOrNull$2(AsyncFontListLoader asyncFontListLoader, Font font, z8.d<? super AsyncFontListLoader$loadWithTimeoutOrNull$2> dVar) {
        super(2, dVar);
        this.this$0 = asyncFontListLoader;
        this.$this_loadWithTimeoutOrNull = font;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new AsyncFontListLoader$loadWithTimeoutOrNull$2(this.this$0, this.$this_loadWithTimeoutOrNull, dVar);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4invoke(o0 o0Var, z8.d<? super Object> dVar) {
        return invoke2(o0Var, (z8.d<Object>) dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            PlatformFontLoader platformFontLoader = this.this$0.platformFontLoader;
            Font font = this.$this_loadWithTimeoutOrNull;
            this.label = 1;
            obj = platformFontLoader.awaitLoad(font, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return obj;
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull o0 o0Var, @Nullable z8.d<Object> dVar) {
        return ((AsyncFontListLoader$loadWithTimeoutOrNull$2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
