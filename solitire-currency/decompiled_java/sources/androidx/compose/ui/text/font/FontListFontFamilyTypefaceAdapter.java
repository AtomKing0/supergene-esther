package androidx.compose.ui.text.font;

import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.font.TypefaceResult;
import h9.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.d0;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.y2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;
import v8.u;
import v8.y;
import z8.g;
import z8.h;

/* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalTextApi
public final class FontListFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {

    @NotNull
    private o0 asyncLoadScope;

    @NotNull
    private final AsyncTypefaceCache asyncTypefaceCache;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final FontMatcher fontMatcher = new FontMatcher();

    @NotNull
    private static final l0 DropExceptionHandler = new FontListFontFamilyTypefaceAdapter$special$$inlined$CoroutineExceptionHandler$1(l0.N7);

    /* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final l0 getDropExceptionHandler() {
            return FontListFontFamilyTypefaceAdapter.DropExceptionHandler;
        }

        @NotNull
        public final FontMatcher getFontMatcher() {
            return FontListFontFamilyTypefaceAdapter.fontMatcher;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3, reason: invalid class name */
    /* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
    @f(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$preload$3", f = "FontListFontFamilyTypefaceAdapter.kt", l = {115}, m = "invokeSuspend")
    static final class AnonymousClass3 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ List<Font> $asyncLoads;
        final /* synthetic */ PlatformFontLoader $resourceLoader;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FontListFontFamilyTypefaceAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(List<Font> list, FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter, PlatformFontLoader platformFontLoader, z8.d<? super AnonymousClass3> dVar) {
            super(2, dVar);
            this.$asyncLoads = list;
            this.this$0 = fontListFontFamilyTypefaceAdapter;
            this.$resourceLoader = platformFontLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$asyncLoads, this.this$0, this.$resourceLoader, dVar);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                o0 o0Var = (o0) this.L$0;
                List<Font> list = this.$asyncLoads;
                HashSet hashSet = new HashSet(list.size());
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    Font font = list.get(i11);
                    if (hashSet.add(font)) {
                        arrayList.add(font);
                    }
                }
                FontListFontFamilyTypefaceAdapter fontListFontFamilyTypefaceAdapter = this.this$0;
                PlatformFontLoader platformFontLoader = this.$resourceLoader;
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                int size2 = arrayList.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    arrayList2.add(kotlinx.coroutines.k.b(o0Var, null, null, new FontListFontFamilyTypefaceAdapter$preload$3$2$1(fontListFontFamilyTypefaceAdapter, (Font) arrayList.get(i12), platformFontLoader, null), 3, null));
                }
                this.label = 1;
                if (kotlinx.coroutines.f.c(arrayList2, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass3) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$resolve$1, reason: invalid class name */
    /* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
    @f(c = "androidx.compose.ui.text.font.FontListFontFamilyTypefaceAdapter$resolve$1", f = "FontListFontFamilyTypefaceAdapter.kt", l = {151}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ AsyncFontListLoader $asyncLoader;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(AsyncFontListLoader asyncFontListLoader, z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$asyncLoader = asyncFontListLoader;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new AnonymousClass1(this.$asyncLoader, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                AsyncFontListLoader asyncFontListLoader = this.$asyncLoader;
                this.label = 1;
                if (asyncFontListLoader.load(this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FontListFontFamilyTypefaceAdapter() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    public final Object preload(@NotNull FontFamily fontFamily, @NotNull PlatformFontLoader platformFontLoader, @NotNull z8.d<? super k0> dVar) {
        if (!(fontFamily instanceof FontListFontFamily)) {
            return k0.f35197a;
        }
        FontListFontFamily fontListFontFamily = (FontListFontFamily) fontFamily;
        List<Font> fonts = fontListFontFamily.getFonts();
        List<Font> fonts2 = fontListFontFamily.getFonts();
        ArrayList arrayList = new ArrayList(fonts2.size());
        int size = fonts2.size();
        for (int i10 = 0; i10 < size; i10++) {
            Font font = fonts2.get(i10);
            if (FontLoadingStrategy.m3400equalsimpl0(font.mo3362getLoadingStrategyPKNRLFQ(), FontLoadingStrategy.Companion.m3404getAsyncPKNRLFQ())) {
                arrayList.add(font);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Font font2 = (Font) arrayList.get(i11);
            arrayList2.add(y.a(font2.getWeight(), FontStyle.m3410boximpl(font2.mo3361getStyle_LCdwA())));
        }
        HashSet hashSet = new HashSet(arrayList2.size());
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        int size3 = arrayList2.size();
        for (int i12 = 0; i12 < size3; i12++) {
            Object obj = arrayList2.get(i12);
            if (hashSet.add((s) obj)) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        int size4 = arrayList3.size();
        for (int i13 = 0; i13 < size4; i13++) {
            s sVar = (s) arrayList3.get(i13);
            FontWeight fontWeight = (FontWeight) sVar.a();
            int iM3416unboximpl = ((FontStyle) sVar.b()).m3416unboximpl();
            List list = (List) FontListFontFamilyTypefaceAdapterKt.firstImmediatelyAvailable(fontMatcher.m3409matchFontRetOiIg(fonts, fontWeight, iM3416unboximpl), new TypefaceRequest(fontFamily, fontWeight, iM3416unboximpl, FontSynthesis.Companion.m3428getAllGVVA2EU(), platformFontLoader.getCacheKey(), null), this.asyncTypefaceCache, platformFontLoader, FontListFontFamilyTypefaceAdapter$preload$2$1.INSTANCE).a();
            if (list != null) {
                arrayList4.add(d0.i0(list));
            }
        }
        Object objF = p0.f(new AnonymousClass3(arrayList4, this, platformFontLoader, null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }

    @Override // androidx.compose.ui.text.font.FontFamilyTypefaceAdapter
    @Nullable
    public TypefaceResult resolve(@NotNull TypefaceRequest typefaceRequest, @NotNull PlatformFontLoader platformFontLoader, @NotNull h9.l<? super TypefaceResult.Immutable, k0> onAsyncCompletion, @NotNull h9.l<? super TypefaceRequest, ? extends Object> createDefaultTypeface) {
        t.i(typefaceRequest, "typefaceRequest");
        t.i(platformFontLoader, "platformFontLoader");
        t.i(onAsyncCompletion, "onAsyncCompletion");
        t.i(createDefaultTypeface, "createDefaultTypeface");
        if (!(typefaceRequest.getFontFamily() instanceof FontListFontFamily)) {
            return null;
        }
        s sVarFirstImmediatelyAvailable = FontListFontFamilyTypefaceAdapterKt.firstImmediatelyAvailable(fontMatcher.m3409matchFontRetOiIg(((FontListFontFamily) typefaceRequest.getFontFamily()).getFonts(), typefaceRequest.getFontWeight(), typefaceRequest.m3451getFontStyle_LCdwA()), typefaceRequest, this.asyncTypefaceCache, platformFontLoader, createDefaultTypeface);
        List list = (List) sVarFirstImmediatelyAvailable.a();
        Object objB = sVarFirstImmediatelyAvailable.b();
        if (list == null) {
            return new TypefaceResult.Immutable(objB, false, 2, null);
        }
        AsyncFontListLoader asyncFontListLoader = new AsyncFontListLoader(list, objB, typefaceRequest, this.asyncTypefaceCache, onAsyncCompletion, platformFontLoader);
        kotlinx.coroutines.k.d(this.asyncLoadScope, null, q0.UNDISPATCHED, new AnonymousClass1(asyncFontListLoader, null), 1, null);
        return new TypefaceResult.Async(asyncFontListLoader);
    }

    public FontListFontFamilyTypefaceAdapter(@NotNull AsyncTypefaceCache asyncTypefaceCache, @NotNull g injectedContext) {
        t.i(asyncTypefaceCache, "asyncTypefaceCache");
        t.i(injectedContext, "injectedContext");
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.asyncLoadScope = p0.a(DropExceptionHandler.plus(injectedContext).plus(y2.a((b2) injectedContext.get(b2.O7))));
    }

    public /* synthetic */ FontListFontFamilyTypefaceAdapter(AsyncTypefaceCache asyncTypefaceCache, g gVar, int i10, k kVar) {
        this((i10 & 1) != 0 ? new AsyncTypefaceCache() : asyncTypefaceCache, (i10 & 2) != 0 ? h.f37608a : gVar);
    }
}
