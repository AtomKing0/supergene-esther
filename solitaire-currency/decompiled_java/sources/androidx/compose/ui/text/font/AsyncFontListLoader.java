package androidx.compose.ui.text.font;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.font.TypefaceResult;
import h9.l;
import java.util.List;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AsyncFontListLoader implements State<Object> {

    @NotNull
    private final AsyncTypefaceCache asyncTypefaceCache;
    private boolean cacheable;

    @NotNull
    private final List<Font> fontList;

    @NotNull
    private final l<TypefaceResult.Immutable, k0> onCompletion;

    @NotNull
    private final PlatformFontLoader platformFontLoader;

    @NotNull
    private final TypefaceRequest typefaceRequest;

    @NotNull
    private final MutableState value$delegate;

    /* JADX INFO: renamed from: androidx.compose.ui.text.font.AsyncFontListLoader$load$1, reason: invalid class name */
    /* JADX INFO: compiled from: FontListFontFamilyTypefaceAdapter.kt */
    @f(c = "androidx.compose.ui.text.font.AsyncFontListLoader", f = "FontListFontFamilyTypefaceAdapter.kt", l = {272, 285}, m = "load")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
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
            return AsyncFontListLoader.this.load(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AsyncFontListLoader(@NotNull List<? extends Font> fontList, @NotNull Object initialType, @NotNull TypefaceRequest typefaceRequest, @NotNull AsyncTypefaceCache asyncTypefaceCache, @NotNull l<? super TypefaceResult.Immutable, k0> onCompletion, @NotNull PlatformFontLoader platformFontLoader) {
        t.i(fontList, "fontList");
        t.i(initialType, "initialType");
        t.i(typefaceRequest, "typefaceRequest");
        t.i(asyncTypefaceCache, "asyncTypefaceCache");
        t.i(onCompletion, "onCompletion");
        t.i(platformFontLoader, "platformFontLoader");
        this.fontList = fontList;
        this.typefaceRequest = typefaceRequest;
        this.asyncTypefaceCache = asyncTypefaceCache;
        this.onCompletion = onCompletion;
        this.platformFontLoader = platformFontLoader;
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(initialType, null, 2, null);
        this.cacheable = true;
    }

    private void setValue(Object obj) {
        this.value$delegate.setValue(obj);
    }

    public final boolean getCacheable$ui_text_release() {
        return this.cacheable;
    }

    @Override // androidx.compose.runtime.State
    @NotNull
    public Object getValue() {
        return this.value$delegate.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb A[Catch: all -> 0x0107, TRY_LEAVE, TryCatch #1 {all -> 0x0107, blocks: (B:28:0x0075, B:30:0x008c, B:35:0x00bb, B:38:0x00ef), top: B:55:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ef A[Catch: all -> 0x0107, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0107, blocks: (B:28:0x0075, B:30:0x008c, B:35:0x00bb, B:38:0x00ef), top: B:55:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0102 -> B:42:0x0103). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x010a -> B:46:0x010c). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object load(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.load(z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadWithTimeoutOrNull$ui_text_release(@org.jetbrains.annotations.NotNull androidx.compose.ui.text.font.Font r7, @org.jetbrains.annotations.NotNull z8.d<java.lang.Object> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = (androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1 r0 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$1
            r0.<init>(r6, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r7 = r0.L$0
            androidx.compose.ui.text.font.Font r7 = (androidx.compose.ui.text.font.Font) r7
            v8.u.b(r8)     // Catch: java.lang.Exception -> L4d java.util.concurrent.CancellationException -> L7a
            goto L4b
        L2e:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L36:
            v8.u.b(r8)
            androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2 r8 = new androidx.compose.ui.text.font.AsyncFontListLoader$loadWithTimeoutOrNull$2     // Catch: java.lang.Exception -> L4d java.util.concurrent.CancellationException -> L7a
            r8.<init>(r6, r7, r4)     // Catch: java.lang.Exception -> L4d java.util.concurrent.CancellationException -> L7a
            r0.L$0 = r7     // Catch: java.lang.Exception -> L4d java.util.concurrent.CancellationException -> L7a
            r0.label = r3     // Catch: java.lang.Exception -> L4d java.util.concurrent.CancellationException -> L7a
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.Object r8 = kotlinx.coroutines.f3.e(r2, r8, r0)     // Catch: java.lang.Exception -> L4d java.util.concurrent.CancellationException -> L7a
            if (r8 != r1) goto L4b
            return r1
        L4b:
            r4 = r8
            goto L85
        L4d:
            r8 = move-exception
            z8.g r1 = r0.getContext()
            kotlinx.coroutines.l0$b r2 = kotlinx.coroutines.l0.N7
            z8.g$b r1 = r1.get(r2)
            kotlinx.coroutines.l0 r1 = (kotlinx.coroutines.l0) r1
            if (r1 == 0) goto L85
            z8.g r0 = r0.getContext()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Unable to load font "
            r3.append(r5)
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            r2.<init>(r7, r8)
            r1.handleException(r0, r2)
            goto L85
        L7a:
            r7 = move-exception
            z8.g r8 = r0.getContext()
            boolean r8 = kotlinx.coroutines.f2.m(r8)
            if (r8 == 0) goto L86
        L85:
            return r4
        L86:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.font.AsyncFontListLoader.loadWithTimeoutOrNull$ui_text_release(androidx.compose.ui.text.font.Font, z8.d):java.lang.Object");
    }

    public final void setCacheable$ui_text_release(boolean z10) {
        this.cacheable = z10;
    }
}
