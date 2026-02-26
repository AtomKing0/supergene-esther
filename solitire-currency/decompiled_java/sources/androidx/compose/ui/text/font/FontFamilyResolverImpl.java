package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.TypefaceResult;
import h9.l;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FontFamilyResolver.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
public final class FontFamilyResolverImpl implements FontFamily.Resolver {

    @NotNull
    private final l<TypefaceRequest, Object> createDefaultTypeface;

    @NotNull
    private final FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter;

    @NotNull
    private final PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter;

    @NotNull
    private final PlatformFontLoader platformFontLoader;

    @NotNull
    private final PlatformResolveInterceptor platformResolveInterceptor;

    @NotNull
    private final TypefaceRequestCache typefaceRequestCache;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1, reason: invalid class name */
    /* JADX INFO: compiled from: FontFamilyResolver.kt */
    @f(c = "androidx.compose.ui.text.font.FontFamilyResolverImpl", f = "FontFamilyResolver.kt", l = {47}, m = "preload")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
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
            return FontFamilyResolverImpl.this.preload(null, this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2, reason: invalid class name */
    /* JADX INFO: compiled from: FontFamilyResolver.kt */
    static final class AnonymousClass2 extends v implements l<TypefaceRequest, TypefaceResult> {

        /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: FontFamilyResolver.kt */
        static final class AnonymousClass1 extends v implements l<TypefaceResult.Immutable, k0> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            AnonymousClass1() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull TypefaceResult.Immutable it) {
                t.i(it, "it");
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(TypefaceResult.Immutable immutable) {
                invoke2(immutable);
                return k0.f35197a;
            }
        }

        /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FontFamilyResolver.kt */
        static final class C01252 extends v implements l<TypefaceResult.Immutable, k0> {
            public static final C01252 INSTANCE = new C01252();

            C01252() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull TypefaceResult.Immutable it) {
                t.i(it, "it");
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(TypefaceResult.Immutable immutable) {
                invoke2(immutable);
                return k0.f35197a;
            }
        }

        AnonymousClass2() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final TypefaceResult invoke(@NotNull TypefaceRequest typeRequest) {
            t.i(typeRequest, "typeRequest");
            TypefaceResult typefaceResultResolve = FontFamilyResolverImpl.this.fontListFontFamilyTypefaceAdapter.resolve(typeRequest, FontFamilyResolverImpl.this.getPlatformFontLoader$ui_text_release(), AnonymousClass1.INSTANCE, FontFamilyResolverImpl.this.createDefaultTypeface);
            if (typefaceResultResolve == null && (typefaceResultResolve = FontFamilyResolverImpl.this.platformFamilyTypefaceAdapter.resolve(typeRequest, FontFamilyResolverImpl.this.getPlatformFontLoader$ui_text_release(), C01252.INSTANCE, FontFamilyResolverImpl.this.createDefaultTypeface)) == null) {
                throw new IllegalStateException("Could not load font");
            }
            return typefaceResultResolve;
        }
    }

