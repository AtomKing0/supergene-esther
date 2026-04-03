package androidx.compose.ui.text.font;

import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1", f = "FontListFontFamilyTypefaceAdapter.kt", l = {105}, m = "invokeSuspend")
final class FontListFontFamilyTypefaceAdapter$preload$3$2$1 extends l implements p<o0, z8.d<? super Object>, Object> {
    final /* synthetic */ Font $font;
    final /* synthetic */ PlatformFontLoader $resourceLoader;
    int label;
    final /* synthetic */ FontListFontFamilyTypefaceAdapter this$0;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
    @f(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1", f = "FontListFontFamilyTypefaceAdapter.kt", l = {107}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements h9.l<z8.d<? super Object>, Object> {
        final /* synthetic */ Font $font;
        final /* synthetic */ PlatformFontLoader $resourceLoader;
        int label;

        /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
        @f(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3$2$1$1$1", f = "FontListFontFamilyTypefaceAdapter.kt", l = {108}, m = "invokeSuspend")
        static final class C01261 extends l implements p<o0, z8.d<? super Object>, Object> {
            final /* synthetic */ Font $font;
            final /* synthetic */ PlatformFontLoader $resourceLoader;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01261(PlatformFontLoader platformFontLoader, Font font, z8.d<? super C01261> dVar) {
                super(2, dVar);
                this.$resourceLoader = platformFontLoader;
                this.$font = font;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C01261(this.$resourceLoader, this.$font, dVar);
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
                    PlatformFontLoader platformFontLoader = this.$resourceLoader;
                    Font font = this.$font;
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
                return ((C01261) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Font font, PlatformFontLoader platformFontLoader, z8.d<? super AnonymousClass1> dVar) {
            super(1, dVar);
            this.$font = font;
            this.$resourceLoader = platformFontLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@NotNull z8.d<?> dVar) {
            return new AnonymousClass1(this.$font, this.$resourceLoader, dVar);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(z8.d<? super Object> dVar) {
            return invoke2((z8.d<Object>) dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    u.b(obj);
                    C01261 c01261 = new C01261(this.$resourceLoader, this.$font, null);
                    this.label = 1;
                    obj = f3.c(15000L, c01261, this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                if (obj != null) {
                    return obj;
                }
                throw new IllegalStateException("Unable to load font " + this.$font);
            } catch (Exception e10) {
                throw new IllegalStateException("Unable to load font " + this.$font, e10);
            }
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@Nullable z8.d<Object> dVar) {
            return ((AnonymousClass1) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FontListFontFamilyTypefaceAdapter$preload$3$2$1(FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, Font font, PlatformFontLoader platformFontLoader, z8.d<? super FontListFontFamilyTypefaceAdapter$preload$3$2$1> dVar) {
        super(2, dVar);
        this.this$0 = fontListFontFamilyTypefaceAdapter;
        this.$font = font;
        this.$resourceLoader = platformFontLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new FontListFontFamilyTypefaceAdapter$preload$3$2$1(this.this$0, this.$font, this.$resourceLoader, dVar);
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
            AsyncTypefaceCache asyncTypefaceCache = this.this$0.asyncTypefaceCache;
            Font font = this.$font;
            PlatformFontLoader platformFontLoader = this.$resourceLoader;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(font, platformFontLoader, null);
            this.label = 1;
            obj = asyncTypefaceCache.runCached(font, platformFontLoader, true, anonymousClass1, this);
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
        return ((FontListFontFamilyTypefaceAdapter$preload$3$2$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