    public FontFamilyResolverImpl(@NotNull PlatformFontLoader platformFontLoader, @NotNull PlatformResolveInterceptor platformResolveInterceptor, @NotNull TypefaceRequestCache typefaceRequestCache, @NotNull FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, @NotNull PlatformFontFamilyTypefaceAdapter platformFamilyTypefaceAdapter) {
        t.i(platformFontLoader, "platformFontLoader");
        t.i(platformResolveInterceptor, "platformResolveInterceptor");
        t.i(typefaceRequestCache, "typefaceRequestCache");
        t.i(fontListFontFamilyTypefaceAdapter, "fontListFontFamilyTypefaceAdapter");
        t.i(platformFamilyTypefaceAdapter, "platformFamilyTypefaceAdapter");
        this.platformFontLoader = platformFontLoader;
        this.platformResolveInterceptor = platformResolveInterceptor;
        this.typefaceRequestCache = typefaceRequestCache;
        this.fontListFontFamilyTypefaceAdapter = fontListFontFamilyTypefaceAdapter;
        this.platformFamilyTypefaceAdapter = platformFamilyTypefaceAdapter;
        this.createDefaultTypeface = new FontFamilyResolverImpl$createDefaultTypeface$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final State<Object> resolve(TypefaceRequest typefaceRequest) {
        return this.typefaceRequestCache.runCached(typefaceRequest, new FontFamilyResolverImpl$resolve$result$1(this, typefaceRequest));
    }

    @NotNull
    public final PlatformFontLoader getPlatformFontLoader$ui_text_release() {
        return this.platformFontLoader;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object preload(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.FontFamily r14, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof androidx.compose.ui.text.font.FontFamilyResolverImpl.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r15
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r0 = (androidx.compose.ui.text.font.FontFamilyResolverImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1 r0 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$1
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r14 = r0.L$1
            androidx.compose.ui.text.font.FontFamily r14 = (androidx.compose.ui.text.font.FontFamily) r14
            java.lang.Object r0 = r0.L$0
            androidx.compose.ui.text.font.FontFamilyResolverImpl r0 = (androidx.compose.ui.text.font.FontFamilyResolverImpl) r0
            v8.u.b(r15)
            goto L55
        L31:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L39:
            v8.u.b(r15)
            boolean r15 = r14 instanceof androidx.compose.ui.text.font.FontListFontFamily
            if (r15 != 0) goto L43
            v8.k0 r14 = v8.k0.f35197a
            return r14
        L43:
            androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter r15 = r13.fontListFontFamilyTypefaceAdapter
            androidx.compose.ui.text.font.PlatformFontLoader r2 = r13.platformFontLoader
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r3
            java.lang.Object r15 = r15.preload(r14, r2, r0)
            if (r15 != r1) goto L54
            return r1
        L54:
            r0 = r13
        L55:
            r15 = r14
            androidx.compose.ui.text.font.FontListFontFamily r15 = (androidx.compose.ui.text.font.FontListFontFamily) r15
            java.util.List r15 = r15.getFonts()
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r15.size()
            r1.<init>(r2)
            int r2 = r15.size()
            r3 = 0
        L6a:
            if (r3 >= r2) goto La5
            java.lang.Object r4 = r15.get(r3)
            androidx.compose.ui.text.font.Font r4 = (androidx.compose.ui.text.font.Font) r4
            androidx.compose.ui.text.font.TypefaceRequest r12 = new androidx.compose.ui.text.font.TypefaceRequest
            androidx.compose.ui.text.font.PlatformResolveInterceptor r5 = r0.platformResolveInterceptor
            androidx.compose.ui.text.font.FontFamily r6 = r5.interceptFontFamily(r14)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r5 = r0.platformResolveInterceptor
            androidx.compose.ui.text.font.FontWeight r7 = r4.getWeight()
            androidx.compose.ui.text.font.FontWeight r7 = r5.interceptFontWeight(r7)
            androidx.compose.ui.text.font.PlatformResolveInterceptor r5 = r0.platformResolveInterceptor
            int r4 = r4.mo3361getStyle_LCdwA()
            int r8 = r5.mo3371interceptFontStyleT2F_aPo(r4)
            androidx.compose.ui.text.font.FontSynthesis$Companion r4 = androidx.compose.ui.text.font.FontSynthesis.Companion
            int r9 = r4.m3428getAllGVVA2EU()
            androidx.compose.ui.text.font.PlatformFontLoader r4 = r0.platformFontLoader
            java.lang.Object r10 = r4.getCacheKey()
            r11 = 0
            r5 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r1.add(r12)
            int r3 = r3 + 1
            goto L6a
        La5:
            androidx.compose.ui.text.font.TypefaceRequestCache r14 = r0.typefaceRequestCache
            androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2 r15 = new androidx.compose.ui.text.font.FontFamilyResolverImpl$preload$2
            r15.<init>()
            r14.preWarmCache(r1, r15)
            v8.k0 r14 = v8.k0.f35197a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.FontFamilyResolverImpl.preload(androidx.compose.ui.text.font.FontFamily, z8.d):java.lang.Object");
    }

    @Override // androidx.compose.ui.text.font.FontFamily.Resolver
    @NotNull
    /* JADX INFO: renamed from: resolve-DPcqOEQ */
    public State<Object> mo3392resolveDPcqOEQ(@Nullable FontFamily fontFamily, @NotNull FontWeight fontWeight, int i10, int i11) {
        t.i(fontWeight, "fontWeight");
        return resolve(new TypefaceRequest(this.platformResolveInterceptor.interceptFontFamily(fontFamily), this.platformResolveInterceptor.interceptFontWeight(fontWeight), this.platformResolveInterceptor.mo3371interceptFontStyleT2F_aPo(i10), this.platformResolveInterceptor.mo3372interceptFontSynthesisMscr08Y(i11), this.platformFontLoader.getCacheKey(), null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ FontFamilyResolverImpl(PlatformFontLoader platformFontLoader, PlatformResolveInterceptor platformResolveInterceptor, TypefaceRequestCache typefaceRequestCache, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontFamilyTypefaceAdapter platformFontFamilyTypefaceAdapter, int i10, k kVar) {
        this(platformFontLoader, (i10 & 2) != 0 ? PlatformResolveInterceptor.Companion.getDefault$ui_text_release() : platformResolveInterceptor, (i10 & 4) != 0 ? FontFamilyResolverKt.getGlobalTypefaceRequestCache() : typefaceRequestCache, (i10 & 8) != 0 ? new FontListFontFamilyTypefaceAdapter(FontFamilyResolverKt.getGlobalAsyncTypefaceCache(), null, 2, 0 == true ? 1 : 0) : fontListFontFamilyTypefaceAdapter, (i10 & 16) != 0 ? new PlatformFontFamilyTypefaceAdapter() : platformFontFamilyTypefaceAdapter);
    }
}
